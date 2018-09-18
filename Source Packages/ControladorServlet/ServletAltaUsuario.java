package ControladorServlet;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Fabrica;
import logica.Interfaces.IControladorUsuario;

@WebServlet(name = "ServletAltaUsuario", urlPatterns = {"/altaUsuarioServlet"})

public class ServletAltaUsuario extends HttpServlet {

    IControladorUsuario iUsuario;

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletAltaUsuario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletAltaUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        iUsuario = Fabrica.getInstance().getIControladorUsuario();
        Boolean ok = false;
        String operacion = request.getParameter("op");
        switch (operacion) {
            case "1":
                String nick = request.getParameter("nick");
                String nombre = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                String correo = request.getParameter("correo");
                String pass = request.getParameter("pass");
                String fecha = (request.getParameter("fecha") == null ? "" : request.getParameter("fecha"));
                String pass2 = request.getParameter("pass2");
                String direccion = request.getParameter("direccion");
                String sitio = request.getParameter("sitio");
                String biografia = request.getParameter("biografia");
                String tipoP = request.getParameter("tipo");
                String imagen = "";
                String mensaje;

                if (tipoP == "proponente") {
                    Calendar cal;
                    DateFormat format = new SimpleDateFormat("yyyy/mm/dd");
                    format.format(fecha);
                    cal = format.getCalendar();
                    ok = iUsuario.AgregarUsuarioProponente(nick, nombre, apellido, correo, cal, imagen, direccion, biografia, sitio, pass);
                    if (ok) {
                        mensaje = "Se registro exitosamente";
                        request.setAttribute("mensaje", mensaje);
                        request.getRequestDispatcher("/Vistas/altaUsuario.jsp").forward(request, response);
                    } else {
                        mensaje = "Error al registrar este usuario";
                        request.setAttribute("mensaje", mensaje);
                        request.getRequestDispatcher("/Vistas/altaUsuario.jsp").forward(request, response);
                    }

                } else {
                    Calendar cal;
                    DateFormat format = new SimpleDateFormat("yyyy/mm/dd");
                    format.format(fecha);
                    cal = format.getCalendar();
                    ok = iUsuario.AgregarUsuarioColaborador(nick, nombre, apellido, correo, cal, pass, pass);
                    if (ok) {
                        mensaje = "Se registro exitosamente";
                        request.setAttribute("mensaje", mensaje);
                        request.getRequestDispatcher("/Vistas/altaUsuario.jsp").forward(request, response);
                    } else {
                        mensaje = "Error al dar registrar este usuario";
                        request.setAttribute("mensaje", mensaje);
                        request.getRequestDispatcher("/Vistas/altaUsuario.jsp").forward(request, response);
                    }
                }
                break;
            default:
                break;
        }

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
