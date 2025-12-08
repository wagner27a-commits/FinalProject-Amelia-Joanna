// this is the pop up that pops up once you feed your unicorn/dragon (updated stats)

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FeedPopUp{
    public static void display(String title, int remainingTasks, int currentHealth, int currentBalance) {
        Stage feedPopUp = new Stage();
      
        feedPopUp.initModality(Modality.APPLICATION_MODAL);
        feedPopUp.setTitle(title);
        feedPopUp.setMinWidth(200); 

        // updates the user on all stats
        Label feedingUnicornText = new Label("Thank you for feeding your "+App.getAnimal()+"!");
        Label tasksLabel = new Label("Remaining Tasks: " + remainingTasks);
        Label healthLabel = new Label("Current Happiness: " + currentHealth);
        Label balanceLabel = new Label("Current Balance: " + currentBalance);
        Button ok = new Button("Ok!");
        ok.setOnAction(e -> feedPopUp.close());

        // formatting/alignment
        VBox feedPopUpBox = new VBox(10, feedingUnicornText, tasksLabel, healthLabel, balanceLabel, ok);
        feedPopUpBox.setAlignment(Pos.CENTER);
        feedPopUpBox.setId("background");
        
        // Scene/Stage
        Scene feedPopUpPage = new Scene(feedPopUpBox, 335, 150);
        feedPopUpPage.getStylesheets().add("style.css");
        feedPopUp.setScene(feedPopUpPage);
        feedPopUp.showAndWait();
    }
}