/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Pedidos;
import java.util.ArrayList;

/**
 *
 * @author aitor
 */
public interface IPedidosDAO {
    public void addPedido(Pedidos pedidos);
    public ArrayList<Pedidos> getPedidos();
    public Pedidos getPedido(int idPedido);
    public void updatePedido(Pedidos pedidos);
    public void deletePedido(Pedidos pedidos);
    public void closeConnection();
}
