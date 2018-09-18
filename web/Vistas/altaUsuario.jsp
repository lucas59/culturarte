<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Crea tu cuenta</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="../css/AltaUsuarioCSS.css">
        <script type="text/javascript" src="../js/validacion.js"></script>
        <script type="text/javascript" src="../js/funcionesAltaUsuario.js"></script>

        <%
            String mensaje = (String) request.getAttribute("mensaje");
            if (mensaje != null) {%>
        <script type="text/javascript">
            window.alert("<%= mensaje%>");
        </script>
        <%  }
        %>
        <script type="text/javascript">
            function mostrarDatos() {
                var elemento = document.getElementById("otros");
                if (elemento.style.display === 'block')
                    document.getElementById("otros").style.display = "none";
                else
                    document.getElementById("otros").style.display = "block";
            }
        </script>

    </head>
    <body>
        <div style="padding-left: 444px" class="form">
            <h1>Registrarte</h1>
            <form>
                <div>
                    <label for="name">Nombre de usuario:</label>
                    <input id="nick" class="form-control"placeholder="Escribe tu nombre de usuario" type="text" required/>
                </div>
                <br>
                <div>
                    <label for="name">Nombre:</label>
                    <input id="nombre" class="form-control"placeholder="Escribe tu nombre de usuario" type="text" required/>
                </div>
                <br>
                <div>
                    <label for="name">Apellido:</label>
                    <input id="apellido" class="form-control"placeholder="Escribe apellido" type="text" required/>
                </div>
                <br>
                <div>
                    <label for="mail">E-mail:</label>
                    <input id="correo" class="form-control" placeholder="Escribe tu correo electrónico" type="email" required/>
                </div>
                <br>
                <div>
                    <label for="contrasenia">Contraseña:</label>
                    <input id="pass" class="form-control" placeholder="Escribe una contraseña" type="password" required/>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <label for="contrasenia">Confirmar contraseña:</label>
                    <input id="pass2" class="form-control" placeholder="Vuelve a escribir tu contraseña" type="password" required/>
                </div>
                <br>
                <div>
                    <label for="fechaN">Fecha de nacimiento</label>
                    <input id="fecha" class="form-control" type="date" required>
                </div>
                <br>
                <div>
                    <label>Tipo de persona</label><br>
                    <input onclick="mostrarDatos()" id="tipo" name="tipoP"  type="radio"  value="colaborador" checked>Soy un colaborador &nbsp;&nbsp;&nbsp;
                    <input onclick="mostrarDatos()" name="tipoP" id="tipo"  type="radio"  value="proponente">Soy un proponente<br>
                </div>
                <br>
                <div id="otros" style="display: none">
                    <div>
                        <label for="direccion">Direccion</label>
                        <input class="form-control" id="direccion" type="text" />
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <label for="sitio">Sitio web</label>
                        <input class="form-control"  id="sitio" type="text" />
                    </div><br><br><br>
                    <div>
                        <p>Biografia:
                            <textarea class="form-control" id="biografia"></textarea>
                        </p>
                    </div>
                </div>
                <div>
                    <input onclick="enviar()" type="submit" value="Crear cuenta"/>
                </div>
            </form>
        </div>     
    </body>
</html>
