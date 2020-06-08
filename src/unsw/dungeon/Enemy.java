package unsw.dungeon;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;


public class Enemy extends Entity implements Observer {
	
	private EnemyState state;
	private Dungeon dungeon;
	private boolean alive;
	
	public Enemy(int x, int y, Dungeon dungeon) {
		super(x, y);
		this.state = new KillState(this, dungeon);
		this.dungeon = dungeon;  
		this.alive = true;
	}
	
 	public boolean isAlive() {
		return alive;
	}
 	
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public void moveUp() {
        if (getY() > 0 && moveCheck(getX(), getY()-1, 1)) {
            y().set(getY() - 1);
            //System.out.println("enemy up");
        }
    }

	public void moveDown() {
        if ((getY() < dungeon.getHeight() - 1) && moveCheck(getX(), getY()+1, 3))
            y().set(getY() + 1);
        	//System.out.println("enemy down");
    }

    public void moveLeft() {
        if ((getX() > 0) && moveCheck((getX() - 1), getY(), 4))
            x().set(getX() - 1);
        	//System.out.println("enemy left");
    }

    public void moveRight() {
        if ((getX() < dungeon.getWidth() - 1) && moveCheck(getX() + 1, getY(), 2))
            x().set(getX() + 1);
        	//System.out.println("enemy right");
    }
    
    public boolean moveCheck(int targetX, int targetY, int direction) {
		
		List<Entity> entities = dungeon.getEntities();
		
		for (Entity entity : entities) {
			if (entity != null) {
				if(targetX == entity.getX() && targetY == entity.getY()) {
					// block wall movement
					if (entity instanceof Wall || entity instanceof Boulder) {
						return false;
					} else if (entity instanceof Door) {
						Door temp = (Door) entity;
						if (temp.getStage() == false) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	
	// method to update the observer, used by subject
	@Override
	public void changeState() {
		if (this.isAlive() == true) {
			this.update(dungeon.getPlayer(), null);
			this.state.move();
			this.dungeon.getPlayer().potionKill();
			this.dungeon.getPlayer().getKill();
		}
	}
	

	/*
	public void update() {
		int invincible_time = dungeon.getPlayer().getPotion();
		if(invincible_time > 0) {
			System.out.println("player is invincible at the moment, run !!");
			this.state = new RunState(this, dungeon);
		} else {
			System.out.println("player lost his power, attack him !!");
			this.state = new KillState(this, dungeon);
		}
		
	}
	*/

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		Player player = (Player) o; 
		int invincible = player.getPotion();
		if(invincible > 0) {
			System.out.println("player is invincible at the moment, run !!");
			this.state = new RunState(this, dungeon);
		} else {
			System.out.println("player lost his power, attack him !!");
			this.state = new KillState(this, dungeon);
		}
	}

}

