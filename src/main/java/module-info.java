module ec.edu.espol.proyecto {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens ec.edu.espol.proyecto to javafx.fxml;
    exports ec.edu.espol.proyecto;
}
