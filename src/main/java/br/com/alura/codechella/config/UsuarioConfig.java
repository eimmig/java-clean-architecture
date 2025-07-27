package br.com.alura.codechella.config;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.application.usecases.AlterarUsuarioUseCase;
import br.com.alura.codechella.application.usecases.CriarUsuarioUseCase;
import br.com.alura.codechella.application.usecases.ExcluirUsuarioUseCase;
import br.com.alura.codechella.application.usecases.ListarUsuariosUseCase;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioJpa;
import br.com.alura.codechella.infra.mapper.UsuarioEntityMapper;
import br.com.alura.codechella.infra.persistence.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    @Bean
    CriarUsuarioUseCase criarUsuarioUseCase(RepositorioDeUsuario repositorioDeUsuario) {
        return new CriarUsuarioUseCase(repositorioDeUsuario);
    }

    @Bean
    RepositorioDeUsuarioJpa repositorioDeUsuarioJpa(UsuarioRepository usuarioRepository, UsuarioEntityMapper usuarioEntityMapper) {
        return new RepositorioDeUsuarioJpa(usuarioRepository, usuarioEntityMapper);
    }

    @Bean
    UsuarioEntityMapper usuarioEntityMapper() {
        return new UsuarioEntityMapper();
    }

    @Bean
    ListarUsuariosUseCase listarUsuariosUseCase(RepositorioDeUsuario repositorioDeUsuario) {
        return new ListarUsuariosUseCase(repositorioDeUsuario);
    }

    @Bean
    AlterarUsuarioUseCase alteraUsuario(RepositorioDeUsuario repositorioDeUsuario){
        return new AlterarUsuarioUseCase(repositorioDeUsuario);
    }

    @Bean
    ExcluirUsuarioUseCase excluiUsuario(RepositorioDeUsuario repositorioDeUsuario){
        return new ExcluirUsuarioUseCase(repositorioDeUsuario);
    }
}
