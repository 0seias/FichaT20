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
    private static final String CAMPO_DEFESA = "defesa";
    private static final String CAMPO_PV = "PV";
    private static final String CAMPO_PM = "PM";

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
                + CAMPO_DEFESA + " INTEGER,"
                + CAMPO_PV + " INTEGER,"
                + CAMPO_PM+ " INTEGER" + ")";
        banco.execSQL(CriaTabelaContatos);
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
        values.put(CAMPO_DEFESA, dadosFicha.getDefesa());
        values.put(CAMPO_PV, dadosFicha.getPV());
        values.put(CAMPO_PM, dadosFicha.getPM());
        banco.insert(TABELA_FICHAS, null, values);
        banco.close();
    }
    public DadosFicha consultaDadosFicha (int id)
    {
        SQLiteDatabase banco= this.getReadableDatabase();
        Cursor cursor = banco.query(TABELA_FICHAS, new String[] {CAMPO_ID, CAMPO_NOME,
                        CAMPO_CLASSE, CAMPO_RACA, CAMPO_NIVEL, CAMPO_DEFESA, CAMPO_PV,  CAMPO_PM},
                CAMPO_ID + "=?", new String[] {String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
        {
            cursor.moveToFirst();
        }

        DadosFicha dadosFicha = new DadosFicha(Integer.parseInt(cursor.getString(0)),
                cursor.getString( 1),
                cursor.getString( 2),
                cursor.getString( 3),
                cursor.getString( 4),
                cursor.getString( 5),
                cursor.getString( 6),
                cursor.getString( 7));

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
                dadosFicha.setDefesa(cursor.getString(5));
                dadosFicha.setPV(cursor.getString(6));
                dadosFicha.setPM(cursor.getString(7));
                listaDadosFicha.add(dadosFicha);
            }
            while (cursor.moveToNext());
        }
        return listaDadosFicha;
    }
    public int atualizaDadosFicha (DadosFicha dadosFicha)
    {
        SQLiteDatabase banco = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CAMPO_NOME, dadosFicha.getNome());
        values.put(CAMPO_CLASSE, dadosFicha.getClasse());
        values.put(CAMPO_RACA, dadosFicha.getRaca());
        values.put(CAMPO_NIVEL, dadosFicha.getNivel());
        values.put(CAMPO_DEFESA, dadosFicha.getDefesa());
        values.put(CAMPO_PV, dadosFicha.getPV());
        values.put(CAMPO_PM, dadosFicha.getPM());
        return banco.update(TABELA_FICHAS, values, CAMPO_ID + "=?", new String[]
                {String.valueOf(dadosFicha.getId())});
    }


    public void deletaDadosFicha(DadosFicha dadosFicha)
    {

        SQLiteDatabase banco = this.getWritableDatabase();
        banco.delete(TABELA_FICHAS, CAMPO_ID + "=?", new String[]
                {String.valueOf(dadosFicha.getId())});

        banco.close();
    }

    public int consultaQuantidadeFichas()
    {
        String countQuery = "SELECT * FROM " + TABELA_FICHAS;
        SQLiteDatabase banco = this.getReadableDatabase();
        Cursor cursor = banco.rawQuery(countQuery, null);
        return cursor.getCount();
    }

    }



