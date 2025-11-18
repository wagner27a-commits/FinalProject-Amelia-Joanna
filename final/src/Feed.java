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

public class Feed{
    
    public static void display(String title, String message) {
        Stage feed = new Stage();
      
        feed.initModality(Modality.APPLICATION_MODAL);
        feed.setTitle(title);
        feed.setMinWidth(250); 

        Label yourInventory = new Label("Your Inventory");

        VBox vboxFeed = new VBox(yourInventory);
        
        // Scene/Stage
        Scene feedPage = new Scene(vboxFeed, 400, 400);
        feed.setScene(feedPage);
        feed.showAndWait();
    }
}