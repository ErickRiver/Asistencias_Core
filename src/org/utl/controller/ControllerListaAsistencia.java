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
import org.utl.model.Docente;
import org.utl.model.FormatoLista;
import org.utl.model.Grupo;
import org.utl.model.ListaAsistencia;
import org.utl.model.Materia;

/**
 *
 * @author DaniV
 */
public class ControllerListaAsistencia {

    public void insert(ListaAsistencia listaAsistencia) throws SQLException {
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();
        String insertLista = "INSERT INTO listaAsistencia(idMateria, idDocente, idAlumno, "
                + "dia, hora, semana, asistencia) VALUES(" + listaAsistencia.getMateria().getIdMateria() + ", "
                + listaAsistencia.getDocente().getIdDocente() + ", " + listaAsistencia.getAlumno().getIdAlumno()
                + ", '" + listaAsistencia.getDia() + "', '" + listaAsistencia.getHora() + "', " + listaAsistencia.getSemana()
                + ", '" + listaAsistencia.getAsistencia() + "')";
        PreparedStatement pstmt = conn.prepareStatement(insertLista);
        pstmt.execute();
    }

    public List<ListaAsistencia> getAllFiltro(int idAlumno, int idMateria, int idDocente) throws SQLException {
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();

        String queryListaAsistencia = "Select * from listaAsistencia where idAlumno = " + idAlumno + " OR idMateria = "
                + idMateria + " OR idDocente = " + idDocente;

        PreparedStatement pstmt = conn.prepareStatement(queryListaAsistencia);
        ResultSet rs = pstmt.executeQuery();

        List<ListaAsistencia> asistenciaListas = new ArrayList<>();
        Alumno alumno = new Alumno();
        Materia materia = new Materia();
        Docente docente = new Docente();

        while (rs.next()) {
            ListaAsistencia listaAsistencia = new ListaAsistencia();

            materia.setIdMateria(rs.getInt("idMateria"));
            docente.setIdDocente(rs.getInt("idDocente"));
            alumno.setIdAlumno(rs.getInt("idAlumno"));
            listaAsistencia.setSemana(rs.getInt("semana"));
            listaAsistencia.setIdListaAsistencia(rs.getInt("idListaAsistencia"));
            listaAsistencia.setDia(rs.getString("dia"));
            listaAsistencia.setHora(rs.getString("hora"));
            listaAsistencia.setDocente(docente);
            listaAsistencia.setMateria(materia);
            listaAsistencia.setAlumno(alumno);
            String asistenciaString = rs.getString("asistencia");
            char asistencia = ' ';
            if (asistenciaString != null && !asistenciaString.isEmpty()) {
                asistencia = asistenciaString.charAt(0);
            }
            listaAsistencia.setAsistencia(asistencia);
            asistenciaListas.add(listaAsistencia);
        }
        return asistenciaListas;
    }

    public List<ListaAsistencia> getListaPorSemana(int semana) throws SQLException {
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();

        String queryListaAsistencia = "Select * from listaAsistencia where semana = " + semana;

        PreparedStatement pstmt = conn.prepareStatement(queryListaAsistencia);
        ResultSet rs = pstmt.executeQuery();

        List<ListaAsistencia> asistenciaListas = new ArrayList<>();
        Alumno alumno = new Alumno();
        Materia materia = new Materia();
        Docente docente = new Docente();

        while (rs.next()) {
            ListaAsistencia listaAsistencia = new ListaAsistencia();

            materia.setIdMateria(rs.getInt("idMateria"));
            docente.setIdDocente(rs.getInt("idDocente"));
            alumno.setIdAlumno(rs.getInt("idAlumno"));
            listaAsistencia.setSemana(rs.getInt("semana"));
            listaAsistencia.setIdListaAsistencia(rs.getInt("idListaAsistencia"));
            listaAsistencia.setDia(rs.getString("dia"));
            listaAsistencia.setHora(rs.getString("hora"));
            listaAsistencia.setDocente(docente);
            listaAsistencia.setMateria(materia);
            listaAsistencia.setAlumno(alumno);
            String asistenciaString = rs.getString("asistencia");
            char asistencia = ' ';
            if (asistenciaString != null && !asistenciaString.isEmpty()) {
                asistencia = asistenciaString.charAt(0);
            }
            listaAsistencia.setAsistencia(asistencia);
            asistenciaListas.add(listaAsistencia);
        }
        return asistenciaListas;
    }

