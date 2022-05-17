module com.example.snakemvc_ihm {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.snakemvc_ihm to javafx.fxml;
    exports com.example.snakemvc_ihm;
    exports com.example.snakemvc_ihm.modele;
    opens com.example.snakemvc_ihm.modele to javafx.fxml;
}