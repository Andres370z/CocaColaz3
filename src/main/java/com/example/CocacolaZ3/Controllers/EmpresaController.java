package com.example.CocacolaZ3.Controllers;

import com.example.CocacolaZ3.Entities.Empresas;
import com.example.CocacolaZ3.Services.EmpresaService;
import com.example.CocacolaZ3.Services.Reponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("empresas")
public class EmpresaController {
    private EmpresaService servicioaEmpresa;
    public EmpresaController(EmpresaService serviEmpresa){
        this.servicioaEmpresa = serviEmpresa;
    }
    /// esamos metodo creado en servicios
    @RequestMapping("get")
    public ArrayList<Empresas> seleccionaTodo(){
        return this.servicioaEmpresa.seleccionaTodo();
    }
    /// consultando una empresa
    @RequestMapping("get/{id}")
    public Empresas getempresa(@PathVariable int id){
        return this.servicioaEmpresa.seleccionaUnaEmpresa(id);
    }
    //crea una empresa
    @PostMapping("crea")
    public Reponse creaEmpresa(@RequestBody Empresas nuevaEmpresa){
        return this.servicioaEmpresa.creaEmpresa(nuevaEmpresa);

    }
    @DeleteMapping("delete/{id}")
    public Reponse borraEmpresa(@PathVariable int id){
        return this.servicioaEmpresa.EliminaEmpresa(id);
    }

    @PutMapping("update")
    public Reponse actualizaEmpresa(@RequestBody Empresas actualizaNuevaEmpresa){
        return this.servicioaEmpresa.actualizaEmpresa(actualizaNuevaEmpresa);
    }
}
