package com.example.snakemvc_ihm.Controleur;

import com.example.snakemvc_ihm.Constantes;
import com.example.snakemvc_ihm.modele.Serpent;
import com.example.snakemvc_ihm.vue.VueGraphique;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class ControleurClavier implements EventHandler<KeyEvent> {
    private Serpent modele;
    private VueGraphique vueGraphique;

    public ControleurClavier(Serpent modele, VueGraphique vueGraphique) {
        this.modele = modele;
        this.vueGraphique = vueGraphique;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        switch (keyEvent.getCode()){
            case Z:
                modele.deplacement(String.valueOf(Constantes.Direction.HAUT));
                vueGraphique.update();
                System.out.println(String.valueOf(Constantes.Direction.HAUT));
                break;
            case S:
                modele.deplacement(String.valueOf(Constantes.Direction.BAS));
                vueGraphique.update();
                break;
            case D:
                modele.deplacement(String.valueOf(Constantes.Direction.DROITE));
                vueGraphique.update();
                break;
            case Q:
                modele.deplacement(String.valueOf(Constantes.Direction.GAUCHE));
                vueGraphique.update();
                break;
        }
    }
}
