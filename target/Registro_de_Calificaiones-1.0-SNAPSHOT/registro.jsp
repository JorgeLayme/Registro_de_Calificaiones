<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registro de Calificaciones</title>
</head>
<body>
    <div style="border: 1px solid black; padding: 10px;">
        <h2 style="text-align: center;">PRIMER PARCIAL TEM-742</h2>
    <div style="text-align: center;">
        <p>Nombre: Jorge Paulino Layme Quiñones</p>
        <p>Carnet: 7097633</p>
    </div>
    </div>
    <h2 style="text-align: center;">Registro de Calificaciones</h2>
    <div style="border: 1px solid black; padding: 10px;">
        <form action="MainServlet" method="post">
            <label for="nombre">Nombre del Estudiante:</label>
            <input type="text" id="nombre" name="nombre"><br><br>
            <label for="p1">Primer Parcial (sobre 30 pts):</label>
            <input type="text" id="p1" name="p1"><br><br>
            <label for="p2">Segundo Parcial (sobre 30 pts):</label>
            <input type="text" id="p2" name="p2"><br><br>
            <label for="ef">Examen Final (sobre 40 pts):</label>
            <input type="text" id="ef" name="ef"><br><br>
            <button type="submit">Enviar</button>
        </form>
    </div>
</body>
</html>




