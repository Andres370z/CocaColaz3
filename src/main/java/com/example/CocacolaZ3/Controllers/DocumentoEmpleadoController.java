package com.example.CocacolaZ3.Controllers;

import com.example.CocacolaZ3.Entities.Empleados;
import com.example.CocacolaZ3.Services.EmpleadosService;
import com.example.CocacolaZ3.Services.Reponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@Controller
@RequestMapping("documentoempleado")
public class DocumentoEmpleadoController {
    private EmpleadosService empleadosService;
    public DocumentoEmpleadoController(EmpleadosService serviEmpleado){
        this.empleadosService = serviEmpleado;

    }
///Consulta documentos a ala base de datos
    @GetMapping("index")
    public String index(Model documentos){
        ArrayList<Empleados> EmpleadosZ = this.empleadosService.seleccionaTodo();
        documentos.addAttribute("misdocumentos",EmpleadosZ );
        return "empleados/index";
    }

    @GetMapping("createuser")
    public String create(){
        return "empleados/create";
    }
    @PostMapping("createemployee")
    public RedirectView creaEmpleado(Empleados nuevoEmpleado){
        Reponse reponse = this.empleadosService.creaEmpleado(nuevoEmpleado);
        return new RedirectView("/documentoempleado/index");
    }
}
