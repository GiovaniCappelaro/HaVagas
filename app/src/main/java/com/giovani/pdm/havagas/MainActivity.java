package com.giovani.pdm.havagas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

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


        /*Aparição de botões 'gone'*/

        // -> Add celular - input
        /*HELPS: https://stackoverflow.com/questions/8386832/android-checkbox-listener
                 https://alvinalexander.com/source-code/android/android-checkbox-listener-setoncheckedchangelisteneroncheckedchangelistener-exam/
         */

        amb.addCelularCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()){
                    amb.celularEt.setVisibility(View.VISIBLE);
                }else{
                    amb.celularEt.setVisibility(View.GONE);
                }
            }
        });


        //Baseados na formação: (talves precise ser tudo IF, sem ELSE)

        amb.formacaoSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if( (i == 0) || (i == 1) ){
                    amb.anoDeFormaturaEt.setVisibility(view.VISIBLE);   //fundamental e medio

                    amb.anoConclusaoInstituicaoLl.setVisibility(view.GONE);
                    amb.tituloMonografiaOrientadorLl.setVisibility(view.GONE);  //esconde dos outros
                }
                else if( (i == 2) || (i == 3) ){
                    amb.anoConclusaoInstituicaoLl.setVisibility(view.VISIBLE);  //Graduação e especialização

                    amb.anoDeFormaturaEt.setVisibility(view.GONE);
                    amb.tituloMonografiaOrientadorLl.setVisibility(view.GONE); //esconde dos outros
                }
                else if( (i == 4) || (i == 5) ){
                    amb.anoConclusaoInstituicaoLl.setVisibility(view.VISIBLE);
                    amb.tituloMonografiaOrientadorLl.setVisibility(view.VISIBLE);

                    amb.anoDeFormaturaEt.setVisibility(view.GONE);                  //mostra todos menos ano de formatura (só pra fund. e medio)
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }



}