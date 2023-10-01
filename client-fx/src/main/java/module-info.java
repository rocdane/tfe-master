module startup.loga.client {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.google.gson;
    requires unirest.java;
    requires lombok;

    opens startup.loga.client.controller to javafx.fxml;
    opens startup.loga.client.model to com.google.gson;
    opens startup.loga.client.app.factory to com.google.gson;

    exports startup.loga.client;
}