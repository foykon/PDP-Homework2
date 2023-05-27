/**
*
* @author Furkan YILDIZ furkan.yildiz12@ogr.sakarya.edu.tr
* @since 22 Mayıs 2023
* <p>
* Colony sınıfı koloni özelliklerini tanımladığımız sınıftır 
* </p>
*/


package entity;

import production.IProduction;
import tactic.ITactic;

public class Colony {

	public char symbol;
	public int colonyMember;
	public int foodStock = 0;
	public int countOfWin = 0;
	public int countOfLose = 0;
	public ITactic tactic;
	public IProduction production;
	public boolean isColonyAlive = true;
	
	public Colony(char symbol, int colonyMember, ITactic tactic, IProduction production) {
		super();
		this.colonyMember = colonyMember;
		this.symbol = symbol;
		this.tactic=tactic;
		this.production=production;
		setFoodStock(colonyMember);
	}

	public void setFoodStock(int colonyMember) {
		foodStock = colonyMember*colonyMember;
	}
	
}
