package logic;

import java.util.ArrayList;
import java.util.List;

import entity.Colony;
import production.IProduction;
import tactic.ITactic;

public class GameLogicA implements IGameLogic {

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

	@Override
	public void startGame(String consoleInput) {
		createColonies(consoleInput);
		warTime();
		
	}
	
	@Override
	public void createColonies(String consoleInput) {
		
		numbers = consoleInput.split(" ");
		for (String number : numbers) {
			colonies.add(new Colony('*',Integer.parseInt(number),tactics.get(0),productions.get(0)));
        
		}
		
		
		/*for (Colony colony : colonies) {
			System.out.println(colony.colonyMember+" "+colony.foodStock+" "+colony.tactic.war());
			
		}*/
		
	}

	@Override
	public void warTime() {

		
		Colony[] arrayOfColonies = colonies.toArray(new Colony[colonies.size()]);
		for (int i = 0; i < arrayOfColonies.length-1; i++) {
			for (int j = i+1; j < arrayOfColonies.length; j++) {
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
				
			}
			
		}
		
	}

	@Override
	public void warReparations(Colony winner, Colony loser) {
		int percentDifference = difference * 100 / 1000;
		loser.colonyMember = loser.colonyMember * (100-percentDifference) / 100;
		winner.foodStock += loser.foodStock * (percentDifference) / 100;
		loser.foodStock -= loser.foodStock * (percentDifference) / 100;
		
	}
	
	
	

	
	
}
