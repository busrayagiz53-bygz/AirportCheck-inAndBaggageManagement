package com.example.airportcheckinandbaggagemanagement;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AirportGUI extends Application {

    PassengerBST bst = new PassengerBST();
    BaggageStack stack = new BaggageStack();

    @Override
    public void start(Stage stage) {

        Label ticketLabel = new Label("Ticket Number:");
        TextField ticketField = new TextField();

        Label nameLabel = new Label("Passenger Name:");
        TextField nameField = new TextField();

        Label weightLabel = new Label("Baggage Weight (kg):");
        TextField weightField = new TextField();

        Button addBtn = new Button("Check-in Passenger");
        Button loadBtn = new Button("Load Baggage");
        Button unloadBtn = new Button("Unload Last Baggage");
        Button searchBtn = new Button("Search Passenger");
        Button showAllBtn = new Button("Show All Passengers");
        Button showStackBtn = new Button("Show Baggage Stack");

        TextArea output = new TextArea();
        output.setEditable(false);

        // CHECK-IN
        addBtn.setOnAction(e -> {
            try {
                int ticket = Integer.parseInt(ticketField.getText());
                String name = nameField.getText();
                double weight = Double.parseDouble(weightField.getText());

                Passenger p = new Passenger(ticket, name, weight);
                bst.root = bst.insert(bst.root, p);

                output.setText("✅ Passenger checked-in:\n" + p);

            } catch (Exception ex) {
                output.setText("❌ Invalid input!");
            }
        });

        // LOAD BAGGAGE (STACK PUSH)
        loadBtn.setOnAction(e -> {
            try {
                int ticket = Integer.parseInt(ticketField.getText());
                Passenger p = bst.search(bst.root, ticket);

                if (p != null) {
                    stack.addBaggage(p);
                    output.setText("🧳 Baggage loaded:\n" + p);
                } else {
                    output.setText("⚠️ Passenger not found!");
                }

            } catch (Exception ex) {
                output.setText("❌ Enter valid ticket number!");
            }
        });

        // UNLOAD BAGGAGE (STACK POP)
        unloadBtn.setOnAction(e -> {
            Passenger p = stack.removeBaggage();

            if (p != null)
                output.setText("⏏️ Unloaded baggage:\n" + p);
            else
                output.setText("📭 No baggage to unload.");
        });

        // SEARCH
        searchBtn.setOnAction(e -> {
            try {
                int ticket = Integer.parseInt(ticketField.getText());
                Passenger p = bst.search(bst.root, ticket);

                if (p != null)
                    output.setText("🔍 Found:\n" + p);
                else
                    output.setText("⚠️ Passenger not found.");

            } catch (Exception ex) {
                output.setText("❌ Invalid ticket.");
            }
        });

        // SHOW ALL
        showAllBtn.setOnAction(e -> {
            String data = bst.getAllPassengers(bst.root);

            if (data.isEmpty())
                output.setText("📭 No passengers.");
            else
                output.setText("📋 Passenger List:\n" + data);
        });

        // SHOW STACK
        showStackBtn.setOnAction(e -> {
            output.setText(stack.showBaggage());
        });

        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER_LEFT);

        root.getChildren().addAll(
                ticketLabel, ticketField,
                nameLabel, nameField,
                weightLabel, weightField,
                addBtn, loadBtn, unloadBtn,
                searchBtn, showAllBtn, showStackBtn,
                new Label("Output:"), output
        );

        Scene scene = new Scene(root, 400, 600);
        stage.setTitle("Airport Check-in & Baggage System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
