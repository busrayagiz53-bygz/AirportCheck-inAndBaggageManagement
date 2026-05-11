module com.example.airportcheckinandbaggagemanagement {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.airportcheckinandbaggagemanagement to javafx.fxml;
    exports com.example.airportcheckinandbaggagemanagement;
}