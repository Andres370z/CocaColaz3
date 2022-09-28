package com.example.CocacolaZ3.Controllers;

import com.example.CocacolaZ3.Entities.User;
import com.example.CocacolaZ3.Services.Reponse;
import com.example.CocacolaZ3.Services.UserService;
import com.example.CocacolaZ3.dto.RegistroDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;
///importante para logear
@Controller
@RequestMapping("login")
public class LoginController {
    private UserService service;
    public LoginController(UserService service){
        this.service = service;
    }

    @GetMapping("login")
    public String login(){return "login/login";}
    @GetMapping("registro")
    public String registro(){return "login/registro";}

    @PostMapping("postlogin")
    public RedirectView postlogin(User data){
        Reponse reponse = this.service.loginUser(data);
        if (reponse.getCode() == 200){
            return new RedirectView("/inicio");

        }
        else {
            return new RedirectView("/login/error");

        }
    }
    @PostMapping("postregistro")
    public RedirectView postregistro(RegistroDTO data){
        if (data.getContraseña().equals(null) || data.getContraseña()== ""){
            System.out.println("Contraseña no valida");
            return new RedirectView("/login/error");
        }
        if (!data.getContraseña().equals(data.getValidaPassword())){
            System.out.println("la contraseña no coincide");
            return new RedirectView("/login/error");
        }
        User user = new User();
        //Maping
        user.setCorreo(data.getCorreo());
        user.setContraseña(data.getContraseña());
        user.setNombre(data.getNombre());
        user.setApellidos(data.getApellidos());
        user.setNumeroDocumento(data.getNumeroDocumento());
        user.setTipoDocumento(data.getTipoDocumento());


        Reponse reponse = this.service.creaUsuario(user);
        System.out.println(reponse.getMensaje());
        if (reponse.getCode() == 200){
            return new RedirectView("/inicio");

        }
        else {
            return new RedirectView("/login/error");

        }
    }
    @GetMapping("error")
    public String error(){
        return "login/error";
    }



}
