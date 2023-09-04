module ec.edu.espol.proyecto {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens ec.edu.espol.proyecto to javafx.fxml;
    opens ec.edu.espol.clases to javafx.base;
    exports ec.edu.espol.proyecto;
}
