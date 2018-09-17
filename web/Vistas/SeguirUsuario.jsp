<%@page import="java.util.Iterator"%>
<%@page import="logica.Clases.DtUsuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/bootstrap.css" rel="stylesheet">
        <script src="js/bootstrap.js"></script>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/tabs.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
      <jsp:include page="/SeguirUsuario"/>;
    <body>
        <h1>Hello World!</h1>
        
        
        
         <%

                            List<DtUsuario> proponentes = (List<DtUsuario>) request.getAttribute("usuarios");
                            for (int i = 0; i < proponentes.size(); i++) {
                                    out.print("<label for=\"" + i + "\"></label></td>");
                                    out.print("<tr>");
                                     
                                    out.print("<td seleccionarusuario(" + proponentes.get(i).getNombre()+ "\")\">" + proponentes.get(i).getApellido() + "</td>");
                                        
                                    out.print("</tr>");
                                   
                            }

                        %>
        
        

        
        
        
    </body>
</html>
