package SelectTur;

import java.util.Vector;

public class ProvinciaFactory {

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

    public static final int NUMERO_PREFERENCIAS = 5;
    public static final boolean CULTURA = true;
    public static final boolean SOLYPLAYA = true;
    public static final boolean GASTRONOMIA = true;
    public static final boolean DISCO = true;
    public static final boolean DEPORTES = true;


    public static Vector<Provincia> crearProvincias() {
        Vector<Provincia> provincias = new Vector<Provincia>();
        provincias.add(new Provincia(MADRID, COMMADRID,3, new boolean[]{CULTURA, false, GASTRONOMIA, DISCO, false},40.55,6454440,8027));
        provincias.add(new Provincia(ALMERIA, COMANDALUCIA, 1, new boolean[]{false, SOLYPLAYA, false, DISCO, DEPORTES},27.01,701688,8774));
        provincias.add(new Provincia(CADIZ, COMANDALUCIA, 1, new boolean[]{false, SOLYPLAYA, false, false, DEPORTES},30.04,1240175,7436));
        provincias.add(new Provincia(CORDOBA, COMANDALUCIA, 1, new boolean[]{CULTURA, false, GASTRONOMIA, false, false},46.48,799402,13771));
        provincias.add(new Provincia(GRANADA, COMANDALUCIA, 2, new boolean[]{CULTURA, SOLYPLAYA, GASTRONOMIA, false, false},28.68,919455,12647));
        provincias.add(new Provincia(HUELVA, COMANDALUCIA, 7, new boolean[]{CULTURA, SOLYPLAYA, GASTRONOMIA, DISCO, DEPORTES},51.75,519229,10128));
        provincias.add(new Provincia(JAEN, COMANDALUCIA, 1, new boolean[]{false, false, GASTRONOMIA, false, DEPORTES},33.24,659033,13496));
        provincias.add(new Provincia(MALAGA, COMANDALUCIA, 7, new boolean[]{false, SOLYPLAYA, GASTRONOMIA, false, false},37.75,1621968,7308));
        provincias.add(new Provincia(SEVILLA, COMANDALUCIA, 3, new boolean[]{CULTURA, false, GASTRONOMIA, false, false},31.73,1941355,14036));
        provincias.add(new Provincia(BARCELONA, COMCATALUNA, 3, new boolean[]{CULTURA, SOLYPLAYA, false, false, false},42.42,5523784,7728));
        provincias.add(new Provincia(GIRONA, COMCATALUNA,2, new boolean[]{false, SOLYPLAYA, GASTRONOMIA, false, DEPORTES},47.78,756156,5909));
        provincias.add(new Provincia(LLEIDA, COMCATALUNA, 1, new boolean[]{false, false, false, DISCO, DEPORTES},43.47,438001,12150));
        provincias.add(new Provincia(TARRAGONA, COMCATALUNA, 7, new boolean[]{false, SOLYPLAYA, false, false, DEPORTES},50.35,800962,6303));
        provincias.add(new Provincia(ALICANTE, COMVALENCIANA, 3, new boolean[]{false, SOLYPLAYA, false, DISCO, DEPORTES},48.33,1868438,5817));
        provincias.add(new Provincia(CASTELLON, COMVALENCIANA, 2, new boolean[]{false, SOLYPLAYA, false, false, DEPORTES},66.15,587508,6632));
        provincias.add(new Provincia(VALENCIA, COMVALENCIANA, 3, new boolean[]{false, SOLYPLAYA, false, DISCO, false},62.98,2548898,10808));
        provincias.add(new Provincia(ACORUNA, COMGALICIA, 2, new boolean[]{CULTURA, SOLYPLAYA, false, false, DEPORTES},39.46,1132735,7950));
        provincias.add(new Provincia(LUGO, COMGALICIA, 1, new boolean[]{false, SOLYPLAYA, GASTRONOMIA, DISCO, DEPORTES},23.94,342748,9857));
        provincias.add(new Provincia(OURENSE, COMGALICIA, 2, new boolean[]{false, false, GASTRONOMIA, DISCO, false},19.47,322293,7273));
        provincias.add(new Provincia(PONTEVEDRA, COMGALICIA,3, new boolean[]{false, SOLYPLAYA, false, DISCO, DEPORTES},57.44,950919,4495));
        provincias.add(new Provincia(ALAVA, COMPAISVASCO,1, new boolean[]{false, false, GASTRONOMIA, false, DEPORTES},47.31,321932,3037));
        provincias.add(new Provincia(GIPUZKOA, COMPAISVASCO,2, new boolean[]{false, SOLYPLAYA, false, DISCO, DEPORTES},43.39,715148,1980));
        provincias.add(new Provincia(BIZKAIA, COMPAISVASCO,2, new boolean[]{CULTURA, SOLYPLAYA, false, false, false},39.45,1151905,2216));

        return provincias;
    }


    public static String getNombre(int codigo) {

        switch (codigo) {
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
