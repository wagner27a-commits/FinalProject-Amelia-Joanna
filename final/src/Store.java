// store popup that pops up when you click the store button

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Store{

    public static void display(String title, String message) {
        Stage addStore = new Stage();
      
        addStore.initModality(Modality.APPLICATION_MODAL);
        addStore.setTitle(title);
        addStore.setMinWidth(250); 

        // Grid for store layout
        GridPane storePane = new GridPane(10, 10);

        // Add each food
        addFoodRow(storePane, 0, App.gc(), "final/src/Images/GlitterCupcake.png", "21 Rainbows");
        addFoodRow(storePane, 1, App.rc(), "final/src/Images/RainbowCake.png", "41 Rainbows");
        addFoodRow(storePane, 2, App.fp(), "final/src/Images/FunfettiPancake.png", "67 Rainbows");
        addFoodRow(storePane, 3, App.jp(), "final/src/Images/JelloPudding.png", "111 Rainbows");
        addFoodRow(storePane, 4, App.sd(), "final/src/Images/SparklyDonut.png", "420 Rainbows");

        HBox hBoxStore = new HBox(20,storePane);
        hBoxStore.setAlignment(Pos.CENTER);

        Button close = new Button("Close");
        close.setOnAction(e -> addStore.close());
        close.setAlignment(Pos.BOTTOM_CENTER);

        // Main Store Layout
        VBox store = new VBox(30,hBoxStore,close);
        store.setAlignment(Pos.CENTER);
        store.setId("background");
        
        // Scene/Stage
        Scene addStore1 = new Scene(store, 400, 400);
        addStore1.getStylesheets().add("style.css");
        
        addStore.setScene(addStore1);
        addStore.showAndWait();
        }

        private static void addFoodRow(GridPane pane, int row, Food food, String imagePath, String costText) {
            ImageView imageView;

            try {
                FileInputStream Stream = new FileInputStream(imagePath);
                imageView = new ImageView(new Image(Stream));
            } catch(FileNotFoundException e) { 
                System.err.println("Image not found " + imagePath);
                imageView = new ImageView();
            }

            Label name = new Label(food.getName());
            Label cost = new Label(costText);
            Button buyBtn = createBuyButton(food);

            pane.add(imageView, 0, row);
            pane.add(name, 1, row);
            pane.add(cost, 2, row);
            pane.add(buyBtn, 3, row);
        }

    // Buy Button
    private static Button createBuyButton(Food food) {
        Button buyBtn = new Button("Buy");
        buyBtn.setOnAction(e -> {
            if (App.getBalance() >= food.getCost()){
                food.increaseQuantity();
                App.setBalance(App.getBalance() - food.getCost());
            }
            else{
                NotEnoughRainbows.display("Not Enough Rainbows", "sorry!");
            }
        });

        return buyBtn;
    }
}