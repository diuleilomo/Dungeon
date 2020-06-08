package unsw.dungeon;

public class Key extends Entity {

	private Dungeon dungeon;
	private String color;
	
	public Key(int x, int y, Dungeon dungeon, String color) {
		super(x, y);
		this.dungeon = dungeon;
		this.color = color;
	}

	// get color of the key
	public String getColor() {
		return this.color;
	}
	
	// collect a key
	public void collectKey() {
		if (dungeon.getPlayer().getKeyNum() == 0) {
			dungeon.getPlayer().addKey();
			dungeon.getPlayer().setKeyColor(this.getColor());
			System.out.println("You collect a " + this.getColor() +" key.");
			dungeon.removeEntities(this);
		} else {
			System.out.println("You have a key already." + " Please use it first.");
		}
	}

	@Override
	public void changeState() {
		if (dungeon.getPlayer().getX() == getX() && dungeon.getPlayer().getY() == getY()) {
				collectKey();
		}
	}
}
