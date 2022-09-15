package com.example.CocacolaZ3.Services;

import com.example.CocacolaZ3.Entities.Empresas;
import com.example.CocacolaZ3.Repository.IEmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EmpresaService {
    private IEmpresaRepository empresaRepository;
    public EmpresaService(IEmpresaRepository repEmpresa){
        this.empresaRepository = repEmpresa;
    }
    ///Metodo para seleccionar datos de empresa
    public ArrayList<Empresas> seleccionaTodo(){
        return (ArrayList<Empresas>)this.empresaRepository.findAll();
    }
    ///Ahora bien buscamos crear el metodo que consulte a una sola empresa

    public Empresas seleccionaUnaEmpresa(int Id){
        Optional<Empresas> ExisteEmpresa = this.empresaRepository.findById(Id);
        if (ExisteEmpresa.isPresent()){
            return ExisteEmpresa.get();
        }
        else{
            return null;
        }

    }
    ///Ahora creamos el metodo para crear un registro
    public Reponse creaEmpresa(Empresas nuevaEmpresa){
        Reponse reponse = new Reponse();
        this.empresaRepository.save(nuevaEmpresa);
        reponse.setCode(200);
        reponse.setMensaje("En hora buena la empresa se añadio de manera exitosa");
        return reponse;
    }
    ///Ahora crewamos el metodo que permitira eliminar un registro
    public Reponse EliminaEmpresa(int id){
        Reponse reponse = new Reponse();
        try {
            this.empresaRepository.deleteById(id);
            reponse.setCode(200);
            reponse.setMensaje("Empresa eliminada existosamente");
            return reponse;
        }catch (Exception ex){
            reponse.setCode(500);
            reponse.setMensaje("Error,"+ex.getMessage());
            return reponse;
        }
    }
    ///Metodo para editar el regustro de alguna empresa
    public Reponse actualizaEmpresa(Empresas actualizaNuevaEmpresa){
        Reponse reponse = new Reponse();
        Empresas existeEmpresa = seleccionaUnaEmpresa(actualizaNuevaEmpresa.getId());
        if(actualizaNuevaEmpresa.getId() == 0 || existeEmpresa ==null){
            reponse.setMensaje("Error, el Id de la empresa no es valido o no existe");
            return reponse;
        }
        existeEmpresa.setDomicilio(actualizaNuevaEmpresa.getDomicilio());
        existeEmpresa.setNdocumento(actualizaNuevaEmpresa.getNdocumento());
        existeEmpresa.setName(actualizaNuevaEmpresa.getName());
        existeEmpresa.setTel(actualizaNuevaEmpresa.getTel());
        reponse.setCode(200);
        reponse.setMensaje("En hora buenas los datos se modificaron de manera correcta");
        return reponse;
    }
}
