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

}
