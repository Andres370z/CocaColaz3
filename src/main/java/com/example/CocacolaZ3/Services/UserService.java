package com.example.CocacolaZ3.Services;

import com.example.CocacolaZ3.Entities.Empleados;
import com.example.CocacolaZ3.Entities.User;
import com.example.CocacolaZ3.Repository.IUserRepository;
import org.apache.coyote.Response;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Service
public class UserService {
   private IUserRepository userRepository;

   public UserService(IUserRepository repUser){this.userRepository = repUser;}
   public Reponse creaUsuario(User nuevoUsuario){
      Reponse reponse = new Reponse();
      this.userRepository.save(nuevoUsuario);
      reponse.setCode(200);
      reponse.setMensaje("Usuario registrado correctamente");
      return reponse;
   }
   ///METODO QUE PERMITE VALIDAR SI USUARIO Y CONTRASEÑAS EXISTEN EN LA BASE DE DATOS CON AYUDA DE IUSER REPOSITORY
   public Reponse loginUser(User data){
      Reponse reponse = new Reponse();
      ArrayList<User> existe = this.userRepository.validaCredenciales(data.getCorreo(), data.getContraseña());
      if (existe != null  && existe.size() > 0){
         reponse.setCode(200);
         reponse.setMensaje("Usuario registrado correctamente");
         return reponse;
      }
      reponse.setCode(500);
      reponse.setMensaje("Lamentablemente su usuario o contraseña son incorrectos");
      return reponse;
   }



}
