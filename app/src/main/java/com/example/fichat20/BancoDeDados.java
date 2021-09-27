package com.example.fichat20;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BancoDeDados extends SQLiteOpenHelper
{
    private static final int VERSAO_BANCO_DADOS = 1;
    private static final String NOME_BANCO_DADOS = "gerenciaFichas";
    private static final String TABELA_FICHAS = "dadosficha";
    private static final String CAMPO_ID= "id";
    private static final String CAMPO_NOME = "nome";
    private static final String CAMPO_CLASSE = "classe";
    private static final String CAMPO_RACA = "raca";
    private static final String CAMPO_NIVEL = "nivel";
    private static final String CAMPO_FORCA = "forca";
    private static final String CAMPO_DESTREZA = "destreza";
    private static final String CAMPO_CONSTITUICAO = "constituicao";
    private static final String CAMPO_CARISMA = "carisma";
    private static final String CAMPO_INTELIGENCIA = "inteligencia";
    private static final String CAMPO_SABEDORIA = "sabedoria";
    private static final String CAMPO_DEFESA = "defesa";
    private static final String CAMPO_ATAQUE = "ataque";
    private static final String CAMPO_HISTORIA = "historia";


    public BancoDeDados(Context context)
    {
        super(context, NOME_BANCO_DADOS, null, VERSAO_BANCO_DADOS);
    }
    @Override
    public void onCreate(SQLiteDatabase banco)
    {
        String CriaTabelaContatos = "CREATE TABLE " + TABELA_FICHAS + "(" + CAMPO_ID + " INTEGER PRIMARY KEY,"
                + CAMPO_NOME + " TEXT,"
                + CAMPO_CLASSE + " TEXT,"
                + CAMPO_RACA + " TEXT,"
                + CAMPO_NIVEL + " NUMBER,"
                + CAMPO_FORCA + " INTEGER,"
                + CAMPO_DESTREZA + " INTEGER,"
                + CAMPO_CONSTITUICAO + " INTEGER,"
                + CAMPO_CARISMA  + " INTEGER,"
                + CAMPO_INTELIGENCIA + " INTEGER,"
                + CAMPO_SABEDORIA + " INTEGER,"
                + CAMPO_DEFESA + " INTEGER,"
                + CAMPO_ATAQUE + " INTEGER,"
                + CAMPO_HISTORIA+ " TEXT" + ")";
        banco.execSQL(CriaTabelaContatos);
    }
    @Override
    public void onUpgrade(SQLiteDatabase banco, int i, int i1)
    {
        banco.execSQL("DROP TABLE IF EXISTS " + TABELA_FICHAS);
        onCreate(banco);
    }

    public void deletar(SQLiteDatabase banco)
    {

        banco.execSQL("DROP TABLE IF EXISTS " + TABELA_FICHAS);
    }


    public void insereDadosFichas(DadosFicha dadosFicha)
    {
        SQLiteDatabase banco = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CAMPO_NOME, dadosFicha.getNome());
        values.put(CAMPO_CLASSE, dadosFicha.getClasse());
        values.put(CAMPO_RACA, dadosFicha.getRaca());
        values.put(CAMPO_NIVEL, dadosFicha.getNivel());
        values.put(CAMPO_FORCA, dadosFicha.getForca());
        values.put(CAMPO_DESTREZA, dadosFicha.getDestreza());
        values.put(CAMPO_CONSTITUICAO, dadosFicha.getConstituicao());
        values.put(CAMPO_CARISMA, dadosFicha.getCarisma());
        values.put(CAMPO_INTELIGENCIA, dadosFicha.getInteligencia());
        values.put(CAMPO_SABEDORIA, dadosFicha.getSabedoria());
        values.put(CAMPO_DEFESA, dadosFicha.getDefesa());
        values.put(CAMPO_ATAQUE, dadosFicha.getAtaque());
        values.put(CAMPO_HISTORIA, dadosFicha.getHistoria());

        banco.insert(TABELA_FICHAS, null, values);
        banco.close();
    }
    public DadosFicha consultaDadosFicha (int id)
    {
        SQLiteDatabase banco= this.getReadableDatabase();
        Cursor cursor = banco.query(TABELA_FICHAS, new String[] {CAMPO_ID, CAMPO_NOME,
                        CAMPO_CLASSE, CAMPO_RACA, CAMPO_NIVEL, CAMPO_FORCA, CAMPO_DESTREZA, CAMPO_CONSTITUICAO, CAMPO_CARISMA,
                        CAMPO_INTELIGENCIA, CAMPO_SABEDORIA, CAMPO_DEFESA, CAMPO_ATAQUE, CAMPO_HISTORIA},
                CAMPO_ID + "=?", new String[] {String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
        {
            cursor.moveToFirst();
        }



        return dadosFicha;
    }



    public List<DadosFicha> listaTodosDadosFicha()
    {
        List<DadosFicha> listaDadosFicha = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABELA_FICHAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst())
        {
            do
            {
                DadosFicha dadosFicha = new DadosFicha();
                dadosFicha.setId(Integer.parseInt(cursor.getString(0)));
                dadosFicha.setNome(cursor.getString(1));
                dadosFicha.setClasse(cursor.getString(2));
                dadosFicha.setRaca(cursor.getString(3));
                dadosFicha.setNivel(cursor.getString(4));
                dadosFicha.setForca(cursor.getString(5));
                dadosFicha.setDestreza(cursor.getString(6));
                dadosFicha.setConstituicao(cursor.getString(7));
                dadosFicha.setCarisma(cursor.getString(8));
                dadosFicha.setInteligencia(cursor.getString(9));
                dadosFicha.setSabedoria(cursor.getString(10));
                dadosFicha.setDefesa(cursor.getString(11));
                dadosFicha.setAtaque(cursor.getString(12));
                dadosFicha.setHistoria(cursor.getString(13));
                listaDadosFicha.add(dadosFicha);
            }
            while (cursor.moveToNext());
        }
        return listaDadosFicha;
    }
    public int atualizaContatos (DadosFicha dadosFicha)
    {
        SQLiteDatabase banco = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CAMPO_NOME, dadosFicha.getNome());
        values.put(CAMPO_CLASSE, dadosFicha.getClasse());
        values.put(CAMPO_RACA, dadosFicha.getRaca());
        values.put(CAMPO_NIVEL, dadosFicha.getNivel());
        values.put(CAMPO_FORCA, dadosFicha.getForca());
        values.put(CAMPO_DESTREZA, dadosFicha.getDestreza());
        values.put(CAMPO_CONSTITUICAO, dadosFicha.getConstituicao());
        values.put(CAMPO_CARISMA, dadosFicha.getCarisma());
        values.put(CAMPO_INTELIGENCIA, dadosFicha.getInteligencia());
        values.put(CAMPO_SABEDORIA, dadosFicha.getSabedoria());
        values.put(CAMPO_DEFESA, dadosFicha.getDefesa());
        values.put(CAMPO_ATAQUE, dadosFicha.getAtaque());
        values.put(CAMPO_HISTORIA, dadosFicha.getHistoria());
        return banco.update(TABELA_FICHAS, values, CAMPO_ID + "=?", new String[]
                {String.valueOf(dadosFicha.getId())});
    }
    public void deletaContatos(DadosFicha dadosFicha)
    {

        SQLiteDatabase banco = this.getWritableDatabase();
        banco.delete(TABELA_FICHAS, CAMPO_ID + "=?", new String[]
                {String.valueOf(dadosFicha.getId())});
        banco.close();
    }
    public int consultaQuantidadeContatos()
    {
        String countQuery = "SELECT * FROM " + TABELA_FICHAS;
        SQLiteDatabase banco = this.getReadableDatabase();
        Cursor cursor = banco.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }

    }



