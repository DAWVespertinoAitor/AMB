/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Usuarios;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author aitor
 */
public class UsuariosDAO implements IUsuariosDAO {

    @Override
    public void addUsuario(Usuarios usuario) {
        String sql = "INSERT INTO usuarios (email, clave, ultimoAcceso, tipo, bloqueado) VALUES (?,?,?,?,?)";

        PreparedStatement preparada;

        try {
            preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.setString(1, usuario.getEmail());
            preparada.setString(2, String.valueOf(usuario.getClave()));
            preparada.setString(3, String.valueOf(usuario.getUltimoAcceso()));
            preparada.setString(4, String.valueOf(usuario.getTipo()));
            preparada.setString(5, String.valueOf(usuario.getBloqueado()));
            preparada.execute();

        } catch (SQLException ex) {
            ex.getStackTrace();
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public ArrayList<Usuarios> getUsuarios() {
        String sql = "SELECT * FROM usuarios";
        ArrayList<Usuarios> listaUsuarios = new ArrayList();
        Statement sentencia;

        try {
            
            sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);

            while (resultado.next()) {

                Usuarios usuario = new Usuarios();
                
                usuario.setIdUsuario(Integer.parseInt(resultado.getString("idUsuario")));
                usuario.setEmail(resultado.getString("email"));
                usuario.setClave(resultado.getString("clave").getBytes());
                usuario.setUltimoAcceso(Date.valueOf(resultado.getString("denominacion")));
                usuario.setTipo(resultado.getString("tipo").charAt(0));
                usuario.setBloqueado(resultado.getString("bloqueado").charAt(0));
            }

            resultado.close();
        } catch (SQLException ex) {
            ex.getStackTrace();
        } finally {
            this.closeConnection();
        }

        return listaUsuarios;
    }

    @Override
    public Usuarios getUsuario(int idUsuario) {
        Usuarios usuario = new Usuarios();
        
        String sql = "SELECT * FROM usuarios where idUsuario = " + idUsuario;
        Statement sentencia;
        try {
            sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            
            if (resultado.next()) {
                
                
                usuario.setIdUsuario(Integer.parseInt(resultado.getString("idUsuario")));
                usuario.setEmail(resultado.getString("email"));
                usuario.setClave(resultado.getString("clave").getBytes());
                usuario.setUltimoAcceso(Date.valueOf(resultado.getString("denominacion")));
                usuario.setTipo(resultado.getString("tipo").charAt(0));
                usuario.setBloqueado(resultado.getString("bloqueado").charAt(0));
            }
            resultado.close();
        } catch (SQLException ex) {
            ex.getStackTrace();
        } finally {
            this.closeConnection();
        }
        
        return usuario;
    }

    @Override
    public void updateUsuario(Usuarios usuario) {
        String sql = "UPDATE usuarios SET "
                + "email = '"+usuario.getEmail()+"', "
                + "clave = '"+usuario.getClave()+"', "
                + "ultimoAcceso = "+usuario.getUltimoAcceso()+" "
                + "tipo = "+usuario.getTipo()+" "
                + "bloqueado = "+usuario.getBloqueado()+" "
                + "WHERE idUsuario = "+usuario.getIdUsuario();
    
        PreparedStatement preparada;
        try {
            preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.execute();
            
        } catch (SQLException ex) {
            ex.getStackTrace();
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public void deleteUsuario(Usuarios usuario) {
        String sql = "DELETE FROM usuarios WHERE idUsuario = " + usuario.getIdUsuario();
        PreparedStatement preparada;
        try {
            preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.execute();

        } catch (SQLException ex) {
            ex.getStackTrace();
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public void closeConnection() {
        ConnectionFactory.closeConnection();
    }
    
}
