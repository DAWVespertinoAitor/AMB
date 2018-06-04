/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Productos;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author aitor
 */
public class ProductosDAO implements IProductosDAO {

    @Override
    public void addProducto(Productos producto) {
        String sql = "INSERT INTO productos (idProducto, idMarca, denominacion, descripcion, precioUnitario, stock, stockMinimo, fechaAlta, oferta, fueraCatalogo) VALUES (?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement preparada;

        try {
            preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.setString(1, String.valueOf(producto.getIdProducto()));
            preparada.setString(2, String.valueOf(producto.getIdMarca()));
            preparada.setString(3, producto.getDenominacion());
            preparada.setString(4, producto.getDescripcion());
            preparada.setString(5, String.valueOf(producto.getPrecioUnitario()));
            preparada.setString(6, String.valueOf(producto.getStock()));
            preparada.setString(7, String.valueOf(producto.getStockMinimo()));
            preparada.setString(8, String.valueOf(producto.getFechaAlta()));
            preparada.setString(9, String.valueOf(producto.getOferta()));
            preparada.setString(10, String.valueOf(producto.getFueraCatalogo()));
            preparada.execute();

        } catch (SQLException ex) {
            ex.getStackTrace();
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public ArrayList<Productos> getProductos() {
        String sql = "SELECT * FROM productos";
        ArrayList<Productos> listaProductos = new ArrayList();
        Statement sentencia;

        try {

            sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);

            while (resultado.next()) {

                Productos producto = new Productos();

                producto.setIdProducto(Integer.parseInt(resultado.getString("idProducto")));
                producto.setIdCategoria(Integer.parseInt(resultado.getString("idCategoria")));
                producto.setIdMarca(Integer.parseInt(resultado.getString("idMarca")));
                producto.setDenominacion(resultado.getString("denominacion"));
                producto.setDescripcion(resultado.getString("descripcion"));
                producto.setPrecioUnitario(Double.valueOf(resultado.getString("precioUnitario")));
                producto.setStock(Integer.valueOf(resultado.getString("stock")));
                producto.setStockMinimo(Integer.valueOf(resultado.getString("stockMinimo")));
                producto.setFechaAlta(Timestamp.valueOf(resultado.getString("fechaAlta")));
                producto.setOferta(resultado.getString("oferta").charAt(0));
                producto.setFueraCatalogo(resultado.getString("fueraCatalogo").charAt(0));
                listaProductos.add(producto);
            }

            resultado.close();
        } catch (SQLException ex) {
            ex.getStackTrace();
        } finally {
            this.closeConnection();
        }

        return listaProductos;
    }

    @Override
    public ArrayList<Productos> getProductosGroupByCategoria(String idCategoria) {
        System.out.println("idCategoria " + idCategoria);
        String sql = "SELECT * FROM productos WHERE idCategoria = " + idCategoria;
        ArrayList<Productos> listaProductos = new ArrayList();
        Statement sentencia;
        try {

            sentencia = ConnectionFactory.getConnection().createStatement();
            try (ResultSet resultado = sentencia.executeQuery(sql)) {
                while (resultado.next()) {
                    
                    Productos producto = new Productos();
                    
                    producto.setIdProducto(Integer.parseInt(resultado.getString("idProducto")));
                    producto.setIdCategoria(Integer.parseInt(resultado.getString("idCategoria")));
                    producto.setIdMarca(Integer.parseInt(resultado.getString("idMarca")));
                    producto.setDenominacion(resultado.getString("denominacion"));
                    producto.setDescripcion(resultado.getString("descripcion"));
                    producto.setPrecioUnitario(Double.valueOf(resultado.getString("precioUnitario")));
                    producto.setStock(Integer.valueOf(resultado.getString("stock")));
                    producto.setStockMinimo(Integer.valueOf(resultado.getString("stockMinimo")));
                    producto.setFechaAlta(resultado.getTimestamp("fechaAlta"));
                    producto.setOferta(resultado.getString("oferta").charAt(0));
                    producto.setFueraCatalogo(resultado.getString("fueraCatalogo").charAt(0));
                    listaProductos.add(producto);
                }
            }
        } catch (SQLException ex) {
            ex.getStackTrace();
        } finally {
            this.closeConnection();
        }
        System.out.println("LISTA DAO " + listaProductos.size());
        return listaProductos;
    }

    @Override
    public Productos getProducto(int idProducto) {
        Productos producto = new Productos();

        String sql = "SELECT * FROM productos where idProducto = " + idProducto;
        Statement sentencia;
        try {
            sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);

            if (resultado.next()) {

                producto.setIdProducto(Integer.parseInt(resultado.getString("idProducto")));
                producto.setIdCategoria(Integer.parseInt(resultado.getString("idCategoria")));
                producto.setIdMarca(Integer.parseInt(resultado.getString("idMarca")));
                producto.setDenominacion(resultado.getString("denominacion"));
                producto.setDescripcion(resultado.getString("descripcion"));
                producto.setPrecioUnitario(Double.valueOf(resultado.getString("precioUnitario")));
                producto.setStock(Integer.valueOf(resultado.getString("stock")));
                producto.setStockMinimo(Integer.valueOf(resultado.getString("stockMinimo")));
                producto.setFechaAlta(Timestamp.valueOf(resultado.getString("fechaAlta")));
                producto.setOferta(resultado.getString("oferta").charAt(0));
                producto.setFueraCatalogo(resultado.getString("fueraCatalogo").charAt(0));
            }
            resultado.close();
        } catch (SQLException ex) {
            ex.getStackTrace();
        } finally {
            this.closeConnection();
        }

        return producto;
    }

    @Override
    public void updateProducto(Productos producto) {
        String sql = "UPDATE producto SET "
                + "idCategoria = '" + producto.getIdCategoria() + "', "
                + "idMarca = '" + producto.getIdMarca() + "', "
                + "denominacion = " + producto.getDenominacion() + " "
                + "descripcion = " + producto.getDescripcion() + " "
                + "precioUnitario = " + producto.getPrecioUnitario() + " "
                + "stock = " + producto.getStock() + " "
                + "stockMinimo = " + producto.getStockMinimo() + " "
                + "fechaAlta = " + producto.getFechaAlta() + " "
                + "oferta = " + producto.getOferta() + " "
                + "fueraCatalogo = " + producto.getFueraCatalogo() + " "
                + "WHERE idProducto = " + producto.getIdProducto();

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
    public void deleteProducto(Productos producto) {
        String sql = "DELETE FROM productos WHERE idProducto = " + producto.getIdProducto();
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
