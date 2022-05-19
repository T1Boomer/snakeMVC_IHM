package com.example.snakemvc_ihm.Controleur;

import com.example.snakemvc_ihm.Constantes;
import com.example.snakemvc_ihm.modele.Serpent;
import com.example.snakemvc_ihm.vue.VueGraphique;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

import java.util.Random;

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
                modele.deplacement(String.valueOf(Constantes.Direction.UP));
                vueGraphique.update();
                break;
            case S:
                modele.deplacement(String.valueOf(Constantes.Direction.DOWN));
                vueGraphique.update();
                break;
            case D:
                modele.deplacement(String.valueOf(Constantes.Direction.RIGHT));
                vueGraphique.update();
                break;
            case Q:
                modele.deplacement(String.valueOf(Constantes.Direction.LEFT));
                vueGraphique.update();
                break;
            case R:
                vueGraphique.newVueGraphique();
                break;
            case ESCAPE:
                Platform.exit();

        }
    }
}
