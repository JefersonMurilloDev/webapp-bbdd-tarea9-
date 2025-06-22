package org.jmurillo.apiservlet.jdbc.tarea.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jmurillo.apiservlet.jdbc.tarea.model.Curso;
import org.jmurillo.apiservlet.jdbc.tarea.service.CursoService;
import org.jmurillo.apiservlet.jdbc.tarea.service.CursoServiceImpl;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/cursos/buscar")
public class BuscarCursoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        CursoService service = new CursoServiceImpl(conn);

        String nombre = req.getParameter("nombre");
        List<Curso> cursos = service.porNombre(nombre);

        req.setAttribute("cursos", cursos);
        req.setAttribute("titulo", "Resultados de la búsqueda para: " + nombre);
        getServletContext().getRequestDispatcher("/listar.jsp").forward(req, resp);
    }
}