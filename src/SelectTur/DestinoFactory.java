package SelectTur;

import java.util.Vector;

public class DestinoFactory {

    public static final int COMMADRID = 100;
    public static final int MADRID = 0;
    public static final int COMANDALUCIA = 200;
    public static final int ALMERIA = 1;
    public static final int CADIZ = 2;
    public static final int CORDOBA = 3;
    public static final int GRANADA = 4;
    public static final int HUELVA = 5;
    public static final int JAEN = 6;
    public static final int MALAGA = 7;
    public static final int SEVILLA = 8;
    public static final int COMCATALUNA = 300;
    public static final int BARCELONA = 9;
    public static final int GIRONA = 10;
    public static final int LLEIDA = 11;
    public static final int TARRAGONA = 12;
    public static final int COMVALENCIANA = 400;
    public static final int ALICANTE = 13;
    public static final int CASTELLON = 14;
    public static final int VALENCIA = 15;
    public static final int COMGALICIA = 500;
    public static final int ACORUNA = 16;
    public static final int LUGO = 17;
    public static final int OURENSE = 18;
    public static final int PONTEVEDRA = 19;
    public static final int COMPAISVASCO = 600;
    public static final int ALAVA = 20;
    public static final int GIPUZKOA = 21;
    public static final int BIZKAIA = 22;

    public static final boolean CULTURA = true;
    public static final boolean CAMPOYPLAYA = true;
    public static final boolean GASTRONOMIA = true;
    public static final boolean DISCO = true;

    public static Vector<Destino> destinos;

    public static Vector<Destino> createDestinos() {
        destinos.add(new Destino(MADRID, COMMADRID,3, new boolean[]{CULTURA, false, GASTRONOMIA, DISCO}));
        destinos.add(new Destino(ALMERIA, COMANDALUCIA, 1, new boolean[]{CULTURA, CAMPOYPLAYA, GASTRONOMIA, DISCO}));
        destinos.add(new Destino(CADIZ, COMANDALUCIA, 1, new boolean[]{CULTURA, CAMPOYPLAYA, GASTRONOMIA, DISCO}));
        destinos.add(new Destino(CORDOBA, COMANDALUCIA, 1, new boolean[]{CULTURA, CAMPOYPLAYA, GASTRONOMIA, DISCO}));
        destinos.add(new Destino(GRANADA, COMANDALUCIA, 2, new boolean[]{CULTURA, CAMPOYPLAYA, GASTRONOMIA, DISCO}));
        destinos.add(new Destino(HUELVA, COMANDALUCIA, 7, new boolean[]{CULTURA, CAMPOYPLAYA, GASTRONOMIA, DISCO}));
        destinos.add(new Destino(JAEN, COMANDALUCIA, 1, new boolean[]{CULTURA, CAMPOYPLAYA, GASTRONOMIA, DISCO}));
        destinos.add(new Destino(MALAGA, COMANDALUCIA, 7, new boolean[]{CULTURA, CAMPOYPLAYA, GASTRONOMIA, DISCO}));
        destinos.add(new Destino(SEVILLA, COMANDALUCIA, 3, new boolean[]{CULTURA, CAMPOYPLAYA, GASTRONOMIA, DISCO}));
        destinos.add(new Destino(BARCELONA, COMCATALUNA, 3, new boolean[]{CULTURA, CAMPOYPLAYA, GASTRONOMIA, DISCO}));
        destinos.add(new Destino(GIRONA, COMCATALUNA,2, new boolean[]{CULTURA, CAMPOYPLAYA, GASTRONOMIA, DISCO}));
        destinos.add(new Destino(LLEIDA, COMCATALUNA, 1, new boolean[]{CULTURA, CAMPOYPLAYA, GASTRONOMIA, DISCO}));
        destinos.add(new Destino(TARRAGONA, COMCATALUNA, 7, new boolean[]{CULTURA, CAMPOYPLAYA, GASTRONOMIA, DISCO}));
        destinos.add(new Destino(ALICANTE, COMVALENCIANA, 3, new boolean[]{CULTURA, CAMPOYPLAYA, GASTRONOMIA, DISCO}));
        destinos.add(new Destino(CASTELLON, COMVALENCIANA, 2, new boolean[]{CULTURA, CAMPOYPLAYA, GASTRONOMIA, DISCO}));
        destinos.add(new Destino(VALENCIA, COMVALENCIANA, 3, new boolean[]{CULTURA, CAMPOYPLAYA, GASTRONOMIA, DISCO}));
        destinos.add(new Destino(ACORUNA, COMGALICIA, 2, new boolean[]{CULTURA, CAMPOYPLAYA, GASTRONOMIA, DISCO}));
        destinos.add(new Destino(LUGO, COMGALICIA, 1, new boolean[]{CULTURA, CAMPOYPLAYA, GASTRONOMIA, DISCO}));
        destinos.add(new Destino(OURENSE, COMGALICIA, 2, new boolean[]{CULTURA, CAMPOYPLAYA, GASTRONOMIA, DISCO}));
        destinos.add(new Destino(PONTEVEDRA, COMGALICIA,3, new boolean[]{CULTURA, CAMPOYPLAYA, GASTRONOMIA, DISCO}));
        destinos.add(new Destino(ALAVA, COMPAISVASCO,1, new boolean[]{CULTURA, CAMPOYPLAYA, GASTRONOMIA, DISCO}));
        destinos.add(new Destino(GIPUZKOA, COMPAISVASCO,2, new boolean[]{CULTURA, CAMPOYPLAYA, GASTRONOMIA, DISCO}));
        destinos.add(new Destino(BIZKAIA, COMPAISVASCO,2, new boolean[]{CULTURA, CAMPOYPLAYA, GASTRONOMIA, DISCO}));


        return destinos
    }


    public static String getName(int nombre) {

        switch (nombre) {
            case 0: return "MADRID, C. DE MADRID";
            case 1: return "ALMERIA, C. DE ANDALUCIA";
            case 2: return "CADIZ, C. DE ANDALUCIA";
            case 3: return "CORDOBA, C. DE ANDALUCIA";
            case 4: return "GRANADA, C. DE ANDALUCIA";
            case 5: return "HUELVA, C. DE ANDALUCIA";
            case 6: return "JAEN, C. DE ANDALUCIA";
            case 7: return "MALAGA, C. DE ANDALUCIA";
            case 8: return "SEVILLA, C. DE ANDALUCIA";
            case 9: return "BARCELONA, C. DE CATALUNA";
            case 10: return "GIRONA, C. DE CATALUNA";
            case 11: return "LLEIDA, C. DE CATALUNA";
            case 12: return "TARRAGONA, C. DE CATALUNA";
            case 13: return "ALICANTE, C. VALENCIANA";
            case 14: return "CASTELLON, C. VALENCIANA";
            case 15: return "VALENCIA, C. VALENCIANA";
            case 16: return "ACORUNA, C. DE GALICIA";
            case 17: return "LUGO, C. DE GALICIA";
            case 18: return "OURENSE, C. DE GALICIA";
            case 19: return "PONTEVEDRA, C. DE GALICIA";
            case 20: return "ALAVA, PAIS VASCO";
            case 21: return "GIPUZKOA, PAIS VASCO";
            case 22: return "BIZKAIA, PAIS VASCO";
            default: return "ERROR DE CODIGO";
        }
    }
}
