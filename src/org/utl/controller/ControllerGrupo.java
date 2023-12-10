/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.utl.bd.ConexionMySQL;
import org.utl.model.DiaClase;
import org.utl.model.FormatoLista;
import org.utl.model.Grupo;

/**
 *
 * @author DaniV
 */
public class ControllerGrupo {

    public List<Grupo> getAll() throws SQLException, Exception {
        //La consulta SQL a ejecutar:
        String sql = "SELECT * FROM grupo";

        //Con este objeto nos vamos a conectar a la Base de Datos:
        ConexionMySQL connMySQL = new ConexionMySQL();

        //Abrimos la conexión con la Base de Datos:
        Connection conn = connMySQL.open();

        //Con este objeto ejecutaremos la consulta:
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //Aquí guardaremos los resultados de la consulta:
        ResultSet rs = pstmt.executeQuery();

        List<Grupo> grupos = new ArrayList<>();

        while (rs.next()) {
            grupos.add(fill(rs));
        }

        rs.close();
        pstmt.close();
        connMySQL.close();

        return grupos;
    }

    public Grupo getLastId() throws SQLException, Exception {
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();

        String selectFormato = "SELECT MAX(idGrupo) AS idGrupo FROM grupo";

        PreparedStatement pstmt = conn.prepareStatement(selectFormato);
        ResultSet rs = pstmt.executeQuery();

        Grupo grupo = new Grupo();

        while (rs.next()) {
            grupo.setIdGrupo(rs.getInt("idGrupo"));
        }

        return grupo;
    }

    public int insertAndGetID(Grupo grupo) throws SQLException {
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();

        String insertFormato = "INSERT INTO grupo(idGrupo, nombreGrupo) VALUES(?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(insertFormato, Statement.RETURN_GENERATED_KEYS);

        // Establecer los valores de los parámetros
        pstmt.setInt(1, grupo.getIdGrupo());
        pstmt.setString(2, grupo.getNombreGrupo());

        // Ejecutar la inserción
        pstmt.executeUpdate();

        // Obtener el ID generado
        ResultSet generatedKeys = pstmt.getGeneratedKeys();
        int idGrupo = -1; // Valor predeterminado si no se puede obtener el ID generado
        if (generatedKeys.next()) {
            idGrupo = generatedKeys.getInt(1); // Obtener el ID generado
        }
        // Cerrar recursos
        generatedKeys.close();
        pstmt.close();

        return idGrupo; // Devolver el ID generado
    }

    private Grupo fill(ResultSet rs) throws Exception {
        Grupo grupo = new Grupo();

        grupo.setIdGrupo(rs.getInt("idGrupo"));
        grupo.setNombreGrupo(rs.getString("nombreGrupo"));
        return grupo;
    }

}
