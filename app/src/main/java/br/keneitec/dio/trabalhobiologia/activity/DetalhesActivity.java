package br.keneitec.dio.trabalhobiologia.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;

import br.keneitec.dio.trabalhobiologia.R;
import br.keneitec.dio.trabalhobiologia.databinding.ActivityDetalhesBinding;
import br.keneitec.dio.trabalhobiologia.model.ClasseGeral;

public class DetalhesActivity extends AppCompatActivity {
    private ActivityDetalhesBinding binding;
    private Bundle bundle;
    private ClasseGeral classeEscolida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetalhesBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        bundle = getIntent().getExtras();
        binding.tvDetalhesTotais.setMovementMethod(new ScrollingMovementMethod());
        if (bundle!= null){
            classeEscolida = (ClasseGeral) bundle.getSerializable("classe");
            binding.tvClasseEscolhida.setText(classeEscolida.getNome());
            binding.ivClasseEscolhida.setImageResource(classeEscolida.getImagem());
            binding.tvDetalhesTotais.setText(classeEscolida.getApresentacao());
            if (classeEscolida.getTipo() == ClasseGeral.TIPO_PLANTA){
                binding.linearLayoutDetalhes.setBackgroundResource(R.drawable.bg_balao_planta);
            }else binding.linearLayoutDetalhes.setBackgroundResource(R.drawable.bg_balao_solo);
            configDarkMode();
        }
    }

    private void configDarkMode() {
        int nightModeFlags =
                getResources().getConfiguration().uiMode &
                        Configuration.UI_MODE_NIGHT_MASK;
        switch (nightModeFlags) {
            case Configuration.UI_MODE_NIGHT_YES:
                binding.tvDetalhesTotais.setBackgroundResource(R.drawable.bg_balao_preto);
                break;

            case Configuration.UI_MODE_NIGHT_NO:
                binding.tvDetalhesTotais.setBackgroundResource(R.drawable.bg_balao_branco);
                break;

            case Configuration.UI_MODE_NIGHT_UNDEFINED:

                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}