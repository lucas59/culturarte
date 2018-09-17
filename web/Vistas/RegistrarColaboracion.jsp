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
    <jsp:include page="/Registrar-colaboracion"/>;
    <body>



        <div >
            <table class="table table-bordered table-hover  formulario" style="margin-left: 192px; width: 30%;">
                <thead>
                <h3 style=" position: absolute; top: 76px;left: 358px;">Propuestas</h3>
                <form class="navbar-form navbar-right">
                    <input style="width: 184px;margin-left: 330px;margin-top: 12px;margin-bottom: -23px;" type="text" class="form-control" placeholder="Buscar" />
                </form>
                <tr>
                    <th class="active">Titulo de Propuesta</th>
                    <th class="active">Nombre del Proponente</th>
                    <th class="active">Acciones</th>
                </tr>
                </thead>
                <tbody>
                    <tr>
                        <%

                            List<DtNickTitProp> lista = (List<DtNickTitProp>) request.getAttribute("lista_propuestas");
                            for (int i = 0; i < lista.size(); i++) {
                                out.print("<tr>");
                                out.print("<label for=\"" + i + "\"></label></td>");
                                out.print("<td onclick=\"seleccionarusuario(" + lista.get(i).getTituloP() + "\")\">" + lista.get(i).getTituloP() + "</td>");
                                out.print("<td>" + lista.get(i).getProponente() + "</td>");
                                out.print("<td><button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#VerInfoPropuesta\">Ver</button><td>");
                                out.print("</tr>");
                            }

                        %>



                <div class="modal fade" id="VerInfoPropuesta" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Información de la propuesta</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <div id="mostrarinfo">
                                    <div>
                                        <div class="input-group input-group-sm">
                                            <span class="input-group-addon">Titulo</span>
                                            <input readonly  type="text" class="form-control" placeholder="">
                                        </div>
                                        </br>
                                        <div class="input-group input-group-sm">
                                            <span class="input-group-addon">Descripcion</span>
                                            <input readonly type="text" class="form-control" placeholder="">
                                        </div>
                                        </br>
                                        <div class="input-group input-group-sm">
                                            <span class="input-group-addon">Tipo de espectaculo</span>
                                            <input readonly type="text" class="form-control" placeholder="">
                                        </div>
                                        </br>
                                        <div class="input-group input-group-sm">
                                            <span class="input-group-addon">Lugar</span>
                                            <input readonly type="text" class="form-control" placeholder="">
                                        </div>
                                        </br>
                                        <div class="input-group input-group-sm">
                                            <span class="input-group-addon">Fecha de relizacion</span>
                                            <input readonly type="text" class="form-control" placeholder="">
                                        </div>
                                        </br>
                                        <div class="input-group input-group-sm">
                                            <span class="input-group-addon">Precio de entrada</span>
                                            <input readonly type="text" class="form-control" placeholder="">
                                        </div>
                                        </br>
                                        <div class="input-group input-group-sm">
                                            <span class="input-group-addon">Monto final</span>
                                            <input readonly type="text" class="form-control" placeholder="">
                                        </div>
                                        </br>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                            </div>
                        </div>
                    </div>
                </div>




            </table>
            <ul class="pager" style="margin-left: -656px">
                <li><a href="#">Anterior</a></li>
                <li><a href="#">Siguiente</a></li>
            </ul>


        </div>

    </body>
</html>
