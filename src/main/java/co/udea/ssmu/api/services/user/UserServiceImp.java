package co.udea.ssmu.api.services.user;

import co.udea.ssmu.api.model.jpa.model.Usuario;
import co.udea.ssmu.api.model.jpa.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements IUserService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public boolean createUser(Usuario usuario) {
        try {
            this.usuarioRepository.save(usuario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public List<Usuario> getUsers() {
        return this.usuarioRepository.findAll();
    }

    @Override
    public Usuario getUserById(Long id) {
        return this.usuarioRepository.findById(id).orElse(null);
    }

}
