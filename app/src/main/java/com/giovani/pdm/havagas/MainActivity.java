package com.giovani.pdm.havagas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.giovani.pdm.havagas.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    //Objetos da classe ActivityMainBinding e Candidato
    private ActivityMainBinding amb;
    private Candidato candidato;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //instanciar o objeto da classe ActivityMainBinding
        amb = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(amb.getRoot()); //view vai ser a definida como root da Activity


        /*---------LISTENNERS---------*/


        //Limpar o form
        amb.limparBt.setOnClickListener(view -> {
            amb.nomeCompletoEt.setText("");
            amb.emailEt.setText("");
            amb.desejoAtualizacoesCb.setChecked(false);
            amb.telefoneEt.setText(null);   //ver se null serve pra numero mesmo
            amb.isTelefoneComercialCb.setChecked(false);
            amb.addCelularCb.setChecked(false);
            amb.masculinoRb.setChecked(true);
            amb.dataDeNascimentoEt.setText("");
            amb.formacaoSp.setSelection(0);
            amb.vagasInteresse.setText("");
            candidato = null;   //zerar o objeto
        });

    }








}