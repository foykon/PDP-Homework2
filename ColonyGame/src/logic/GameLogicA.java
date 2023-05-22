package logic;

import java.util.ArrayList;
import java.util.List;

import entity.Colony;
import production.IProduction;
import tactic.ITactic;

public class GameLogicA implements IGameLogic {

	int countOfAliveColony=0;
	int countOfWar=0;
	int difference=0;
	String[] numbers;
	List<Colony> colonies = new ArrayList<Colony>();
	List<ITactic> tactics;
	List<IProduction> productions;
	
	public GameLogicA(List<ITactic> tactics, List<IProduction> productions) {
		super();
		this.tactics = tactics;
		this.productions = productions;
		
	}
	
	public void output() {
		System.out.println("colonyMember\tfoodStock\tcoutOfWin\tcountOfLose");
		for (Colony colony : colonies) {
			if(colony.isColonyAlive)
				System.out.println(colony.colonyMember + "\t\t" + colony.foodStock + "\t\t" + colony.countOfWin + "\t\t" + colony.countOfLose);
			else
				System.out.println("--\t\t--\t\t" + colony.countOfWin + "\t\t" + colony.countOfLose);
		}
	}

	@Override
	public void startGame(String consoleInput) {
		createColonies(consoleInput);
		output();
		while(countOfAliveColony() != 1) {
			countOfAliveColony = 0;
			warTime();
			colonyLifeLoops();
			System.out.println("--------" + countOfWar + "------");
			output();
		
		}
		
	}
	
	@Override
	public void createColonies(String consoleInput) {
		numbers = consoleInput.split(" ");
		for (String number : numbers) {
			colonies.add(new Colony('*',Integer.parseInt(number),tactics.get(0),productions.get(0)));
        
		}

	}

	@Override
	public void warTime() {
		countOfWar++;
		Colony[] arrayOfColonies = colonies.toArray(new Colony[colonies.size()]);
		for (int i = 0; i < arrayOfColonies.length-1; i++) {
			if(arrayOfColonies[i].isColonyAlive) {
				for (int j = i+1; j < arrayOfColonies.length; j++) {
					if(arrayOfColonies[j].isColonyAlive) {
						if(arrayOfColonies[i].tactic.war() > arrayOfColonies[j].tactic.war()) {
							difference = arrayOfColonies[i].tactic.war() - arrayOfColonies[j].tactic.war();
							warReparations(arrayOfColonies[i], arrayOfColonies[j]);
							
						}else if (arrayOfColonies[j].tactic.war() > arrayOfColonies[i].tactic.war()) {
							difference = arrayOfColonies[j].tactic.war() - arrayOfColonies[i].tactic.war();
							warReparations(arrayOfColonies[j], arrayOfColonies[i]);
							
						}else {
							if(arrayOfColonies[i].colonyMember >= arrayOfColonies[j].colonyMember) {
								difference = arrayOfColonies[i].colonyMember - arrayOfColonies[j].colonyMember;
								warReparations(arrayOfColonies[i], arrayOfColonies[j]);
								
							}else {
								difference = arrayOfColonies[j].colonyMember - arrayOfColonies[i].colonyMember;
								warReparations(arrayOfColonies[j], arrayOfColonies[i]);
								
							}
							
						}
						difference=0;
						
					}else continue;
						
				}
			
			}else continue;
			
		}
		
	}

	@Override
	public void warReparations(Colony winner, Colony loser) {
		int percentDifference = difference * 100 / 1000;
		loser.colonyMember = loser.colonyMember * (100-percentDifference) / 100;
		winner.foodStock += loser.foodStock * (percentDifference) / 100;
		loser.foodStock -= loser.foodStock * (percentDifference) / 100;
		winner.countOfWin++;
		loser.countOfLose++;
		
	}

	@Override
	public void colonyLifeLoops() {
		for (Colony colony : colonies) {
			if(checkColonyIsAlive(colony)) {
				colony.colonyMember *= 120 / 100;
				colony.foodStock += colony.production.produce();
				colony.foodStock -= (colony.colonyMember * 2);
				
			}
			
		}
		
	}

	@Override
	public boolean checkColonyIsAlive(Colony colony) {
		if(colony.foodStock < 0 || colony.colonyMember < 0) {
			colony.colonyMember = 0;
			colony.foodStock = 0;
			colony.isColonyAlive = false;
			return false;
			
		}
		return true;
	
	}

	@Override
	public int countOfAliveColony() {
		for (Colony colony : colonies) {
			if(colony.isColonyAlive)
				countOfAliveColony++;
		}
		return countOfAliveColony;
	}
	
}
