package logic;

import java.util.ArrayList;
import java.util.List;

import entity.Colony;
import production.IProduction;
import tactic.ITactic;

public class GameLogicA implements IGameLogic {

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
		
	}
	
	@Override
	public void createColonies(String consoleInput) {
		
		numbers = consoleInput.split(" ");
		for (String number : numbers) {
			colonies.add(new Colony('*',Integer.parseInt(number),tactics.get(0),productions.get(0)));
        
		}
		
		
		/*for (Colony colony : colonies) {
			System.out.println(colony.colonyMember+" "+colony.foodStock);
			
		}*/
		
	}

	
	
}
