package com.example.fichat20;

public class DadosFicha {

    int id;
    String nome;
    String classe;
    String raca;
    String nivel;
    String defesa;
    String PV;
    String PM;


    public DadosFicha()
    {
    }

    public DadosFicha(String nome, String classe, String raca, String nivel, String defesa, String PV, String PM)
    {
        this.nome = nome;
        this.classe = classe;
        this.raca = raca;
        this.nivel = nivel;
        this.defesa = defesa;
        this.PV = PV;
        this.PM = PM;

    }

    public DadosFicha(int id, String nome, String classe, String raca, String nivel, String defesa, String PV, String PM)
    {
        this.id = id;
        this.nome = nome;
        this.classe = classe;
        this.raca = raca;
        this.nivel = nivel;
        this.defesa = defesa;
        this.PV = PV;
        this.PM = PM;

    }

    public DadosFicha(int id)
    {
        this.id = id;
        this.nome = "";
        this.classe = "";
        this.raca = "";
        this.nivel = "";
        this.defesa = "";
        this.PV = "";
        this.PM = "";

    }

    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }

    public String getNome()
    {
        return nome;
    }
    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getClasse()
    {
        return classe;
    }
    public void setClasse(String classe)
    {
        this.classe = classe;
    }

    public String getRaca() {
        return raca;
    }
    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getNivel() {
        return nivel;
    }
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getDefesa() {
        return defesa;
    }
    public void setDefesa(String defesa) {
        this.defesa = defesa;
    }

    public String getPV() { return PV; }
    public void setPV(String PV) { this.PV = PV; }

    public String getPM() { return PM; }
    public void setPM(String PM) {
        this.PM = PM;
    }

}