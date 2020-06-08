package unsw.dungeon;

import java.util.ArrayList;

public class GoalOR implements Goal{

	private ArrayList<Goal> goalList;
	
	public GoalOR() {
		this.goalList = new ArrayList<Goal>();
	}
	
	@Override
	public boolean isFinished() {
		for (Goal gl : this.goalList) {
			if (gl.isFinished() == true)
				return true;
		}
		return false;
	}
	
	public void addGoal(Goal g) {
		this.goalList.add(g);
		//System.out.println(g);
	}
	
	@Override
	public String toString() {
		return "OR Goals";
	}
}
