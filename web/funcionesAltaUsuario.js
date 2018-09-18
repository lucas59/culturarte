/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global request */

function enviar() {
    $.ajax({
        type: "POST", //va por post 
        url: '/altaUsuarioServlet',
        data: {
            "op": "1",
            "nick": $("#nick").val().toString(),
            "nombre": $("#nombre").val().toString(),
            "apellido": $("#apellido").val().toString(),
            "correo": $("#correo").val().toString(),
            "pass": $("#pass").val().toString(),
            "pass2": $("#pass2").val().toString(),
            "tipo": $("#tipo").val().toString(),
            "direccion": $("#direccion").val().toString(),
            "sitio": $("#sitio").val().toString(),
            "biografia": $("#biografia").val().toString()
        },
        success: function (data) {
            
        }
    });
}