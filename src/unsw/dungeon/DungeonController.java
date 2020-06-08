package unsw.dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;


public class DungeonController {

    @FXML
    private GridPane squares;

    private List<ImageView> initialEntities;

    private Player player;

    private Dungeon dungeon;

    public DungeonController(Dungeon dungeon, List<ImageView> initialEntities) {
        this.dungeon = dungeon;
        this.initialEntities = new ArrayList<>(initialEntities);
        this.player = dungeon.getPlayer();    
    }

    @FXML
    public void initialize() {
        Image ground = new Image("/dirt_0_new.png");

        // Add the ground first so it is below all other entities
        for (int x = 0; x < dungeon.getWidth(); x++) {
            for (int y = 0; y < dungeon.getHeight(); y++) {
                squares.add(new ImageView(ground), x, y);
            }
        }

        for (ImageView entity : initialEntities)
            squares.getChildren().add(entity);
        Enemy();
    }

    @FXML
    public void handleKeyPress(KeyEvent event) {
        switch (event.getCode()) {

        case K:
            player.useSword();
            dungeon.changeState();
            break;
        case SPACE:
        	player.dropBomb();
        	break;
        case UP:
            player.moveUp();
            dungeon.changeState();
            break;
        case DOWN:
            player.moveDown();
            dungeon.changeState();
            break;
        case LEFT:
            player.moveLeft();
            dungeon.changeState();
            break;
        case RIGHT:
            player.moveRight();
            dungeon.changeState();
            break;
        default:
            break;
        }
    }

    public void Enemy() {
    	
    	//Enemy[] enemy = new Enemy[10];
    	int count = 0;
    	for (int i = 0; i < dungeon.getEntities().size(); i++) {
    		if (dungeon.getEntities().get(i) instanceof Enemy) {
    			Enemy enemy = (Enemy) dungeon.getEntities().get(i);
    			dungeon.getPlayer().addObserver(enemy);
    			Timer time = new Timer();
    	    	TimerTask task = new TimerTask() {
    	    		@Override
    	    		public void run() {
    	    			enemy.changeState();
    	    			dungeon.getPlayer().potionKill();
    	    			dungeon.getPlayer().getKill();
    	    		}
    	    	};
    	    	time.scheduleAtFixedRate(task, 1000, 700);
    	    	count++;
    		}
    	}
    	System.out.println(count + " enemy in the list");
    	
    	/*
    	int limit = count;
    	Timer time = new Timer();
    	TimerTask task = new TimerTask() {
    		@Override
    		public void run() {
	    		for (int k = 0; k < limit; k++) {
	    			enemy[k].changeState();
	    			dungeon.getPlayer().potionKill();
	    			dungeon.getPlayer().getKill();
	    		}
    		}
    	};
    	time.scheduleAtFixedRate(task, 1000, 700);
    	*/		
    	
    	
    }
    
}

