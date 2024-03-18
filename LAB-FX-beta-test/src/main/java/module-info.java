module com.example.labfxbetatest {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.labfxbetatest to javafx.fxml;
    exports com.example.labfxbetatest;
}