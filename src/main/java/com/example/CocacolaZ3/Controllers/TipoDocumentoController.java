package com.example.CocacolaZ3.Controllers;

import com.example.CocacolaZ3.Entities.TipoDocumento;
import com.example.CocacolaZ3.Services.TipoDocumentoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("tipodocumento")
public class TipoDocumentoController {
    private TipoDocumentoService service;
    public TipoDocumentoController(TipoDocumentoService ser){
        this.service = ser;
    }
    @RequestMapping("get")
    public ArrayList<TipoDocumento> get(){
        return this.service.selectAll();
    }

}
