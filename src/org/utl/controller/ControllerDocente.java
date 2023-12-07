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
import org.utl.model.Docente;
import org.utl.model.Grupo;
import org.utl.model.Usuario;

/**
 *
 * @author DaniV
 */
public class ControllerDocente {

    public Docente getDocente(int idUsuario) throws SQLException, Exception {
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();

        String queryListaDocentes = "Select * from docente where idUsuario = " + idUsuario;

        PreparedStatement pstmt = conn.prepareStatement(queryListaDocentes);
        ResultSet rs = pstmt.executeQuery();

        Docente docente = new Docente();

        while (rs.next()) {
            docente = fill(rs);
        }

        return docente;
    }

    public List<Docente> getAll() throws SQLException, Exception {
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();

        String queryListaDocentes = "Select * from docente";

        PreparedStatement pstmt = conn.prepareStatement(queryListaDocentes);
        ResultSet rs = pstmt.executeQuery();

        List<Docente> listaDocentes = new ArrayList<>();
        while (rs.next()) {
            listaDocentes.add(fill(rs));
        }

        return listaDocentes;
    }

    private Docente fill(ResultSet rs) throws Exception {
        Docente docente = new Docente();
        Usuario usuario = new Usuario();

        docente.setNombre(rs.getString("nombre"));
        docente.setApellido(rs.getString("apellido"));
        docente.setEspecialidad(rs.getString("especialidad"));
        docente.setIdDocente(rs.getInt("idDocente"));

        usuario.setIdUsuario(rs.getInt("idUsuario"));
        docente.setUsuario(usuario);

        return docente;
    }
}
