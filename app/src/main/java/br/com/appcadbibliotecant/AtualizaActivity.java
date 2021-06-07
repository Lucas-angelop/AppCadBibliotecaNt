package br.com.appcadbibliotecant;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import br.com.appcadbibliotecant.modelos.Aluno;
import br.com.appcadbibliotecant.persistencia.BaseDados;

public class AtualizaActivity extends AppCompatActivity {


    public static Aluno aluno = new Aluno();
    EditText edtNome, edtMatricula, edtLivro, edtDevolucao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualiza2);
        setTitle("");

        try {
            edtNome = ((EditText)findViewById(R.id.edtNome));
            edtNome.setText(aluno.getNome());
            edtMatricula = ((EditText)findViewById(R.id.edtMatricula));
            edtMatricula.setText(String.valueOf(aluno.getMatricula()));
            edtLivro = ((EditText)findViewById(R.id.edtLivro));
            edtLivro.setText(aluno.getLivro());
            edtDevolucao = ((EditText)findViewById(R.id.edtDevolucao));
            edtDevolucao.setText(aluno.getDevolucao());

        } catch (Exception ex) {
            new AlertDialog.Builder(this)
                    .setMessage(ex.getMessage())
                    .setPositiveButton(android.R.string.yes, null)
                    .show();}

        }
    

    public void atualizar(View view){

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

    public void excluir(View v){

        BaseDados.rAlunos.remove(this.aluno);
        finish(); }

    public void voltar(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

}