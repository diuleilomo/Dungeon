package unsw.dungeon;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;


public class DungeonControllerLoader extends DungeonLoader {

	private List<ImageView> entities;
    //Images
    private Image playerImage;
    private Image wallImage;
    private Image boulderImage;
    private Image floorswitchImage;
    private Image treasureImage;
    private Image keyYellowImage;
    private Image keyRedImage;
    private Image keyBlueImage;
    private Image doorCYImage;
    private Image doorOYImage;
    private Image doorCRImage;
    private Image doorORImage;
    private Image doorCBImage;
    private Image doorOBImage;
    private Image swordImage;
    private Image potionImage;
    private Image unlitbombImage;
    private Image litbomb1Image;
    private Image litbomb2Image;
    private Image litbomb3Image;
    private Image flameImage;
    private Image enemyImage;
    private Image exitImage;

    public DungeonControllerLoader(String filename)
            throws FileNotFoundException {
        super(filename);
        entities = new ArrayList<>();
        playerImage = new Image("/human_new.png");
        wallImage = new Image("/brick_brown_0.png");
        boulderImage = new Image("/boulder.png");
        floorswitchImage = new Image("/pressure_plate.png");
        treasureImage = new Image("/gold_pile.png");
        keyYellowImage = new Image("/keyYellow.png");
        keyRedImage = new Image("/keyRed.png");
        keyBlueImage = new Image("/keyBlue.png");
        doorCYImage = new Image("/doorClosedYellow.png");
        doorOYImage = new Image("/doorOpenYellow.png");
        doorCRImage = new Image("/doorClosedRed.png");
        doorORImage = new Image("/doorOpenRed.png");
        doorCBImage = new Image("/doorClosedBlue.png");
        doorOBImage = new Image("/doorOpenBlue.png");
        swordImage = new Image("/greatsword_1_new.png");
        potionImage = new Image("/brilliant_blue_new.png");
        unlitbombImage = new Image("/bomb_unlit.png");
        litbomb1Image = new Image("/bomb_lit_1.png");
        litbomb2Image = new Image("/bomb_lit_2.png");
        litbomb3Image = new Image("/bomb_lit_3.png");
        flameImage = new Image("/bomb_lit_4.png");
        enemyImage = new Image("/deep_elf_master_archer.png");
        exitImage = new Image("/exit.png");
    }

    @Override
    public void onLoad(Entity player) {
        ImageView view = new ImageView(playerImage);
        addEntity(player, view);
    }

    @Override
    public void onLoad(Wall wall) {
        ImageView view = new ImageView(wallImage);
        addEntity(wall, view);
    }
    
    @Override
    public void onLoad(Boulder boulder) {
        ImageView view = new ImageView(boulderImage);
        addEntity(boulder, view);
    }
    
    @Override
    public void onLoad(FloorSwitch floorswitch) {
        ImageView view = new ImageView(floorswitchImage);
        addEntity(floorswitch, view);
    }
    
    @Override
    public void onLoad(Treasure treasure) {
        ImageView view = new ImageView(treasureImage);
        addEntity(treasure, view);
    }
    
    @Override
    public void onLoad(Key key) {
    	if (key.getColor().equals("Yellow")) {
    		ImageView view = new ImageView(keyYellowImage);
    		addEntity(key, view);
    	} 
    	else if (key.getColor().equals("Red")) {
    		ImageView view = new ImageView(keyRedImage);
    		addEntity(key, view);
    	} 
    	else if (key.getColor().equals("Blue")) {
    		ImageView view = new ImageView(keyBlueImage);
    		addEntity(key, view);
    	} 
    }
    
    @Override
    public void onLoad(Door door) {
    	if (door.getColor().equals("Yellow")) {
	    	Door d1 = new Door(door.getX(),door.getY(),door.getDungeon(), door.getColor());
	        ImageView viewY = new ImageView(doorOYImage);
	        addEntity(d1, viewY);
	        ImageView view = new ImageView(doorCYImage);
	        addEntity(door, view);
    	} else if (door.getColor().equals("Red")) {
	    	Door d1 = new Door(door.getX(),door.getY(),door.getDungeon(), door.getColor());
	        ImageView viewR = new ImageView(doorORImage);
	        addEntity(d1, viewR);
	        ImageView view = new ImageView(doorCRImage);
	        addEntity(door, view);
    	}  else if (door.getColor().equals("Blue")) {
	    	Door d1 = new Door(door.getX(),door.getY(),door.getDungeon(), door.getColor());
	        ImageView viewR = new ImageView(doorOBImage);
	        addEntity(d1, viewR);
	        ImageView view = new ImageView(doorCBImage);
	        addEntity(door, view);
    	}
    }
    
    @Override
    public void onLoad(UnlitBomb unlitbomb) {
        ImageView view = new ImageView(unlitbombImage);
        addEntity(unlitbomb, view);
    }
    
    @Override
    public void onLoad(LitBomb1 litbomb1) {
        ImageView view = new ImageView(litbomb1Image);
        addEntity(litbomb1, view);
    }
    
    @Override
    public void onLoad(LitBomb2 litbomb2) {
        ImageView view = new ImageView(litbomb2Image);
        addEntity(litbomb2, view);
    }
    
    @Override
    public void onLoad(LitBomb3 litbomb3) {
        ImageView view = new ImageView(litbomb3Image);
        addEntity(litbomb3, view);
    }
    
    
    @Override
    public void onLoad(Flame flame) {
        ImageView view = new ImageView(flameImage);
        addEntity(flame, view);
    }
    
   @Override
    public void onLoad(Sword sword) {
        ImageView view = new ImageView(swordImage);
        addEntity(sword, view);
    }
    
     @Override
    public void onLoad(Potion potion) {
        ImageView view = new ImageView(potionImage);
        addEntity(potion, view);
    }

    @Override
    public void onLoad(Enemy enemy) {
        ImageView view = new ImageView(enemyImage);
        addEntity(enemy, view);
    }
    
    @Override
    public void onLoad(Exit exit) {
        ImageView view = new ImageView(exitImage);
        addEntity(exit, view);
    }

    private void addEntity(Entity entity, ImageView view) {
        trackPosition(entity, view);
        entities.add(view);
    }
    

    /**
     * Set a node in a GridPane to have its position track the position of an
     * entity in the dungeon.
     *
     * By connecting the model with the view in this way, the model requires no
     * knowledge of the view and changes to the position of entities in the
     * model will automatically be reflected in the view.
     * @param entity
     * @param node
     */
    private void trackPosition(Entity entity, Node node) {
        GridPane.setColumnIndex(node, entity.getX());
        GridPane.setRowIndex(node, entity.getY());
        entity.x().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                    Number oldValue, Number newValue) {
                GridPane.setColumnIndex(node, newValue.intValue());
            }
        });
        entity.y().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                    Number oldValue, Number newValue) {
                GridPane.setRowIndex(node, newValue.intValue());
            }
        });
    }

    /**
     * Create a controller that can be attached to the DungeonView with all the
     * loaded entities.
     * @return
     * @throws FileNotFoundException
     */
    public DungeonController loadController() throws FileNotFoundException {
        return new DungeonController(load(), entities);
    }



}
