package com.example.snakemvc_ihm.modele;

import com.example.snakemvc_ihm.Constantes;

import java.util.ArrayList;
import java.util.Random;

public class Serpent {
    private ArrayList<Position> snake;
    private ArrayList<Position> murs;
    private int[][] grille;
    private Position tete;
    private String direction;
    public Serpent(){
        initGrille();
        setSnake();
        addMurs(Constantes.NOMBRE_MURS);
    }

    public void setSnake(){
        snake = new ArrayList<>(Constantes.TAILLE_SNAKE);
        for (int i = 0; i < Constantes.TAILLE_SNAKE; i++) {
            snake.add(new Position(i,0));
            grille[snake.get(i).getY()][snake.get(i).getX()] = 1;
        }
        tete = snake.get(0);
    }

    public void initGrille(){
        int s,m;
        grille = new int[Constantes.NOMBRE_LIGNES][Constantes.NOMBRE_COLONNES];
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                grille[i][j] = 0;
            }
        }
    }

    public void addMurs(int taille){
        murs = new ArrayList<>(taille);
        Random random = new Random();
        boolean arret = false;
        Position posMurs = new Position(random.nextInt(Constantes.NOMBRE_COLONNES), random.nextInt(Constantes.NOMBRE_LIGNES));
        for (int i = 0; i < taille; i++) {
            while (grille[posMurs.getY()][posMurs.getX()] == 1 || grille[posMurs.getY()][posMurs.getX()] == 2 ){
                posMurs = new Position(random.nextInt(Constantes.NOMBRE_COLONNES), random.nextInt(Constantes.NOMBRE_LIGNES));
            }
            murs.add(posMurs);
            grille[posMurs.getY()][posMurs.getX()] = 2;
        }
    }

    public Position getTete() {
        return tete;
    }

    public int[][] getGrille() {
        return grille;
    }

    public void setApple(){

    }
    public void deplacement(String direction) {
        if (future_position(direction)) {
            grille[snake.get(snake.size()-1).getY()][snake.get(snake.size()-1).getX()] = 0;
            for (int i = Constantes.TAILLE_SNAKE - 1; i > 0; i--) {
                snake.set(i, new Position(snake.get(i - 1).getX(), snake.get(i - 1).getY()));
            }
            switch (direction) {
                case "HAUT":
                    tete.setY(tete.getY() - 1);
                    break;
                case "BAS":
                    tete.setY(tete.getY() + 1);
                    break;
                case "GAUCHE":
                    tete.setX(tete.getX() - 1);
                    break;
                case "DROITE":
                    tete.setX(tete.getX() + 1);
                    break;
            }
            grille[tete.getY()][tete.getX()] = 1;
        }
    }

    public boolean future_position(String direction){
        switch (direction){
            case "HAUT":
                if (tete.getY() - 1 < 0 || tete.getY() - 1 > Constantes.NOMBRE_LIGNES){
                    return false;
                }
                break;
            case "BAS":
                if (tete.getY() + 1 < 0 || tete.getY() + 1 > Constantes.NOMBRE_LIGNES){
                    return false;
                }
                break;
            case "GAUCHE":
                if (tete.getX() - 1 < 0 || tete.getX() - 1 > Constantes.NOMBRE_COLONNES){
                    return false;
                }
                break;
            case "DROITE":
                if (tete.getX() + 1 < 0 || tete.getX() + 1 > Constantes.NOMBRE_COLONNES){
                    return false;
                }
                break;
            default:
                return true;
        }
        return true;
    }

    public String toString(){
        String res = "";
        boolean snake;
        Position pos;
        for (int i = 0; i < Constantes.NOMBRE_LIGNES; i++) {
            for (int j = 0; j < Constantes.NOMBRE_COLONNES; j++) {
                pos = new Position(j,i);
                snake = false;
                for (int k = 0; k < this.snake.size(); k++) {
                    if (pos.getX() == this.snake.get(k).getX() && pos.getY() == this.snake.get(k).getY()){
                        snake = true;
                        break;
                    }
                }
                if (snake){
                    res+= "□";
                } else {
                    res+= ".";
                }
            }
            res+= "\n";
        }
        return res;
    }

    public ArrayList<Position> getSnake() {
        return snake;
    }

    public ArrayList<Position> getMurs() {
        return murs;
    }
}
