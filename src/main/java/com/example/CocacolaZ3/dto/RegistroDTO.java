package com.example.CocacolaZ3.dto;

public class RegistroDTO {
    private String Nombre;
    private String Apellidos;
    private String Correo;
    private String Contraseña;
    private String NumeroDocumento;
    private String TipoDocumento;
    private String ValidaPassword;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
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

    public String getValidaPassword() {
        return ValidaPassword;
    }

    public void setValidaPassword(String validaPassword) {
        ValidaPassword = validaPassword;
    }
}
