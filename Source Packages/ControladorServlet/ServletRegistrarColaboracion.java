/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import logica.Fabrica;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Clases.DtNickTitProp;
import logica.Clases.DtProponente;
import logica.Clases.DtinfoColaborador;
import logica.Clases.Usuario;
import logica.Interfaces.IControladorUsuario;
import logica.Interfaces.IPropCat;

/**
 *
 * @author Santiago.S
 */
@WebServlet(name = "ServletRegistrarColaboracion", urlPatterns = {"/Registrar-colaboracion"})
public class ServletRegistrarColaboracion extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IControladorUsuario ICU = Fabrica.getInstance().getIControladorUsuario();
        IPropCat IPC = Fabrica.getInstance().getControladorPropCat();
        IPC.comprobarBaseCat();
        ICU.CargarUsuarios();
        IPC.CargarPropuestas();
        IPC.CargarColaboraciones();
        List<DtNickTitProp> lista = IPC.listarPropuestaC();
        List<DtinfoColaborador> lista2 = ICU.ListarColaboradores();
        request.setAttribute("lista_propuestas", lista);
        request.setAttribute("lista_colaboradores", lista2);
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

    private void log(String[] Titulos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
