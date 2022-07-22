module fr.equipecinq.TicketFXMaven {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;
	requires java.sql;

    opens fr.equipecinq.TicketFXMaven to javafx.fxml;
    exports fr.equipecinq.TicketFXMaven;
}
