package org.jmurillo.apiservlet.jdbc.tarea.repository;

import org.jmurillo.apiservlet.jdbc.tarea.model.Curso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoRepositorioImpl implements Repositorio<Curso> {

    private Connection conn;

    public CursoRepositorioImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Curso> listar() {
        List<Curso> cursos = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM cursos")) {
            while (rs.next()) {
                cursos.add(crearCurso(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cursos;
    }

    @Override
    public List<Curso> porNombre(String nombre) {
        List<Curso> cursos = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM cursos as c WHERE c.nombre like ?")) {
            stmt.setString(1, "%" + nombre + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    cursos.add(crearCurso(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cursos;
    }

    private Curso crearCurso(ResultSet rs) throws SQLException {
        Curso curso = new Curso();
        curso.setId(rs.getInt("id"));
        curso.setNombre(rs.getString("nombre"));
        curso.setDescripcion(rs.getString("descripcion"));
        curso.setInstructor(rs.getString("instructor"));
        curso.setDuracion(rs.getDouble("duracion"));
        return curso;
    }
}
