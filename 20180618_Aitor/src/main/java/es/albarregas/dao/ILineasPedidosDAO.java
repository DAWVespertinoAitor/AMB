/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.LineasPedidos;
import java.util.ArrayList;

/**
 *
 * @author aitor
 */
public interface ILineasPedidosDAO {
    public void addLineaPedido(LineasPedidos lineaPedido);
    public ArrayList<LineasPedidos> getLineasPedidos();
    public LineasPedidos getLineaPedido(int idLineaPedido);
    public void updateLineaPedido(LineasPedidos lineaPedido);
    public void deleteLineaPedido(LineasPedidos lineaPedido);
    public void closeConnection();
}
