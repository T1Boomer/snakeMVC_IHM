package com.example.snakemvc_ihm.modele;

import com.example.snakemvc_ihm.Constantes;
import javafx.geometry.Pos;

public class Position {
    private int x;
    private  int y;
    private final int limiteX = Constantes.NOMBRE_COLONNES;
    private final int limiteY = Constantes.NOMBRE_LIGNES;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }
    public Position(){
        this.x = 0;
        this.y = 0;
    }
}