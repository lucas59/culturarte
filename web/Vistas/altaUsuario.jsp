<!DOCTYPE html>
<html>
    <head>
        <title>Crea tu cuenta</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="../css/AltaUsuarioCSS.css">
        <script type="text/javascript" src="../js/validacion.js"></script>

    </head>
    <body>
        <div style="padding-left: 444px" class="form">
            <h1>Registrarte</h1>
            <h4>Es gratis y lo sera siempre.</h4>
            <form action="altaUsuarioServlet" name="formu" method="post">
                <div>
                    <label for="name">Nombre de usuario:</label>
                    <input name="nick" type="text"/>
                </div>
                <br>
                <div>
                    <label for="name">Nombre:</label>
                    <input name="nombre" type="text" />
                </div>
                <br>
                <div>
                    <label for="name">Apellido:</label>
                    <input name="apellido" type="text"/>
                </div>
                <br>
                <div>
                    <label for="mail">E-mail:</label>
                    <input name="correo" type="email"/>
                </div>
                <br>
                <div>
                    <label for="contrasenia">Contraseña:</label>
                    <input name="pass" type="password"/>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <label for="contrasenia">Confirmar contraseña:</label>
                    <input name="confPass"type="password" />
                </div>
                <br>
                <div>
                    <label for="fechaN">Fecha de nacimiento</label>
                    <input name="fecha" type="date">
                </div>
                <br>
                <div>

                    <label>Tipo de persona</label><br>
                    <input name="tipo"  type="radio"  value="colaborador" checked>Soy un colaborador &nbsp;&nbsp;&nbsp;
                    <input name="tipo"  type="radio"  value="proponente">Soy un proponente<br>
                </div>
                <br>
                <div id="adivionales">
                    <div>
                        <label for="direccion">Direccion</label>
                        <input name="direccion" type="text" />
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <label for="sitio">Sitio web</label>
                        <input  name="sitio" type="text" />
                    </div><br><br><br>
                    <div>
                        <p>Biografia:
                            <textarea name="biografia"></textarea>
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
