package com.emergentes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener la acción de la solicitud (por ejemplo, "nuevo")
        String action = request.getParameter("action");

        if (action != null && action.equals("nuevo")) {
            // Redireccionar a la página de registro
            RequestDispatcher dispatcher = request.getRequestDispatcher("registro.jsp");
            dispatcher.forward(request, response);
        } else {
            // Si no hay acción específica, cargar los registros y enviarlos a index.jsp
            List<Registro> registros = obtenerRegistros(request.getSession()); // Obtener la lista de registros de la sesión

            // Agregar la lista de registros al objeto request
            request.setAttribute("registros", registros);

            // Redireccionar a index.jsp
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Procesar los datos del formulario de registro
        String action = request.getParameter("action");

        if (action != null && action.equals("eliminar")) {
            // Obtener el ID del registro a eliminar
            int idEliminar = Integer.parseInt(request.getParameter("id"));

            // Obtener la lista de registros de la sesión
            List<Registro> registros = obtenerRegistros(request.getSession());

            // Eliminar el registro correspondiente
            Registro registroAEliminar = null;
            for (Registro registro : registros) {
                if (registro.getId() == idEliminar) {
                    registroAEliminar = registro;
                    break;
                }
            }

            // Eliminar el registro de la lista
            if (registroAEliminar != null) {
                registros.remove(registroAEliminar);
            }

            // Redireccionar a index.jsp para mostrar los registros actualizados
            response.sendRedirect("MainServlet");
        } else {
            // Procesar los datos del formulario de registro como lo hacías antes
            String nombre = request.getParameter("nombre");
            int p1 = Integer.parseInt(request.getParameter("p1"));
            int p2 = Integer.parseInt(request.getParameter("p2"));
            int ef = Integer.parseInt(request.getParameter("ef"));

            // Calcular la nota total
            int nota = p1 + p2 + ef;

            // Crear un nuevo objeto Registro con los datos recibidos
            Registro nuevoRegistro = new Registro(nombre, p1, p2, ef, nota);

            // Obtener la lista de registros de la sesión
            List<Registro> registros = obtenerRegistros(request.getSession());

            // Agregar el nuevo registro a la lista de registros
            registros.add(nuevoRegistro);

            // Redireccionar a index.jsp para mostrar los registros actualizados
            response.sendRedirect("MainServlet");
        }
    }

    // Método para obtener la lista de registros de la sesión
    private List<Registro> obtenerRegistros(HttpSession session) {
        // Obtener la lista de registros de la sesión
        List<Registro> registros = (List<Registro>) session.getAttribute("registros");
        // Si no existe la lista de registros en la sesión, crear una nueva
        if (registros == null) {
            registros = new ArrayList<>();
            session.setAttribute("registros", registros);
        }
        return registros;
    }
}
