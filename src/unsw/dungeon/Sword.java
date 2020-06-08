package unsw.dungeon;

public class Sword extends Entity {

	private Dungeon dungeon;
	
	public Sword(int x, int y, Dungeon dungeon) {
			super(x, y);
			this.dungeon = dungeon;
			// each sword is capable for 5 hits
			
	}
	
	// carry a sword
	public void get_sword() {
		dungeon.getPlayer().addSword();
	}
	
	@Override
	public void changeState() {
		if (dungeon.getPlayer().getX() == getX() && dungeon.getPlayer().getY() == getY()) {
			if (dungeon.getPlayer().getSword() == 0) {
    			dungeon.getPlayer().addSword();
    			System.out.println("You have picked up a sword, press 'K' to use the sword");
    			x().set(dungeon.getWidth());
    			y().set(dungeon.getHeight());
			} else {
				System.out.println("!! You can only hold one sword at a time");
			}
		}
	}
}
