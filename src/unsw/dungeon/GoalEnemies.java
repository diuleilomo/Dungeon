package unsw.dungeon;

import java.util.List;

public class GoalEnemies implements Goal{

	private Dungeon dungeon;
	
	public GoalEnemies(Dungeon dungeon) {
		this.dungeon = dungeon;
	}
	
	@Override
	public boolean isFinished() {
		List<Entity> entities = dungeon.getEntities();
		for (Entity e : entities) {
			if (e instanceof Enemy) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "Destroyed all enemies.";
	}
	
}
