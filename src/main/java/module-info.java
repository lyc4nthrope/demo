module co.edu.uniquindio.demo.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.desktop;

    opens co.edu.uniquindio.demo.demo to javafx.fxml;
    exports co.edu.uniquindio.demo.demo;
}