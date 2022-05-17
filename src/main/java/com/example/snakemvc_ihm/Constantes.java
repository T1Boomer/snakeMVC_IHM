package com.example.snakemvc_ihm;

public class Constantes {
    public static int TAILLE_SNAKE = 5;
    public final static int NOMBRE_COLONNES = 20;
    public final static int NOMBRE_LIGNES = 25;
    public final static int TAILLE_CASE = 20;
    public final static int NOMBRE_MURS = 30;
    public final static int WIDTH_GRID = NOMBRE_COLONNES*TAILLE_CASE;
    public final static int HEIGHT_GRID = NOMBRE_LIGNES*TAILLE_CASE;
    public enum Direction {
        HAUT, BAS, GAUCHE, DROITE
    }

}
