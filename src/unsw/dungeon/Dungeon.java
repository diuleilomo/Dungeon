/**
 *
 */
package unsw.dungeon;

import java.util.ArrayList;
import java.util.List;


public class Dungeon {

    private int width, height;
    private List<Entity> entities;
    private Player player;
    private Goal goal;

    public Dungeon(int width, int height) {
        this.width = width;
        this.height = height;
        this.entities = new ArrayList<>();
        this.player = null;
        this.goal = null;
    }
    
    public void setGoal(Goal goal) {
    	this.goal = goal;
    }
    
    public boolean goalCheck() {
    	if (goal.isFinished()) return true;
    	else return false;
    }
    
    public void moveBombtoCorner() {
    	for (Entity entity : entities) {
    		if (entity instanceof LitBomb1 || entity instanceof LitBomb2 || entity instanceof LitBomb3 || entity instanceof Flame) {
    			entity.setX(getWidth());
    			entity.setY(getHeight());
    		}
    	}
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }
    
    public void setEntities(List<Entity> entities) {
		this.entities = entities;
	}
    
    public void removeEntities(Entity entity) {
    
    	entity.setX(this.width);
    	entity.setY(this.height);
    	//this.entities.remove(entity);
    }
    
      
    public void removeEntitiesList(List entity) {
    	for (int i = 0; i < entity.size(); i++) {
    		Entity temp = (Entity) entity.get(i);
    		temp.setX(this.width);
        	temp.setY(this.height);
        	this.entities.remove(temp);
    	}
    }

	public List<Entity> getEntities() {
		return entities;
	}
	
	public Entity checkLocation(int x, int y) {
		for (Entity entity : entities) {
			if (entity != null) {
				if (entity.getX() == x && entity.getY() == y) {
					return entity;
				}
			}
		}
		return null;
	}
	
	public Entity findClassEntity(String string) {
		for (Entity entity : entities) {
			if (entity != null) {
				if (entity.getClass().toString().equals(string)) {
					
					if (string.equals("class unsw.dungeon.LitBomb1")) {
						LitBomb1 temp1 = (LitBomb1) entity;
						if (temp1.isState() == false) {
							return temp1;
						}
					} else if (string.equals("class unsw.dungeon.LitBomb2")) {
						LitBomb2 temp2 = (LitBomb2) entity;
						if (temp2.isState() == false) {
							return temp2;
						}
					} else if (string.equals("class unsw.dungeon.LitBomb3")) {
						LitBomb3 temp3 = (LitBomb3) entity;
						if (temp3.isState() == false) {
							return temp3;
						}
					} else if (string.equals("class unsw.dungeon.Flame")) {
						Flame temp4 = (Flame) entity;
						if (temp4.isState() == false) {
							return temp4;
						}
					}
				}
			}
		}
		return null;
	}
	
	public int countClassEntity(String string) {
		int count = 0;
		for (Entity entity : entities) {
			if (entity != null) {
				if (entity.getClass().toString().equals(string)) {
					count++;
				}
			}
		}
		return count;
	}


	public void changeState() {
		
		List<Entity> change = new ArrayList<>();
		
    	for (Entity entity : entities) {
			if (entity instanceof Boulder || entity instanceof FloorSwitch || entity instanceof Treasure
				|| entity instanceof UnlitBomb || entity instanceof Flame || entity instanceof LitBomb1 
				|| entity instanceof LitBomb2 || entity instanceof LitBomb3 || entity instanceof Sword 
				|| entity instanceof Key || entity instanceof Door || entity instanceof Potion 
				|| entity instanceof Player || entity instanceof Exit) {	
	  			change.add(entity);
			}	
    	}
    	
    	for (int i = 0; i < change.size(); i++) {
    		change.get(i).changeState();
    	}
    }
}
