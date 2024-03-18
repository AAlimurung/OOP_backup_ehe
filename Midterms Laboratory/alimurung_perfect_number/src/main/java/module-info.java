module com.example.alimurung_perfect_number {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.alimurung_perfect_number to javafx.fxml;
    exports com.example.alimurung_perfect_number;
}