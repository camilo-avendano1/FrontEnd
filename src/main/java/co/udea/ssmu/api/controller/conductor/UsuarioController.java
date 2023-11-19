package co.udea.ssmu.api.controller.conductor;


import co.udea.ssmu.api.model.jpa.model.Usuario;
import co.udea.ssmu.api.services.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UsuarioController {

    @Autowired
    private IUserService userService;


    @PostMapping("/create")
    public ResponseEntity<HttpStatus> crearUsuario(@RequestBody Usuario usuario){
        boolean isCreated = this.userService.createUser(usuario);
        if(isCreated) return new ResponseEntity<>(HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("")
    public ResponseEntity<List<Usuario>> obtenerUsuarios(){
        List<Usuario> usuarios = this.userService.getUsers();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerUsuario(@PathVariable Long id){
        Usuario usuario = this.userService.getUserById(id);
        if(usuario == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
}
