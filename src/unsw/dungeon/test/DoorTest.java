package unsw.dungeon.test;

import unsw.dungeon.Door;
import unsw.dungeon.Dungeon;
import static org.junit.Assert.*;
import org.junit.Test;

public class DoorTest {

	@Test 
	public void initialDoorTest() {
		
		Dungeon dungeon = new Dungeon(2, 2);
		Door door = new Door(0, 0, dungeon, "Yellow");
		
		assertTrue("the door should closed when initiate", door.getStage() == false);
	}
	
	@Test
	public void unlockTest() {
		
		Dungeon dungeon = new Dungeon(2, 2);
		Door door = new Door(0, 0, dungeon, "Red");
		
		assertTrue("the door should closed when initiate", door.getStage() == false);
		
		door.changeState();
		assertTrue("the door should be opened when use key unlock", door.getStage());
	}
}
