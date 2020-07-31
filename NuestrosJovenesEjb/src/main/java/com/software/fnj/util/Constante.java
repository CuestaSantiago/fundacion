/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.software.fnj.util;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author santiago
 */
public class Constante {

    public static final String UTF8_CHARSET = ";charset=utf-8";

    public enum PerfilConstante {
        SUPERADMIN(1),
        ADMIN(2);

        private final Integer profileId;

        private PerfilConstante(Integer perfilId) {
            this.profileId = perfilId;
        }

        public Integer getProfileId() {
            return profileId;
        }

        public static Map<Integer, String> getPerfilMap() {
            Map<Integer, String> perfilMap = new HashMap<>();
            for (PerfilConstante type : PerfilConstante.values()) {
                perfilMap.put(type.getProfileId(), type.name());
            }
            return perfilMap;
        }

    }

    public enum UsuarioConstante {
        ACTIVO(1),
        DESACTIVADO(2),
        SINFIRMA(3);

        private final Integer usuarioConstanteId;

        private UsuarioConstante(Integer usuarioConstanteId) {
            this.usuarioConstanteId = usuarioConstanteId;
        }

        public Integer getUsuarioConstanteId() {
            return usuarioConstanteId;
        }

        public static Map<Integer, String> getUsuarioConstanteMap() {
            Map<Integer, String> usuarioConstanteMap = new HashMap<>();
            for (UsuarioConstante type : UsuarioConstante.values()) {
                usuarioConstanteMap.put(type.getUsuarioConstanteId(), type.name());
            }
            return usuarioConstanteMap;
        }

    }
}
