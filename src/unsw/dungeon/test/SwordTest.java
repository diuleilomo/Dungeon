package unsw.dungeon.test;
import unsw.dungeon.Dungeon;
import org.junit.Before;
import unsw.dungeon.Sword;
import unsw.dungeon.Player;
import static org.junit.Assert.*;
import org.junit.Test;

public class SwordTest {
	Dungeon dungeon;
	Sword sword1;
	Sword sword2;
	Player John;
	
	@Before
	public void init_Sword() {
		dungeon = new Dungeon(10, 10);
		sword1 = new Sword(3,2,dungeon);
		sword2 = new Sword(1,1,dungeon);
		John = new Player(0,0,dungeon);
		dungeon.setPlayer(John);
	}
	
	@Test
	public void pick_up_Sword_test() {
		assertTrue("player is not invincible", John.getSword() == 0);
		John.moveRight();
		John.moveDown();
		John.addSword();
		sword1.changeState();
		John.changeState();
		assertTrue(John.getSword() > 0);
	}
	
	@Test
	public void use_sword_test() {
		// once the player has successfully pick up a Sword from its position:
		pick_up_Sword_test();
		
		// move two steps
		John.moveDown();
		John.moveLeft();
		

		// Sowrd will not be used until 'K' is press which invoke the use_sowrd function
		assertTrue(John.getSword() == 5);
		
		while (John.getSword() > 0) {
			John.useSword();
			John.changeState();
		}
		sword1.changeState();
		// invincible Sword exceed limit number of steps
		assertTrue(John.getSword() == 0);
	}
	
	@Test
	public void max_num_Sword() {
		Dungeon dungeon = new Dungeon(10, 10);
		sword1.setX(6);
		sword1.setY(2);
		sword2.setX(8);
		sword2.setY(2);
		John.setX(5);
		John.setY(2);
		assertTrue("player does not have a sword", John.getSword() == 0);
		
		// move one step to get the first sword, with 5 hits
		John.moveRight();
		sword1.get_sword();
		John.getSword();
		assertTrue(John.getSword() == 5);
		
		John.moveRight();
		John.useSword();
		assertTrue(John.getSword() == 4);
		John.useSword();
		assertTrue(John.getSword() == 3);
		John.useSword();
		assertTrue(John.getSword() == 2);
		John.useSword();
		assertTrue(John.getSword() == 1);
		John.useSword();
		assertTrue(John.getSword() == 0);
		
		// pick up another sword, # hits increase
		sword2.get_sword();
		
		// unable to pick up another Sword
		assertTrue(John.getSword() == 5);
		
	}
	
}