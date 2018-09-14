<%@page import="logica.Clases.Usuario"%>
<%@page import="logica.Clases.DtNickTitProp"%>
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
        <title>Registrar Colaboración</title>
    </head>
    <body>
        <jsp:include page="/Registrar-colaboracion"/> 



        <form action="ServletRegistrarColaboracion" method="post">
            <div class="table-responsive" >
                <table class="table table-bordered table-hover" style="margin-left: 192px; width: 30%;">
                    <thead>
                    <h3 style="position:fixed;top: 58px;left: 358px;">Propuestas</h3>
                    <tr>
                        <th class="active">#</th>
                        <th class="active">Titulo de Propuesta</th>
                        <th class="active">Nombre del Proponente</th>
                    </tr>
                    </thead>
                    <tbody>
                        <tr>

                            <%
                                List<DtNickTitProp> lista = (List<DtNickTitProp>) request.getAttribute("lista_propuestas");
                                for (int i = 0; i < lista.size(); i++) {
                                    out.print("<tr>");
                                    out.print("<td> <input class=\"magic-checkbox\" name=\"layout" + i + "\" id=\"" + i + "\" value=\"option \" type=\"checkbox\">");
                                    out.print("<label class=\"pull-left\" for=\"" + i + "\"></label></td>");
                                    out.print("<td>" + lista.get(i).getTituloP() + "</td>");
                                    out.print("<td>" + lista.get(i).getProponente() + "</td>");
                                    out.print("</tr>");
                                }

                            %>
                    <script type="text/javascript">
                    </script>
                    </tbody>
                </table>
                    <ul class="pager" style="margin-left: -656px">
                    <li><a href="#">Anterior</a></li>
                    <li><a href="#">Siguiente</a></li>
                </ul>


            </div>



            <div   style="width: 402px;margin-left: 200px">
                <div class="input-group input-group-sm">
                    <span class="input-group-addon">Titulo</span>
                    <input type="text" class="form-control" placeholder="">
                </div>
                </br>
                <div class="input-group input-group-sm">
                    <span class="input-group-addon">Descripcion</span>
                    <input type="text" class="form-control" placeholder="">
                </div>
                </br>
                <div class="input-group input-group-sm">
                    <span class="input-group-addon">Tipo de espectaculo</span>
                    <input type="text" class="form-control" placeholder="">
                </div>
                </br>
                <div class="input-group input-group-sm">
                    <span class="input-group-addon">Lugar</span>
                    <input type="text" class="form-control" placeholder="">
                </div>
                </br>
                <div class="input-group input-group-sm">
                    <span class="input-group-addon">Fecha de relizacion</span>
                    <input type="text" class="form-control" placeholder="">
                </div>
                </br>
                <div class="input-group input-group-sm">
                    <span class="input-group-addon">Precio de entrada</span>
                    <input type="text" class="form-control" placeholder="">
                </div>
                </br>
                <div class="input-group input-group-sm">
                    <span class="input-group-addon">Monto final</span>
                    <input type="text" class="form-control" placeholder="">
                </div>
                </br>
            </div>
        </form>
    </body>
</html>
