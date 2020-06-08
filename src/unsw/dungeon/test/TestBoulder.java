package unsw.dungeon.test;
import unsw.dungeon.Dungeon;
import unsw.dungeon.*;
import static org.junit.Assert.*;
import org.junit.Test;



public class TestBoulder {
	
	
	
	// initial cooridinate check
	@Test
	public void initialize() {
		Dungeon dungeon= new Dungeon(10, 10);
    	Player player = new Player(4,1, dungeon);
    	dungeon.setPlayer(player);
    	Boulder boulder = new Boulder(4, 2, dungeon);
		
		assert(boulder.getX() == 4);
		assert(boulder.getY() == 2);
	}
	
	// player not near the boulder
	@Test
	public void move0() {
		Dungeon dungeon= new Dungeon(10, 10);
    	Player player = new Player(1,1, dungeon);
    	dungeon.setPlayer(player);
    	Boulder boulder = new Boulder(4, 2, dungeon);

    	//assert(boulder.getMove() == 0);
	}
	
	// player on the top of boulder
	@Test
	public void move1() {
		Dungeon dungeon= new Dungeon(10, 10);
    	Player player = new Player(4,1, dungeon);
    	dungeon.setPlayer(player);
    	Boulder boulder = new Boulder(4, 2, dungeon);

    	assert(boulder.getMove() == 1);
	}
	
	// player on the right of boulder
	@Test
	public void move2() {
		Dungeon dungeon= new Dungeon(10, 10);
    	Player player = new Player(5, 2, dungeon);
    	dungeon.setPlayer(player);
    	Boulder boulder = new Boulder(4, 2, dungeon);

    	assert(boulder.getMove() == 2);
	}
	
	// player on the bottom of boulder
	@Test
	public void move3() {
		Dungeon dungeon= new Dungeon(10, 10);
    	Player player = new Player(4, 3, dungeon);
    	dungeon.setPlayer(player);
    	Boulder boulder = new Boulder(4, 2, dungeon);

    	assert(boulder.getMove() == 3);
	}
		
	// player on the left of boulder
	@Test
	public void move4() {
		Dungeon dungeon= new Dungeon(10, 10);
    	Player player = new Player(3, 2, dungeon);
    	dungeon.setPlayer(player);
    	Boulder boulder = new Boulder(4, 2, dungeon);

    	assert(boulder.getMove() == 4);
	}
	
	// check legal move
	@Test
	public void legalmove() {
		Dungeon dungeon= new Dungeon(10, 10);
    	Player player = new Player(4,1, dungeon);
    	dungeon.setPlayer(player);
    	Boulder boulder = new Boulder(4, 2, dungeon);
    	dungeon.addEntity(boulder);
    	
    	dungeon.getPlayer().setX(4);
    	dungeon.getPlayer().setY(2);
    	dungeon.changeState();
    	assert(boulder.getX() == 4);
    	assert(boulder.getY() == 3);
    	
	}
	
	// check illegal move with wall
	@Test
	public void illegalmove1() {
		Dungeon dungeon= new Dungeon(10, 10);
    	Player player = new Player(4,1, dungeon);
    	dungeon.setPlayer(player);
    	Boulder boulder = new Boulder(4, 2, dungeon);
    	dungeon.addEntity(boulder);
    	Wall wall = new Wall(4, 3);
    	dungeon.addEntity(wall);
    	
    	dungeon.getPlayer().setX(4);
    	dungeon.getPlayer().setY(2);
    	dungeon.changeState();
    	assert(boulder.getX() == 4);
    	assert(boulder.getY() == 2);
    	
	}
	
	// check illegal move with boulder
	@Test
	public void illegalmove2() {
		Dungeon dungeon= new Dungeon(10, 10);
    	Player player = new Player(4,1, dungeon);
    	dungeon.setPlayer(player);
    	Boulder boulder = new Boulder(4, 2, dungeon);
    	dungeon.addEntity(boulder);
    	Boulder boulder1 = new Boulder(4, 3, dungeon);
    	dungeon.addEntity(boulder1);
    	
    	dungeon.getPlayer().setX(4);
    	dungeon.getPlayer().setY(2);
    	dungeon.changeState();
    	assert(boulder.getX() == 4);
    	assert(boulder.getY() == 2);
    	
	}
			
		
	
	
}
