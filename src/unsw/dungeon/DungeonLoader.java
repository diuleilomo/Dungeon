package unsw.dungeon;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;


public abstract class DungeonLoader {

    private JSONObject json;
    private int bombId = 0;
    
    public DungeonLoader(String filename) throws FileNotFoundException {
        json = new JSONObject(new JSONTokener(new FileReader("dungeons/" + filename)));
    }

    /**
     * Parses the JSON to create a dungeon.
     * @return
     */
    public Dungeon load() {
        int width = json.getInt("width");
        int height = json.getInt("height");

        Dungeon dungeon = new Dungeon(width, height);

        JSONArray jsonEntities = json.getJSONArray("entities");

        for (int i = 0; i < jsonEntities.length(); i++) {
            loadEntity(dungeon, jsonEntities.getJSONObject(i));
        }
        
        JSONObject jsonGoals = json.getJSONObject("goal-condition");
        
        dungeon.setGoal(loadGoals(dungeon, jsonGoals));
        
        return dungeon;
    }
    
        private Goal loadGoals(Dungeon dungeon, JSONObject json) {
    	String type = json.getString("goal");
    	
    	Goal goal = null;
    	switch(type) {
    	case "exit":
    		goal = new GoalExit(dungeon);
    		break;
    	case "enemies":
    		goal = new GoalEnemies(dungeon);
    		break;
    	case "boulders":
    		goal = new GoalBoulder(dungeon);
    		break;
    	case "treasure":
    		goal = new GoalTreasure(dungeon);
    		break;
    	case "AND":
    		goal = new GoalAND();
    		JSONArray jsonAndSubgoals= json.getJSONArray("subgoals");
    		for (int j = 0; j < jsonAndSubgoals.length(); j++)
    			((GoalAND)goal).addGoal(loadGoals(dungeon, jsonAndSubgoals.getJSONObject(j)));
    		break;
    	case "OR":
    		goal = new GoalOR();
    		JSONArray jsonOrSubgoals= json.getJSONArray("subgoals");
    		for (int j = 0; j < jsonOrSubgoals.length(); j++)
    			((GoalOR)goal).addGoal(loadGoals(dungeon, jsonOrSubgoals.getJSONObject(j)));
    		break;
    	}
    	return goal;
    }

    private void loadEntity(Dungeon dungeon, JSONObject json) {
        String type = json.getString("type");
        int x = json.getInt("x");
        int y = json.getInt("y");

        Entity entity = null;
        switch (type) {
        case "player":
            Player player = new Player(x, y, dungeon);
            dungeon.setPlayer(player);
            onLoad(player);
            entity = player;
            break;
        case "wall":
            Wall wall = new Wall(x, y);
            onLoad(wall);
            entity = wall;
            break;
            
        // TODO Handle other possible entities
        case "boulder":
        	Boulder boulder = new Boulder(x, y, dungeon);
        	onLoad(boulder);
        	entity = boulder;
        	break;
        case "floorswitch":
        	FloorSwitch floorswitch = new FloorSwitch(x, y, dungeon);
        	onLoad(floorswitch);
        	entity = floorswitch;
        	break;
        case "treasure":
        	Treasure treasure = new Treasure(x, y, dungeon);
        	onLoad(treasure);
        	entity = treasure;
        	break;
        case "key":
        	String keyColor = json.getString("color");
        	Key key = new Key(x, y, dungeon, keyColor);
        	onLoad(key);
        	entity = key;
        	break;
        case "door":
        	String doorColor = json.getString("color");
        	Door door = new Door(x, y, dungeon, doorColor);
        	onLoad(door);
        	entity = door;
        	break;
        case "sword":
        	Sword sword = new Sword(x, y, dungeon);
        	onLoad(sword);
        	entity = sword;
        	break;
        case "potion":
        	Potion potion = new Potion(x, y, dungeon);
        	onLoad(potion);
        	entity = potion;
        	break;
        case "bomb":
        	UnlitBomb bomb = new UnlitBomb(x, y, dungeon);
        	onLoad(bomb);
        	dungeon.addEntity(bomb);
        	LitBomb1 bomb1 = new LitBomb1(dungeon.getWidth(), dungeon.getHeight(), dungeon);
        	onLoad(bomb1);
        	dungeon.addEntity(bomb1);
        	LitBomb2 bomb2 = new LitBomb2(dungeon.getWidth(), dungeon.getHeight(), dungeon);
        	onLoad(bomb2);
        	dungeon.addEntity(bomb2);
        	LitBomb3 bomb3 = new LitBomb3(dungeon.getWidth(), dungeon.getHeight(), dungeon);
        	onLoad(bomb3);
        	dungeon.addEntity(bomb3);
        	Flame flame = new Flame(dungeon.getWidth(), dungeon.getHeight(), dungeon);
        	onLoad(flame);
        	dungeon.addEntity(flame);
        	break;
        case "enemy":
        	Enemy enemy = new Enemy(x, y, dungeon);
        	onLoad(enemy);
        	entity = enemy;
        	break;
        case "exit":
        	Exit exit = new Exit(x, y, dungeon);
        	onLoad(exit);
        	entity = exit;
        	break;
        }
        dungeon.addEntity(entity);
    }

    public abstract void onLoad(Entity player);

    public abstract void onLoad(Wall wall);

	public abstract void onLoad(Boulder boulder);
	
	public abstract void onLoad(FloorSwitch floorswitch);
	
	public abstract void onLoad(Treasure treasure);
	
	public abstract void onLoad(Key key);
	
	public abstract void onLoad(Door door);
	
	public abstract void onLoad(Sword sword);
	
    public abstract void onLoad(Potion potion);
    
    public abstract void onLoad(UnlitBomb unlitbomb);
    
    public abstract void onLoad(LitBomb1 litbomb1);
    
    public abstract void onLoad(LitBomb2 litbomb2);
    
    public abstract void onLoad(LitBomb3 litbomb3);
    
    public abstract void onLoad(Flame flame);

    public abstract void onLoad(Enemy enemy);

	public abstract void onLoad(Exit exit);
	 
}
