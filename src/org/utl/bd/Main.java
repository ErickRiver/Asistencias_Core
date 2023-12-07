/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.bd;

/**
 *
 * @author Erick
 */
public class Main {

    public static void main(String[] args) {
        ConexionMySQL cm = new ConexionMySQL();
        try {
            cm.open();
            cm.close();
        } catch (Exception e) {
            e.printStackTrace();
            // Manejo de la excepción, puedes mostrar un mensaje de error o realizar alguna acción específica.
        }

    }
}
