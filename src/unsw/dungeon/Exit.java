package unsw.dungeon;

public class Exit extends Entity {

	private Dungeon dungeon;
	private boolean state;
	
	public Exit(int x, int y, Dungeon dungeon) {
		super(x, y);
		this.dungeon = dungeon;
		this.state = false;
	}

	public boolean getState() {
		return this.state;
	}
	
	@Override
	public void changeState() {
		if (dungeon.getPlayer().getX() == getX() && dungeon.getPlayer().getY() == getY() && dungeon.goalCheck()) {
			this.state = true;
			System.out.println("You win the game");
		}
		System.out.println("You haven't finish all the goals");
	}

}
