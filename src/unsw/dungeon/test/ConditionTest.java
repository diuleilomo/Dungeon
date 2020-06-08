package unsw.dungeon.test;

import unsw.dungeon.GoalTreasure;
import unsw.dungeon.Boulder;
import unsw.dungeon.Dungeon;
import unsw.dungeon.FloorSwitch;
import unsw.dungeon.GoalBoulder;
import unsw.dungeon.Treasure;
import unsw.dungeon.Player;
import static org.junit.Assert.*;
import org.junit.Test;

public class ConditionTest {

	@Test 
	public void collectTreasureTest() {
		
		Dungeon dungeon = new Dungeon(2, 2);
		Player player = new Player(0, 0, dungeon);
		Treasure t = new Treasure(0, 0, dungeon);
		Treasure t1 = new Treasure(0, 1, dungeon);
		GoalTreasure gt = new GoalTreasure(dungeon);
		
		dungeon.setPlayer(player);
		dungeon.addEntity(t);
		dungeon.addEntity(t1);
		t.changeState();
		dungeon.getPlayer().moveDown();
		t1.changeState();
		
		assert(gt.isFinished());
		
		assertTrue("treasure should be collected", dungeon.getPlayer().getTreasure() == 2);
		
	}
	
	@Test 
	public void boulderTest() {
		
		Dungeon dungeon = new Dungeon(2, 2);
		Player p = new Player(1, 1, dungeon);
		dungeon.setPlayer(p);
		dungeon.addEntity(p);
		FloorSwitch f = new FloorSwitch(0, 0, dungeon);
		Boulder b = new Boulder(0, 0, dungeon);
		FloorSwitch f1 = new FloorSwitch(0, 1, dungeon);
		Boulder b1 = new Boulder(0, 1, dungeon);
		
		GoalBoulder gt = new GoalBoulder(dungeon);
		
		dungeon.addEntity(f);
		dungeon.addEntity(b);
		dungeon.addEntity(f1);
		dungeon.addEntity(b1);
		f.changeState();
		f1.changeState();
		
		assert(gt.isFinished());
		
	}
	
}
