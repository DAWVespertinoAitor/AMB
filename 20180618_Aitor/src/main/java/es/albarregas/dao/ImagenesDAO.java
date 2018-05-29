/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Imagenes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author aitor
 */
public class ImagenesDAO implements IImagenesDAO {

    @Override
    public void addImagen(Imagenes imagen) {
        String sql = "INSERT INTO imagenes (idproducto, imagen, idx) VALUES (?,?,?)";

        PreparedStatement preparada;

        try {
            preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.setString(1, String.valueOf(imagen.getIdProducto()));
            preparada.setString(2, imagen.getImagen());
            preparada.setString(3, String.valueOf(imagen.getIdx()));
            preparada.execute();

        } catch (SQLException ex) {
            ex.getStackTrace();
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public ArrayList<Imagenes> getImagenes() {
        String sql = "SELECT * FROM imagenes";
        ArrayList<Imagenes> listaImagenes = new ArrayList();
        Statement sentencia;

        try {
            
            sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);

            while (resultado.next()) {

                System.out.println("Entro aqui");
                Imagenes imagen = new Imagenes();

                imagen.setIdImagen(Integer.parseInt(resultado.getString("idImagen")));
                imagen.setIdProducto(Integer.parseInt(resultado.getString("idPorducto")));
                imagen.setImagen(resultado.getString("imagen"));
                imagen.setIdx(Integer.parseInt(resultado.getString("idx")));
            }

            resultado.close();
        } catch (SQLException ex) {
            ex.getStackTrace();
        } finally {
            this.closeConnection();
        }

        return listaImagenes;
    }

    @Override
    public Imagenes getImagen(int idImagen) {
        Imagenes imagen = new Imagenes();
        
        String sql = "SELECT * FROM imagenes where idImagen = " + idImagen;
        Statement sentencia;
        try {
            sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            
            if (resultado.next()) {
                
                
                imagen.setIdImagen(Integer.parseInt(resultado.getString("idImagen")));
                imagen.setIdProducto(Integer.parseInt(resultado.getString("idPorducto")));
                imagen.setImagen(resultado.getString("imagen"));
                imagen.setIdx(Integer.parseInt(resultado.getString("idx")));
            }
            resultado.close();
        } catch (SQLException ex) {
            ex.getStackTrace();
        } finally {
            this.closeConnection();
        }
        
        return imagen;
    }

    @Override
    public void updateImagen(Imagenes imagen) {
        String sql = "UPDATE imagenes SET "
                + "idProducto = '"+imagen.getIdProducto()+"', "
                + "imagen = '"+imagen.getImagen()+"', "
                + "idx = '"+imagen.getIdx()+"', "
                + "WHERE idImagen = "+imagen.getIdImagen();
    
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
    public void deleteImagen(Imagenes imagen) {
        String sql = "DELETE FROM imagenes WHERE idImagen = " + imagen.getIdImagen();
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
