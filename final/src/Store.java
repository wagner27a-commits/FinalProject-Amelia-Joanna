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

        Food gc = new Food("Glitter Cupcake", 21, 10);
        Food rc = new Food("Rainbow Cake", 41, 15);
        Food fp = new Food("Funfetti Pancakes", 67, 30);
        Food jp = new Food("Jell-O Pudding", 420,50);
        Food sd = new Food("Sparkly Donuts", 12, 5);

        App.getFoods().add(gc);
        App.getFoods().add(rc);
        App.getFoods().add(fp);
        App.getFoods().add(jp);
        App.getFoods().add(sd);
      
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
            if (App.getBalance()>=gc.getCost()){
                gc.increaseQuantity();
                App.setBalance(App.getBalance() - gc.getCost());
            }
            else{
                NotEnoughRainbows.display("Not Enough Rainbows", "sorry!");
            }
        });

        // Food #2 (RC = Rainbow Cake)
        Label rainbowCake = new Label(rc.getName());
        Label rainbowCakeCost = new Label("41 Rainbows");
        Button buyRCBtn = new Button();
        buyRCBtn.setText("Buy");
        buyRCBtn.setOnAction(e -> {
            if (App.getBalance()>=rc.getCost()){
                rc.increaseQuantity();
                App.setBalance(App.getBalance() - rc.getCost());
            }
            else{
                NotEnoughRainbows.display("Not Enough Rainbows", "sorry!");
            }
        });

        // Food #3 (FP = Funfetti Pancakes)
        Label funfettiPancakes = new Label(fp.getName());
        Label funfettiPancakesCost = new Label("67 Rainbows");
        Button buyFPBtn = new Button();
        buyFPBtn.setText("Buy");
        buyFPBtn.setOnAction(e -> {
            if (App.getBalance()>=fp.getCost()){
                fp.increaseQuantity();
                App.setBalance(App.getBalance() - fp.getCost());
            }
            else{
                NotEnoughRainbows.display("Not Enough Rainbows", "sorry!");
            }
        });

        // Food #4 (JP = Jell-o Pudding)
        Label jelloPudding = new Label(jp.getName());
        Label jelloPuddingCost = new Label("420 Rainbows");
        Button buyJPBtn = new Button();
        buyJPBtn.setText("Buy");
        buyJPBtn.setOnAction(e -> {
            if (App.getBalance()>=jp.getCost()){
                jp.increaseQuantity();
                App.setBalance(App.getBalance() - jp.getCost());
            }
            else{
                NotEnoughRainbows.display("Not Enough Rainbows", "sorry!");
            }
        });

        // Food #5 (SD = Sparkly Donuts)
        Label sparklyDonuts = new Label(sd.getName());
        Label sparklyDonutsCost = new Label("12 Rainbows");
        Button buySDBtn = new Button();
        buySDBtn.setText("Buy");
        buySDBtn.setOnAction(e -> {
            if (App.getBalance()>=sd.getCost()){
                sd.increaseQuantity();
                App.setBalance(App.getBalance() - sd.getCost());
            }
            else{
                NotEnoughRainbows.display("Not Enough Rainbows", "sorry!");
            }
        });
        
        VBox vBoxStoreLeft = new VBox(11,glitterCupcake, rainbowCake, funfettiPancakes, jelloPudding, sparklyDonuts);
        VBox vBoxStoreMiddle = new VBox(11,glitterCupcakeCost, rainbowCakeCost, funfettiPancakesCost, jelloPuddingCost, sparklyDonutsCost);
        VBox vBoxStoreRight = new VBox(buyGCBtn, buyRCBtn, buyFPBtn, buyJPBtn, buySDBtn);

        HBox hBoxStore = new HBox(20,vBoxStoreLeft, vBoxStoreMiddle, vBoxStoreRight);
        hBoxStore.setAlignment(Pos.CENTER);

        Button close = new Button("Close");
        close.setOnAction(e -> addStore.close());
        close.setAlignment(Pos.BOTTOM_CENTER);

        VBox store = new VBox(30,hBoxStore,close);
        store.setAlignment(Pos.CENTER);
        
        // Scene/Stage
        Scene addStore1 = new Scene(store, 400, 400);
        addStore.setScene(addStore1);
        addStore.showAndWait();
    }
}