<%-- 
    Document   : iniciarSesion
    Created on : 11/09/2018, 11:06:29 PM
    Author     : PabloDesk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../css/iniciarSesion.css">
        <title>Iniciar Sesion:: CulturarteWeb</title>
    </head>
    <body>
        <div class="container">
            <form class="form-signin" style="padding-left: 25%;padding-right: 25%" action="${pageContext.request.contextPath}/iniciar-sesion" method="POST">				
				<h2 class="form-signin-heading">Ingrese sus datos</h2>
				<br/>
				<br/>
				<label for="inputEmail" class="sr-only">Nickname o Email: </label>
				<input type="text" name="login" id="inputEmail" class="form-control" placeholder="Nickname o Email..." required autofocus>
				<br/>
				<label for="inputPassword" class="sr-only">Contraseña: </label>
				<input type="password" name="pass" id="inputPassword" class="form-control" placeholder="Contraseña..." required>
				<br/>
				<label1><input type="checkbox" name="checkRecordar" value="">Recordarme</label1>
				<br/>
				<br/>
				<button class="btn btn-lg btn-primary btn-block" onclick="submit()">Iniciar Sesión</button>
			</form>
	</div> 
 
    </body>
</html>
