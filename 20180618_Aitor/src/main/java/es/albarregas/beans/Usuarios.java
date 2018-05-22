/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author aitor
 */
public class Usuarios implements Serializable {
    
    private int idUsuario;
    private String email;
    private byte[] clave;
    private Date ultimoAcceso;
    private char tipo;
    private char bloqueado;

    public Usuarios() {
    }

    public Usuarios(int idUsuario, String email, byte[] clave, Date ultimoAcceso, char tipo, char bloqueado) {
        this.idUsuario = idUsuario;
        this.email = email;
        this.clave = clave;
        this.ultimoAcceso = ultimoAcceso;
        this.tipo = tipo;
        this.bloqueado = bloqueado;
    }

    public char getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(char bloqueado) {
        this.bloqueado = bloqueado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getClave() {
        return clave;
    }

    public void setClave(byte[] clave) {
        this.clave = clave;
    }

    public Date getUltimoAcceso() {
        return ultimoAcceso;
    }

    public void setUltimoAcceso(Date ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
    
    
}
