package unsw.dungeon;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DungeonApplication extends Application {

	private Stage primaryStage;
	 @Override
	    public void start(Stage primaryStage) throws IOException {
		 	this.primaryStage = primaryStage;
	        primaryStage.setTitle("Welcome to Dungeon");

	        FXMLLoader loader = new FXMLLoader(getClass().getResource("start.fxml"));
	        loader.setController(new StartController(this));
	        Parent root = loader.load();
	        Scene scene = new Scene(root);
	        root.requestFocus();
	        primaryStage.setScene(scene);
	        primaryStage.show();

	    }

    public void game_easy(String path) throws IOException {
        
    	DungeonControllerLoader dungeonLoader = new DungeonControllerLoader("maze.json");

        DungeonController controller = dungeonLoader.loadController();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("DungeonView.fxml"));
        
        loader.setController(controller);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        root.requestFocus();
        primaryStage.setScene(scene);
        primaryStage.getScene().setRoot(root);
        primaryStage.show();

    }
    public void game_medium(String path) throws IOException {
        
    	DungeonControllerLoader dungeonLoader = new DungeonControllerLoader("boulders.json");

        DungeonController controller = dungeonLoader.loadController();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("DungeonView.fxml"));
        
        loader.setController(controller);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        root.requestFocus();
        primaryStage.setScene(scene);
        primaryStage.getScene().setRoot(root);
        primaryStage.show();

    }

    public void game_hard(String path) throws IOException {
    
        DungeonControllerLoader dungeonLoader = new DungeonControllerLoader("advanced1.json");
        
        DungeonController controller = dungeonLoader.loadController();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DungeonView.fxml"));
        
        loader.setController(controller);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        root.requestFocus();
        primaryStage.setScene(scene);
        primaryStage.getScene().setRoot(root);
        primaryStage.show();
        
    }
    
    public void view_rules(String path) throws IOException {
	        
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("rules.fxml"));
	    loader.setController(new RulesController(this));
	    Parent root = loader.load();
	    Scene scene = new Scene(root);
	    root.requestFocus();
	    primaryStage.setScene(scene);
	    primaryStage.show();
	
	 }
	
	public void game_super(String path) throws IOException {
        
    	DungeonControllerLoader dungeonLoader = new DungeonControllerLoader("advanced.json");

        DungeonController controller = dungeonLoader.loadController();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("DungeonView.fxml"));
        
        loader.setController(controller);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        root.requestFocus();
        primaryStage.setScene(scene);
        primaryStage.getScene().setRoot(root);
        primaryStage.show();

    }

	
	public void back_to_menu(String path) throws IOException {
        
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("start.fxml"));
	    loader.setController(new StartController(this));
	    Parent root = loader.load();
	    Scene scene = new Scene(root);
	    root.requestFocus();
	    primaryStage.setScene(scene);
	    primaryStage.show();
	
	 }
	    
    public static void main(String[] args) {
        launch(args);
    }

}
