/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.utl.bd.ConexionMySQL;
import org.utl.model.Alumno;
import org.utl.model.Directivo;
import org.utl.model.Docente;
import org.utl.model.Grupo;
import org.utl.model.Usuario;

/**
 *
 * @author DaniV
 */
public class ControllerLogin {

    public Usuario login(Usuario usuario) throws Exception {
        String sql = "SELECT * FROM usuario WHERE username = '" + usuario.getUsername()
                    + "' AND contrasenia = '" + usuario.getContrasenia() + "'";

        ConexionMySQL connMySQL = new ConexionMySQL();

        //Abrimos la conexión con la Base de Datos:
        Connection conn = connMySQL.open();

        //Con este objeto ejecutaremos la operacion:
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //Ejecutamos la operacion:
        ResultSet rs = pstmt.executeQuery();
        
        Usuario usu = new Usuario();
        while (rs.next()) {
            usu = fill(rs);
        }

        pstmt.close();
        connMySQL.close();
        
        return usu;
    }

    private Usuario fill(ResultSet rs) throws Exception {
        Usuario usu = new Usuario();
        usu.setIdUsuario(rs.getInt("idUsuario"));
        usu.setUsername(rs.getString("username"));
        usu.setContrasenia(rs.getString("contrasenia"));
        
        return usu;
    }
}
