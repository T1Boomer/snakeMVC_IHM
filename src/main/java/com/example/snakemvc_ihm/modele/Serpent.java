package com.example.snakemvc_ihm.modele;

import com.example.snakemvc_ihm.Constantes;

import java.util.ArrayList;
import java.util.Random;

public class Serpent {
    private ArrayList<Position> snake;
    private ArrayList<Position> murs;
    private Position apple;
    private int[][] grille;
    private Position tete;
    private boolean estFini;
    private String direction;
    public Serpent(){
        this.direction = "DOWN";
        estFini = false;
        this.murs = new ArrayList<>();
        initGrille();
        setSnake();
        addMurs(10);
        setApple();
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
        Random random = new Random();
        boolean arret = false;
        Position posMurs = new Position(random.nextInt(Constantes.NOMBRE_COLONNES), random.nextInt(Constantes.NOMBRE_LIGNES));
        for (int i = 0; i < taille; i++) {
            while (grille[posMurs.getY()][posMurs.getX()] == 1 || grille[posMurs.getY()][posMurs.getX()] == 2 || grille[posMurs.getY()][posMurs.getX()] == 3 ){
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
        Position posApple = new Position(new Random().nextInt(Constantes.NOMBRE_COLONNES),new Random().nextInt(Constantes.NOMBRE_LIGNES));
        while (grille[posApple.getY()][posApple.getX()] == 1 || grille[posApple.getY()][posApple.getX()] == 2){
            posApple = new Position(new Random().nextInt(Constantes.NOMBRE_COLONNES),new Random().nextInt(Constantes.NOMBRE_LIGNES));
        }
        grille[posApple.getY()][posApple.getX()] = 3;
        apple = posApple;
    }
    public void deplacement(String direction) {
        if (future_position(direction) && !estFini) {
            if (this.direction != "DEMI-T") {
                Position posLastSnake = new Position(snake.get(snake.size() - 1).getX(), snake.get(snake.size() - 1).getY());
                grille[snake.get(snake.size() - 1).getY()][snake.get(snake.size() - 1).getX()] = 0;
                for (int i = Constantes.TAILLE_SNAKE - 1; i > 0; i--) {
                    snake.set(i, new Position(snake.get(i - 1).getX(), snake.get(i - 1).getY()));
                }
                switch (direction) {
                    case "UP":
                        tete.setY(tete.getY() - 1);
                        break;
                    case "DOWN":
                        tete.setY(tete.getY() + 1);
                        break;
                    case "LEFT":
                        tete.setX(tete.getX() - 1);

                        break;
                    case "RIGHT":
                        tete.setX(tete.getX() + 1);
                        break;
                }
                grille[tete.getY()][tete.getX()] = 1;
                if (new Random().nextInt(20) == 1) {
                    addMurs(1);
                }
                isApple(posLastSnake);
                this.direction = direction;
            } else {
                switch (direction){
                    case "UP":
                        this.direction = "DOWN";
                        break;
                    case "DOWN":
                        this.direction = "UP";
                        break;
                    case "LEFT":
                        this.direction = "RIGHT";
                        break;
                    case "RIGHT":
                        this.direction = "LEFT";
                        break;
                }
            }
        } else {
            if (!estFini){
                for (int i = 0; i < snake.size(); i++) {
                    grille[snake.get(i).getY()][snake.get(i).getX()] = 4;
                }
                estFini = true;
            }
        }
    }

    public void isApple(Position posNewPart){
        for (int i = 0; i < snake.size(); i++) {
            if (snake.get(i).getX() == apple.getX() && snake.get(i).getY() == apple.getY()){
                setApple();
                snake.add(posNewPart);
                Constantes.TAILLE_SNAKE++;
                break;
            }
        }
    }
    public boolean future_position(String direction){
        switch (direction){
            case "UP":
                if (this.direction == "DOWN"){
                    this.direction = "DEMI-T";
                    break;
                }
                if (tete.getY() - 1 < 0 || tete.getY() - 1 > Constantes.NOMBRE_LIGNES || grille[tete.getY() - 1][tete.getX()] == 2 || grille[tete.getY() - 1][tete.getX()] == 1){
                    return false;
                }
                break;
            case "DOWN":
                if (this.direction == "UP"){
                    this.direction = "DEMI-T";
                    break;
                }
                if (tete.getY() + 1 < 0 || tete.getY() + 1 >= Constantes.NOMBRE_LIGNES || grille[tete.getY() + 1][tete.getX()] == 2 || grille[tete.getY() + 1][tete.getX()] == 1){
                    return false;
                }
                break;
            case "LEFT":
                if (this.direction == "RIGHT"){
                    this.direction = "DEMI-T";
                    break;
                }
                if (tete.getX() - 1 < 0 || tete.getX() - 1 > Constantes.NOMBRE_COLONNES || grille[tete.getY()][tete.getX() - 1] == 2 || grille[tete.getY()][tete.getX() - 1] == 1){
                    return false;
                }
                break;
            case "RIGHT":
                if (this.direction == "LEFT"){
                    this.direction = "DEMI-T";
                    break;
                }
                if (tete.getX() + 1 < 0 || tete.getX() + 1 >= Constantes.NOMBRE_COLONNES || grille[tete.getY()][tete.getX() + 1] == 2 || grille[tete.getY()][tete.getX() + 1] == 1){
                    return false;
                }
                break;
            default:
                return false;
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

    public void afficherGrille(){
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                System.out.print(grille[i][j] + " ");
            }
            System.out.println();
        }
    }

    public ArrayList<Position> getSnake() {
        return snake;
    }

    public ArrayList<Position> getMurs() {
        return murs;
    }
}
