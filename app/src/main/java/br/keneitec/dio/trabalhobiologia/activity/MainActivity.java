package br.keneitec.dio.trabalhobiologia.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import br.keneitec.dio.trabalhobiologia.R;
import br.keneitec.dio.trabalhobiologia.databinding.ActivityMainBinding;
import br.keneitec.dio.trabalhobiologia.fragment.MainFragment;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private int backButtonCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        iniciarFragment();
        binding.fabInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),InfoActivity.class));
            }
        });
    }

    private void iniciarFragment() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        MainFragment fragment = new MainFragment();

        transaction.add(R.id.frameLayout,fragment,"tagTipoSoloxPlanta").addToBackStack(null).commit();
    }

    @Override
    public void onBackPressed(){
        Fragment manager = getSupportFragmentManager().findFragmentByTag("tagTipo");
        if (isTaskRoot()){
            if (manager != null){
                if (manager.isVisible()){
                    //Log.d("erro", "onBackPressed: ativo"+manager.getLifecycle());
                    startActivity(new Intent(MainActivity.this,MainActivity.class));
                    finish();
                }
            }else if (backButtonCount >= 1){
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }else{
                Toast.makeText(this, "Pressione novamente para sair", Toast.LENGTH_SHORT).show();
                backButtonCount++;
            }
        }else{
            super.onBackPressed();
        }
    }

    @Override
    protected void onStart() {
        backButtonCount = 0;
        super.onStart();
    }

}