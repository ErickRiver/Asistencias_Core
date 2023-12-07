/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.controller;

import java.sql.Connection;
import org.utl.bd.ConexionMySQL;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.utl.model.Docente;
import org.utl.model.FormatoLista;
import org.utl.model.Grupo;
import org.utl.model.Materia;
import java.util.ArrayList;

/**
 *
 * @author DaniV
 */
public class ControllerFormatoLista {
    
    public void insert(FormatoLista formatoLista) throws SQLException{
        
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();
        String insertFormato = "INSERT INTO formatoLista(idMateria, idDocente, idGrupo,  "
                                + "semanas, nomenclatura) VALUES('"+ formatoLista.getMateria().getIdMateria() + "', '" + 
                                formatoLista.getDocente().getIdDocente() + "', '" + formatoLista.getGrupo().getIdGrupo() +
                                "', "  + formatoLista.getSemanas() +
                                ", " + formatoLista.getNomenclatura() +")";
        PreparedStatement pstmt = conn.prepareStatement(insertFormato);
        pstmt.execute();
    }
    
    
    
    public List<FormatoLista> getAll(int idDocente, int idGrupo, int idMateria) throws SQLException{
        FormatoLista formatoLista = new FormatoLista();
        List<FormatoLista> listaFormatos = new ArrayList<>();
        Grupo grupo = new Grupo();
        Materia materia = new Materia();
        Docente docente = new Docente();
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();
        String selectFormato = "Select * from formatoLista where idDocente = " + idDocente + " OR idGrupo = "
                + idGrupo + " OR idMateria = "+ idMateria;
        PreparedStatement pstmt = conn.prepareStatement(selectFormato);
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
            grupo.setIdGrupo(rs.getInt("idGrupo"));
            materia.setIdMateria(rs.getInt("idMateria"));
            docente.setIdDocente(rs.getInt("idDocente"));
            formatoLista.setSemanas(rs.getInt("semanas"));
            formatoLista.setIdFormatoLista(rs.getInt("idFormatoLista"));
            formatoLista.setNomenclatura(rs.getInt("nomenclatura"));
            formatoLista.setDocente(docente);
            formatoLista.setMateria(materia);
            formatoLista.setGrupo(grupo);
            listaFormatos.add(formatoLista);
            
        }
        return listaFormatos;
    }
    
    
   
}
