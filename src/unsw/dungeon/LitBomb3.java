package unsw.dungeon;

import java.util.ArrayList;
import java.util.List;

public class LitBomb3 extends Entity {

	private boolean state;
	private int count;
	private Dungeon dungeon;
	
	public LitBomb3(int x, int y, Dungeon dungeon) {
		super(x, y);
		this.state = false;
		this.count = -1;
		this.dungeon = dungeon;
	}
	
	public boolean isState() {
		return state;
	}

	public void activate() {
		this.state = true;
		this.count = 2;
	}

	@Override
	public void changeState() {
		// TODO Auto-generated method stub
		if (this.state == true) {
			count--;
			
			if (count == 0) {
				List<Entity> entities = new ArrayList<>();
				
				for (int i = 0; i < dungeon.getEntities().size(); i++) {
					if (inRange(dungeon.getEntities().get(i))) {
						//System.out.println("Bomb loop i: " + i);
						dungeon.getEntities().get(i).setX(dungeon.getWidth());
						dungeon.getEntities().get(i).setY(dungeon.getHeight());
						if (dungeon.getEntities().get(i) instanceof Enemy) {
							Enemy enemy = (Enemy) dungeon.getEntities().get(i);
							enemy.setAlive(false);
						}
					
					}
				}
				
				Flame temp = (Flame)dungeon.findClassEntity("class unsw.dungeon.Flame");
				temp.setX(this.getX());
				temp.setY(this.getY());
				temp.activate();
				dungeon.removeEntities(this);
			}
		}
	}
	
	public boolean inRange(Entity entity) {
		
		if (entity == null) return false;	
		int bombx = getX();
		int bomby = getY();
		int x = entity.getX();
		int y = entity.getY();
		
		if ((x == bombx && y == bomby) || (x == bombx-1 && y == bomby) ||
			(x == bombx+1 && y == bomby) || (x == bombx && y == bomby-1) ||
			(x == bombx && y == bomby+1)) {
			if (entity instanceof Player || entity instanceof Boulder || entity instanceof Enemy) {//add enemy
				System.out.println(this.getClass().toString());
				System.out.println(x);
				System.out.println(y);
				return true;
			}
		}
		return false;
	}

}

