package com.example.fichat20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button Salvar, Deletar;
    TextView mostraGrupo, NomeL, ClasseL, RacaL, NivelL, DefesaL, PML, PVL;
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
        Classe = findViewById(R.id.Classe);
        ClasseL = findViewById(R.id.ClasseL);
        Raca = findViewById(R.id.Raca);
        RacaL = findViewById(R.id.RacaL);
        Nivel = findViewById(R.id.Nivel);
        NivelL = findViewById(R.id.NivelL);
        Defesa = findViewById(R.id.Defesa);
        DefesaL = findViewById(R.id.DefesaL);
        PV = findViewById(R.id.PV);
        PVL = findViewById(R.id.PVL);
        PM = findViewById(R.id.PM);
        PML = findViewById(R.id.PML);
        ID = findViewById(R.id.ID);
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
        banco.insereDadosFichas(new DadosFicha(nome1, classe1, raca1, nivel1, defesa1, pm1, pv1));
        Atualizar();
    }



    public void Deletar(View view){
        int id1 = Integer.parseInt(ID.getText().toString());
        banco.deletaDadosFicha(new DadosFicha(id1));
        Atualizar();

    }

    public void Atualizar(){
        List<DadosFicha> dadosFichas = banco.listaTodosDadosFicha();
        for (DadosFicha c : dadosFichas )
        {
            String log = "ID "+c.getId() + ": " + c.getNome() + ", " + c.getRaca() + ", "+ c.getClasse() + " "+ c.getNivel() + " (PV: "+ c.getPV() + ", PM: "+ c.getPM() + ", DEF: "+ c.getDefesa() +") ;" +"\n";
            text = text + log;
        }
        mostraGrupo.setText(text);
        text = "";
    }


}