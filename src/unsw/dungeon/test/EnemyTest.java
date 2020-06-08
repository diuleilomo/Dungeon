package unsw.dungeon.test;
import unsw.dungeon.Dungeon;
import org.junit.Before;
import unsw.dungeon.Enemy;
import unsw.dungeon.Player;
import unsw.dungeon.Potion;
import static org.junit.Assert.*;
import org.junit.Test;

public class EnemyTest {

	Dungeon dungeon;
	Enemy enemy;
	Player player;
	
	@Before
	public void init_enemy() {
		dungeon = new Dungeon(6, 6);
		enemy = new Enemy(2,0,dungeon);
		player = new Player(0,0,dungeon);
		dungeon.setPlayer(player);
	}
	@Test
	public void can_not_kill_by_normal_player() {
		player.moveRight();
		player.moveRight();
		enemy.changeState();
		assertTrue(enemy.getX() == 2);
		assertTrue(enemy.getY() == 0);
	}
	@Test
	public void killed_by_invincible() {
		player.addPotion();
		assertTrue(player.getPotion() == 10);
		assertTrue(player.getX() == 0);
		
		// invincible player move toward enemy
		player.moveRight();
		player.changeState();
		assertTrue(player.getPotion() == 9);
		player.moveRight();
		player.changeState();
		assertTrue(player.getX() != 0);
		enemy.changeState();
		assertFalse(enemy.getX() == 2);
	}
	
}
