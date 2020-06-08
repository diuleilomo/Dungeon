package unsw.dungeon;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class StartController {

	@FXML
	private Button EasyButton;
	private DungeonApplication dungeonapp;
	
	@FXML
	private Button MediumButton;
	
	@FXML
	private Button HardButton;
	
	@FXML
	private Button RuleButton;
	
	

	public StartController(DungeonApplication dungeonapp) {
		this.dungeonapp = dungeonapp;
	}

	@FXML 
	void HandleEasy(ActionEvent easy) {
		try {
			dungeonapp.game_easy(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML 
	void HandleMedium(ActionEvent medium) {
		try {
			dungeonapp.game_medium(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML 
	void HandleHard(ActionEvent hard) {
		try {
			dungeonapp.game_hard(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	void HandleRule(ActionEvent rule) {
	    try {
			dungeonapp.view_rules(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	public void setDungeonScreen(DungeonApplication dungeonapp) {
		this.dungeonapp = dungeonapp;
	}
}
