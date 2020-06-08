package unsw.dungeon;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class ExitController {

		@FXML
		private Button BackButton;
		private DungeonApplication dungeonapp;
		
		@FXML
		private Button NewGameButton;
		
		public ExitController(DungeonApplication dungeonapp) {
			this.dungeonapp = dungeonapp;
		}

		@FXML 
		void HandleBack(ActionEvent back_to_menu) {
			try {
				dungeonapp.back_to_menu(null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@FXML 
		void HandleNewGame(ActionEvent back_to_menu) {
			try {
				dungeonapp.game_super(null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			
		public void setDungeonScreen(DungeonApplication dungeonapp) {
			this.dungeonapp = dungeonapp;
		}
}

