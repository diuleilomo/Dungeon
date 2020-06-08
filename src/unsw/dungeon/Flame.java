package unsw.dungeon;

public class Flame extends Entity {

	private boolean state;
	private int count;
	private Dungeon dungeon;
	
	public Flame(int x, int y, Dungeon dungeon) {
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
				dungeon.removeEntities(this);
			}
		}
	}

}
