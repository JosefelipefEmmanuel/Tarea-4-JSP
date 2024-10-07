/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;


import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Empleado;

@WebServlet(name = "sr_empleado", urlPatterns = {"/sr_empleado"})
public class sr_empleado extends HttpServlet {

    Empleado empleado;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet sr_empleado</title>");
            out.println("</head>");
            out.println("<body>");
           
            empleado = new Empleado(request.getParameter("txt_codigo"),
            Integer.valueOf(request.getParameter("drop_puesto")),
            Integer.valueOf(request.getParameter("txt_id")),
            request.getParameter("txt_nombres"),
            request.getParameter("txt_apellidos"),
            request.getParameter("txt_direccion"),
            request.getParameter("txt_telefono"),
            request.getParameter("txt_fn")); 
           
            if ("agregar".equals(request.getParameter("btn_agregar"))) {
                if (empleado.agregar() > 0) {
                    response.sendRedirect("index.jsp");
                } else {
                    out.println("<h1>Error al agregar</h1>");
                    out.println("<a href='index.jsp'>Regresar</a>");
                }
            } else if ("modificar".equals(request.getParameter("btn_modificar"))) {
                if (empleado.modificar() > 0) {
                    response.sendRedirect("index.jsp");
                } else {
                    out.println("<h1>Error al modificar</h1>");
                    out.println("<a href='index.jsp'>Regresar</a>");
                }
            } else if ("eliminar".equals(request.getParameter("btn_eliminar"))) {
                if (empleado.eliminar() > 0) {
                    response.sendRedirect("index.jsp");
                } else {
                    out.println("<h1>Error al eliminar</h1>");
                    out.println("<a href='index.jsp'>Regresar</a>");
                }
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}