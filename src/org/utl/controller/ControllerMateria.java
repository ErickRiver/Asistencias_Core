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
import org.utl.model.Grupo;
import org.utl.model.Materia;

/**
 *
 * @author DaniV
 */
public class ControllerMateria {

    public List<Materia> getAll() throws SQLException, Exception {
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();
        
        String queryListaAsistencia = "Select * from materia";
        
        PreparedStatement pstmt = conn.prepareStatement(queryListaAsistencia);
        ResultSet rs = pstmt.executeQuery();
        
        List<Materia> listaMaterias = new ArrayList<>();
        while (rs.next()) {
            listaMaterias.add(fill(rs));
        }
        
        return listaMaterias;
    }

    private Materia fill(ResultSet rs) throws Exception {
        Materia materia = new Materia();

        materia.setNombre(rs.getString("nombre"));
        materia.setIdMateria(rs.getInt("idMateria"));

        return materia;
    }
}
