/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yavirac.fnj.pruebas;

import com.yavirac.fnj.consultas.GeneroConsulta;
import com.yavirac.fnj.modelo.Genero;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alterbios
 */
public class Prueba {

    public static void main(String[] arg) {
        GeneroConsulta genero = new GeneroConsulta();
        genero.conectar();
        List<Genero> generos = new ArrayList();
        generos = genero.getAll();
        for (Genero genero1 : generos) {
            System.out.println("Los generos son");
            System.out.println(genero1.getIdGenero());
            System.out.println(genero1.getDescripcion());
        }
        genero.desconectar();

    }
}
