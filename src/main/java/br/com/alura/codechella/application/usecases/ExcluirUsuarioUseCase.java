package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;

public class ExcluirUsuarioUseCase {
    private final RepositorioDeUsuario repositorio;

    public ExcluirUsuarioUseCase(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public void excluirUsuario(String cpf) {
        repositorio.excluiUsuario(cpf);
    }
}
