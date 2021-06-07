package br.com.appcadbibliotecant;

import androidx.appcompat.app.AlertDialog;
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

public class AdicionaActivity extends AppCompatActivity {

    Aluno aluno = new Aluno();

    EditText edtNome, edtMatricula, edtLivro, edtDevolucao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("");
        setContentView(R.layout.activity_adiciona);
        edtNome = findViewById(R.id.edtNome);
        edtMatricula = findViewById(R.id.edtMatricula);
        edtLivro = findViewById(R.id.edtLivro);
        edtDevolucao = findViewById(R.id.edtDevolucao);
    }

    public void salvarAluno(View view) {
        try {
            this.aluno.nome = "" + edtNome.getText();
            this.aluno.matricula = Integer.valueOf("" + edtMatricula.getText());
            this.aluno.livro = "" + edtLivro.getText();
            this.aluno.devolucao = "" + edtDevolucao.getText();
            if (this.aluno.id == null) {
                BaseDados.rAlunos.insert(this.aluno);
            } else {
                BaseDados.rAlunos.update(this.aluno);
            }
        } catch (Exception ex) {
            new AlertDialog.Builder(this)
                    .setMessage(ex.getMessage())
                    .setPositiveButton(android.R.string.yes, null)
                    .show();
        }
        this.aluno = new Aluno();
        this.edtNome.setText("");
        this.edtMatricula.setText("");
        this.edtLivro.setText("");
        this.edtDevolucao.setText("");
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void cancelarAluno(View view) {
        this.aluno = new Aluno();

            edtNome.setText("");
            edtMatricula.setText("");
            edtLivro.setText("");
            edtDevolucao.setText("");

        edtNome.requestFocus();
        edtMatricula.requestFocus();
        edtLivro.requestFocus();
        edtDevolucao.requestFocus();
    }

    public void voltar(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
}