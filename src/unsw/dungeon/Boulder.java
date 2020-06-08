package unsw.dungeon;

import java.util.List;

public class Boulder extends Entity {
	
	private Dungeon dungeon;
	private int move;
	
	
	public Boulder (int x, int y, Dungeon dungeon) {
		super(x, y);
        this.dungeon = dungeon;
        this.move = 0;
        this.changeState();
	}
	
	@Override
	public void changeState() {
		
		int playerX = dungeon.getPlayer().getX();
		int playerY = dungeon.getPlayer().getY();
		
		if (this.move == 0) {
			
			if (playerX == this.getX() && playerY == this.getY() - 1) {
				this.move = 1;
			} else if (playerX == this.getX() && playerY == this.getY() + 1) {
				this.move = 3;
			} else if (playerY == this.getY() && playerX == this.getX() + 1) {
				this.move = 2;
			} else if (playerY == this.getY() && playerX == this.getX() - 1) {
				this.move = 4;
			} else {
				this.move = 0;
			}
		
		} else {
			if (playerX == this.getX() && playerY == this.getY()) {
				if (this.move == 1) {
					if (moveCheck(getX(), getY()+1) == true) {
						y().set(getY()+1);
					}
				} else if (this.move == 2) {
					if (moveCheck(getX()-1, getY()) == true) {
						x().set(getX()-1);
					}
				} else if (this.move == 3) {
					if (moveCheck(getX(), getY()-1) == true) {
						y().set(getY()-1);
					}
				} else if (this.move == 4) {
					if (moveCheck(getX()+1, getY()) == true) {
						x().set(getX()+1);
					}
				}
			} else {
				this.move = 0;
			}
		}
		
	}
	
	
	public boolean moveCheck(int targetX, int targetY) {
		
		if (targetX < 0 || targetX > dungeon.getWidth()-1 || targetY < 0 || targetY > dungeon.getHeight()-1) {
			return false;
		}
		
		List<Entity> entities = dungeon.getEntities();
		
		for (Entity entity : entities) {
			if (entity instanceof Wall || entity instanceof Boulder) {
				if (entity.getX() == targetX && entity.getY() == targetY) {
					return false;
				}
			}
		}
		
		return true;
	}

	public int getMove() {
		return this.move;
	}

}
