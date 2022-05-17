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
        this.rectangles = new Rectangle[Constantes.NOMBRE_LIGNES][Constantes.NOMBRE_COLONNES];
        initGrille();
    }

    public void initGrille(){
        Rectangle rect;
        for (int i = 0; i < Constantes.NOMBRE_LIGNES; i++) {
            for (int j = 0; j < Constantes.NOMBRE_COLONNES; j++) {
                rect = new Rectangle(j*Constantes.TAILLE_CASE,i*Constantes.TAILLE_CASE,Constantes.TAILLE_CASE,Constantes.TAILLE_CASE);
                if (modele.getGrille()[i][j] == 0){
                    rect.setFill(Color.GREEN);
                    rect.setStroke(Color.BLACK);
                }
                if (modele.getGrille()[i][j] == 1){
                    if (modele.getTete().getX() == j && modele.getTete().getY() == i){
                        rect.setFill(Color.RED);
                        rect.setStroke(Color.DARKRED);
                    } else{
                        rect.setFill(Color.ORANGE);
                        rect.setStroke(Color.DARKORANGE);
                    }
                }
                if (modele.getGrille()[i][j] == 2){
                    rect.setFill(Color.BLACK);
                    rect.setStroke(Color.BLACK);
                }
                super.add(rect,j,i);
                rectangles[i][j] = rect;
            }
        }
    }

    public void update(){
        rectangles[modele.getSnake().get(0).getY()][modele.getSnake().get(0).getX()].setFill(Color.RED);
        rectangles[modele.getSnake().get(0).getY()][modele.getSnake().get(0).getX()].setStroke(Color.DARKRED);
        for (int i = 1; i < modele.getSnake().size(); i++) {
            rectangles[modele.getSnake().get(0).getY()][modele.getSnake().get(0).getX()].setFill(Color.ORANGE);
            rectangles[modele.getSnake().get(0).getY()][modele.getSnake().get(0).getX()].setStroke(Color.DARKORANGE);
        }
    }
}
