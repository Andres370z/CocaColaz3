package com.example.CocacolaZ3.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Empresas")
public class Empresas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Nombre")
    private String name;
    @Column(name = "Direccion")
    private String domicilio;
    @Column(name = "Telefono")
    private int tel;
    @Column(name = "NIT")
    private  int Ndocumento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public int getNdocumento() {
        return Ndocumento;
    }

    public void setNdocumento(int ndocumento) {
        Ndocumento = ndocumento;
    }
}
