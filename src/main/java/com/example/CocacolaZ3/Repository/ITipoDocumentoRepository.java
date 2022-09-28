package com.example.CocacolaZ3.Repository;

import com.example.CocacolaZ3.Entities.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface ITipoDocumentoRepository extends JpaRepository<TipoDocumento,Integer> {
    @Query("SELECT v FROM TipoDocumento v WHERE v.nombre = ?1")
    ArrayList<TipoDocumento> findByNombre(String nombre);
}
