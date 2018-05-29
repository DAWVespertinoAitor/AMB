/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Categorias;
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
public class CategoriasDAO implements ICategoriasDAO {

    @Override
    public void addCategoria(Categorias categoria) {
        String sql = "INSERT INTO categorias (nombre) VALUES (?)";

        PreparedStatement preparada;

        try {
            preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.setString(1, categoria.getNombre());
            preparada.execute();

        } catch (SQLException ex) {
            ex.getStackTrace();
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public ArrayList<Categorias> getCategorias() {
        String sql = "SELECT * FROM categorias";
        ArrayList<Categorias> listaCategorias = new ArrayList();
        Statement sentencia;

        try {
            
            sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);

            while (resultado.next()) {
                Categorias categoria = new Categorias();

                categoria.setIdCategoria(Integer.parseInt(resultado.getString("idCategoria")));
                categoria.setNombre(resultado.getString("nombre"));
                listaCategorias.add(categoria);
            }

            resultado.close();
        } catch (SQLException ex) {
            ex.getStackTrace();
        } finally {
            this.closeConnection();
        }

        return listaCategorias;
    }

    @Override
    public Categorias getCategoria(int idCategoria) {
        Categorias categoria = new Categorias();
        
        String sql = "SELECT * FROM categorias where idCategoria = " + idCategoria;
        Statement sentencia;
        try {
            sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            
            if (resultado.next()) {
                
                
                categoria.setIdCategoria(Integer.parseInt(resultado.getString("idCategoria")));
                categoria.setNombre(resultado.getString("nombre"));
            }
            resultado.close();
        } catch (SQLException ex) {
            ex.getStackTrace();
        } finally {
            this.closeConnection();
        }
        
        return categoria;
    }

    @Override
    public void updateCategoria(Categorias categoria) {
        String sql = "UPDATE categorias SET "
                + "nombre = '"+categoria.getNombre()+"', "
                + "WHERE idCategoria = "+categoria.getIdCategoria();
    
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
    public void deleteCategoria(Categorias categoria) {
        String sql = "DELETE FROM categorias WHERE idCategoria = " + categoria.getIdCategoria();
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
