import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NotEnoughRainbows{
    public static void display(String title, String message) {
        Stage notEnoughRainbows = new Stage();
      
        notEnoughRainbows.initModality(Modality.APPLICATION_MODAL);
        notEnoughRainbows.setTitle(title);
        notEnoughRainbows.setMinWidth(250); 

        Label text = new Label("Sorry, you don't have enough rainbows for this.");
        Label text2 = new Label("Please try a different food or completing more tasks.");
        Button ok = new Button("Ok!");
        ok.setOnAction(e -> notEnoughRainbows.close());
        VBox texts = new VBox(20,text,text2,ok);
        texts.setAlignment(Pos.CENTER);
        texts.setId("background");
        
        // Scene/Stage
        Scene notEnoughRainbowsScene = new Scene(texts, 420, 150);
        notEnoughRainbowsScene.getStylesheets().add("style.css");
        notEnoughRainbows.setScene(notEnoughRainbowsScene);
        notEnoughRainbows.showAndWait();
    }
}