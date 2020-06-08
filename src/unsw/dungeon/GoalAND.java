package unsw.dungeon;

import java.util.ArrayList;

public class GoalAND implements Goal{

	private ArrayList<Goal> goalList;
	
	public GoalAND() {
		this.goalList = new ArrayList<Goal>();
	}
	
	@Override
	public boolean isFinished() {
		for (Goal gl : this.goalList) {
			if (gl.isFinished() == false)
				return false;
		}
		return true;
	}
	
	public void addGoal(Goal g) {
		this.goalList.add(g);
		//System.out.println(g);
	}
	@Override
	public String toString() {
		return "AND Goals";
	}
}
