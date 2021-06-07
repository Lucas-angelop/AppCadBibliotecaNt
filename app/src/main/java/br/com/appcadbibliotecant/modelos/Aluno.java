package br.com.appcadbibliotecant.modelos;

import android.os.Build;

import androidx.annotation.RequiresApi;

import org.dizitart.no2.IndexType;
import org.dizitart.no2.NitriteId;
import org.dizitart.no2.objects.Id;
import org.dizitart.no2.objects.Index;
import org.dizitart.no2.objects.Indices;

import java.io.Serializable;
import java.util.Objects;

@Indices(value = {
        @Index(value = "nome", type = IndexType.Unique)

})
public class Aluno {
    @Id
    public NitriteId id;// gerado automaticamente
    public String nome;
    public Integer matricula;
    public String livro;
    public String devolucao;

    // GET SET
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getLivro() {
        return livro;
    }

    public void setLivro(String livro) {
        this.livro = livro;
    }

    public String getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(String devolucao) {
        this.devolucao = devolucao;
    }

    // GET SET

    @Override
    public String toString() {
        return "\n Nome: " + this.nome + "\n Matricula: " + this.matricula + "\n Livro: " + this.livro + "\n Devolucao: " + this.devolucao;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(id, aluno.id);
    }

}
