/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Clientes;
import java.util.ArrayList;

/**
 *
 * @author aitor
 */
public interface IClientesDAO {
    public void addCliente(Clientes clientes);
    public ArrayList<Clientes> getClientes();
    public Clientes getCliente(int idClientes);
    public void updateCliente(Clientes clientes);
    public void deleteCliente(Clientes clientes);
    public void closeConnection();
}
