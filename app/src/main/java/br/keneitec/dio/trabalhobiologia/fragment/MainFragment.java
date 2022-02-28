package br.keneitec.dio.trabalhobiologia.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.keneitec.dio.trabalhobiologia.R;
import br.keneitec.dio.trabalhobiologia.databinding.FragmentMainBinding;

public class MainFragment extends Fragment {
    private FragmentMainBinding binding;
    private String tipo;

    public MainFragment() {
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
        binding = FragmentMainBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        binding.linearPlantas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tipo = "plantas";
                escolheTipo(tipo);
            }
        });

        binding.linearSolos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tipo = "solos";
                escolheTipo(tipo);
            }
        });

        return view;
    }

    private void escolheTipo(String tipoEscolhido) {
        Bundle bundle = new Bundle();
        bundle.putString("tipo", tipoEscolhido);

        //Passar data(extras) de fragment para fragment
        GridFragment fragment = new GridFragment();
        fragment.setArguments(bundle);
        //getFragmentManager().beginTransaction().replace(R.id.frameLayout,new ConfigDaSalaFragment()).commit();

        getParentFragmentManager().setFragmentResult("requestKey",bundle);

        changeFragment();
    }

    private void changeFragment() {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frameLayout, new GridFragment(),"tagTipo").commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}