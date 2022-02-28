package br.keneitec.dio.trabalhobiologia.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

import br.keneitec.dio.trabalhobiologia.R;
import br.keneitec.dio.trabalhobiologia.activity.DetalhesActivity;
import br.keneitec.dio.trabalhobiologia.adapter.GridAdapter;
import br.keneitec.dio.trabalhobiologia.databinding.FragmentGridBinding;
import br.keneitec.dio.trabalhobiologia.model.ClasseGeral;

public class GridFragment extends Fragment {
    private FragmentGridBinding binding;
    private List<ClasseGeral> list = new ArrayList<>();
    private String tipo;
    private GridAdapter adapter;

    public GridFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentGridBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        //Recuperar tipo escolhido do outro fragment
        getParentFragmentManager().setFragmentResultListener("requestKey", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                tipo = bundle.getString("tipo");
                if (tipo.equals("plantas")){
                    binding.tvTipoEscolhido.setText("Plantas");
                    configListPlantas();
                }else {
                    binding.tvTipoEscolhido.setText("Solos");
                    configListSolos();
                }
            }
        });

        return view;
    }

    private void configListSolos() {
        //Adicionar Solos a serem mostrados no grid
        list.add(new ClasseGeral(R.drawable.cambissolo,"CAMBISSOLO",ClasseGeral.TIPO_SOLO,getString(R.string.cambissolo)));
        list.add(new ClasseGeral(R.drawable.chernossolo,"CHERNOSSOLO",ClasseGeral.TIPO_SOLO,getString(R.string.chernossolo)));
        list.add(new ClasseGeral(R.drawable.espodossolo,"ESPODOSSOLO",ClasseGeral.TIPO_SOLO,getString(R.string.espodossolo)));
        list.add(new ClasseGeral(R.drawable.luvissolo,"LUVISSOLO",ClasseGeral.TIPO_SOLO,getString(R.string.luvissolo)));

        configurarGrid(ClasseGeral.TIPO_SOLO);
    }

    private void configListPlantas() {
        //Adicionar Plantas a serem mostradas no grid
        list.add(new ClasseGeral(R.drawable.rosas_do_deserto,"ROSAS DO DESERTO",ClasseGeral.TIPO_PLANTA,getString(R.string.rosas_do_deserto)));
        list.add(new ClasseGeral(R.drawable.hortensia,"HORTÊNSIA",ClasseGeral.TIPO_PLANTA,getString(R.string.hortensia)));
        list.add(new ClasseGeral(R.drawable.xaxim,"XAXIM",ClasseGeral.TIPO_PLANTA,getString(R.string.xaxim)));
        list.add(new ClasseGeral(R.drawable.orelhas_de_shrek,"ORELHAS DE SHREK",ClasseGeral.TIPO_PLANTA,getString(R.string.orelhas_de_shrek)));

        configurarGrid(ClasseGeral.TIPO_PLANTA);
    }

    private void configurarGrid(int tipoEscolhido) {
        //Configurar tamanho do grid
        int tamanhoGrid = getResources().getDisplayMetrics().widthPixels;
        int tamanhoImagem = tamanhoGrid/2;
        binding.gridView.setColumnWidth(tamanhoImagem);

        //Configurar adapter
        adapter = new GridAdapter( getActivity() , list ,tipoEscolhido);
        binding.gridView.setAdapter( adapter );

        binding.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //Abrir escolha do usuario
                Intent i = new Intent(getActivity(), DetalhesActivity.class);
                i.putExtra("classe",list.get(position));
                startActivity(i);
            }
        });
    }
}