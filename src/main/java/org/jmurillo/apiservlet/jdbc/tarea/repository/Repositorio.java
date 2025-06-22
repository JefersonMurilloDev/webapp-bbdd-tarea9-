package org.jmurillo.apiservlet.jdbc.tarea.repository;

import java.util.List;

public interface Repositorio<T> {
    List<T> listar();
    List<T> porNombre(String nombre);
}
