/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.dao.ICategoriasDAO;
import es.albarregas.daofactory.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aitor
 */
@WebServlet(name = "Categorias", urlPatterns = {"/Categorias"})
public class Categorias extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = null;

        HttpSession sesion = request.getSession(true);

        DAOFactory daof = DAOFactory.getDAOFactory();
        ICategoriasDAO cdao = daof.getCategoriasDAO();

        Categorias categoria = new Categorias();
        List<es.albarregas.beans.Categorias> listaCate = cdao.getCategorias();

        if (sesion.getAttribute("categoriasSesion") == null) {
            System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
            System.out.println("Hola?");
            System.out.println(sesion.getAttribute("categoriasSesion"));
            sesion.setAttribute("categoriasSesion", listaCate);
            System.out.println("Tamaño lista si no existe la sesion" + listaCate.size());
            out.println("<ul class='nav nav-stacked'>");
            for (int i = 0; i < listaCate.size(); i++) {
                System.out.println(listaCate.get(i).getNombre());
                out.println("<li><a href=\"Controlador?cate=" + listaCate.get(i).getNombre() + "\">" + listaCate.get(i).getNombre() + "</a></li>");
            }
            out.println("</ul>");

        }
//        else {
//            System.out.println("Entro al else");
//            List<Categorias> lista = (List<Categorias>) sesion.getAttribute("categoriasSesion");
//            System.out.println("tamaño lista else" + lista.size());
//            out.println(" <ul class='nav nav-stacked'>");
//            for (int i = 0; i < lista.size(); i++) {
////                System.out.println(lista.get(i).getNombre());
//                out.println("<li><a href=\"Controlador?cate=" + listaCate.get(i).getNombre() + "\">" + listaCate.get(i).getNombre() + "</a></li>");
//            }
//            out.println("</ul>");
//        }
//        out.println("<ul class=\"dropdown-menu\">");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
