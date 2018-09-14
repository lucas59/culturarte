<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Crea tu cuenta</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="../css/AltaUsuarioCSS.css">
        <script type="text/javascript" src="../js/validacion.js"></script>

        <%
            String mensaje = (String) request.getSession().getAttribute("mensaje");
            if (mensaje != null) {%>
        <script type="text/javascript">
            alert("<%= mensaje%>");
        </script>
        <%  }
        %>
        <script type="text/javascript">
            function mandarDatos(evento) {
            evento.preventDefault();
            var nick = $("#nick").val().toString();
            var nombre = $("#nombre").val().toString();
            var apellido = $("#apellido").val().toString();
            var correo = $("#correo").val().toString();
            var pass = $("#pass").val().toString();
            var confPass = $("#confPass").val().toString();
            var tipo = $("#tipo").val().toString();
            var direccion = $("#direccion").val().toString();
            var sitio = $("#sitio").val().toString();
            var biografia = $("#biografia").val().toString();
            if (tipo.equals "colaborador"){

            } else{

            }
            }

            function enviar() {

            $.ajax({
            type: 'POST', //va por post 
                    url: "/altaUsuarioServlet",
                    data: {

                    },
                    success: function (datos) {

                    }
            );
            });
            }
        </script>

    </head>
    <body>
        <div style="padding-left: 444px" class="form">
            <h1>Registrarte</h1>
            <h4>Es gratis y lo sera siempre.</h4>
            <form onsubmit="mandarDatos(this)">
                <div>
                    <label for="name">Nombre de usuario:</label>
                    <input id="nick" class="form-control" type="text"/>
                </div>
                <br>
                <div>
                    <label for="name">Nombre:</label>
                    <input id="nombre" class="form-control" type="text" />
                </div>
                <br>
                <div>
                    <label for="name">Apellido:</label>
                    <input id="apellido" class="form-control" type="text"/>
                </div>
                <br>
                <div>
                    <label for="mail">E-mail:</label>
                    <input id="correo" class="form-control" type="email"/>
                </div>
                <br>
                <div>
                    <label for="contrasenia">Contraseña:</label>
                    <input id="pass" class="form-control" type="password"/>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <label for="contrasenia">Confirmar contraseña:</label>
                    <input id="confPass" class="form-control" type="password" />
                </div>
                <br>
                <div>
                    <label for="fechaN">Fecha de nacimiento</label>
                    <input id="fecha" class="form-control" type="date">
                </div>
                <br>
                <div>

                    <label>Tipo de persona</label><br>
                    <input id="tipo"  type="radio"  value="colaborador" checked>Soy un colaborador &nbsp;&nbsp;&nbsp;
                    <input id="tipo"  type="radio"  value="proponente">Soy un proponente<br>
                </div>
                <br>
                <div id="adivionales">
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
                    <input type="submit" value="Crear cuenta"/>
                </div>
            </form>
        </div>     
    </body>
</html>
