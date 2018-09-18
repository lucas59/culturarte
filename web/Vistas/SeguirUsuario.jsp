<%@page import="java.util.Iterator"%>
<%@page import="logica.Clases.DtUsuario"%>
<%@page import="java.util.List"%>



<!DOCTYPE html>
<html>
    <head>
        <link href="css/bootstrap.css" rel="stylesheet">
        <script src="js/bootstrap.js"></script>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/tabs.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Culturarte:: Seguir Usuario</title>
    </head>
    
<jsp:include page="/SeguirUsuario"/>;
      
        <body>
        
        <table class="table table-bordered table-hover  formulario" style="margin-left: 192px; width: 88%;">
            
            <thead>
                <h3 style=" position: absolute; top: 76px;left: 358px;">Usuarios</h3>
                <form class="navbar-form navbar-right">
                    <input style="width: 184px;margin-left: 330px;margin-top: 12px;margin-bottom: -23px;" type="text" class="form-control" placeholder="Buscar" />
                </form>
                 <tr>
                    <th class="active">Nick del Usuario</th>
                    <th class="active">Nombre del Usuario</th>
                    <th class="active">Apellido del Usuario</th>
                    <th class="active">Acciones</th>
                </tr>           
            </thead>
            
            
            <tbody>
                <%
               
                List<DtUsuario> lista = (List<DtUsuario>) request.getAttribute("usuarios");
                for (int i = 0; i < lista.size(); i++) {
                    out.print("<tr>");
                    out.print("<label for=\"" + i + "\"></label></td>");
                    out.print("<td>" +lista.get(i).getNickName()+ "</td>");
                    out.print("<td>" + lista.get(i).getNombre() + "</td>");
                    out.print("<td>" + lista.get(i).getApellido() + "</td>");
                    out.print("<td><button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#VerInfoPropuesta\">Seguir</button>");
                    out.print("&nbsp;&nbsp;&nbsp;&nbsp;");
                    out.print("<button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#VerInfoPropuesta\">Dejar de Seguir</button><td>");
                    out.print("</tr>");
      
                }
                %>
            </tbody> 
                
        </table>

  
    </body>
</html>
