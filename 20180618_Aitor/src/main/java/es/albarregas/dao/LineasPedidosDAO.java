/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.LineasPedidos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author aitor
 */
public class LineasPedidosDAO implements ILineasPedidosDAO{

    @Override
    public void addLineaPedido(LineasPedidos lineaPedido) {
        String sql = "INSERT INTO lineaspedidos (idPedido, idProducto, cantidad, precioUnitario) VALUES (?,?,?,?)";

        PreparedStatement preparada;

        try {
            preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.setString(1, String.valueOf(lineaPedido.getIdPedido()));
            preparada.setString(1, String.valueOf(lineaPedido.getIdProducto()));
            preparada.setString(2, String.valueOf(lineaPedido.getCantidad()));
            preparada.setString(3, String.valueOf(lineaPedido.getPrecioUnitario()));
            preparada.execute();

        } catch (SQLException ex) {
            ex.getStackTrace();
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public ArrayList<LineasPedidos> getLineasPedidos() {
        String sql = "SELECT * FROM lineasPedidos";
        ArrayList<LineasPedidos> listaLineasPedidos = new ArrayList();
        Statement sentencia;

        try {
            
            sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);

            while (resultado.next()) {

                System.out.println("Entro aqui");
                LineasPedidos lineaPedido = new LineasPedidos();
                
                lineaPedido.setNumeroLinea(Integer.parseInt(resultado.getString("numeroLinea")));
                lineaPedido.setIdPedido(Integer.parseInt(resultado.getString("idImagen")));
                lineaPedido.setIdProducto(Integer.parseInt(resultado.getString("idPorducto")));
                lineaPedido.setCantidad(Integer.parseInt(resultado.getString("cantidad")));
                lineaPedido.setPrecioUnitario(Integer.parseInt(resultado.getString("precioUnitario")));
            }

            resultado.close();
        } catch (SQLException ex) {
            ex.getStackTrace();
        } finally {
            this.closeConnection();
        }

        return listaLineasPedidos;
    }

    @Override
    public LineasPedidos getLineaPedido(int idLineaPedido) {
        LineasPedidos lineaPedido = new LineasPedidos();
        
        String sql = "SELECT * FROM lineasPedidos where idLineaPedido = " + idLineaPedido;
        Statement sentencia;
        try {
            sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            
            if (resultado.next()) {
                
                lineaPedido.setNumeroLinea(Integer.parseInt(resultado.getString("numeroLinea")));
                lineaPedido.setIdPedido(Integer.parseInt(resultado.getString("idImagen")));
                lineaPedido.setIdProducto(Integer.parseInt(resultado.getString("idPorducto")));
                lineaPedido.setCantidad(Integer.parseInt(resultado.getString("cantidad")));
                lineaPedido.setPrecioUnitario(Integer.parseInt(resultado.getString("precioUnitario")));
            }
            resultado.close();
        } catch (SQLException ex) {
            ex.getStackTrace();
        } finally {
            this.closeConnection();
        }
        
        return lineaPedido;
    }

    @Override
    public void updateLineaPedido(LineasPedidos lineaPedido) {
        String sql = "UPDATE lineasPedidos SET "
                + "idProducto = '"+lineaPedido.getIdProducto()+"', "
                + "cantidad = '"+lineaPedido.getCantidad()+"', "
                + "precioUnitario = '"+lineaPedido.getPrecioUnitario()+"', "
                + "WHERE numeroLinea = "+lineaPedido.getNumeroLinea();
    
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
    public void deleteLineaPedido(LineasPedidos lineaPedido) {
        String sql = "DELETE FROM lineasPedidos WHERE numeroLinea = " + lineaPedido.getNumeroLinea();
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
