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

        App.getFoods().add(App.gc());
        App.getFoods().add(App.rc());
        App.getFoods().add(App.fp());
        App.getFoods().add(App.jp());
        App.getFoods().add(App.sd());
      
        addStore.initModality(Modality.APPLICATION_MODAL);
        addStore.setTitle(title);
        addStore.setMinWidth(250); 

        // Food #1 (GC = Glitter Cupcake)
        String path1 = "final/src/Images/GlitterCupcake.png";
        FileInputStream inputFile1 = null;
        try {
            inputFile1 = new FileInputStream(path1);
        }
        catch (FileNotFoundException e) {
            System.err.println(e);
        }
        Image GC = new Image(inputFile1);
        ImageView GCView = new ImageView(GC);

        Label glitterCupcake = new Label(App.gc().getName());
        Label glitterCupcakeCost = new Label("21 Rainbows");
        Button buyGCBtn = new Button();
        buyGCBtn.setText("Buy");
        buyGCBtn.setOnAction(e -> {
            if (App.getBalance()>=App.gc().getCost()){
                App.gc().increaseQuantity();
                App.setBalance(App.getBalance() - App.gc().getCost());
            }
            else{
                NotEnoughRainbows.display("Not Enough Rainbows", "sorry!");
            }
        });


        // Food #2 (RC = Rainbow Cake)
        String path2 = "final/src/Images/RainbowCake.png";
        FileInputStream inputFile2 = null;
        try {
            inputFile2 = new FileInputStream(path2);
        }
        catch (FileNotFoundException e) {
            System.err.println(e);
        }
        Image RC = new Image(inputFile2);
        ImageView RCView = new ImageView(RC);

        Label rainbowCake = new Label(App.rc().getName());
        Label rainbowCakeCost = new Label("41 Rainbows");
        Button buyRCBtn = new Button();
        buyRCBtn.setText("Buy");
        buyRCBtn.setOnAction(e -> {
            if (App.getBalance()>=App.rc().getCost()){
                App.rc().increaseQuantity();
                App.setBalance(App.getBalance() - App.rc().getCost());
            }
            else{
                NotEnoughRainbows.display("Not Enough Rainbows", "sorry!");
            }
        });

        // Food #3 (FP = Funfetti Pancakes)
        String path3 = "final/src/Images/FunfettiPancake.png";
        FileInputStream inputFile3 = null;
        try {
            inputFile3 = new FileInputStream(path3);
        }
        catch (FileNotFoundException e) {
            System.err.println(e);
        }
        Image FP = new Image(inputFile3);
        ImageView FPView = new ImageView(FP);

        Label funfettiPancakes = new Label(App.fp().getName());
        Label funfettiPancakesCost = new Label("67 Rainbows");
        Button buyFPBtn = new Button();
        buyFPBtn.setText("Buy");
        buyFPBtn.setOnAction(e -> {
            if (App.getBalance()>=App.fp().getCost()){
                App.fp().increaseQuantity();
                App.setBalance(App.getBalance() - App.fp().getCost());
            }
            else{
                NotEnoughRainbows.display("Not Enough Rainbows", "sorry!");
            }
        });

        // Food #4 (JP = Jell-o Pudding)
        String path4 = "final/src/Images/JelloPudding.png";
        FileInputStream inputFile4 = null;
        try {
            inputFile4 = new FileInputStream(path4);
        }
        catch (FileNotFoundException e) {
            System.err.println(e);
        }
        Image JP = new Image(inputFile4);
        ImageView JPView = new ImageView(JP);

        Label jelloPudding = new Label(App.jp().getName());
        Label jelloPuddingCost = new Label("420 Rainbows");
        Button buyJPBtn = new Button();
        buyJPBtn.setText("Buy");
        buyJPBtn.setOnAction(e -> {
            if (App.getBalance()>=App.jp().getCost()){
                App.jp().increaseQuantity();
                App.setBalance(App.getBalance() - App.jp().getCost());
            }
            else{
                NotEnoughRainbows.display("Not Enough Rainbows", "sorry!");
            }
        });

        // Food #5 (SD = Sparkly Donuts)
        String path5 = "final/src/Images/SparklyDonut.png";
        FileInputStream inputFile5 = null;
        try {
            inputFile5 = new FileInputStream(path5);
        }
        catch (FileNotFoundException e) {
            System.err.println(e);
        }
        Image SD = new Image(inputFile5);
        ImageView SDView = new ImageView(SD);

        Label sparklyDonuts = new Label(App.sd().getName());
        Label sparklyDonutsCost = new Label("12 Rainbows");
        Button buySDBtn = new Button();
        buySDBtn.setText("Buy");
        buySDBtn.setOnAction(e -> {
            if (App.getBalance()>=App.sd().getCost()){
                App.sd().increaseQuantity();
                App.setBalance(App.getBalance() - App.sd().getCost());
            }
            else{
                NotEnoughRainbows.display("Not Enough Rainbows", "sorry!");
            }
        });
        
        GridPane storePane = new GridPane(10,10);
        storePane.add(GCView,0,0);
        storePane.add(RCView,0,1);
        storePane.add(FPView,0,2);
        storePane.add(JPView,0,3);
        storePane.add(SDView,0,4);
        storePane.add(glitterCupcake,1,0);
        storePane.add(rainbowCake,1,1);
        storePane.add(funfettiPancakes,1,2);
        storePane.add(jelloPudding,1,3);
        storePane.add(sparklyDonuts,1,4);
        storePane.add(glitterCupcakeCost,2,0);
        storePane.add(rainbowCakeCost,2,1);
        storePane.add(funfettiPancakesCost,2,2);
        storePane.add(jelloPuddingCost,2,3);
        storePane.add(sparklyDonutsCost,2,4);
        storePane.add(buyGCBtn,3,0);
        storePane.add(buyRCBtn,3,1);
        storePane.add(buyFPBtn,3,2);
        storePane.add(buyJPBtn,3,3);
        storePane.add(buySDBtn,3,4);

        HBox hBoxStore = new HBox(20,storePane);
        hBoxStore.setAlignment(Pos.CENTER);

        Button close = new Button("Close");
        close.setOnAction(e -> addStore.close());
        close.setAlignment(Pos.BOTTOM_CENTER);

        VBox store = new VBox(30,hBoxStore,close);
        store.setAlignment(Pos.CENTER);
        
        // Scene/Stage
        Scene addStore1 = new Scene(store, 400, 400);
        addStore1.getStylesheets().add("style.css");
        addStore.setScene(addStore1);
        addStore.showAndWait();
    }
}