import java.time.LocalDate;
import java.util.ArrayList;

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

public class Feed{
    
    public static void display(String title, String message) {
        VBox table = new VBox(5);

        ArrayList<Food> boughtFoods = new ArrayList<>();
        for (Food f : App.getFoods()){
            if (f.getQuant()>0){
                boughtFoods.add(f);
            }
        }

        Stage feed = new Stage();
      
        feed.initModality(Modality.APPLICATION_MODAL);
        feed.setTitle(title);
        feed.setMinWidth(400); 

        Label yourInventory = new Label("Your Inventory");

        for (Food f : boughtFoods){
            Label foodLabel = new Label(f.getName());
            Label foodHappiness = new Label(""+f.getHappiness());
            Button feedButton = new Button();
            feedButton.setText("Feed Uni!");
            feedButton.setOnAction(e -> {
                f.decreaseQuantity();
                App.setHappy(App.getHappy()+f.getHappiness());
                feed.close();
                FeedPopUp.display("Thanks for feeding your unicorn!", App.getTasks().size(), App.getHappy(), App.getBalance());
            });
            HBox foodBox = new HBox(20, foodLabel, foodHappiness, feedButton);

            table.getChildren().add(foodBox);
        }

        VBox vboxFeed = new VBox(yourInventory, table);
        
        // Scene/Stage
        Scene feedPage = new Scene(vboxFeed, 400, 400);
        feed.setScene(feedPage);
        feed.showAndWait();
    }
}