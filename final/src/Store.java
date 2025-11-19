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

        Food gc = new Food("Glitter Cupcake", 21);
        Food rc = new Food("Rainbow Cake", 41);
        Food fp = new Food("Funfetti Pancakes", 67);
        Food jp = new Food("Jell-O Pudding", 420);
        Food sd = new Food("Sparkly Donuts", 12);
      
        addStore.initModality(Modality.APPLICATION_MODAL);
        addStore.setTitle(title);
        addStore.setMinWidth(250); 

        // Add images of all of the food and the rainbow icons
        Label welcomeUser = new Label("Welcome User");

        // Food #1 (GC = Glitter Cupcake)
        Label glitterCupcake = new Label(gc.getName());
        Label glitterCupcakeCost = new Label("21 Rainbows");
        Button buyGCBtn = new Button();
        buyGCBtn.setText("Buy");
        buyGCBtn.setOnAction(e -> {
            gc.increaseQuantity();
            App.setBalance(App.getBalance() - gc.getCost());
        });

        // Food #2 (RC = Rainbow Cake)
        Label rainbowCake = new Label(rc.getName());
        Label rainbowCakeCost = new Label("41 Rainbows");
        Button buyRCBtn = new Button();
        buyRCBtn.setText("Buy");
        buyRCBtn.setOnAction(e -> {
            rc.increaseQuantity();
            App.setBalance(App.getBalance() - rc.getCost());
        });

        // Food #3 (FP = Funfetti Pancakes)
        Label funfettiPancakes = new Label(fp.getName());
        Label funfettiPancakesCost = new Label("67 Rainbows");
        Button buyFPBtn = new Button();
        buyFPBtn.setText("Buy");
        buyFPBtn.setOnAction(e -> {
            fp.increaseQuantity();
            App.setBalance(App.getBalance() - fp.getCost());
        });

        // Food #4 (JP = Jell-o Pudding)
        Label jelloPudding = new Label(jp.getName());
        Label jelloPuddingCost = new Label("420 Rainbows");
        Button buyJPBtn = new Button();
        buyJPBtn.setText("Buy");
        buyJPBtn.setOnAction(e -> {
            jp.increaseQuantity();
            App.setBalance(App.getBalance() - jp.getCost());
        });

        // Food #5 (SD = Sparkly Donuts)
        Label sparklyDonuts = new Label(sd.getName());
        Label sparklyDonutsCost = new Label("12 Rainbows");
        Button buySDBtn = new Button();
        buySDBtn.setText("Buy");
        buySDBtn.setOnAction(e -> {
            sd.increaseQuantity();
            App.setBalance(App.getBalance() - sd.getCost());
        });
        
        VBox vBoxStoreLeft = new VBox(11,glitterCupcake, rainbowCake, funfettiPancakes, jelloPudding, sparklyDonuts);
        VBox vBoxStoreMiddle = new VBox(11,glitterCupcakeCost, rainbowCakeCost, funfettiPancakesCost, jelloPuddingCost, sparklyDonutsCost);
        VBox vBoxStoreRight = new VBox(buyGCBtn, buyRCBtn, buyFPBtn, buyJPBtn, buySDBtn);

        HBox hBoxStore = new HBox(20,vBoxStoreLeft, vBoxStoreMiddle, vBoxStoreRight);
        
        // Scene/Stage
        Scene addStore1 = new Scene(hBoxStore, 400, 400);
        addStore.setScene(addStore1);
        addStore.showAndWait();
    }
}