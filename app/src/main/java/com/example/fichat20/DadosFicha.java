package com.example.fichat20;

public class DadosFicha {

    int id;
    String nome;
    String classe;
    String raca;
    String nivel;
    String forca;
    String destreza;
    String constituicao;
    String carisma;
    String inteligencia;
    String sabedoria;
    String defesa;
    String ataque;
    String historia;


    public DadosFicha()
    {
    }

    public DadosFicha(String nome, String classe, String raca, String nivel, String forca, String destreza, String constituicao, String carisma, String inteligencia, String sabedoria, String defesa, String ataque, String historia)
    {
        this.nome = nome;
        this.classe = classe;
        this.raca = raca;
        this.nivel = nivel;
        this.forca = forca;
        this.destreza = destreza;
        this.constituicao = constituicao;
        this.carisma = carisma;
        this.inteligencia = inteligencia;
        this.sabedoria = sabedoria;
        this.defesa = defesa;
        this.ataque = ataque;
        this.historia = historia;

    }

    public DadosFicha(int id, String nome, String classe, String raca, String nivel, String forca, String destreza, String constituicao, String carisma, String inteligencia, String sabedoria, String defesa, String ataque, String historia)
    {
        this.id = id;
        this.nome = nome;
        this.classe = classe;
        this.raca = raca;
        this.nivel = nivel;
        this.forca = forca;
        this.destreza = destreza;
        this.constituicao = constituicao;
        this.carisma = carisma;
        this.inteligencia = inteligencia;
        this.sabedoria = sabedoria;
        this.defesa = defesa;
        this.ataque = ataque;
        this.historia = historia;

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

    public String getForca() {
        return forca;
    }

    public void setForca(String forca) {
        this.forca = forca;
    }

    public String getDestreza() {
        return destreza;
    }

    public void setDestreza(String destreza) {
        this.destreza = destreza;
    }

    public String getConstituicao() {
        return constituicao;
    }

    public void setConstituicao(String constituicao) {
        this.constituicao = constituicao;
    }

    public String getCarisma() {
        return carisma;
    }

    public void setCarisma(String carisma) {
        this.carisma = carisma;
    }

    public String getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(String inteligencia) {
        this.inteligencia = inteligencia;
    }

    public String getSabedoria() {
        return sabedoria;
    }

    public void setSabedoria(String sabedoria) {
        this.sabedoria = sabedoria;
    }

    public String getDefesa() {
        return defesa;
    }

    public void setDefesa(String defesa) {
        this.defesa = defesa;
    }

    public String getAtaque() {
        return ataque;
    }

    public void setAtaque(String ataque) {
        this.ataque = ataque;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }
}