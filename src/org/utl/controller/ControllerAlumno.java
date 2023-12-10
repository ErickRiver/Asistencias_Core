/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.utl.bd.ConexionMySQL;
import org.utl.model.Alumno;
import org.utl.model.Grupo;
import org.utl.model.Usuario;

/**
 *
 * @author DaniV
 */
public class ControllerAlumno {

    public void insert(Alumno alumno) throws SQLException {
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();

        String insertFormato = "INSERT INTO alumno(nombre, apellido, fechaNacimiento, idGrupo, idUsuario) VALUES('"
                + alumno.getNombre() + "', '"
                + alumno.getApellido() + "', '"
                + alumno.getFechaNacimiento() + "', "
                + alumno.getGrupo().getIdGrupo() + ", "
                + alumno.getUsuario().getIdUsuario() + ")";
        PreparedStatement pstmt = conn.prepareStatement(insertFormato);
        pstmt.execute();
    }

    public List<Alumno> getAlumnoOgrupo(int idUsuario, int idGrupo) throws SQLException, Exception {
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();

        String queryListaAlumnos = "SELECT * FROM alumno where idUsuario = " + idUsuario + " OR idGrupo = " + idGrupo;

        PreparedStatement pstmt = conn.prepareStatement(queryListaAlumnos);

        ResultSet rs = pstmt.executeQuery();

        List<Alumno> listaAlumnos = new ArrayList<>();
        while (rs.next()) {
            listaAlumnos.add(fill(rs));
        }

        return listaAlumnos;
    }

    public List<Alumno> getAll() throws SQLException, Exception {
        //La consulta SQL a ejecutar:
        String sql = "SELECT * FROM alumno";

        //Con este objeto nos vamos a conectar a la Base de Datos:
        ConexionMySQL connMySQL = new ConexionMySQL();

        //Abrimos la conexión con la Base de Datos:
        Connection conn = connMySQL.open();

        //Con este objeto ejecutaremos la consulta:
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //Aquí guardaremos los resultados de la consulta:
        ResultSet rs = pstmt.executeQuery();

        List<Alumno> listaAlumnos = new ArrayList<>();

        while (rs.next()) {
            listaAlumnos.add(fill(rs));
        }

        rs.close();
        pstmt.close();
        connMySQL.close();

        return listaAlumnos;
    }

    public List<Alumno> getAlumnosGrupo(int idGrupo) throws SQLException, Exception {
        //La consulta SQL a ejecutar:
        String sql = "SELECT * FROM alumno where idGrupo = " + idGrupo;

        //Con este objeto nos vamos a conectar a la Base de Datos:
        ConexionMySQL connMySQL = new ConexionMySQL();

        //Abrimos la conexión con la Base de Datos:
        Connection conn = connMySQL.open();

        //Con este objeto ejecutaremos la consulta:
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //Aquí guardaremos los resultados de la consulta:
        ResultSet rs = pstmt.executeQuery();

        List<Alumno> listaAlumnos = new ArrayList<>();

        while (rs.next()) {
            listaAlumnos.add(fill(rs));
        }

        rs.close();
        pstmt.close();
        connMySQL.close();

        return listaAlumnos;
    }

    private Alumno fill(ResultSet rs) throws Exception {
        Alumno alumno = new Alumno();
        Grupo grupo = new Grupo();
        Usuario usuario = new Usuario();

        alumno.setIdAlumno(rs.getInt("idAlumno"));
        alumno.setNombre(rs.getString("nombre"));
        alumno.setApellido(rs.getString("apellido"));
        alumno.setFechaNacimiento(rs.getString("fechaNacimiento"));

        grupo.setIdGrupo(rs.getInt("idGrupo"));
        alumno.setGrupo(grupo);

        usuario.setIdUsuario(rs.getInt("idUsuario"));
        alumno.setUsuario(usuario);

        return alumno;
    }

}
