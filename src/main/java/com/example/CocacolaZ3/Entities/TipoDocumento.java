package com.example.CocacolaZ3.Entities;

import javax.persistence.*;

@Entity
@Table(name = "tipodocumento")
public class TipoDocumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
