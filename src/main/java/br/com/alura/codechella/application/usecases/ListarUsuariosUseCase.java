package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioJpa;

import java.util.List;

public class ListarUsuariosUseCase {

    private final RepositorioDeUsuario repositorio;

    public ListarUsuariosUseCase(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public List<Usuario> listar() {
       return repositorio.listarTodos();
    }
}
