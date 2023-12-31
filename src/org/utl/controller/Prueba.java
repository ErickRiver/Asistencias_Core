/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.utl.controller;

import java.util.ArrayList;
import java.util.List;
import org.utl.model.Alumno;

import org.utl.model.DiaClase;
import org.utl.model.DiaInhabil;

import org.utl.model.Docente;
import org.utl.model.FormatoLista;
import org.utl.model.Grupo;
import org.utl.model.Horario;
import org.utl.model.ListaAsistencia;
import org.utl.model.Materia;

import org.utl.model.Usuario;

/**
 *
 * @author DaniV
 */
public class Prueba {

    public static void main(String[] args) throws Exception {
        ListaAsistencia listaAsistencia = new ListaAsistencia();
        Alumno alumno = new Alumno();
        alumno.setIdAlumno(2);
        
        Materia materia = new Materia();
        materia.setIdMateria(2);
        
        Docente docente = new Docente();
        docente.setIdDocente(2);
            
        listaAsistencia.setAlumno(alumno);
        listaAsistencia.setMateria(materia);
        listaAsistencia.setDocente(docente);
        
        listaAsistencia.setDia("2023-10-10");
        listaAsistencia.setHora("10:00");
        listaAsistencia.setSemana(1);
        listaAsistencia.setAsistencia('A');
        
        ControllerListaAsistencia as = new ControllerListaAsistencia();
        as.insert(listaAsistencia);
        
        ControllerListaAsistencia ctrListaAsistencia = new ControllerListaAsistencia();
//        ctrListaAsistencia.update(1, 'R');
        
        Usuario usuario = new Usuario();
        usuario.setUsername("usuario23");
        usuario.setContrasenia("1234");

        ControllerLogin ctrLogin = new ControllerLogin();
//        System.out.println(ctrLogin.login(usuario));
//        Grupo grupo = new Grupo();
//        grupo.setIdGrupo(1);
//        Usuario usuario = new Usuario();
//        usuario.setIdUsuario(1);
//        
//        Alumno alumno = new Alumno();
//        alumno.setNombre("Erick");
//        alumno.setApellido("Rivera");
//        alumno.setFechaNacimiento("2003-08-01");
//        
//        alumno.setGrupo(grupo);
//        alumno.setUsuario(usuario);
//        
//        ControllerAlumno ctrAlumno = new ControllerAlumno();
//        ctrAlumno.insert(alumno);
//        DiaClase diaClase = new DiaClase();
//        Horario horario = new Horario();
//        diaClase.setIdDiaClase(1);
//        diaClase.setDia("Martes");
//
//        FormatoLista fl = Formatonew FormatoLista();
//        fl.setIdFormatoLista(2);
//        diaClase.setFormatoLista(fl);
//        
//        ControllerDiaClase cda = new ControllerDiaClase();
//        System.out.println(cda.insertAndGetID(diaClase));
//        Horario horario = new Horario();
//        DiaClase diaClase = new DiaClase();
//        diaClase.setIdDiaClase(1);
//        
//        horario.setHorario("9:00 - 10:00");
//        horario.setDiaClase(diaClase);
//        
//        
//        ControllerHorario ctrHorario = new ControllerHorario();
//        ctrHorario.insert(horario);

//        ControllerDiaInhabil ctrDia = new ControllerDiaInhabil();
//        ctrDia.insert(4);
//        System.out.println(ctrFormatoLista.getAll());
//
//        FormatoLista formatoLista = new FormatoLista();
//        formatoLista.setIdFormatoLista(1);
//
//        ControllerDiaClase ctrDiaClase = new ControllerDiaClase();
//
//        List<DiaClase> diasParaInsertar = new ArrayList<>();
//
//        DiaClase lunes = new DiaClase();
//        lunes.setDia("Lunes");
//        lunes.setFormatoLista(formatoLista);
//        diasParaInsertar.add(lunes);
//
//        DiaClase martes = new DiaClase();
//        martes.setDia("Martes");
//        martes.setFormatoLista(formatoLista);
//        diasParaInsertar.add(martes);
//
//        DiaClase miercoles = new DiaClase();
//        miercoles.setDia("Miércoles");
//        miercoles.setFormatoLista(formatoLista);
//        diasParaInsertar.add(miercoles);

//        for (DiaClase dia : diasParaInsertar) {
//            ctrDiaClase.insert(dia);
//        }
//        ControllerListaAsistencia ctrLista = new ControllerListaAsistencia();
//        System.out.println(ctrLista.getVistaListaPorSemana(1));
//        System.out.println(ctrLista.getAll());
//        System.out.println(ctrLista.getListaPorSemana(1));
//        ControllerHorario ctrHorario = new ControllerHorario();
//        System.out.println(ctrHorario.getAll());
//        ControllerDiaClase ctrDiasClase = new ControllerDiaClase();
//        System.out.println(ctrDiasClase.getDiaPorFormatoLista(1));
//        ControllerGrupo ctrGrupo = new ControllerGrupo();
//        System.out.println(ctrGrupo.getAll());
        //Usuario usuario = new Usuario(0, "erickXDDD", "54321");
//        Grupo grupo = new Grupo(1, "IDGS701");
//   
//Materia materia = new Materia(8, "Mate");
//        ControllerMateria ctrMateria = new ControllerMateria();
//        System.out.println(ctrMateria.getAll());
//        Usuario usuario = new Usuario();
//        usuario.setUsername("fvaldeman");
//        usuario.setContrasenia("12345");
//        
//        ControllerLogin ctrLogin = new ControllerLogin();
//        System.out.println(ctrLogin.login(usuario));
//        ControllerAlumno ctrAlumno = new ControllerAlumno();
//        System.out.println(ctrAlumno.getAlumnoOgrupo(1, 1));
//        
//        ControllerDiaClase ctrDiaClase = new ControllerDiaClase();
//        ctrDiaClase.getAll(0);
//        ControllerDirectivo ctrDirectivo = new ControllerDirectivo();
//        System.out.println(ctrDirectivo.getAll());
//        ControllerDocente ctrDocente = new ControllerDocente();
//        System.out.println(ctrDocente.getAll());
//        System.out.println(ctrDocente.getDocente(11));
//        
//        Materia materia = new Materia();
//        //Docente docente = new Docente(2, "", "", "", usuario);
//        Docente docente = new Docente();
//        Alumno alumno = new Alumno(2,"","","",usuario, grupo);
        //ListaAsistencia listaAsistencia = new ListaAsistencia(0, 1, alumno, materia, docente, "2023-10-15", "11:00 PM", 'A');
//        LisListaAsistaAsistencia listaAsistencia = new ListaAsistencia(0, 0, alumno, materia, docente, "", "", ' ');
//        FormatoLista formatoLista = new FormatoLista(0,12, materia, docente, grupo, 1);
//        FormatoLista formatoList2 = new FormatoLista(0,12, materia, docente, grupo, 1);
//        DiaInhabil diaInhabil = new DiaInhabil(0 ,"2023-10-08", formatoLista);
//        DiaClase diaClase = new DiaClase(3, "miercoles", formatoLista);
//        Horario horario = new Horario(0, "10:00 PM", diaClase);
//        ControllerListaAsistencia cla = new ControllerListaAsistencia();
        //cla.insert(listaAsistencia);
//        List<ListaAsistencia> asistenciaListas = cla.getAll(listaAsistencia.getAlumno().getIdAlumno(), 
//                listaAsistencia.getMateria().getIdMateria(), listaAsistencia.getDocente().getIdDocente());
//        for (ListaAsistencia asistenciaLista : asistenciaListas) {
//            System.out.println(asistenciaLista);
//        }
//List<FormatoLista> listaFormatos = cgla.getAll(formatoLista.getDocente().getIdDocente(), 0, 0);
        //cgla.insert(  formatoLista, diaInhabilList, 
        //        listDiaClase, horarioList);
        //FormatoLista formato = cgla.getFormatoLista(2, 1);
        //ControllerListaAsistencia cla = new ControllerListaAsistencia();
        /* for (FormatoLista listaFormato : listaFormatos) {
            System.out.println(listaFormato);
        }*/
    }

}
