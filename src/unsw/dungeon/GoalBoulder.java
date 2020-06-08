package unsw.dungeon;

import java.util.List;

public class GoalBoulder implements Goal{

	private Dungeon dungeon;
	
	public GoalBoulder(Dungeon dungeon) {
		this.dungeon = dungeon;
	}
	
	@Override
	public boolean isFinished() {
		
		int flag = 0;
		List<Entity> entities = dungeon.getEntities();
		for (Entity e : entities) {
			if (e instanceof FloorSwitch) {
				flag++;
				int x = e.getX();
				int y = e.getY();
				for (Entity i: entities) {
					if (i instanceof Boulder) {
						if (i.getX() == x && i.getY() == y) {
							flag--;
						}
					}
				}
			}
		}
		System.out.println(flag);
		if (flag == 0) return true;
		else return false;
	}
	
	@Override
	public String toString() {
		return "All floor switches has a boulder";
	}
}
