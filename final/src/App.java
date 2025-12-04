// UniTask
// Amelia Wagner and Joanna Arul Jeeva
// Date completed
// UniTask is a task manager productivity planner designed to make completing assignments more enjoyable by rewarding users with the opportunity to take care of a virtual unicorn.
// I agree to abide by the Academic Honesty Agreement.

import java.io.FileInputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class App extends Application {
    
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static ArrayList<Task> completedTasks = new ArrayList<>();

    public static ArrayList<Task> getTasks() {
        return tasks;
    }
    
    private static Boolean isUnicorn = true;
    private static String animal = "unicorn";
    private static ArrayList<Food> foods = new ArrayList<>();
    private static int balance = 0;
    private static int happy = 0;
    private static GridPane gridpane = new GridPane(10,5);
    private static Food gc = new Food("Glitter Cupcake", 21, 10);
    private static Food rc = new Food("Rainbow Cake", 41, 15);
    private static Food fp = new Food("Funfetti Pancakes", 67, 30);
    private static Food jp = new Food("Jell-O Pudding", 111,50);
    private static Food sd = new Food("Sparkly Donuts", 420, 5);
    private static VBox vBoxRight = new VBox();

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        // adds all of the food to the foods ArrayList
        foods.add(gc);
        foods.add(rc);
        foods.add(fp);
        foods.add(jp);
        foods.add(sd);

        // sets initial animal
        if (isUnicorn){
            animal = "unicorn";
        }
        else{
            animal = "dragon";
        }

        // rainbow currency image
        String pathRainbow = "final/src/Images/Rainbow.png";
        FileInputStream inputFileRainbow = new FileInputStream(pathRainbow);
        Image rainbowImage = new Image(inputFileRainbow);
        ImageView rainbow = new ImageView(rainbowImage);

        // header
        Label websiteLogo = new Label("UniTask");
        websiteLogo.setId("mainTitle");
        Label happiness = new Label("Happiness: "+happy+"%");
        Label balanceLabel = new Label("Balance: "+balance);
        HBox balanceBox = new HBox(3,balanceLabel,rainbow);
        Button addTaskBtn = new Button();
        addTaskBtn.setText("Add Task");

        // first task and date label
        Label yourTasks = new Label("Your Tasks");
        yourTasks.setId("sectionHeader");
        Label task1 = new Label("Task");
            task1.setId("subsectionHeader");

        Label date1 = new Label("Date");
            date1.setId("subsectionHeader");

        gridpane.add(task1, 1, 0);
        gridpane.add(date1, 2,0);

        // second task and date label
        Label completedTitle = new Label("Completed");
        completedTitle.setId("sectionHeader");
        GridPane completedGridPane = new GridPane(10,5);
        Label task2 = new Label("Task");
            task2.setId("subsectionHeader");

        Label date2 = new Label("Date");
            date2.setId("subsectionHeader");

        completedGridPane.add(task2,1,0);
        completedGridPane.add(date2,2,0);

        // this is what happens when you press the add task button
        addTaskBtn.setOnAction(e -> {
            // creates a new task
            Task newTask = AddTask.display("Add a task!", "hello!");
            if (newTask != null){
                tasks.add(newTask);
            }

            sortTasks();

            // adds all tasks to a gridpane as long as the user does not close the popup before entering information
            if (tasks.size()!=0 && newTask != null){
                gridpane.getChildren().clear();
                gridpane.add(task1, 1, 0);
                gridpane.add(date1, 2,0);
                for (int i=0; i<tasks.size(); i++){
                    Task task = tasks.get(i);
                    CheckBox cb = new CheckBox();
                    cb.setSelected(false);
                    
                    gridpane.add(cb, 0, i+1);
                    Label name = new Label(task.getTaskName());
                    Label date = new Label(task.dueString());
                    gridpane.add(name,1,i+1);
                    gridpane.add(date,2,i+1);

                    // when a task is checked off, move it from the first gridpane to the completed gridpane
                    cb.setOnAction(event -> {
                        if (cb.isSelected()) {
                            tasks.remove(task);
                            gridpane.getChildren().remove(name);
                            gridpane.getChildren().remove(date);
                            gridpane.getChildren().remove(cb);
                            completedTasks.add(task);

                            completedGridPane.getChildren().clear();
                            completedGridPane.add(task2,1,0);
                            completedGridPane.add(date2,2,0);
                            for (int j=0; j<completedTasks.size(); j++){
                                Task cTask = completedTasks.get(j);
                                Label cName = new Label(cTask.getTaskName());
                                Label cDate = new Label(cTask.dueString());
                                CheckBox cb1  = new CheckBox();
                                cb1.setSelected(true);
                                completedGridPane.add(cb1,0,j+1);
                                completedGridPane.add(cName,1,j+1);
                                completedGridPane.add(cDate,2,j+1);
                            }

                            balance += 100;
                            balanceLabel.setText("Balance: "+balance);
                        }
                    });

                    // decreases happiness if there are overdue tasks
                    if (task.getTaskDue().isBefore(LocalDate.now())){
                        App.setHappy(App.getHappy()-20);
                    }
                    happiness.setText("Happiness: "+happy+"%");
                }
            }

        });
        
        // makes the entire left side of the application into one formatted VBox
        VBox vbox1L = new VBox(websiteLogo, addTaskBtn);
        HBox hbox1 = new HBox(100, vbox1L, balanceBox);
        VBox vbox2 = new VBox(10, yourTasks, gridpane);
        VBox vbox3 = new VBox(10, completedTitle, completedGridPane);
        VBox vBoxLeft = new VBox(20,hbox1, vbox2, vbox3);
        vBoxLeft.setId("leftSide");

        // Unicorn image
        String path = "final/src/Images/Uni.png";
        FileInputStream inputFile = new FileInputStream(path);
        Image unicorn = new Image(inputFile);
        ImageView uniView = new ImageView(unicorn);

        // Dragon image
        String pathD = "final/src/Images/Dragon.png";
        FileInputStream inputFileD = new FileInputStream(pathD);
        Image dragon1 = new Image(inputFileD);
        ImageView dragonView = new ImageView(dragon1);

        // Store button
        Button storeButton = new Button("Store");
        storeButton.setOnAction(e -> {
            Store.display("Buy food for your "+animal+"!", "hello!");
            balanceLabel.setText("Balance: "+ balance);
        });

        // HBox for the top of the right side
        HBox uniTop = new HBox(150, storeButton, happiness);

        // Feed button
        Button feed = new Button("Feed");
        feed.setOnAction(e -> {
            Feed.display("Feed your "+animal+"!", "hello!");
            happiness.setText("Happiness: "+happy+"%");
        });

        // unicorn HBox
        HBox uni = new HBox(uniView);
        uni.setAlignment(Pos.CENTER);

        // dragon HBox
        HBox dragon = new HBox(dragonView);
        dragon.setAlignment(Pos.CENTER);

        // play button
        Button playButton = new Button("Play");
        playButton.setOnAction(e -> {
            if (happy >= 100) {
                happy = 100;
            } else {
                happy +=5;
            }
            happiness.setText("Happiness: "+happy+"%");
        });

        // Switch animal button
        String text;
        if (isUnicorn){
            text = "Switch to Dragon ";
        }
        else{
            text = "Switch to Unicorn";
        }
        Button switchAnimal = new Button(text);
        HBox uniBottom = new HBox(50,feed, switchAnimal, playButton);
        if (isUnicorn){
            vBoxRight = new VBox(100,uniTop,uni, uniBottom);
        }
        else{
            vBoxRight = new VBox(100, uniTop, dragon, uniBottom);
        }
        switchAnimal.setOnAction(e -> {
            if (!isUnicorn){
                vBoxRight.getChildren().remove(1);
                vBoxRight.getChildren().add(1,uni);
                App.setIsUnicorn(true);
                switchAnimal.setText("Switch to Dragon ");
                animal = "unicorn";
            }
            else{
                vBoxRight.getChildren().remove(1);
                vBoxRight.getChildren().add(1,dragon);
                App.setIsUnicorn(false);
                switchAnimal.setText("Switch to Unicorn");
                animal = "dragon";
            }
        });

        vBoxRight.setId("rightSide");

        // full scene HBox for horizontal alignment
        HBox fullScene = new HBox(20,vBoxLeft,vBoxRight);
        fullScene.setAlignment(Pos.CENTER);

        // full VBox for vertical alignment
        VBox full = new VBox(fullScene);
        full.setAlignment(Pos.CENTER);
        full.setId("background");
        
        // Scene/Stage
        Scene mainPage = new Scene(full, 810, 550);
        mainPage.getStylesheets().add("style.css");
        primaryStage.setTitle("UniTask");
        primaryStage.setScene(mainPage);
        primaryStage.show();
    }

    // getters and setters
    public static int getBalance() {
        return balance;
    }

    public static void setBalance(int balance) {
        App.balance = balance;
    }

    public static int getHappy(){
        return happy;
    }

    public static void setHappy(int happy){
        App.happy = happy;
    }

    public static ArrayList<Food> getFoods(){
        return foods;
    }

    public static void setIsUnicorn(Boolean is){
        App.isUnicorn = is;
    }

    public static Boolean getIsUnicorn(){
        return isUnicorn;
    }

    public static String getAnimal(){
        return animal;
    }

    // sorts tasks list
    public static void sortTasks(){
        for (int j=0; j<tasks.size()-1; j++){
            for (int i=0; i<tasks.size()-1-j; i++){
                if (tasks.get(i).getTaskDue().isAfter(tasks.get(i+1).getTaskDue())){
                    Task hold = tasks.get(i);
                    tasks.set(i, tasks.get(i+1));
                    tasks.set(i+1, hold);
                }
            }
        }
    }

    public static Food gc(){
        return gc;
    }

    public static Food rc(){
        return rc;
    }

    public static Food fp(){
        return fp;
    }

    public static Food jp(){
        return jp;
    }

    public static Food sd(){
        return sd;
    }

}