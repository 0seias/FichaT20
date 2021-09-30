package com.example.fichat20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button Salvar, Deletar, Atualizar, Refresh, Preencher;
    TextView mostraGrupo, NomeL, ClasseL, RacaL, NivelL, DefesaL, PML, PVL, GrupoL;
    EditText Nome, Classe, Raca, Nivel, Defesa, PM, PV, ID;
    String text = "", text2 = "", nome1, classe1, raca1, nivel1, defesa1, pv1, pm1, id1;
    BancoDeDados banco = new BancoDeDados(this);


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Nome = findViewById(R.id.Nome);
        NomeL = findViewById(R.id.NomeL);
        Classe = findViewById(R.id.Raca);
        ClasseL = findViewById(R.id.RacaL);
        Raca = findViewById(R.id.Classe);
        RacaL = findViewById(R.id.ClasseL);
        Nivel = findViewById(R.id.Nivel);
        NivelL = findViewById(R.id.NivelL);
        Defesa = findViewById(R.id.Defesa);
        DefesaL = findViewById(R.id.DefesaL);
        PV = findViewById(R.id.PV);
        PVL = findViewById(R.id.PVL);
        PM = findViewById(R.id.PM);
        PML = findViewById(R.id.PML);
        ID = findViewById(R.id.ID);
        GrupoL =  findViewById(R.id.GrupoL);
        mostraGrupo = (TextView) findViewById(R.id.mostraGrupo);

    }

    public void Salvar(View view){
        nome1 = Nome.getText().toString();
        classe1 = Classe.getText().toString();
        raca1 = Raca.getText().toString();
        nivel1 = Nivel.getText().toString();
        defesa1 = Defesa.getText().toString();
        pv1 = PV.getText().toString();
        pm1 = PM.getText().toString();
        banco.insereDadosFichas(new DadosFicha(nome1, raca1, classe1, nivel1, defesa1, pv1, pm1));
        Atualizar();
    }



    public void Deletar(View view){
        int id1 = Integer.parseInt(ID.getText().toString());
        banco.deletaDadosFicha(new DadosFicha(id1));
        Atualizar();

    }

    public void Editar(View view){
        int id1 = Integer.parseInt(ID.getText().toString());
        nome1 = Nome.getText().toString();
        classe1 = Classe.getText().toString();
        raca1 = Raca.getText().toString();
        nivel1 = Nivel.getText().toString();
        defesa1 = Defesa.getText().toString();
        pv1 = PV.getText().toString();
        pm1 = PM.getText().toString();
        banco.atualizaDadosFicha(new DadosFicha(id1, nome1, raca1, classe1, nivel1, defesa1, pv1, pm1 ));
        Atualizar();

    }

    public void Preencher(View view){
        int id1 = Integer.parseInt(ID.getText().toString());
        DadosFicha df= banco.consultaDadosFicha(id1);
        Nome.setText(df.getNome());
        Raca.setText(df.getRaca());
        Classe.setText(df.getClasse());
        Nivel.setText(df.getNivel());
        Defesa.setText(df.getDefesa());
        PV.setText(df.getPV());
        PM.setText(df.getPM());
        Atualizar();

    }

    public void Atualizar(){
        List<DadosFicha> dadosFichas = banco.listaTodosDadosFicha();
        for (DadosFicha c : dadosFichas )
        {
            String log = "ID "+c.getId() + ": " + c.getNome() + ", " + c.getRaca() + ", "+ c.getClasse() + " "+ c.getNivel() + " (DEF: "+ c.getDefesa() +", PV: "+ c.getPV() + ", PM: "+ c.getPM() + ");" +"\n";
            text = text + log;
        }
        mostraGrupo.setText(text);
        text = "";
        int i = banco.consultaQuantidadeFichas();
        String cont = String.valueOf(i);
        String cont2 = "Grupo " + cont;
        GrupoL.setText(cont2);
        cont2 = "";
    }

    public void Refresh(View view){

        Atualizar();
    }

}