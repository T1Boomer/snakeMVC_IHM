package com.example.snakemvc_ihm.modele;

import com.example.snakemvc_ihm.Constantes;

import java.util.Scanner;

public class Jeu {
    private boolean position_;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Serpent serpent = new Serpent();
        System.out.println(serpent);
        while (true){
            String s = sc.nextLine();
            serpent.deplacement(s, Constantes.TAILLE_SNAKE);
            System.out.println(serpent);
            for (int i = 0; i < Constantes.TAILLE_SNAKE; i++) {
                System.out.println(serpent.getSnake().get(i).getX() + "" + serpent.getSnake().get(i).getY());
            }
        }
    }
}
