package unsw.dungeon;
import java.math.*;


public class KillState implements EnemyState {

	private Enemy enemy;
	private Dungeon dungeon;
	
	public KillState(Enemy enemy, Dungeon dungeon) {
		this.enemy = enemy;
		this.dungeon = dungeon;
	}
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		int sourceX = this.enemy.getX();
		int sourceY = this.enemy.getY();
		int targetX = this.dungeon.getPlayer().getX();
		int targetY = this.dungeon.getPlayer().getY();
		int ydiff = sourceY-targetY;
		int xdiff = sourceX-targetX;
		boolean[] move = {true, true, true, true};
		canMove(move);
		int way = way(move);
		//System.out.println("can move in "+ way + " way");
		//System.out.println("xdiff: " + xdiff);
		//System.out.println("ydiff: " + ydiff);
		
		// open unblock case direct counter
		if (sourceX == targetX && sourceY > targetY && move[0] == true) {
			this.enemy.moveUp();
			return;
		} else if (sourceX < targetX && sourceY == targetY && move[1] == true) {
			this.enemy.moveRight();
			return;
		} else if (sourceX == targetX && sourceY < targetY && move[2] == true) {
			this.enemy.moveDown();
			return;
		} else if (sourceX > targetX && sourceY == targetY && move[3] == true) {
			this.enemy.moveLeft();
			return;
		} 
		
		// trap in dead end
		if (way == 1) {
			if (move[0] == true) {this.enemy.moveUp(); return;}
			if (move[1] == true) {this.enemy.moveRight(); return;}
			if (move[2] == true) {this.enemy.moveDown(); return;}
			if (move[3] == true) {this.enemy.moveLeft(); return;}
		// two way scenario
		} else if (way == 2) {
			
			if (move[0] == true && move[2] == true) {
				if (ydiff > 0) {this.enemy.moveUp(); return;}
				else {this.enemy.moveDown(); return;}
			} else if (move[1] == true && move[3] == true) {
				if (xdiff > 0) {this.enemy.moveLeft(); return;}
				else {this.enemy.moveRight(); return;}
			} else {
				if (ydiff > xdiff) {
					if (move[0] == true) {this.enemy.moveUp(); return;}
					if (move[2] == true) {this.enemy.moveDown(); return;}
				} else {
					if (move[1] == true) {this.enemy.moveRight(); return;}
					if (move[3] == true) {this.enemy.moveLeft(); return;}
				}
			}
		//	three way scenario
		} else if (way == 3) {
			if (move[0] == false) {
				if (ydiff < 0) {
					this.enemy.moveDown(); return;
				} else {
					if (xdiff > 0) {
						this.enemy.moveLeft(); return;
					} else {
						this.enemy.moveRight(); return;
					}	
				}
			} else if (move[1] == false) {
				if (xdiff > 0) {
					this.enemy.moveLeft(); return;
				} else {
					if (ydiff > 0) {
						this.enemy.moveUp(); return;
					} else {
						this.enemy.moveDown(); return;
					}	
				}	
			} else if (move[2] == false) {
				if (ydiff > 0) {
					this.enemy.moveUp(); return;
				} else {
					if (xdiff > 0) {
						this.enemy.moveLeft(); return;
					} else {
						this.enemy.moveRight(); return;
					}	
				}
				
			} else if (move[3] == false) {
				if (xdiff < 0) {
					this.enemy.moveRight(); return;
				} else {
					if (ydiff > 0) {
						this.enemy.moveUp(); return;
					} else {
						this.enemy.moveDown(); return;
					}	
				}	
			}
		} else if (way == 4)  {
			if (ydiff < xdiff) {
				if (ydiff > 0) {
					this.enemy.moveUp(); return;
				} else {
					this.enemy.moveDown(); return;
				}
			} else {
				if (xdiff > 0) {
					this.enemy.moveLeft(); return;
				} else {
					this.enemy.moveRight(); return;
				}	
			}
		}	
		
	}
	
	public int way(boolean[] array) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == true) {
				count++;
			}
		}
		return count;
	}

	public boolean[] canMove(boolean[] array) {
		int x = this.enemy.getX();
		int y = this.enemy.getY();
		
		//System.out.println("Enemy position x= " + x + " y= " + y);
		
		Entity[] temp = new Entity[4];
		temp[0] = dungeon.checkLocation(x, y-1);
		temp[1] = dungeon.checkLocation(x+1, y);
		temp[2] = dungeon.checkLocation(x, y+1);
		temp[3] = dungeon.checkLocation(x-1, y);
		
		// for objects in the game
		for (int i = 0; i < 4; i++) {
			if (temp[i] instanceof Wall || temp[i] instanceof Boulder) {
				array[i] = false;
			} else if (temp[i] instanceof Door) {
				Door door = (Door)temp[i];
				if (door.getStage() == false) {
					array[i] = false;
				}
			}
		}
		
		// for boarder
		if (x == 0) array[3] = false;
		if (x == dungeon.getWidth()) array[1] = false;
		if (y == 0) array[0] = false;
		if (y == dungeon.getHeight()) array[4] = false;
		
		return array;
	}

}
