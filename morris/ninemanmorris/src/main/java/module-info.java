module com.example.ninemanmorris {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires com.almasb.fxgl.all;

    opens com.example.ninemanmorris to javafx.fxml;
    exports com.example.ninemanmorris;
}