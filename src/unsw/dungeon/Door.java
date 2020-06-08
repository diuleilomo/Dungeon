package unsw.dungeon;

public class Door extends Entity {

	private Dungeon dungeon;
	private boolean doorOpen;
	private String color;
	
	public Door(int x, int y, Dungeon dungeon, String color) {
		super(x, y);
		this.dungeon = dungeon;
		this.doorOpen = false;
		this.color = color;
	}
	
	public String getColor() {
		return this.color;
	}
	
	// open the door
	public void openDoor(String color) {
		if (dungeon.getPlayer().getKeyNum() == 1) {
			if (dungeon.getPlayer().getKeyColor().equals(color)) {
				this.doorOpen = true;
				dungeon.getPlayer().useKey();
				dungeon.removeEntities(this);
				System.out.println("Door opened.");
			} else {
				System.out.println("Key color not matches Door color.");
			}
		} else {
			System.out.println("You haven't collect a key yet.");
		}
	}
	
	// check whether the door is open or not
	public boolean getStage() {
		return this.doorOpen;
	}
	
	@Override
	public void changeState() {
		if (dungeon.getPlayer().getX() == getX() && dungeon.getPlayer().getY() == getY()) {
			openDoor(this.getColor());
		}
	}

	public Dungeon getDungeon() {
		return this.dungeon;
	}
}
