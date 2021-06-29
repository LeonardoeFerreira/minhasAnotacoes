package com.playxcodes.minhasanotaces;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;

import androidx.navigation.ui.AppBarConfiguration;

import com.playxcodes.minhasanotaces.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    AnotacaoPreferencias preferencias;

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    private EditText editAnotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAnotacao = findViewById(R.id.editAnotacao);
        preferencias = new AnotacaoPreferencias(getApplicationContext());

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

        @Override
            public void onClick(View view) {

                //validacao se foi digitado algo
                String textoRecuperado = editAnotacao.getText().toString();

                if(textoRecuperado.equals("")){
                    Snackbar.make(view, "Preencha a anotação", Snackbar.LENGTH_LONG).show();
                }else{
                   preferencias.salvarAnotacoes(textoRecuperado);

                    Snackbar.make(view, "Anotação  salva com sucesso!", Snackbar.LENGTH_LONG).show();
                }

            }
        });

        //recuperando as anotacoes

        String anotacao = preferencias.recuperarAnotacao();

        //testar se esta preenchida
        if(!anotacao.equals("")){
            editAnotacao.setText(anotacao);
        }



    }



}