package unsw.dungeon.test;

import unsw.dungeon.Key;
import unsw.dungeon.Door;
import unsw.dungeon.Player;
import unsw.dungeon.Dungeon;
import static org.junit.Assert.*;
import org.junit.Test;

public class KeyTest {

	@Test
	public void collectKeyTest() {
		
		// initiate
		Dungeon dungeon = new Dungeon(2, 2);
		Player player = new Player(0, 0, dungeon);
		dungeon.setPlayer(player);
		Key key = new Key(0, 0, dungeon, "Yellow");
		assertTrue("player does not have any key at the moment", player.getKeyNum() == 0);
		
		// collect key
		key.collectKey();
		assertTrue("the player should keep one key", player.getKeyNum() == 1);
	}
	
	@Test
	public void useKeyTest() {
		
		// initiate
		Dungeon dungeon = new Dungeon(2, 2);
		Player player = new Player(0, 0, dungeon);
		dungeon.setPlayer(player);
		Key key = new Key(0, 0, dungeon, "Red");
		Door door = new Door(0, 1, dungeon,"Yellow");
		assertTrue("player does not have any key at the moment", player.getKeyNum() == 0);
		assertTrue("the door should closed when initiate", door.getStage() == false);

		// collect the key
		key.collectKey();
		assertTrue("the player should keep one key", player.getKeyNum() == 1);
		
		// move down and use the key
		player.moveDown();
		door.changeState();
		assertTrue("the player should move down to (0, 1)", (player.getX() == 0 && player.getY() == 1));
		assertTrue("the player should use the key to unlock the door", player.getKeyNum() == 0);
		assertTrue("the door should be opened when use key unlock", door.getStage());
	}
	
	@Test
	public void collectTwoKeys() {
		
		// initiate
		Dungeon dungeon = new Dungeon(2, 2);
		Player player = new Player(0, 0, dungeon);
		dungeon.setPlayer(player);
		Key key1 = new Key(0, 0, dungeon, "Red");
		Key key2 = new Key(0, 1, dungeon, "Yellow");
		
		// collect one key
		key1.collectKey();
		assertTrue("the player should keep one key", player.getKeyNum() == 1);
		
		// move down and failed to collect the second key
		player.moveDown();
		key2.changeState();
		assertTrue("the player should move down to (0, 1)", (player.getX() == 0 && player.getY() == 1));
		assertTrue("the key number should be 1", player.getKeyNum() == 1);
	}

}
