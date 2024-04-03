<%@page import="java.util.List"%>
<%@page import="com.emergentes.Registro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Inicio - Gestión de Calificaciones</title>
</head>
<body>
    <div style="border: 1px solid black; padding: 10px;">
        <h2 style="text-align: center;">PRIMER PARCIAL TEM-742</h2>
    <div style="text-align: center;">
        <p>Nombre: Jorge Paulino Layme Quiñones</p>
        <p>Carnet: 7097633</p>
    </div>
    </div>
    
    
        <h3 style="text-align: center;">Registro de Calificaciones</h3>
        <form action="MainServlet" method="get">
            <input type="hidden" name="action" value="nuevo">
            <button type="submit" style="float: left;">Nuevo</button>
            <br>
        </form>
        <br>
    
    <div style="border: 1px solid black; padding: 10px; margin-top: 10px;">
        <table style="width:100%; border-collapse: collapse;">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>P1(30)</th>
                <th>P2(30)</th>
                <th>EF(40)</th>
                <th>Nota</th>
                <th>Editar</th>
                <th>Eliminar</th>
            </tr>
            
            <%
                List<Registro> registros = (List<Registro>) request.getAttribute("registros");
                if (registros != null) {
                    for (Registro registro : registros) {
            %>
            <tr>
                <td><%= registro.getId() %></td>
                <td><%= registro.getNombre() %></td>
                <td><%= registro.getP1() %></td>
                <td><%= registro.getP2() %></td>
                <td><%= registro.getEf() %></td>
                <td><%= registro.getNota() %></td>
                <td><a href="#">Editar</a></td>
                <td><a href="MainServlet?action=eliminar&id=<%= registro.getId() %>">Eliminar</a></td>


            </tr>
            <% 
                    }
                }
            %>
        </table>
    </div>
</body>
</html>
