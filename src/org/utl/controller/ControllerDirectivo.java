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
import org.utl.model.Directivo;
import org.utl.model.Docente;
import org.utl.model.Usuario;

/**
 *
 * @author DaniV
 */
public class ControllerDirectivo {

    public Directivo getDirectivo(int idUsuario) throws SQLException, Exception {
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();

        String queryListaDocentes = "Select * from directivo where idUsuario = " + idUsuario;

        PreparedStatement pstmt = conn.prepareStatement(queryListaDocentes);
        ResultSet rs = pstmt.executeQuery();

        Directivo directivo = new Directivo();

        while (rs.next()) {
            directivo = fill(rs);
        }

        return directivo;
    }

    public List<Directivo> getAll() throws SQLException, Exception {
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();

        String queryListaDocentes = "Select * from directivo";

        PreparedStatement pstmt = conn.prepareStatement(queryListaDocentes);
        ResultSet rs = pstmt.executeQuery();

        List<Directivo> listaDirectivos = new ArrayList<>();;

        while (rs.next()) {
            listaDirectivos.add(fill(rs));
        }

        return listaDirectivos;
    }
    
    private Directivo fill(ResultSet rs) throws Exception {
        Directivo directivo = new Directivo();
        Usuario usuario = new Usuario();

        usuario.setIdUsuario(rs.getInt("idUsuario"));
        directivo.setNombre(rs.getString("nombre"));
        directivo.setApellido(rs.getString("apellido"));
        directivo.setPuesto(rs.getString("puesto"));

        directivo.setIdDirectivo(rs.getInt("idDirectivo"));
        directivo.setUsuario(usuario);

        return directivo;
    }

}
