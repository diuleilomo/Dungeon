package unsw.dungeon;

public class LitBomb2 extends Entity {

	private boolean state;
	private int count;
	private Dungeon dungeon;
		
	public LitBomb2(int x, int y, Dungeon dungeon) {
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
		if (this.state == true) {
			count--;
			
			if (count == 0) {
				LitBomb3 temp = (LitBomb3) dungeon.findClassEntity("class unsw.dungeon.LitBomb3");
				temp.setX(this.getX());
				temp.setY(this.getY());
				temp.activate();
				dungeon.removeEntities(this);
			}
		}

	}

}
