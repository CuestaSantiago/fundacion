/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yavirac.fnj.consultas;

import com.yavirac.fnj.modelo.Genero;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alterbios
 */
public class GeneroConsulta {
    
     private Connection c = null; //coneccion 
    private Statement stmt = null; // la declaracion 
    private final String db_name = "fundacion.db";  //nombre de la base

      public void conectar() {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:" + db_name);  // se conecta la base 
            c.setAutoCommit(false);
            stmt = c.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    /**
     * Este metodo sirve para desconectar la base de datos
     */
    public void desconectar() {
        try {
            stmt.close();
            c.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    
    public List<Genero> getAll() {   // Aqui se ejecuta los usuarios que han entrado y aun no  han salido
        List<Genero> listaGenero = new ArrayList<>();
        ResultSet rs = null;

        String consulta = "SELECT idGenero, descripcion from genero";
        try {
            rs = stmt.executeQuery(consulta);
            while (rs.next()) {
                Genero genero = new Genero();
                genero.setIdGenero(rs.getInt("idGenero"));
                genero.setDescripcion(rs.getString("descripcion"));
                listaGenero.add(genero);
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
        }
        return listaGenero;
    }
}
