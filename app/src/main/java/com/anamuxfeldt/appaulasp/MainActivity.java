package com.anamuxfeldt.appaulasp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "App_aulaSP";
    private static final String PREF_NOME = "App_aulaSP_pref";

///criar arquivo para salvar os dados
    SharedPreferences sharedPreferences;
    ///criar objeto para salvar os dados
    SharedPreferences.Editor dados;
//// definir tipo dos dados
    String nomeProduto;
    int codigoProduto;
    float  precoProduto;
    boolean estoque;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "Rodando...");

        sharedPreferences = getSharedPreferences(PREF_NOME, Context.MODE_PRIVATE);
        Log.i(TAG, "Pasta SharedPreferences criada...");

        //criar acesso aos dados 1º passo abrir a edição
        dados = sharedPreferences.edit();

        nomeProduto = "Notebook";
        codigoProduto = 12345;
        precoProduto = 999.97f;
        estoque = true;

                ///salvar os dados no SharedPreferences
        dados.putString("nomeProduto", nomeProduto);
        dados.putInt("codigoProduto", codigoProduto);
        dados.putFloat("precoProduto", precoProduto);
        dados.putBoolean("estoque", estoque);

//salva dados no XML
        dados.apply();
        //Modo Debug
        Log.i(TAG, "Dados para serem salvos...");
        Log.w(TAG, "Produto: "+nomeProduto);
        Log.w(TAG, "Código: "+codigoProduto);
        Log.w(TAG, "Preço: "+precoProduto);
        Log.w(TAG, "Tem no Estoque: "+estoque);


        //limpar dados salvos
       // dados.clear();
       // dados.apply();

        ///deletar algum objeto
        //dados.remove("estoque");
        //dados.apply();

        //recuperar os dados salvos na SharedPreferences
        Log.i(TAG, "Dados recuperados...");

        Log.w(TAG, "Produto: "+sharedPreferences.getString("nomeProduto","fora de estoque"));
        Log.w(TAG, "Código: "+sharedPreferences.getInt("codigoProduto", -1));
        Log.w(TAG, "Preço: "+sharedPreferences.getFloat("precoProduto", -1.0f));
        Log.w(TAG, "Tem no Estoque: "+sharedPreferences.getBoolean("estoque", false));
    }
}