package unsw.dungeon.test;

import unsw.dungeon.Wall;
import unsw.dungeon.Player;
import unsw.dungeon.Dungeon;
import static org.junit.Assert.*;
import org.junit.Test;


public class PlayerTest {

	@Test
	public void leftWallBlockPlayerTest() {
		
		// initialize
		Dungeon dungeon = new Dungeon(3, 3);
		Player player = new Player(1, 1, dungeon);
		Wall wall = new Wall(0, 1);
		dungeon.setPlayer(player);
		dungeon.addEntity(wall);
		
		// left move block
		player.moveLeft();
		assertTrue("the player is blocked at the same position", (player.getX() == 1 && player.getY() == 1));
		
		// the player can move to the other directions
		player.moveRight();
		assertTrue("the player can move to the right", (player.getX() == 1 && player.getY() == 1) == false);
		player.moveUp();
		assertTrue("the player can move up", (player.getX() == 1 && player.getY() == 1) == false);
		player.moveDown();
		assertTrue("the player can move down", (player.getX() == 1 && player.getY() == 1) == false);
	}
	
	@Test
	public void rightWallBlockPlayerTest() {
		
		// initialize
		Dungeon dungeon = new Dungeon(3, 3);
		Player player = new Player(1, 1, dungeon);
		Wall wall = new Wall(2, 1);
		dungeon.setPlayer(player);
		dungeon.addEntity(wall);
		
		// right move block
		player.moveRight();
		assertTrue("the player is blocked at the same position", (player.getX() == 1 && player.getY() == 1));
		
		// the player can move to the other directions
		player.moveLeft();
		assertFalse("the player can move to the left", player.getX() == 1 && player.getY() == 1);
		player.moveUp();
		assertFalse("the player can move up", player.getX() == 1 && player.getY() == 1);
		player.moveDown();
		assertFalse("the player can move down", player.getX() == 1 && player.getY() == 1);
	}
	
	@Test
	public void upWallBlockPlayerTest() {
		
		// initialize
		Dungeon dungeon = new Dungeon(3, 3);
		Player player = new Player(1, 1, dungeon);
		Wall wall = new Wall(1, 0);
		dungeon.setPlayer(player);
		dungeon.addEntity(wall);
		
		// right move block
		player.moveUp();
		assertTrue("the player is blocked at the same position", player.getX() == 1 && player.getY() == 1);
		
		// the player can move to the other directions
		player.moveLeft();
		assertFalse("the player can move to the left", player.getX() == 1 && player.getY() == 1);
		player.moveRight();
		assertTrue("the player can move to the right", player.getX() == 1 && player.getY() == 1);
		player.moveDown();
		assertFalse("the player can move down", player.getX() == 1 && player.getY() == 1);
	}
	
	@Test
	public void downWallBlockPlayerTest() {
		
		// initialize
		Dungeon dungeon = new Dungeon(3, 3);
		Player player = new Player(1, 1, dungeon);
		Wall wall = new Wall(1, 2);
		dungeon.setPlayer(player);
		dungeon.addEntity(wall);
		
		// right move block
		player.moveDown();
		assertTrue("the player is blocked at the same position", player.getX() == 1 && player.getY() == 1);
		
		// the player can move to the other directions
		player.moveLeft();
		assertFalse("the player can move to the left", player.getX() == 1 && player.getY() == 1);
		player.moveRight();
		assertTrue("the player can move to the right", player.getX() == 1 && player.getY() == 1);
		player.moveUp();
		assertFalse("the player can move up", player.getX() == 1 && player.getY() == 1);
	}
	
	@Test
	public void noWallsTest() {
		// initialize
		Dungeon dungeon = new Dungeon(3, 3);
		Player player = new Player(1, 1, dungeon);
		dungeon.setPlayer(player);
		
		player.moveUp();
		assertFalse("the player can move up", player.getX() == 1 && player.getY() == 1);
		player.moveDown();
		assertTrue("the player can move down", player.getX() == 1 && player.getY() == 1);
		player.moveLeft();
		assertFalse("the player can move to the left", player.getX() == 1 && player.getY() == 1);
		player.moveRight();
		assertTrue("the player can move to the right", player.getX() == 1 && player.getY() == 1);
		
	}

}
