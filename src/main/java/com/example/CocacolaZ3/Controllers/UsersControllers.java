package com.example.CocacolaZ3.Controllers;

import com.example.CocacolaZ3.Entities.User;
import com.example.CocacolaZ3.Services.Reponse;
import com.example.CocacolaZ3.Services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("users")
public class UsersControllers {
    private UserService userService;
    public UsersControllers(UserService serviUsuario){
        this.userService = serviUsuario;
    }
    @PostMapping("crear")
    public Reponse creaUser(@RequestBody User nuevoUsurio){
        return this.userService.creaUsuario(nuevoUsurio);
    }

}
