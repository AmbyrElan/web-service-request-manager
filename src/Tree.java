
public class Tree {
	
	private int distanceFromHouse;
	private int heightOfTree;
	
	public Tree() {
		int distanceFromHouse = 10;
		int heightOfTree = 5;
	}
	
	public Tree (int treeDistance, int treeHeight) {
		this.distanceFromHouse = treeDistance;
		this.heightOfTree = treeDistance;
	}
	
	//Getters
	public int getMyTreeDistance() {
		
		return this.distanceFromHouse;
	}
	
	public int getMyTreeHeight() {
		return this.heightOfTree;
	}
	
	//Setters
	public void setMyTreeDistance(int treeDistance) {
		this.distanceFromHouse = treeDistance;
	}
	public void setMyTreeHeight(int treeHeight) {
		this.heightOfTree = treeHeight;
	}
}
