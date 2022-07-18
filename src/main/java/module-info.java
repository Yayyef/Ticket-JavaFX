module fr.equipecinq.TicketFXMaven {
    requires javafx.controls;
    requires javafx.fxml;

    opens fr.equipecinq.TicketFXMaven to javafx.fxml;
    exports fr.equipecinq.TicketFXMaven;
}
