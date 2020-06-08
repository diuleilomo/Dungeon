package unsw.dungeon.test;
import unsw.dungeon.Dungeon;
import unsw.dungeon.*;
import static org.junit.Assert.*;
import org.junit.Test;


public class TestFloorSwitch {
	
	@Test
	public void FloorSwitchOn() {
		
		Dungeon dungeon= new Dungeon(10, 10);
    	Player player = new Player(4,1, dungeon);
    	dungeon.setPlayer(player);
    	Boulder boulder = new Boulder(4, 2, dungeon);
    	dungeon.addEntity(boulder);
    	FloorSwitch floorswitch = new FloorSwitch(4, 2, dungeon);
    	dungeon.addEntity(floorswitch);
    	dungeon.changeState();
    	
    	assert(floorswitch.isState() == true);
    
	}
	
	@Test
	public void FloorSwitchOff() {
		
		Dungeon dungeon= new Dungeon(10, 10);
    	Player player = new Player(4,1, dungeon);
    	dungeon.setPlayer(player);
    	FloorSwitch floorswitch = new FloorSwitch(4, 2, dungeon);
    	dungeon.addEntity(floorswitch);
    	dungeon.changeState();
    	
  
    	assert(floorswitch.isState() == false);
    	
	}
}
