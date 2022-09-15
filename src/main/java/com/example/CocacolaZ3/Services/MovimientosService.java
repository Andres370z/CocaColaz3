package com.example.CocacolaZ3.Services;

import com.example.CocacolaZ3.Entities.Transacciones;
import com.example.CocacolaZ3.Repository.ITransaccionesRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MovimientosService {
    /// a traer datos metodos
    private ITransaccionesRepository transaccionesRepository;

    public MovimientosService(ITransaccionesRepository repTransanccion){
        this.transaccionesRepository = repTransanccion;
    }
    public ArrayList<Transacciones> seleccionaTodo(){
        return (ArrayList<Transacciones>) this.transaccionesRepository.findAll();
    }
    public Transacciones seleccionaUno(int id){
        Optional<Transacciones> existeMovimiento = this.transaccionesRepository.findById(id);
        if (existeMovimiento.isPresent()){
            return existeMovimiento.get();
        }
        else {
            return null;
        }
    }
    /// registro en transaccion
    public Reponse creaTransaccion(Transacciones nuevaTransaccion){
        Reponse reponse = new Reponse();
        this.transaccionesRepository.save(nuevaTransaccion);
        reponse.setCode(200);
        reponse.setMensaje("Transaccion registrada Exitosamente");
        return reponse;
    }
    public Reponse borraTransaccion(int id) {
        Reponse reponse = new Reponse();
        try {
            this.transaccionesRepository.deleteById(id);
            reponse.setCode(200);
            reponse.setMensaje("Transaccion realizada con exito");
            return reponse;
        } catch (Exception ex) {
            reponse.setCode(500);
            reponse.setMensaje("Error " + ex.getMessage());
            return reponse;
        }
    }

}

