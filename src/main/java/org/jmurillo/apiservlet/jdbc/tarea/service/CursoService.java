package org.jmurillo.apiservlet.jdbc.tarea.service;

import org.jmurillo.apiservlet.jdbc.tarea.model.Curso;

import java.util.List;

public interface CursoService {
    List<Curso> listar();
    List<Curso> porNombre(String nombre);
}
