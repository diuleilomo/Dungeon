package unsw.dungeon;

public class Potion extends Entity {

	private Dungeon dungeon;
	
	public Potion(int x, int y, Dungeon dungeon) {
		super(x, y);
		this.dungeon = dungeon;
	}

    // become invicible
		public void get_potion() {
			dungeon.getPlayer().addPotion();
		}
	
	@Override
	public void changeState() {
		if (dungeon.getPlayer().getX() == getX() && dungeon.getPlayer().getY() == getY()) {
			if(dungeon.getPlayer().getPotion() == 0) {
    			dungeon.getPlayer().addPotion();
    			System.out.println("Invincible potion is used");
    			x().set(100);
    			y().set(100);
			}else {
				System.out.println("!!You can not use more than one potion at a time");
			}
		}
	}
}
