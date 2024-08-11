module com.mycompany.ed_p1_grupo12_parcial2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.ed_p1_grupo12_parcial2 to javafx.fxml;
    exports com.mycompany.ed_p1_grupo12_parcial2;
}
