package unsw.dungeon;

import java.util.List;

public class FloorSwitch extends Entity {
	
		private Dungeon dungeon;
		private boolean state;
	
		public FloorSwitch(int x, int y, Dungeon dungeon) {
			super(x, y);
			this.dungeon = dungeon;
			this.state = false;
		}
	
		public boolean isState() {
			return state;
		}
		
		@Override
		public void changeState() {
			
			List<Entity> entities = dungeon.getEntities();
			for (Entity entity : entities) {
	    		if (entity instanceof Boulder && entity.getX() == getX() && entity.getY() == getY()) {
	    			this.state = true;
	    			System.out.println("Floorswitch on"); //debug ouput
	    			break;
	    		}
	    	this.state = false;
			}
		}

}
		
