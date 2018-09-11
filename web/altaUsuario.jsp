<!DOCTYPE html>
<html>
    <head>
        <title>Crea tu cuenta</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="../css/AltaUsuarioCSS.css">
    </head>
    <body>
        <div style="align-self: center" class="form">
            <h1>Registrarte</h1>
            <h4>Es gratis y lo sera siempre.</h4>
            <form action="" method="post">
                <div>
                    <label for="name">Nombre de usuario:</label>
                    <input type="text" id="name"/>
                </div>
                <br>
                <div>
                    <label for="name">Nombre:</label>
                    <input type="text" id="name" />
                </div>
                <br>
                <div>
                    <label for="name">Apellido:</label>
                    <input type="text" id="name" />
                </div>
                <br>
                <div>
                    <label for="mail">E-mail:</label>
                    <input type="email" id="mail" />
                </div>
                <br>
                <div>
                    <label for="contrasenia">Contraseña:</label>
                    <input type="password" id="name" />
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <label for="contrasenia">Confirmar contraseña:</label>
                    <input type="password" id="name" />
                </div>
                <br>
                <div>
                    <label for="fechaN">Fecha de nacimiento</label>
                    <input id="date" type="date">
                </div>
                <br>
                <div>

                    <label for="tipoP">Tipo de persona</label><br>
                    <input type="radio" name="gender" value="male" checked>Soy un colaborador &nbsp;&nbsp;&nbsp;
                    <input type="radio" name="gender" value="female">Soy un proponente<br>
                </div>
                <br>
                <div id="adivionales">
                    <div>
                        <label for="direccion">Direccion</label>
                        <input type="text" id="name" />
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <label for="direccion">Sitio web</label>
                        <input type="text" id="name" />
                    </div><br><br><br>
                    <div>
                        <p>Biografia:
                            <textarea id="msg"></textarea>
                        </p>
                    </div>
                </div>
                <div>
                    <input type="submit" value="Registrarme" />
                </div>
            </form>
        </div>
    </body>
</html>
