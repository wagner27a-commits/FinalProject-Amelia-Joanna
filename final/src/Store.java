import java.time.LocalDate;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Store{
    
    public static void display(String title, String message) {
        Stage addStore = new Stage();
      
        addStore.initModality(Modality.APPLICATION_MODAL);
        addStore.setTitle(title);
        addStore.setMinWidth(250); 

        // Add images of all of the food and the rainbow icons
        Label welcomeUser = new Label("Welcome User");

        // Food #1 (GC = Glitter Cupcake)
        Label glitterCupcake = new Label("Glitter Cupcake");
        Label glitterCupcakeCost = new Label("21 Rainbows");
        Button buyGCBtn = new Button();
        buyGCBtn.setText("Buy");

        // Food #2 (RC = Rainbow Cake)
        Label rainbowCake = new Label("Rainbow Cake");
        Label rainbowCakeCost = new Label("41 Rainbows");
        Button buyRCBtn = new Button();
        buyRCBtn.setText("Buy");

        // Food #3 (FP = Funfetti Pancakes)
        Label funfettiPancakes = new Label("Funfetti Pancakes");
        Label funfettiPancakesCost = new Label("67 Rainbows");
        Button buyFPBtn = new Button();
        buyFPBtn.setText("Buy");

        // Food #4 (JP = Jell-o Pudding)
        Label jelloPudding = new Label("Jell-O Pudding");
        Label jelloPuddingCost = new Label("420 Rainbows");
        Button buyJPBtn = new Button();
        buyJPBtn.setText("Buy");

        // Food #5 (SD = Sparkly Donuts)
        Label sparklyDonuts = new Label("Sparkly Donuts");
        Label sparklyDonutsCost = new Label("12 Rainbows");
        Button buySDBtn = new Button();
        buySDBtn.setText("Buy");
        
        VBox vBoxStoreLeft = new VBox(glitterCupcake, rainbowCake, funfettiPancakes, jelloPudding, sparklyDonuts);
        VBox vBoxStoreMiddle = new VBox(glitterCupcakeCost, rainbowCakeCost, funfettiPancakesCost, jelloPuddingCost, sparklyDonutsCost);
        VBox vBoxStoreRight = new VBox(buyGCBtn, buyRCBtn, buyFPBtn, buyJPBtn, buySDBtn);

        HBox hBoxStore = new HBox(vBoxStoreLeft, vBoxStoreMiddle, vBoxStoreRight);
        
        // Scene/Stage
        Scene addStore1 = new Scene(hBoxStore, 400, 400);
        addStore.setScene(addStore1);
        addStore.showAndWait();
    }
}