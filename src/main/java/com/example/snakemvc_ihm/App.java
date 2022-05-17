package com.example.snakemvc_ihm;

import com.example.snakemvc_ihm.modele.Serpent;
import com.example.snakemvc_ihm.vue.VueGraphique;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Serpent serpent = new Serpent();
        VueGraphique root = new VueGraphique(serpent);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
