package br.com.alura.codechella;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioEmArquivo;

import java.time.LocalDate;

public class UtilizaUsuarioComArquivos {
    public static void main(String[] args) {
        RepositorioDeUsuarioEmArquivo repositorioDeUsuarioEmArquivo = new RepositorioDeUsuarioEmArquivo();

        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario(
                "123.456.789-01",
                "João da Silva",
                LocalDate.parse("2002-06-13"),
                "teste@teste.com"
        ));

        repositorioDeUsuarioEmArquivo.listarTodos()
                .forEach(usuario -> System.out.println("Usuário cadastrado: " + usuario.getNome()));
    }
}
