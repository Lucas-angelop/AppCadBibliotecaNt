package br.com.appcadbibliotecant.persistencia;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import br.com.appcadbibliotecant.modelos.Aluno;

public class BaseDados {
    public static ObjectRepository<Aluno> rAlunos;

    public static void init(String file) {
        Nitrite db = Nitrite.builder()
                .compressed()
                .filePath(file)
                .openOrCreate("root", "salesiano");

        rAlunos = db.getRepository(Aluno.class);
    }
}
