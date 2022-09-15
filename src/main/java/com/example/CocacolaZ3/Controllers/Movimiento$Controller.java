package com.example.CocacolaZ3.Controllers;

import com.example.CocacolaZ3.Entities.Transacciones;
import com.example.CocacolaZ3.Services.MovimientosService;
import com.example.CocacolaZ3.Services.Reponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("Montos")
public class Movimiento$Controller {
    private MovimientosService movimientosService;
    public Movimiento$Controller(MovimientosService serTransaccion){
        this.movimientosService = serTransaccion;
    }
    //se trae datos de tabla transacciones
    @RequestMapping("get")
    public ArrayList<Transacciones> seleccionaTodo(){
        return this.movimientosService.seleccionaTodo();
    }
    @RequestMapping("{id}")
    public Transacciones gerTransaccione(@PathVariable int id){
        return this.movimientosService.seleccionaUno(id);
    }
    @PostMapping("create")
    private Reponse creaTransaccion(@RequestBody Transacciones nuevaTransaccion){
        return this.movimientosService.creaTransaccion(nuevaTransaccion);

    }
    @DeleteMapping("delete/{id}")
    public Reponse borraTransaccion(@PathVariable int id){
        return this.movimientosService.borraTransaccion(id);
    }

}
