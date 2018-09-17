<%@page import="logica.Clases.DtinfoColaborador"%>
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
    <jsp:include page="/Registrar-colaboracion"/>
    <body>



        <div style="float: left">
            <table class="table table-bordered table-hover  formulario" style="margin-left: 192px; width: 88%;">
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
                </tbody>
            </table>


            <div class="modal fade" id="VerInfoPropuesta" tabindex="1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
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
        </div>










        <div style="float: right">
            <table  class="table table-bordered table-hover  formulario" style="margin-left: 150px; width: 60%;margin-right: 230px;">
                <thead>
                <h3 style=" position: absolute; top: 76px;left: 1020px;">Colaboradores</h3>
                <form class="navbar-form navbar-right">
                    <input style="width: 184px;margin-left: 330px;margin-top: 12px;margin-bottom: -23px;" type="text" class="form-control" placeholder="Buscar" />
                </form>
                <tr>
                    <th class="active">Nickname de el colaborador</th>
                    <th class="active">Nombre del colaborador</th>
                    <th class="active">Acciones</th>
                </tr>
                </thead>
                <tbody>
                    <% List<DtinfoColaborador> lista2 = (List<DtinfoColaborador>) request.getAttribute("lista_colaboradores");
                        for (int i = 0; i < lista.size(); i++) {
                            out.print("<tr>");
                            out.print("<label for=\"" + i + "\"></label></td>");
                            out.print("<td onclick=\"seleccionarusuario(" + lista2.get(i).getNickname() + "\")\">" + lista2.get(i).getNickname() + "</td>");
                            out.print("<td>" + lista2.get(i).getNombre() + "</td>");
                            out.print("<td><button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#VerInfoColaborador\">Ver</button><td>");
                            out.print("</tr>");
                        }
                    %>
                <button style="position: absolute;right: 195px;top: 546px;" data-toggle="modal" data-target="#Registrarcolaboracion" type="button" class="btn btn-primary btn-lg">Aceptar</button>
                </tbody>

            </table>
            <div class="modal fade" id="VerInfoColaborador" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Información del colaborador</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div id="mostrarinfo">
                                <div>
                                    <div class="input-group input-group-sm">
                                        <span class="input-group-addon">Nickname</span>
                                        <input readonly  type="text" class="form-control" placeholder="">
                                    </div>
                                    </br>
                                    <div class="input-group input-group-sm">
                                        <span class="input-group-addon">Nombre</span>
                                        <input readonly type="text" class="form-control" placeholder="">
                                    </div>
                                    </br>
                                    <div class="input-group input-group-sm">
                                        <span class="input-group-addon">Apellido</span>
                                        <input readonly type="text" class="form-control" placeholder="">
                                    </div>
                                    </br>
                                    <div class="input-group input-group-sm">
                                        <span class="input-group-addon">Correo</span>
                                        <input readonly type="text" class="form-control" placeholder="">
                                    </div>
                                    </br>
                                    <div class="input-group input-group-sm">
                                        <span class="input-group-addon">Fecha de nacimiento</span>
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
                
        </div>



        <div class="modal fade" id="Registrarcolaboracion" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Registro de colaboracion</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form >
                            <div class="form-group">
                                <label for="recipient-name" class="col-form-label">Monto:</label>
                                <input required type="text" class="form-control" id="recipient-name">
                            </div>
                            <div class="form-group">
                                <div class="dropdown">
                                    <button class="btn btn-default dropdown-toggle" type="button" id="menu1" data-toggle="dropdown">Tipo de entrada
                                        <span class="caret"></span></button>
                                    <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
                                        <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Entradas</a></li>
                                        <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Por ganancias</a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                        <button type="button" class="btn btn-primary">Registrar Colaboración</button>
                    </div>
                        </form>
                    </div>
                    
                </div>
            </div>
        </div>


    </body>
</html>
