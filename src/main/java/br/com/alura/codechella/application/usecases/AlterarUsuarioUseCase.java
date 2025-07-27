package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

public class AlterarUsuarioUseCase {
    private final RepositorioDeUsuario repositorio;

    public AlterarUsuarioUseCase(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public Usuario alteraDadosUsuario(String cpf, Usuario usuario) {
        return repositorio.alteraUsuario(cpf, usuario);
    }

}
