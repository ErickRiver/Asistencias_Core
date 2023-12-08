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

    public void insert(DiaInhabil diaInhabil) throws SQLException {

        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();
        String insertFormato = "INSERT INTO diaInhabil(idDiaInhabil, fecha, idFormatoLista) VALUES("
                + diaInhabil.getIdDiaInhabil() + ", '" + diaInhabil.getFecha() + "', "
                + diaInhabil.getFormatoLista().getIdFormatoLista() + ")";
        PreparedStatement pstmt = conn.prepareStatement(insertFormato);
        pstmt.execute();
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
