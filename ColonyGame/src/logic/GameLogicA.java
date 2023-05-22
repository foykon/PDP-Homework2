package logic;

import java.util.ArrayList;
import java.util.List;

import entity.Colony;

public class GameLogicA implements IGameLogic {

	String[] numbers;
	List<Colony> colonies = new ArrayList<Colony>();
	
	
	@Override
	public void startGame(String consoleInput) {
		createColonies(consoleInput);
		
	}
	
	@Override
	public void createColonies(String consoleInput) {
		
		numbers = consoleInput.split(" ");
		for (String number : numbers) {
			colonies.add(new Colony('*',Integer.parseInt(number)));
        }
		
		
		/*for (Colony colony : colonies) {
			System.out.println(colony.colonyMember+" "+colony.foodStock);
			
		}*/
		
	}

	
	
}
