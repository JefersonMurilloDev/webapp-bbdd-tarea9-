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

@WebServlet({"/cursos/listar", ""})
public class CursoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        CursoService service = new CursoServiceImpl(conn);
        List<Curso> cursos = service.listar();

        req.setAttribute("cursos", cursos);
        req.setAttribute("titulo", "Listado de cursos");
        getServletContext().getRequestDispatcher("/listar.jsp").forward(req, resp);
    }
}
