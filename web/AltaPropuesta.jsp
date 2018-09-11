<%-- 
    Document   : AltaPropuesta
    Created on : 11/09/2018, 11:51:57 AM
    Author     : Martin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nueva Propuesta</title>
    </head>
    <body>
        <h1>Informacion de la propuesta:</h1>
        <div style="align-self: center" class="form">
            <form action="AltaPropuesta" method="get" />
                <div>
                    <label for="tituloP">Titulo: </label>
                    <input type="text" size="15" maxlength="30" value="Titulo" name="TituloP"/>
                </div>
                <br>
                <div>
                    <label for="lugar">Lugar:</label>
                    <input type="text" size="15" maxlength="30" value="Lugar" name="LugarP"/>
                </div>
                <br>
                <div>
                    <label for="descripcion">Descripcion:</label>
                    <input type="text" size="15" maxlength="1000" value="Descripcion" name="Descripcion"/>
                </div>
                <br>
                <div>
                    <label for="montoTot">Monto total:</label>
                    <input type="number" size="15" maxlength="12" value="Monto total" name="MontoTot"/>
                </div>
                <br>
                <div>
                    <label for="montoE">Monto entrada:</label>
                    <input type="number" size="15" maxlength="10" value="Monto entrada" name="MontoE"/>
                </div>
                <br>
                <div>
                    <label for="fechaR">Fecha de realizacion:</label>
                    <input type="date" size="15" maxlength="30" value="Titulo" name="TituloP"/>
                </div>
                <br>
                <div>
                    <input type="submit" />
                </div>
            </form>
        </div>
    </body>
</html>
