package unsw.dungeon.test;
import unsw.dungeon.Dungeon;
import org.junit.Before;
import unsw.dungeon.Potion;
import unsw.dungeon.Player;
import static org.junit.Assert.*;
import org.junit.Test;

public class PotionTest {
	Dungeon dungeon;
	Potion potion1;
	Potion potion2;
	Player John;
	
	@Before
	public void init_potion() {
		dungeon = new Dungeon(10, 10);
		potion1 = new Potion(2,2,dungeon);
		potion2 = new Potion(0,1,dungeon);
		John = new Player(0,0,dungeon);
		dungeon.setPlayer(John);
	}
	
	@Test
	public void pick_up_potion_test() {
		assertTrue("player is not invincible", John.getPotion() == 0);
		John.moveRight();
		John.moveDown();
		System.out.println("player move to Potion's position\n");
		John.addPotion();
		potion1.changeState();
		John.changeState();
		assertTrue(John.getPotion() > 0);
	}
	
	@Test
	public void invincible_time_test() {
		// once the player has successfully pick up a potion from its position:
		pick_up_potion_test();
		
		// move two steps
		John.moveDown();
		John.moveLeft();
		// potion only last for limit steps
		assertFalse(John.getPotion() == 10);
		John.changeState();
		while (John.getPotion() > 0) {
			John.moveRight();
			John.changeState();
		}
		// invincible potion exceed limit number of steps
		assertTrue(John.getPotion() == 0);
	}
	
	@Test
	public void max_num_potion() {
		Dungeon dungeon = new Dungeon(10, 10);
		potion1.setX(5);
		potion1.setY(1);
		potion2.setX(7);
		potion2.setY(1);
		John.setX(4);
		John.setY(1);
		assertTrue("player is not invincible", John.getPotion() == 0);
		
		John.moveRight();
		potion1.get_potion();
		John.changeState();
		assertTrue(John.getPotion() > 0);
		System.out.printf("Invincible power will last for: ", Integer.toString(John.getPotion()), " steps");
		
		John.moveRight();
		John.moveRight();
		potion2.get_potion();
		System.out.printf("Invincible power will now last for: ", Integer.toString(John.getPotion()), " steps");
		// unable to pick up another potion when the player is invincible
	
		John.changeState();
		assertTrue(John.getPotion() != 10);
		
	}
	
}
