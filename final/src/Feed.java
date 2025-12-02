// import java.time.LocalDate;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

// import javafx.application.Application;
// import javafx.event.ActionEvent;
// import javafx.event.EventHandler;
// import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
// import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Feed{
    
    public static void display(String title, String message) {
        // VBox table = new VBox(5);

        GridPane grid = new GridPane(10,10);

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

        ImageView image = null;

        for (int i=0; i<boughtFoods.size(); i++){
            Food f = boughtFoods.get(i);
            if (f.equals(App.gc())){
                String path1 = "final/src/Glitter Cupcake-1.png (2) (1).png";
                FileInputStream inputFile1 = null;
                try {
                    inputFile1 = new FileInputStream(path1);
                }
                catch (FileNotFoundException e) {
                    System.err.println(e);
                }
                Image GC = new Image(inputFile1);
                image = new ImageView(GC);
            }
            else if (f.equals(App.rc())){
                String path2 = "final/src/finalRainbowCake.png";
                FileInputStream inputFile2 = null;
                try {
                    inputFile2 = new FileInputStream(path2);
                }
                catch (FileNotFoundException e) {
                    System.err.println(e);
                }
                Image RC = new Image(inputFile2);
                image = new ImageView(RC);
            }
            else if (f.equals(App.fp())){
                String path3 = "final/src/finalFunfettiPancake.png";
                FileInputStream inputFile3 = null;
                try {
                    inputFile3 = new FileInputStream(path3);
                }
                catch (FileNotFoundException e) {
                    System.err.println(e);
                }
                Image FP = new Image(inputFile3);
                image = new ImageView(FP);
            }
            else if (f.equals(App.jp())){
                String path4 = "final/src/finalJelloPudding.png";
                FileInputStream inputFile4 = null;
                try {
                    inputFile4 = new FileInputStream(path4);
                }
                catch (FileNotFoundException e) {
                    System.err.println(e);
                }
                Image JP = new Image(inputFile4);
                image = new ImageView(JP);
            }
            else if (f.equals(App.sd())){
                String path5 = "final/src/finalSparklyDonut.png";
                FileInputStream inputFile5 = null;
                try {
                    inputFile5 = new FileInputStream(path5);
                }
                catch (FileNotFoundException e) {
                    System.err.println(e);
                }
                Image SD = new Image(inputFile5);
                image = new ImageView(SD);
            }
            Label foodLabel = new Label(f.getName());
            Label foodHappiness = new Label("+"+f.getHappiness()+"% happiness");
            Button feedButton = new Button();
            feedButton.setText("Feed Uni!");
            feedButton.setOnAction(e -> {
                f.decreaseQuantity();
                int thing = App.getHappy()+f.getHappiness();
                if (thing>100){
                    App.setHappy(thing-(thing-100));
                }
                else{
                    App.setHappy(thing);
                }
                FeedPopUp.display("Thanks for feeding your unicorn!", App.getTasks().size(), App.getHappy(), App.getBalance());
                feed.close();
            });
            // HBox foodBox = new HBox(20, foodLabel, foodHappiness, feedButton);

            // table.getChildren().add(foodBox);
            grid.add(image, 0, i);
            grid.add(foodLabel,1,i);
            grid.add(foodHappiness,2,i);
            grid.add(feedButton,3,i);
        }

        VBox vboxFeed = new VBox(10,yourInventory, grid);
        
        // Scene/Stage
        Scene feedPage = new Scene(vboxFeed, 400, 400);
        feed.setScene(feedPage);
        feed.showAndWait();
    }
}