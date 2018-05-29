/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Pedidos;
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
public class PedidosDAO implements IPedidosDAO{

    @Override
    public void addPedido(Pedidos pedido) {
        String sql = "INSERT INTO pedidos (fecha, estado, idCliente, baseImponible, gastosEnvio, iva) VALUES (?,?,?,?,?,?)";

        PreparedStatement preparada;

        try {
            preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.setString(1, String.valueOf(pedido.getFecha()));
            preparada.setString(2, String.valueOf(pedido.getEstado()));
            preparada.setString(3, String.valueOf(pedido.getIdCliente()));
            preparada.setString(4, String.valueOf(pedido.getBaseImponible()));
            preparada.setString(5, String.valueOf(pedido.getGastosEnvio()));
            preparada.setString(6, String.valueOf(pedido.getIva()));
            preparada.execute();

        } catch (SQLException ex) {
            ex.getStackTrace();
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public ArrayList<Pedidos> getPedidos() {
        String sql = "SELECT * FROM pedidos";
        ArrayList<Pedidos> listaPedidos = new ArrayList();
        Statement sentencia;

        try {
            
            sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);

            while (resultado.next()) {

                Pedidos pedido = new Pedidos();
                
                pedido.setIdPedido(Integer.parseInt(resultado.getString("idPedido")));
                pedido.setFecha(Date.valueOf(resultado.getString("fecha")));
                pedido.setEstado(resultado.getString("estado").charAt(0));
                pedido.setIdCliente(Integer.parseInt(resultado.getString("idCliente")));
                pedido.setBaseImponible(Double.valueOf(resultado.getString("baseImponible")));
                pedido.setGastosEnvio(Double.valueOf(resultado.getString("gastosEnvio")));
                pedido.setIva(Double.valueOf(resultado.getString("iva")));
            }

            resultado.close();
        } catch (SQLException ex) {
            ex.getStackTrace();
        } finally {
            this.closeConnection();
        }

        return listaPedidos;
    }

    @Override
    public Pedidos getPedido(int idPedido) {
        Pedidos pedido = new Pedidos();
        
        String sql = "SELECT * FROM pedidos where idPedido = " + idPedido;
        Statement sentencia;
        try {
            sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            
            if (resultado.next()) {
                
                
                pedido.setIdPedido(Integer.parseInt(resultado.getString("idPedido")));
                pedido.setFecha(Date.valueOf(resultado.getString("fecha")));
                pedido.setEstado(resultado.getString("estado").charAt(0));
                pedido.setIdCliente(Integer.parseInt(resultado.getString("idCliente")));
                pedido.setBaseImponible(Double.valueOf(resultado.getString("baseImponible")));
                pedido.setGastosEnvio(Double.valueOf(resultado.getString("gastosEnvio")));
                pedido.setIva(Double.valueOf(resultado.getString("iva")));
            }
            resultado.close();
        } catch (SQLException ex) {
            ex.getStackTrace();
        } finally {
            this.closeConnection();
        }
        
        return pedido;
    }

    @Override
    public void updatePedido(Pedidos pedido) {
        String sql = "UPDATE pedidos SET "
                + "fecha = '"+pedido.getFecha()+"', "
                + "estado = '"+pedido.getEstado()+"', "
                + "idCliente = "+pedido.getIdCliente()+" "
                + "baseImponible = "+pedido.getBaseImponible()+" "
                + "gastosEnvio = "+pedido.getGastosEnvio()+" "
                + "iva = "+pedido.getIva()+" "
                + "WHERE idPedido = "+pedido.getIdPedido();
    
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
    public void deletePedido(Pedidos pedido) {
        String sql = "DELETE FROM pedidos WHERE idPedido = " + pedido.getIdPedido();
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
