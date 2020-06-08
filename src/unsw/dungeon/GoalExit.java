package unsw.dungeon;

import java.util.List;

public class GoalExit implements Goal{

	private Dungeon dungeon;
	
	public GoalExit(Dungeon dungeon) {
		this.dungeon = dungeon;
	}
	@Override
	public boolean isFinished() {
		List<Entity> entities = dungeon.getEntities();
		for (Entity e : entities) {
			if (e instanceof Exit) {
				if (dungeon.getPlayer().getX() == e.getX() && dungeon.getPlayer().getY() == e.getY() && dungeon.goalCheck()) {
					System.out.println("You win the game");
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Reach exit.";
	}

}
