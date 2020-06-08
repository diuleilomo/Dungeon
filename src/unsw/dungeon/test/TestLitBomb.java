package unsw.dungeon.test;
import unsw.dungeon.Dungeon;
import unsw.dungeon.*;
import static org.junit.Assert.*;
import org.junit.Test;


public class TestLitBomb {
	
	@Test
	public void LitBombCountdown() {
		
		Dungeon dungeon= new Dungeon(10, 10);
    	LitBomb bomb = new LitBomb(4,1, dungeon);
    	dungeon.addEntity(bomb);
    	dungeon.changeState();
    	dungeon.changeState();
    	assert(bomb.getX() == 4);
    	assert(bomb.getY() == 1);
    	
	}
	
	@Test
	public void LitBombExplode() {
		
		Dungeon dungeon= new Dungeon(10, 10);
    	Player player = new Player(4, 1, dungeon);
    	dungeon.setPlayer(player);
    	LitBomb bomb = new LitBomb(4, 1, dungeon);
    	dungeon.addEntity(bomb);
    	dungeon.changeState();
    	dungeon.changeState();
    	dungeon.changeState();
      	dungeon.changeState();
    	assert(bomb.getX() == dungeon.getWidth());
    	assert(bomb.getY() == dungeon.getHeight());
    	
	}
	
	@Test
	public void LitBombExplodeUp() {
		
		Dungeon dungeon= new Dungeon(10, 10);
    	Player player = new Player(4, 1, dungeon);
    	dungeon.setPlayer(player);
    	dungeon.addEntity(player);
    	LitBomb bomb = new LitBomb(4, 2, dungeon);
    	dungeon.addEntity(bomb);
    	dungeon.changeState();
    	dungeon.changeState();
    	dungeon.changeState();
      	dungeon.changeState();
      	assert(player.getX() == dungeon.getWidth());
    	assert(player.getY() == dungeon.getHeight());
    	assert(bomb.getX() == dungeon.getWidth());
    	assert(bomb.getY() == dungeon.getHeight());
    	
	}
	
	@Test
	public void LitBombExplodeDown() {
		
		Dungeon dungeon= new Dungeon(10, 10);
    	Player player = new Player(4, 3, dungeon);
    	dungeon.setPlayer(player);
    	dungeon.addEntity(player);
    	LitBomb bomb = new LitBomb(4, 2, dungeon);
    	dungeon.addEntity(bomb);
    	dungeon.changeState();
    	dungeon.changeState();
    	dungeon.changeState();
      	dungeon.changeState();
      	assert(player.getX() == dungeon.getWidth());
    	assert(player.getY() == dungeon.getHeight());
    	assert(bomb.getX() == dungeon.getWidth());
    	assert(bomb.getY() == dungeon.getHeight());
    	
	}
	
	@Test
	public void LitBombExplodeLeft() {
		
		Dungeon dungeon= new Dungeon(10, 10);
    	Player player = new Player(3, 2, dungeon);
    	dungeon.setPlayer(player);
    	dungeon.addEntity(player);
    	LitBomb bomb = new LitBomb(4, 2, dungeon);
    	dungeon.addEntity(bomb);
    	dungeon.changeState();
    	dungeon.changeState();
    	dungeon.changeState();
      	dungeon.changeState();
      	assert(player.getX() == dungeon.getWidth());
    	assert(player.getY() == dungeon.getHeight());
    	assert(bomb.getX() == dungeon.getWidth());
    	assert(bomb.getY() == dungeon.getHeight());
    	
	}
	
	@Test
	public void LitBombExplodeRight() {
		
		Dungeon dungeon= new Dungeon(10, 10);
    	Player player = new Player(5, 2, dungeon);
    	dungeon.setPlayer(player);
    	dungeon.addEntity(player);
    	LitBomb bomb = new LitBomb(4, 2, dungeon);
    	dungeon.addEntity(bomb);
    	dungeon.changeState();
    	dungeon.changeState();
    	dungeon.changeState();
      	dungeon.changeState();
      	assert(player.getX() == dungeon.getWidth());
    	assert(player.getY() == dungeon.getHeight());
    	assert(bomb.getX() == dungeon.getWidth());
    	assert(bomb.getY() == dungeon.getHeight());
    	
	}
	
	@Test
	public void LitBombExplodeCenter() {
		
		Dungeon dungeon= new Dungeon(10, 10);
    	Player player = new Player(4, 2, dungeon);
    	dungeon.setPlayer(player);
    	dungeon.addEntity(player);
    	LitBomb bomb = new LitBomb(4, 2, dungeon);
    	dungeon.addEntity(bomb);
    	dungeon.changeState();
    	dungeon.changeState();
    	dungeon.changeState();
      	dungeon.changeState();
      	assert(player.getX() == dungeon.getWidth());
    	assert(player.getY() == dungeon.getHeight());
    	assert(bomb.getX() == dungeon.getWidth());
    	assert(bomb.getY() == dungeon.getHeight());
    	
	}
	
	@Test
	public void LitBombExplodeNotinRange() {
		
		Dungeon dungeon= new Dungeon(10, 10);
    	Player player = new Player(7, 2, dungeon);
    	dungeon.setPlayer(player);
    	dungeon.addEntity(player);
    	LitBomb bomb = new LitBomb(4, 2, dungeon);
    	dungeon.addEntity(bomb);
    	dungeon.changeState();
    	dungeon.changeState();
    	dungeon.changeState();
      	dungeon.changeState();
      	assert(player.getX() == 7);
    	assert(player.getY() == 2);
    	assert(bomb.getX() == dungeon.getWidth());
    	assert(bomb.getY() == dungeon.getHeight());
    	
	}
	
	
	
	
}
