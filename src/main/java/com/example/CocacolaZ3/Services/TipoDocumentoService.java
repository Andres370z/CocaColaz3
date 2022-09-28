package com.example.CocacolaZ3.Services;

import com.example.CocacolaZ3.Entities.TipoDocumento;
import com.example.CocacolaZ3.Repository.ITipoDocumentoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TipoDocumentoService {
    private ITipoDocumentoRepository repository;
    public TipoDocumentoService(ITipoDocumentoRepository rep){
        this.repository = rep;
    }
    public ArrayList<TipoDocumento> selectAll(){
        return (ArrayList<TipoDocumento>) this.repository.findAll();
    }
    ///Metodo que permite registrar un documento
    public Reponse createDocumento(TipoDocumento data){
        ArrayList<TipoDocumento> documentos = this.repository.findByNombre(data.getNombre());
        if(documentos != null && documentos.size() > 0){
            Reponse response = new Reponse();
            response.setCode(500);
            response.setMensaje("Este tipo de documento ya existe");
            return response;
        }
        this.repository.save(data);
        Reponse response = new Reponse();
        response.setCode(200);
        response.setMensaje("Documento registrado exitosamente");
        return response;
    }

}
