package entity;

public class Colony {

	public char symbol;
	public int colonyMember;
	public int foodStock = 0;
	public int countOfWin = 0;
	public int countOfLose = 0;
	
	public Colony( char symbol,int colonyMember) {
		super();
		this.colonyMember = colonyMember;
		this.symbol = symbol;
		setFoodStock(colonyMember);
	}

	public void setFoodStock(int colonyMember) {
		foodStock = colonyMember*colonyMember;
	}
	
}
