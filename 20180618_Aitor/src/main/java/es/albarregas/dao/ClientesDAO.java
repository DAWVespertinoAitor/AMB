/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Clientes;
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
public class ClientesDAO implements IClientesDAO {

    @Override
    public void addCliente(Clientes cliente) {
        String sql = "INSERT INTO alumnos (nombre, apellidos, nif, direccion, codigopostal, localidad, provincia, telefono, fechaNacimiento, fechaAlta, avatar) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement preparada;

        try {
            preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.setString(1, cliente.getNombre());
            preparada.setString(2, cliente.getApellidos());
            preparada.setString(3, cliente.getNif());
            preparada.setString(4, cliente.getDireccion());
            preparada.setString(5, cliente.getCodigoPostal());
            preparada.setString(6, cliente.getLocalidad());
            preparada.setString(7, cliente.getProvincia());
            preparada.setString(8, cliente.getTelefono());
            preparada.setString(9, String.valueOf(cliente.getFechaNacimiento()));
            preparada.setString(10, String.valueOf(cliente.getFechaAlta()));
            preparada.setString(11, String.valueOf(cliente.getAvatar()));
            preparada.execute();

        } catch (SQLException ex) {
            ex.getStackTrace();
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public ArrayList<Clientes> getClientes() {
//        String sql = "SELECT * FROM clientes INNER JOIN usuarios ON alumnos.idEquipo = equipos.idEquipo";
        String sql = "SELECT * FROM clientes";
        ArrayList<Clientes> listaClientes = new ArrayList();
        Statement sentencia;

        try {
            
            sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);

            while (resultado.next()) {

                System.out.println("Entro aqui");
                Clientes cliente = new Clientes();

                cliente.setIdCliente(Integer.parseInt(resultado.getString("idCliente")));
                cliente.setNombre(resultado.getString("nombre"));
                cliente.setApellidos(resultado.getString("apellidos"));
                cliente.setNif(resultado.getString("nif"));
                cliente.setDireccion(resultado.getString("direccion"));
                cliente.setCodigoPostal(resultado.getString("codigoPostal"));
                cliente.setLocalidad(resultado.getString("localidad"));
                cliente.setProvincia(resultado.getString("provincia"));
                cliente.setTelefono(resultado.getString("telefono"));
                cliente.setFechaNacimiento(Date.valueOf(resultado.getString("fechaNacimiento")));
                cliente.setFechaAlta(Date.valueOf(resultado.getString("fechaAlta")));
                cliente.setAvatar(resultado.getString("avatar").getBytes());
            }

            resultado.close();
        } catch (SQLException ex) {
            ex.getStackTrace();
        } finally {
            this.closeConnection();
        }

        return listaClientes;
    }

    @Override
    public Clientes getCliente(int idCliente) {
//        DAOFactory daof = DAOFactory.getDAOFactory();
//        IEquiposDAO edao = daof.getEquiposDAO();
        Clientes cliente = new Clientes();
        
        String sql = "SELECT * FROM clientes where idCliente = " + idCliente;
        Statement sentencia;
        try {
            sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            
            if (resultado.next()) {
                
                
                cliente.setIdCliente(Integer.parseInt(resultado.getString("idCliente")));
                cliente.setNombre(resultado.getString("nombre"));
                cliente.setApellidos(resultado.getString("apellidos"));
                cliente.setNif(resultado.getString("nif"));
                cliente.setDireccion(resultado.getString("direccion"));
                cliente.setCodigoPostal(resultado.getString("codigoPostal"));
                cliente.setLocalidad(resultado.getString("localidad"));
                cliente.setProvincia(resultado.getString("provincia"));
                cliente.setTelefono(resultado.getString("telefono"));
                cliente.setFechaNacimiento(Date.valueOf(resultado.getString("fechaNacimiento")));
                cliente.setFechaAlta(Date.valueOf(resultado.getString("fechaAlta")));
                cliente.setAvatar(resultado.getString("avatar").getBytes());
            }
            resultado.close();
        } catch (SQLException ex) {
            ex.getStackTrace();
        } finally {
            this.closeConnection();
        }
        
        return cliente;
    }

    @Override
    public void updateCliente(Clientes cliente) {
        String sql = "UPDATE cliente SET "
                + "nombre = '"+cliente.getNombre()+"', "
                + "apellidos = '"+cliente.getApellidos()+"', "
                + "nif = '"+cliente.getNif()+"', "
                + "direccion = "+cliente.getDireccion()+" "
                + "codigoPostal = "+cliente.getCodigoPostal()+" "
                + "localidad = "+cliente.getLocalidad()+" "
                + "provincia = "+cliente.getProvincia()+" "
                + "telefono = "+cliente.getTelefono()+" "
                + "fechaNacimiento = "+cliente.getFechaNacimiento()+" "
                + "fechaAlta = "+cliente.getFechaAlta()+" "
                + "avatar = "+cliente.getAvatar()+" "
                + "WHERE idAlumno = "+cliente.getIdCliente();
    
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
    public void deleteCliente(Clientes clientes) {
        String sql = "DELETE FROM clientes WHERE idCliente = " + clientes.getIdCliente();
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
