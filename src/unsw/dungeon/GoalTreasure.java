package unsw.dungeon;

import java.util.List;

public class GoalTreasure implements Goal{
	
	private Dungeon dungeon;
	
	public GoalTreasure (Dungeon dungeon) {
		this.dungeon = dungeon;
	}

	@Override
	public boolean isFinished() {
		List<Entity> entities = dungeon.getEntities();
		for (Entity e : entities) {
			if (e instanceof Treasure) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "Collect all treasures.";
	}
}
