package br.com.appcadbibliotecant;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import br.com.appcadbibliotecant.modelos.Aluno;
import br.com.appcadbibliotecant.persistencia.BaseDados;


public class MainActivity extends AppCompatActivity {

    private ListView listViewAlunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String nomeArquivoDB = getFilesDir().getPath() + "/baseDadosModelos.db";
        BaseDados.init(nomeArquivoDB);

        listViewAlunos = (ListView) findViewById(R.id.lista);
        listViewAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                abreAlteracao((Aluno) parent.getItemAtPosition(position));

            }
        });
    }

    private void abreAlteracao(Aluno a) {
        AtualizaActivity.aluno = a;
        startActivity(new Intent(this, AtualizaActivity.class));

    }

    public void abreTelaCadastro(View view) {
        startActivity(new Intent(this, AdicionaActivity.class));
    }


    @Override
    protected void onResume() {
        super.onResume();
        List<Aluno> lista = BaseDados.rAlunos.find().toList();
        final ArrayAdapter<Aluno> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);
        listViewAlunos.setAdapter(arrayAdapter);
    }
}