    public List<ListaAsistencia> getAll() throws SQLException {
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();

        String queryListaAsistencia = "Select * from listaAsistencia";

        PreparedStatement pstmt = conn.prepareStatement(queryListaAsistencia);
        ResultSet rs = pstmt.executeQuery();

        List<ListaAsistencia> asistenciaListas = new ArrayList<>();
        Alumno alumno = new Alumno();
        Materia materia = new Materia();
        Docente docente = new Docente();

        while (rs.next()) {
            ListaAsistencia listaAsistencia = new ListaAsistencia();

            materia.setIdMateria(rs.getInt("idMateria"));
            docente.setIdDocente(rs.getInt("idDocente"));
            alumno.setIdAlumno(rs.getInt("idAlumno"));
            listaAsistencia.setSemana(rs.getInt("semana"));
            listaAsistencia.setIdListaAsistencia(rs.getInt("idListaAsistencia"));
            listaAsistencia.setDia(rs.getString("dia"));
            listaAsistencia.setHora(rs.getString("hora"));
            listaAsistencia.setDocente(docente);
            listaAsistencia.setMateria(materia);
            listaAsistencia.setAlumno(alumno);
            String asistenciaString = rs.getString("asistencia");
            char asistencia = ' ';
            if (asistenciaString != null && !asistenciaString.isEmpty()) {
                asistencia = asistenciaString.charAt(0);
            }
            listaAsistencia.setAsistencia(asistencia);
            asistenciaListas.add(listaAsistencia);
        }
        return asistenciaListas;
    }

    public List<ListaAsistencia> getVistaLista() throws SQLException {
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();

        String queryListaAsistencia = "Select * from VistaAsistenciaAlumnos";

        PreparedStatement pstmt = conn.prepareStatement(queryListaAsistencia);
        ResultSet rs = pstmt.executeQuery();

        List<ListaAsistencia> asistenciaListas = new ArrayList<>();
        Alumno alumno = new Alumno();
        Materia materia = new Materia();
        Docente docente = new Docente();

        while (rs.next()) {
            ListaAsistencia listaAsistencia = new ListaAsistencia();

            alumno.setIdAlumno(rs.getInt("idAlumno"));
            alumno.setNombre(rs.getString("NombreAlumno"));
            alumno.setApellido(rs.getString("ApellidoAlumno"));

            materia.setIdMateria(rs.getInt("idMateria"));
            materia.setNombre(rs.getString("NombreMateria"));

            docente.setIdDocente(rs.getInt("idDocente"));
            docente.setNombre(rs.getString("NombreDocente"));
            docente.setApellido(rs.getString("ApellidoDocente"));

            listaAsistencia.setIdListaAsistencia(rs.getInt("idListaAsistencia"));
            listaAsistencia.setSemana(rs.getInt("Semana"));
            listaAsistencia.setDia(rs.getString("FechaAsistencia"));
            listaAsistencia.setHora(rs.getString("HoraAsistencia"));
            listaAsistencia.setDocente(docente);
            listaAsistencia.setMateria(materia);
            listaAsistencia.setAlumno(alumno);

            String asistenciaString = rs.getString("asistencia");
            char asistencia = ' ';
            if (asistenciaString != null && !asistenciaString.isEmpty()) {
                asistencia = asistenciaString.charAt(0);
            }
            listaAsistencia.setAsistencia(asistencia);
            asistenciaListas.add(listaAsistencia);
        }
        return asistenciaListas;
    }

    public List<ListaAsistencia> getVistaListaPorSemana(int semana) throws SQLException {
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();

        String queryListaAsistencia = "Select * from VistaAsistenciaAlumnos2 where semana = " + semana;

        PreparedStatement pstmt = conn.prepareStatement(queryListaAsistencia);
        ResultSet rs = pstmt.executeQuery();

        List<ListaAsistencia> asistenciaListas = new ArrayList<>();

        while (rs.next()) {
            ListaAsistencia listaAsistencia = new ListaAsistencia();
            Alumno alumno = new Alumno();
            Materia materia = new Materia();
            Docente docente = new Docente();
            Grupo grupo = new Grupo();

            alumno.setIdAlumno(rs.getInt("idAlumno"));
            alumno.setNombre(rs.getString("NombreAlumno"));
            alumno.setApellido(rs.getString("ApellidoAlumno"));

            materia.setIdMateria(rs.getInt("idMateria"));
            materia.setNombre(rs.getString("NombreMateria"));

            docente.setIdDocente(rs.getInt("idDocente"));
            docente.setNombre(rs.getString("NombreDocente"));
            docente.setApellido(rs.getString("ApellidoDocente"));

            grupo.setIdGrupo(rs.getInt("idGrupo"));
            grupo.setNombreGrupo(rs.getString("NombreGrupo"));

            listaAsistencia.setIdListaAsistencia(rs.getInt("idListaAsistencia"));
            listaAsistencia.setSemana(rs.getInt("Semana"));
            listaAsistencia.setDia(rs.getString("FechaAsistencia"));
            listaAsistencia.setHora(rs.getString("HoraAsistencia"));
            listaAsistencia.setDocente(docente);
            listaAsistencia.setMateria(materia);
            listaAsistencia.setAlumno(alumno);
            listaAsistencia.getAlumno().setGrupo(grupo);

            String asistenciaString = rs.getString("asistencia");
            char asistencia = ' ';
            if (asistenciaString != null && !asistenciaString.isEmpty()) {
                asistencia = asistenciaString.charAt(0);
            }
            listaAsistencia.setAsistencia(asistencia);
            asistenciaListas.add(listaAsistencia);
        }
        return asistenciaListas;
    }

