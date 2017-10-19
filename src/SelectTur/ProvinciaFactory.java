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

    public static final boolean CULTURA = true;
    public static final boolean SOLYPLAYA = true;
    public static final boolean GASTRONOMIA = true;


    public static Vector<Provincia> crearProvincias() {
        Vector<Provincia> provincias = new Vector<Provincia>();
        provincias.add(new Provincia(MADRID, COMMADRID,4, new boolean[]{CULTURA, false, GASTRONOMIA},40.55));
        provincias.add(new Provincia(ALMERIA, COMANDALUCIA, 4, new boolean[]{false, SOLYPLAYA, false},27.01));
        provincias.add(new Provincia(CADIZ, COMANDALUCIA, 3, new boolean[]{false, SOLYPLAYA, false},30.04));
        provincias.add(new Provincia(CORDOBA, COMANDALUCIA, 2, new boolean[]{CULTURA, false, GASTRONOMIA},46.48));
        provincias.add(new Provincia(GRANADA, COMANDALUCIA, 3, new boolean[]{CULTURA, SOLYPLAYA, GASTRONOMIA},28.68));
        provincias.add(new Provincia(HUELVA, COMANDALUCIA, 5, new boolean[]{CULTURA, SOLYPLAYA, GASTRONOMIA},51.75));
        provincias.add(new Provincia(JAEN, COMANDALUCIA, 2, new boolean[]{false, false, GASTRONOMIA},33.24));
        provincias.add(new Provincia(MALAGA, COMANDALUCIA, 5, new boolean[]{false, SOLYPLAYA, GASTRONOMIA},37.75));
        provincias.add(new Provincia(SEVILLA, COMANDALUCIA, 3, new boolean[]{CULTURA, false, GASTRONOMIA},31.73));
        provincias.add(new Provincia(BARCELONA, COMCATALUNA, 4, new boolean[]{CULTURA, SOLYPLAYA, false},42.42));
        provincias.add(new Provincia(GIRONA, COMCATALUNA,6, new boolean[]{false, SOLYPLAYA, GASTRONOMIA},47.78));
        provincias.add(new Provincia(LLEIDA, COMCATALUNA, 7, new boolean[]{false, false, GASTRONOMIA},43.47));
        provincias.add(new Provincia(TARRAGONA, COMCATALUNA, 6, new boolean[]{false, SOLYPLAYA, false},50.35));
        provincias.add(new Provincia(ALICANTE, COMVALENCIANA, 5, new boolean[]{false, SOLYPLAYA, false},48.33));
        provincias.add(new Provincia(CASTELLON, COMVALENCIANA, 5, new boolean[]{false, SOLYPLAYA, false},66.15));
        provincias.add(new Provincia(VALENCIA, COMVALENCIANA, 4, new boolean[]{false, SOLYPLAYA, false},62.98));
        provincias.add(new Provincia(ACORUNA, COMGALICIA, 7, new boolean[]{CULTURA, SOLYPLAYA, false},39.46));
        provincias.add(new Provincia(LUGO, COMGALICIA, 2, new boolean[]{false, SOLYPLAYA, GASTRONOMIA},23.94));
        provincias.add(new Provincia(OURENSE, COMGALICIA, 4, new boolean[]{false, false, GASTRONOMIA},19.47));
        provincias.add(new Provincia(PONTEVEDRA, COMGALICIA,4, new boolean[]{false, SOLYPLAYA, false},57.44));
        provincias.add(new Provincia(ALAVA, COMPAISVASCO,2, new boolean[]{false, false, GASTRONOMIA, false},47.31));
        provincias.add(new Provincia(GIPUZKOA, COMPAISVASCO,3, new boolean[]{false, SOLYPLAYA, false},43.39));
        provincias.add(new Provincia(BIZKAIA, COMPAISVASCO,3, new boolean[]{CULTURA, SOLYPLAYA, false},39.45));

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
