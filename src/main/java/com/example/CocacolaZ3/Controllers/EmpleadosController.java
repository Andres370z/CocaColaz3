package com.example.CocacolaZ3.Controllers;

import com.example.CocacolaZ3.Entities.Empleados;
import com.example.CocacolaZ3.Services.EmpleadosService;
import com.example.CocacolaZ3.Services.Reponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.Id;
import java.util.ArrayList;

@RestController
@RequestMapping("empleados")

public class EmpleadosController {

    private EmpleadosService empleadosService;
    public EmpleadosController(EmpleadosService serviEmpleado){
        this.empleadosService = serviEmpleado;

    }
    @RequestMapping("get")
    public ArrayList<Empleados> seleccionaTodo(){
        return this.empleadosService.seleccionaTodo();
    }
    @RequestMapping("get/{id}")
    public Empleados getEmpleados(@PathVariable int id){
        return this.empleadosService.seleccionaUnEmpleado(id);
    }

    @PostMapping("create")
    public Reponse creaEmpleado(@RequestBody Empleados nuevoEmpleado){
        return this.empleadosService.creaEmpleado(nuevoEmpleado);
    }
    @DeleteMapping("delete/{id}")
    public Reponse borraEmpleado(@PathVariable int id){
        return this.empleadosService.eliminaEmpleado(id);
    }
    @PutMapping("update")
    public Reponse actualizaEmpleado(@RequestBody Empleados actualizaNuevoEmpleado){
        return this.empleadosService.actualizaEmpleados(actualizaNuevoEmpleado);
    }


}
