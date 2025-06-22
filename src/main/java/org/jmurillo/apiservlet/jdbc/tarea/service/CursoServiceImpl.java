package org.jmurillo.apiservlet.jdbc.tarea.service;

import org.jmurillo.apiservlet.jdbc.tarea.exception.ServiceJdbcException;
import org.jmurillo.apiservlet.jdbc.tarea.model.Curso;
import org.jmurillo.apiservlet.jdbc.tarea.repository.CursoRepositorioImpl;
import org.jmurillo.apiservlet.jdbc.tarea.repository.Repositorio;

import java.sql.Connection;
import java.util.List;

public class CursoServiceImpl implements CursoService {

    private Repositorio<Curso> repositorio;

    public CursoServiceImpl(Connection connection) {
        this.repositorio = new CursoRepositorioImpl(connection);
    }

    @Override
    public List<Curso> listar() {
        try {
            return repositorio.listar();
        } catch (Exception e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<Curso> porNombre(String nombre) {
        try {
            return repositorio.porNombre(nombre);
        } catch (Exception e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }
}
