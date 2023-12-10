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
import org.utl.model.Directivo;
import org.utl.model.FormatoLista;
import org.utl.model.Horario;

/**
 *
 * @author DaniV
 */
public class ControllerHorario {

    public void insert(Horario horario) throws SQLException {
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();
        
        String insertFormato = "INSERT INTO horario(horario, idDiaClase) VALUES('"
                + horario.getHorario() + "', "
                + horario.getDiaClase().getIdDiaClase() + ")";
        
        PreparedStatement pstmt = conn.prepareStatement(insertFormato);
        pstmt.execute();
    }

    public List<Horario> getAll() throws SQLException, Exception {
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();

        String queryListaAsistencia = "Select * from horario";

        PreparedStatement pstmt = conn.prepareStatement(queryListaAsistencia);
        ResultSet rs = pstmt.executeQuery();

        List<Horario> listaHorario = new ArrayList<>();
        while (rs.next()) {
            listaHorario.add(fill(rs));
        }
        return listaHorario;
    }
    
    public List<Horario> getAllFiltro(int idDiaClase) throws SQLException, Exception {
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();

        String queryListaAsistencia = "Select * from horario where idDiaClase = " + idDiaClase;

        PreparedStatement pstmt = conn.prepareStatement(queryListaAsistencia);
        ResultSet rs = pstmt.executeQuery();

        List<Horario> listaHorario = new ArrayList<>();
        while (rs.next()) {
            listaHorario.add(fill(rs));
        }
        return listaHorario;
    }

    private Horario fill(ResultSet rs) throws Exception {
        Horario horario = new Horario();
        DiaClase diaClase = new DiaClase();

        horario.setIdHorario(rs.getInt("idHorario"));
        horario.setHorario(rs.getString("horario"));
        diaClase.setIdDiaClase(rs.getInt("idDiaClase"));
        horario.setDiaClase(diaClase);
        
        return horario;
    }
}
