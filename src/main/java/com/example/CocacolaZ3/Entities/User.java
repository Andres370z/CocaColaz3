package com.example.CocacolaZ3.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Usuarios")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Nombres")
    private String Nombre;
    @Column(name = "Correo")
    private String Correo;
    @Column(name = "Password", length = 200)
    private String Contraseña;
    @Column(name = "Apellidos")
    private String Apellidos;
    @Column(name = "NumeroDocumento")
    private String NumeroDocumento;
    @Column(name = "TipoDocumento")
    private String TipoDocumento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getNumeroDocumento() {
        return NumeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        NumeroDocumento = numeroDocumento;
    }

    public String getTipoDocumento() {
        return TipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        TipoDocumento = tipoDocumento;
    }
}
