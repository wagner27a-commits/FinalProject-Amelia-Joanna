// feed popup that pops up when you click the feed button

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Feed{
    
    public static void display(String title, String message) {

        GridPane grid = new GridPane(10,10);

        // adds food that have been bought to a new ArrayList
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
        yourInventory.setId("sectionHeader");

        ImageView image = null;

        // adds all foods to a gridpane
        for (int i=0; i<boughtFoods.size(); i++){
            Food f = boughtFoods.get(i);

            image = getImage(f);

            // layout of the popup + feed button
            Label foodLabel = new Label(f.getName());
            Label foodHappiness = new Label("+"+f.getHappiness()+"% happiness");
            Button feedButton = new Button();
            feedButton.setText("Feed Uni!");
            if (!App.getIsUnicorn()){
                feedButton.setText("Feed Dragon!");
            }
            feedButton.setOnAction(e -> {
                f.decreaseQuantity();
                int thing = App.getHappy()+f.getHappiness();
                if (thing>100){
                    App.setHappy(thing-(thing-100));
                }
                else{
                    App.setHappy(thing);
                }
                FeedPopUp.display("Thanks for feeding your "+App.getAnimal()+"!", App.getTasks().size(), App.getHappy(), App.getBalance());
                feed.close();
            });

            grid.add(image, 0, i);
            grid.add(foodLabel,1,i);
            grid.add(foodHappiness,2,i);
            grid.add(feedButton,3,i);
        }

        // entire layout
        VBox vboxFeed = new VBox(10,yourInventory, grid);
        vboxFeed.setId("background");
        
        // Scene/Stage
        Scene feedPage = new Scene(vboxFeed, 450, 400);
        feedPage.getStylesheets().add("style.css");
        feed.setScene(feedPage);
        feed.showAndWait();
    }

    // method for getting the image of a food
    public static ImageView getImage(Food f){
        String path;
        if (f.equals(App.gc())){
            path = "final/src/Images/GlitterCupcake.png";
        }
        else if (f.equals(App.rc())){
            path = "final/src/Images/RainbowCake.png";
        }
        else if (f.equals(App.fp())){
            path = "final/src/Images/FunfettiPancake.png";
        }
        else if (f.equals(App.jp())){
            path = "final/src/Images/JelloPudding.png";
        }
        else{
            path = "final/src/Images/SparklyDonut.png";
        }
        FileInputStream inputFile = null;
        try {
            inputFile = new FileInputStream(path);
        }
        catch (FileNotFoundException e) {
            System.err.println(e);
        }
        Image img = new Image(inputFile);
        return new ImageView(img);
    }
}