    public List<ListaAsistencia> getVistaListaPorSemanaYmateria(int semana, int idMateria) throws SQLException {
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();

        String queryListaAsistencia = "Select * from VistaAsistenciaAlumnos where semana = " + semana + " and idMateria = " + idMateria;

        PreparedStatement pstmt = conn.prepareStatement(queryListaAsistencia);
        ResultSet rs = pstmt.executeQuery();

        List<ListaAsistencia> asistenciaListas = new ArrayList<>();
        Alumno alumno = new Alumno();
        Materia materia = new Materia();
        Docente docente = new Docente();

        while (rs.next()) {
            ListaAsistencia listaAsistencia = new ListaAsistencia();

            alumno.setIdAlumno(rs.getInt("idAlumno"));
            alumno.setNombre(rs.getString("NombreAlumno"));
            alumno.setApellido(rs.getString("ApellidoAlumno"));

            materia.setIdMateria(rs.getInt("idMateria"));
            materia.setNombre(rs.getString("NombreMateria"));

            docente.setIdDocente(rs.getInt("idDocente"));
            docente.setNombre(rs.getString("NombreDocente"));
            docente.setApellido(rs.getString("ApellidoDocente"));

            listaAsistencia.setIdListaAsistencia(rs.getInt("idListaAsistencia"));
            listaAsistencia.setSemana(rs.getInt("Semana"));
            listaAsistencia.setDia(rs.getString("FechaAsistencia"));
            listaAsistencia.setHora(rs.getString("HoraAsistencia"));
            listaAsistencia.setDocente(docente);
            listaAsistencia.setMateria(materia);
            listaAsistencia.setAlumno(alumno);

            String asistenciaString = rs.getString("asistencia");
            char asistencia = ' ';
            if (asistenciaString != null && !asistenciaString.isEmpty()) {
                asistencia = asistenciaString.charAt(0);
            }
            listaAsistencia.setAsistencia(asistencia);
            asistenciaListas.add(listaAsistencia);
        }
        return asistenciaListas;
    }

    public List<ListaAsistencia> getVistaListaPorSemanaYmateriaYgrupo(int semana, int idMateria, int idGrupo) throws SQLException {
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();

        String queryListaAsistencia = "Select * from VistaAsistenciaAlumnos2 where semana = " + semana + " and idMateria = " + idMateria + " and idGrupo = " + idGrupo;

        PreparedStatement pstmt = conn.prepareStatement(queryListaAsistencia);
        ResultSet rs = pstmt.executeQuery();

        List<ListaAsistencia> asistenciaListas = new ArrayList<>();
        Alumno alumno = new Alumno();
        Materia materia = new Materia();
        Docente docente = new Docente();
        Grupo grupo = new Grupo();

        while (rs.next()) {
            ListaAsistencia listaAsistencia = new ListaAsistencia();

            alumno.setIdAlumno(rs.getInt("idAlumno"));
            alumno.setNombre(rs.getString("NombreAlumno"));
            alumno.setApellido(rs.getString("ApellidoAlumno"));

            materia.setIdMateria(rs.getInt("idMateria"));
            materia.setNombre(rs.getString("NombreMateria"));

            docente.setIdDocente(rs.getInt("idDocente"));
            docente.setNombre(rs.getString("NombreDocente"));
            docente.setApellido(rs.getString("ApellidoDocente"));

            grupo.setIdGrupo(rs.getInt("idGrupo"));
            grupo.setNombreGrupo(rs.getString("NombreGrupo"));

            listaAsistencia.setIdListaAsistencia(rs.getInt("idListaAsistencia"));
            listaAsistencia.setSemana(rs.getInt("Semana"));
            listaAsistencia.setDia(rs.getString("FechaAsistencia"));
            listaAsistencia.setHora(rs.getString("HoraAsistencia"));
            listaAsistencia.setDocente(docente);
            listaAsistencia.setMateria(materia);
            listaAsistencia.setAlumno(alumno);

            String asistenciaString = rs.getString("asistencia");
            char asistencia = ' ';
            if (asistenciaString != null && !asistenciaString.isEmpty()) {
                asistencia = asistenciaString.charAt(0);
            }
            listaAsistencia.setAsistencia(asistencia);
            listaAsistencia.getAlumno().setGrupo(grupo);

            asistenciaListas.add(listaAsistencia);
        }
        return asistenciaListas;
    }

}
