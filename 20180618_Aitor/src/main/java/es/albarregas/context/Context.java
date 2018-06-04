/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.context;

import es.albarregas.beans.Categorias;
import es.albarregas.beans.Productos;
import es.albarregas.dao.ICategoriasDAO;
import es.albarregas.dao.IProductosDAO;
import es.albarregas.daofactory.DAOFactory;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
/**
 *
 * @author aitor
 */
@WebListener
public class Context implements ServletContextListener{
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        

        System.out.println("Entro a iniciar");
        ServletContext contexto = sce.getServletContext();
        DAOFactory daof = DAOFactory.getDAOFactory();
        
        ICategoriasDAO cdao = daof.getCategoriasDAO();
        
        
        Categorias categoria = new Categorias();
//        
        List<Categorias> listaCate = cdao.getCategorias();
        
        
        
        System.out.println("Tamaño de la lista de categorias " +listaCate.size());
        
        synchronized (contexto){
            contexto.setAttribute("categoriasSesion", listaCate);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Entro a destruir");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
