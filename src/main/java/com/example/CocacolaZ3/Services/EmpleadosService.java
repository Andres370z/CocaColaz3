package com.example.CocacolaZ3.Services;

import com.example.CocacolaZ3.Entities.Empleados;
import com.example.CocacolaZ3.Entities.Empresas;
import com.example.CocacolaZ3.Repository.IEmpleadosRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EmpleadosService {
    private IEmpleadosRepository empleadosRepository;
    public EmpleadosService(IEmpleadosRepository repEmpleados){
        this.empleadosRepository = repEmpleados;
    }
    ///Metodo para seleccionar datos de empresa
    public ArrayList<Empleados> seleccionaTodo() {
        return (ArrayList<Empleados>) this.empleadosRepository.findAll();
    }
    ///Ahora bien buscamos crear el metodo que consulte a una sola empresa

    public Empleados seleccionaUnEmpleado(int Id){
       Optional<Empleados> existeEmpleado = this.empleadosRepository.findById(Id);
       if (existeEmpleado.isPresent()){
           return existeEmpleado.get();
       }
       else {
           return null;
       }
    }
    ///Ahora creamos el metodo para crear un registro
    public Reponse creaEmpleado(Empleados nuevoDato){
        Reponse reponse = new Reponse();
        this.empleadosRepository.save(nuevoDato);
        reponse.setCode(200);
        reponse.setMensaje("Usuario registrado correctamente");
        return reponse;
    }
    //elimina datos
    public Reponse eliminaEmpleado(int id){
        Reponse reponse = new Reponse();
        try {
            this.empleadosRepository.deleteById(id);
            reponse.setCode(200);
            reponse.setMensaje("El empleado ha sido eliminado");
            return reponse;

        }
        catch (Exception ex){
            reponse.setCode(500);
            reponse.setMensaje("Eror al eliminar, " + ex.getMessage());
            return reponse;
        }
    }
    ///Metodo para editar el regustro de alguna empresa
    public Reponse actualizaEmpleados(Empleados actualizaRegistro){
        Reponse reponse = new Reponse();
        Empleados existeEmpleado = seleccionaUnEmpleado(actualizaRegistro.getId());
        if (actualizaRegistro.getId() == 0 || existeEmpleado == null){
            reponse.setMensaje("Error, el Id de la empresa no es valido o no existe");
            return reponse;
        }
        existeEmpleado.setNombreEmpleado(actualizaRegistro.getNombreEmpleado());
        existeEmpleado.setEmail(actualizaRegistro.getEmail());
        existeEmpleado.setCargo(actualizaRegistro.getCargo());
        existeEmpleado.setEnterprise(actualizaRegistro.getEnterprise());
        return reponse;
    }
}
