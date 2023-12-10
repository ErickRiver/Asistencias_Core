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
import org.utl.model.DiaClase;
import org.utl.model.Docente;
import org.utl.model.FormatoLista;
import org.utl.model.ListaAsistencia;
import org.utl.model.Materia;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.CallableStatement;

/**
 *
 * @author DaniV
 */
public class ControllerDiaClase {

    public void insert(DiaClase diaClase) throws SQLException {
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();

        String insertFormato = "INSERT INTO diaClase(idDiaClase, dia, idFormatoLista) VALUES("
                + diaClase.getIdDiaClase() + ", '" + diaClase.getDia() + "', "
                + diaClase.getFormatoLista().getIdFormatoLista() + ")";
        PreparedStatement pstmt = conn.prepareStatement(insertFormato);
        pstmt.execute();
    }

    public int insertAndGetID(DiaClase diaClase) throws SQLException {
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();

        String insertFormato = "INSERT INTO diaClase(dia, idFormatoLista) VALUES(?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(insertFormato, Statement.RETURN_GENERATED_KEYS);

        // Establecer los valores de los parámetros
        pstmt.setString(1, diaClase.getDia());
        pstmt.setInt(2, diaClase.getFormatoLista().getIdFormatoLista());

        // Ejecutar la inserción
        pstmt.executeUpdate();

        // Obtener el ID generado
        ResultSet generatedKeys = pstmt.getGeneratedKeys();
        int idDiaClase = -1; // Valor predeterminado si no se puede obtener el ID generado
        if (generatedKeys.next()) {
            idDiaClase = generatedKeys.getInt(1); // Obtener el ID generado
        }
        // Cerrar recursos
        generatedKeys.close();
        pstmt.close();

        return idDiaClase; // Devolver el ID generado
    }

    public List<DiaClase> getAll() throws SQLException, Exception {
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();

        String queryListaAsistencia = "Select * from diaClase";

        PreparedStatement pstmt = conn.prepareStatement(queryListaAsistencia);
        ResultSet rs = pstmt.executeQuery();

        List<DiaClase> diasClase = new ArrayList<>();
        while (rs.next()) {
            diasClase.add(fill(rs));
        }

        return diasClase;
    }

    public List<DiaClase> getDiaPorFormatoLista(int idFormatoLista) throws SQLException, Exception {
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();

        String queryListaAsistencia = "Select * from diaClase where idFormatoLista = " + idFormatoLista;

        PreparedStatement pstmt = conn.prepareStatement(queryListaAsistencia);
        ResultSet rs = pstmt.executeQuery();

        List<DiaClase> diasClase = new ArrayList<>();
        while (rs.next()) {
            diasClase.add(fill(rs));
        }

        return diasClase;
    }

    private DiaClase fill(ResultSet rs) throws Exception {
        DiaClase diaClase = new DiaClase();
        FormatoLista formatoLista = new FormatoLista();

        formatoLista.setIdFormatoLista(rs.getInt("idFormatoLista"));

        diaClase.setDia(rs.getString("dia"));
        diaClase.setFormatoLista(formatoLista);
        diaClase.setIdDiaClase(rs.getInt("idDiaClase"));

        return diaClase;
    }

    public DiaClase getLastId() throws SQLException, Exception {
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();

        String selectFormato = "SELECT MAX(idDiaClase) AS idDiaClase FROM diaclase";

        PreparedStatement pstmt = conn.prepareStatement(selectFormato);
        ResultSet rs = pstmt.executeQuery();

        DiaClase diaClase = new DiaClase();

        while (rs.next()) {
            diaClase.setIdDiaClase(rs.getInt("idDiaClase"));
        }

        return diaClase;
    }

}
