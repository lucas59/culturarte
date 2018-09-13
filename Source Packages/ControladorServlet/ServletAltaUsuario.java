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

@WebServlet("/registrarse")
public class ServletAltaUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public static final String MENSAJE_ERROR = "mensaje_error";
    public static final String MENSAJE_EXITO = "mensaje_exito";

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
        String nick = request.getParameter("nick");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correo = request.getParameter("correo");
        String pass = request.getParameter("pass");
        String fecha = (request.getParameter("fecha") == null ? "" : request.getParameter("fecha"));
        String confPass = request.getParameter("confPass");
        String direccion = request.getParameter("direccion");
        String sitio = request.getParameter("sitio");
        String biografia = request.getParameter("biografia");
        String tipoP = request.getParameter("tipo");
        String imagen = "";

        if (tipoP == "proponente") {
            if (!nick.equals("") && !apellido.equals("") && !correo.equals("") && !fecha.equals("") && !pass.equals("") && !confPass.equals("")) {
                Calendar cal;
                DateFormat format = new SimpleDateFormat("yyyy/mm/dd");
                format.format(fecha);
                cal = format.getCalendar();
                try {
                    logica.Controladores.ControladorUsuario.getInstance().AgregarUsuarioProponente(nick, nombre, apellido, correo, cal, imagen, direccion, biografia, sitio, pass);
                    String mensajeExito = "Imagen subida correctamente";
                    request.getSession().setAttribute(MENSAJE_EXITO, mensajeExito);
                    request.getSession().setAttribute("nick", nick);
                    request.getRequestDispatcher("/Vistas/exito.jsp").include(request, response);
                } // try
                catch (ExceptionInInitializerError | Exception a) {
                    String mensajeError = "Error al dar registrar este usuario";
                    request.getSession().setAttribute(MENSAJE_ERROR, mensajeError);
                    request.getRequestDispatcher("/Vistas/error.jsp").forward(request, response);
                } // catch           

            } else {
                String mensajeError = "Debe completar todos los campos obligatorios";
                request.getSession().setAttribute(MENSAJE_ERROR, mensajeError);
                request.getRequestDispatcher("").forward(request, response);
            }
        } else {
            if (!nick.equals("") && !apellido.equals("") && !correo.equals("") && !fecha.equals("") && !pass.equals("") && !confPass.equals("") && !sitio.equals("") && !direccion.equals("") && !biografia.equals("")) {

                Calendar cal;
                DateFormat format = new SimpleDateFormat("yyyy/mm/dd");
                format.format(fecha);
                cal = format.getCalendar();
                try {
                    logica.Controladores.ControladorUsuario.getInstance().AgregarUsuarioColaborador(nick, nombre, apellido, correo, cal, pass, pass);
                    String mensajeExito = "Imagen subida correctamente";
                    request.getSession().setAttribute(MENSAJE_EXITO, mensajeExito);
                    request.getSession().setAttribute("nick", nick);
                    request.getRequestDispatcher("/Vistas/exito.jsp").include(request, response);
                } // try
                catch (ExceptionInInitializerError | Exception a) {
                    String mensajeError = "Error al dar registrar este usuario";
                    request.getSession().setAttribute(MENSAJE_ERROR, mensajeError);
                    request.getRequestDispatcher("/Vistas/error.jsp").forward(request, response);
                } // catch           

            } else {
                String mensajeError = "Debe completar todos los campos obligatorios";
                request.getSession().setAttribute(MENSAJE_ERROR, mensajeError);
                request.getRequestDispatcher("/Vistas/error.jsp").forward(request, response);
            }
        }
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
