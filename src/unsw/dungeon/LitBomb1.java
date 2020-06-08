package unsw.dungeon;

public class LitBomb1 extends Entity {

	private boolean state;
	private int count;
	private Dungeon dungeon;
	
	public LitBomb1(int x, int y, Dungeon dungeon) {
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
				LitBomb2 temp = (LitBomb2) dungeon.findClassEntity("class unsw.dungeon.LitBomb2");
				temp.setX(this.getX());
				temp.setY(this.getY());
				temp.activate();
				dungeon.removeEntities(this);
			}
		}
	}

}
