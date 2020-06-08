package unsw.dungeon;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


/**
 * The player entity
 * @author Robert Clifton-Everest
 *
 */
public class Player extends Entity {

    private Dungeon dungeon;
    private ArrayList<Observer> observers;
    private int treasure;
    private int keyNum;
    private int bomb;
    private int sword_with_hits;
    private int potion;
    private String keyColor;

    /**
     * Create a player positioned in square (x,y)
     * @param x
     * @param y
     */
    
    public Player(int x, int y, Dungeon dungeon) {
 		super(x, y);
 		this.observers = new ArrayList<>();
 		this.dungeon = dungeon;
 		this.treasure = 0;
 		this.keyNum = 0;
 		this.bomb = 0;
 		this.sword_with_hits = 0;
 		this.potion = 0;
 		this.keyColor = null;
 	}

    public void moveUp() {
        if (getY() > 0 && moveCheck(getX(), getY()-1, 1)) {
            y().set(getY() - 1);
        }
    }

	public void moveDown() {
        if ((getY() < dungeon.getHeight() - 1) && moveCheck(getX(), getY()+1, 3))
            y().set(getY() + 1);
    }

    public void moveLeft() {
        if ((getX() > 0) && moveCheck((getX() - 1), getY(), 4))
            x().set(getX() - 1);
    }

    public void moveRight() {
        if ((getX() < dungeon.getWidth() - 1) && moveCheck(getX() + 1, getY(), 2))
            x().set(getX() + 1);
    }
    
    public void addTreasure() {
    	this.treasure++;
    }

	public int getTreasure() {
		return treasure;
	}
	
	public int getKeyNum() {
		return keyNum;
	}
	
	public void addKey() {
		this.keyNum++;
	}
	
	public String getKeyColor() {
		return this.keyColor;
	}
	public void setKeyColor(String color) {
		this.keyColor = color;
	}

	public void useKey() {
		this.keyNum--;
	}
	
	public void addBomb() {
		this.bomb++;
	}
	
	public int getBomb() {
		return bomb;
	}

	public void addPotion() {
		this.potion = 10;
	}

	public int getPotion() {
		return potion;
	}

	public void dropBomb() {
		if (this.bomb > 0) {
			System.out.println("bomb drop");
			this.bomb--;
			LitBomb1 temp = (LitBomb1) dungeon.findClassEntity("class unsw.dungeon.LitBomb1");
			temp.setX(this.getX());
			temp.setY(this.getY());
			temp.activate();
		}
	}
	
	// pick up sword
	public void addSword() {
		this.sword_with_hits = 5;
	}
	
	public int getSword() {
		return sword_with_hits;
	}
	
    public void useSword() {
		if (this.sword_with_hits > 0) {
			System.out.println("Sword with " + this.sword_with_hits + " hits available");
			this.sword_with_hits--;
			is_enemy_around();
		} else {
			System.out.println("Attention: You ran out of hits!!!");
		}
	}	

    // sword search for enemy
	public void is_enemy_around() {
		for (int i = 0; i < dungeon.getEntities().size(); i++) {
			if (EnemyinRange(dungeon.getEntities().get(i))) {
				dungeon.getEntities().get(i).setX(dungeon.getWidth());
				dungeon.getEntities().get(i).setY(dungeon.getHeight());
				Enemy enemy = (Enemy) dungeon.getEntities().get(i);
				enemy.setAlive(false);
			}
		}
		
	}
		
	// check if enemy is in range
	public boolean EnemyinRange(Entity entity) {
		
		if (entity == null) return false;	
		int playerx = getX();
		int playery = getY();
		int x = entity.getX();
		int y = entity.getY();
		
		if ((x == playerx-1 && y == playery) ||
			(x == playerx+1 && y == playery) || (x == playerx && y == playery-1) ||
			(x == playerx && y == playery+1)) {
			// if enemy is one block next to a player with sword
			if (entity instanceof Enemy) {
				return true;
			}
		}
		return false;
	}


    public boolean moveCheck(int targetX, int targetY, int direction) {
		
		List<Entity> entities = dungeon.getEntities();
		
		for (Entity entity : entities) {
			if (entity != null) {
				if(targetX == entity.getX() && targetY == entity.getY()) {
					// block wall movement
					if (entity instanceof Wall) {
						return false;
					// block walking into boulder
					} else if (entity instanceof Boulder) {
						// for wall or entity
						Entity temp1 = null;
						if (direction == 1) {
							temp1 = dungeon.checkLocation(targetX, targetY-1);
						} else if (direction == 2) {
							temp1 = dungeon.checkLocation(targetX+1, targetY);
						} else if (direction == 3) {
							temp1 = dungeon.checkLocation(targetX, targetY+1);
						} else if (direction == 4) {
							temp1 = dungeon.checkLocation(targetX-1, targetY);
						}
						
						if (temp1 != null) {
							if (temp1 instanceof Boulder || temp1 instanceof Wall) {
								return false;
							}
						}
						// for boundary
						if (direction == 1 && targetY == 0) {
							return false;
						} else if (direction == 2 && targetX == dungeon.getWidth()-1) {
							return false;
						} else if (direction == 3 && targetY == dungeon.getHeight()-1) {
							return false;
						} else if (direction == 4 && targetX == 0) {
							return false;
						}
					
					// block walking into door	
 					} else if (entity instanceof Door) {
						Door tempDoor = (Door) entity;
						if (dungeon.getPlayer().getKeyColor().equals(tempDoor.getColor())) 
							return true;
						else 
							return false;
					}
				}
			}
		}
		return true;
	}
    
    public void getKill() {
 
    	for (Entity entity : dungeon.getEntities()) {
			if (entity != null) {
				if (entity.getClass().toString().equals("class unsw.dungeon.Enemy")) {
					if (entity.getX() == this.getX() && entity.getY() == this.getY()) {
						System.out.println("Player kill by enemy");
						dungeon.removeEntities(this);
					}
				}
			}
		}
    }
    
    public void potionKill() {
    	if (this.getPotion() == 0) return;
    	for (Entity entity : dungeon.getEntities()) {
			if (entity != null) {
				if (entity instanceof Enemy) {
					if (entity.getX() == this.getX() && entity.getY() == this.getY()) {
						System.out.println("Player's potion kill enemy");
						Enemy enemy = (Enemy) entity;
						enemy.setAlive(false);
						dungeon.removeEntities(entity);
					}
				}
			}
		}
    }

	@Override
	public synchronized void addObserver(Observer o) {
		
		observers.add(o);
	}

	@Override
	public synchronized void deleteObserver(Observer o) {
		
		observers.remove(o);
	}
	
	// notify the enemy that player is invincible for a specific number of steps.
	@Override
	public void notifyObservers(Object m) {
		for(Observer o : observers) {
			o.update(this,m);
		}
	}

	// if the player is invincible, notify the enemy:
	static int flag = 0;
	@Override
	public void changeState() {
		if (this.potion > 0) {
			this.potion--;
			System.out.println("Invincible potion will last for " + this.potion + " steps");
			this.potionKill();
			this.notifyObservers();
		} // once the player his power, notify the enemy one more time
		else if (this.potion == 0 && flag == 1) {
			notifyObservers();
			flag = 0;
		}
		return;
	}




}
