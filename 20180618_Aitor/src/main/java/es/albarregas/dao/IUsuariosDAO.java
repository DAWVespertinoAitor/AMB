/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;


import es.albarregas.beans.Usuarios;
import java.util.ArrayList;

/**
 *
 * @author aitor
 */
public interface IUsuariosDAO {
    public void addUsuario(Usuarios usuarios);
    public ArrayList<Usuarios> getUsuarios();
    public Usuarios getUsuario(int idUsuario);
//    public ArrayList<Categorias> getAlumnosEquipo();
//    public ArrayList<Categorias> getAlumnosSinEquipo();
    
    public void updateUsuario(Usuarios usuarios);
    public void deleteUsuario(Usuarios usuarios);
    public void closeConnection();
}
