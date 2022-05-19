package com.example.snakemvc_ihm.vue;

import com.example.snakemvc_ihm.Constantes;
import com.example.snakemvc_ihm.modele.Serpent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VueGraphique extends GridPane {
    private Serpent modele;
    private Rectangle[][] rectangles;

    public VueGraphique(Serpent modele) {
        super();
        this.modele = modele;
        initGrille();
        update();
        modele.afficherGrille();

    }

    public void removeGrille(){
        for (int i = 0; i < modele.getGrille().length; i++) {
            for (int j = 0; j < modele.getGrille()[i].length; j++) {
                rectangles[i][j].setFill(Color.WHITE);
            }
        }
    }

    public void initGrille(){
        Rectangle rect;
        this.rectangles = new Rectangle[Constantes.NOMBRE_LIGNES][Constantes.NOMBRE_COLONNES];
        for (int i = 0; i < Constantes.NOMBRE_LIGNES; i++) {
            for (int j = 0; j < Constantes.NOMBRE_COLONNES; j++) {
                rect = new Rectangle(j*Constantes.TAILLE_CASE,i*Constantes.TAILLE_CASE,Constantes.TAILLE_CASE,Constantes.TAILLE_CASE);
                super.add(rect,j,i);
                rectangles[i][j] = rect;
            }
        }
    }

    public void update(){
        for (int i = 0; i < modele.getGrille().length; i++) {
            for (int j = 0; j < modele.getGrille()[i].length; j++) {
                if (modele.getGrille()[i][j] == 0){
                    if ((i+j) % 2 == 0){
                        rectangles[i][j].setFill(Color.DARKGREEN);
                        rectangles[i][j].setStroke(Color.BLACK);
                    } else {
                        rectangles[i][j].setFill(Color.FORESTGREEN);
                        rectangles[i][j].setStroke(Color.BLACK);
                    }
                }
                if (modele.getGrille()[i][j] == 1){
                    if (modele.getTete().getX() == j && modele.getTete().getY() == i){
                        rectangles[i][j].setFill(Color.ORANGERED);
                        rectangles[i][j].setStroke(Color.DARKRED);
                    } else{
                        rectangles[i][j].setFill(Color.ORANGE);
                        rectangles[i][j].setStroke(Color.DARKORANGE);
                    }
                }
                if (modele.getGrille()[i][j] == 2){
                    rectangles[i][j].setFill(Color.BLACK);
                    rectangles[i][j].setStroke(Color.BLACK);
                }
                if (modele.getGrille()[i][j] == 3){
                    rectangles[i][j].setFill(Color.RED);
                    rectangles[i][j].setStroke(Color.RED);
                }
                if (modele.getGrille()[i][j] == 4){
                    rectangles[i][j].setFill(Color.GREY);
                    rectangles[i][j].setStroke(Color.BLACK);
                }
            }
        }
    }
}
