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
import org.utl.model.DiaClase;
import org.utl.model.DiaInhabil;
import org.utl.model.FormatoLista;

/**
 *
 * @author DaniV
 */
public class ControllerDiaInhabil {

//    public void insert(int idFormatoLista) throws SQLException {
//
//        ConexionMySQL connMySQL = new ConexionMySQL();
//        Connection conn = connMySQL.open();
//        String insertFormato = "INSERT INTO diaInhabil(idDiaInhabil, fecha, idFormatoLista) VALUES("
//                + diaInhabil.getIdDiaInhabil() + ", '" + diaInhabil.getFecha() + "', "
//                + diaInhabil.getFormatoLista().getIdFormatoLista() + ")";
//        PreparedStatement pstmt = conn.prepareStatement(insertFormato);
//        pstmt.execute();
//    }
    public void insert(int idFormatoLista) throws SQLException {
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();
        PreparedStatement pstmt = null;
        try {
            String insertFormato = "INSERT INTO diaInhabil(fecha, idFormatoLista) VALUES(?, ?)";
            pstmt = conn.prepareStatement(insertFormato);

            // Define an array of dates to insert
            String[] dates = {
                "2023-01-01", "2023-01-20", "2023-02-05", "2023-03-21", "2023-03-25",
                "2023-03-26", "2023-03-27", "2023-03-28", "2023-03-29", "2023-03-30",
                "2023-05-01", "2023-07-22", "2023-07-23", "2023-07-24", "2023-07-25",
                "2023-07-26", "2023-07-29", "2023-07-30", "2023-07-31", "2023-08-01",
                "2023-08-02", "2023-09-16", "2023-09-26", "2023-11-02", "2023-11-20",
                "2023-12-25"
            };

            // Loop through the dates and insert them into the database
            for (String date : dates) {
                pstmt.setString(1, date);
                pstmt.setInt(2, idFormatoLista);
                pstmt.addBatch();
            }

            // Execute batch insert
            pstmt.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
        }
    }

    public List<DiaInhabil> getAll() throws SQLException, Exception, Exception, Exception, Exception, Exception {
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();

        String queryListaAsistencia = "Select * from diaInhabil";

        PreparedStatement pstmt = conn.prepareStatement(queryListaAsistencia);
        ResultSet rs = pstmt.executeQuery();

        List<DiaInhabil> listaDias = new ArrayList<>();
        while (rs.next()) {
            listaDias.add(fill(rs));
        }
        return listaDias;
    }

    public List<DiaInhabil> getDiasPorFormatoLista(int idFormatoLista) throws SQLException, Exception, Exception, Exception, Exception, Exception, Exception, Exception {
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();

        String queryListaAsistencia = "Select * from diaInhabil where idFormatoLista = " + idFormatoLista;

        PreparedStatement pstmt = conn.prepareStatement(queryListaAsistencia);
        ResultSet rs = pstmt.executeQuery();

        List<DiaInhabil> listaDias = new ArrayList<>();
        while (rs.next()) {
            listaDias.add(fill(rs));
        }
        return listaDias;
    }

    private DiaInhabil fill(ResultSet rs) throws Exception {
        DiaInhabil diaInhabil = new DiaInhabil();
        FormatoLista formatoLista = new FormatoLista();

        diaInhabil.setIdDiaInhabil(rs.getInt("idDiaInhabil"));
        diaInhabil.setFecha(rs.getString("fecha"));
        formatoLista.setIdFormatoLista(rs.getInt("idFormatoLista"));
        diaInhabil.setFormatoLista(formatoLista);

        return diaInhabil;
    }
}
