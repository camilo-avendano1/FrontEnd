package co.udea.ssmu.api.services.user;

import co.udea.ssmu.api.model.jpa.model.Usuario;

import java.util.List;

public interface IUserService {
    public boolean createUser(Usuario usuario);
    public List<Usuario> getUsers();
    public Usuario getUserById(Long id);
}
