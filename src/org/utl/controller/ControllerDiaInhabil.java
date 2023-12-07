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
        public void insert(DiaInhabil diaInhabil) throws SQLException{
        
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();
        String insertFormato = "INSERT INTO diaInhabil(idDiaInhabil, fecha, idFormatoLista) VALUES("+ 
                diaInhabil.getIdDiaInhabil() + ", '" + diaInhabil.getFecha() + "', " + 
                diaInhabil.getFormatoLista().getIdFormatoLista() +")";
        PreparedStatement pstmt = conn.prepareStatement(insertFormato);
        pstmt.execute();
    }
    
    public List<DiaInhabil> getAll(int idFormatoLista) throws SQLException{
        DiaInhabil diaInhabil = new DiaInhabil();
        List<DiaInhabil> listaDias = new ArrayList<>();
        FormatoLista formatoLista = new FormatoLista();
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();
        String queryListaAsistencia = "Select * from diaInhabil where idFormatoLista = " + idFormatoLista;
        PreparedStatement pstmt = conn.prepareStatement(queryListaAsistencia);
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
            formatoLista.setIdFormatoLista(rs.getInt("idFormatoLista"));
            diaInhabil.setFecha(rs.getString("fecha"));
            diaInhabil.setFormatoLista(formatoLista);
            diaInhabil.setIdDiaInhabil(rs.getInt("idDiaInhabil"));
            listaDias.add(diaInhabil);
        }
        return listaDias;
    }
}
