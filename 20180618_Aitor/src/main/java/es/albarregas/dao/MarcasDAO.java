/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Marcas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author aitor
 */
public class MarcasDAO implements IMarcasDAO{

    @Override
    public void addMarca(Marcas marca) {
        String sql = "INSERT INTO marcas (denominacion) VALUES (?)";

        PreparedStatement preparada;

        try {
            preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.setString(1, marca.getDenominacion());
            preparada.execute();

        } catch (SQLException ex) {
            ex.getStackTrace();
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public ArrayList<Marcas> getMarcas() {
        String sql = "SELECT * FROM marcas";
        ArrayList<Marcas> listaMarcas = new ArrayList();
        Statement sentencia;

        try {
            
            sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);

            while (resultado.next()) {

                System.out.println("Entro aqui");
                Marcas marca = new Marcas();
                
                marca.setIdMarca(Integer.parseInt(resultado.getString("idMarca")));
                marca.setDenominacion(resultado.getString("denominacion"));
            }

            resultado.close();
        } catch (SQLException ex) {
            ex.getStackTrace();
        } finally {
            this.closeConnection();
        }

        return listaMarcas;
    }

    @Override
    public Marcas getMarca(int idMarca) {
        Marcas marca = new Marcas();
        
        String sql = "SELECT * FROM marcas where idMarca = " + idMarca;
        Statement sentencia;
        try {
            sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            
            if (resultado.next()) {
                
                marca.setIdMarca(Integer.parseInt(resultado.getString("idMarca")));
                marca.setDenominacion(resultado.getString("denominacion"));
            }
            resultado.close();
        } catch (SQLException ex) {
            ex.getStackTrace();
        } finally {
            this.closeConnection();
        }
        
        return marca;
    }

    @Override
    public void updateMarca(Marcas marca) {
        String sql = "UPDATE marcas SET "
                + "cantidad = '"+marca.getDenominacion()+"', "
                + "WHERE idMarca = "+marca.getIdMarca();
    
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
    public void deleteMarca(Marcas marca) {
        String sql = "DELETE FROM marcas WHERE idMarca = " + marca.getIdMarca();
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
