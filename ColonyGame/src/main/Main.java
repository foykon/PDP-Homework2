/**
*
* @author Furkan YILDIZ furkan.yildiz12@ogr.sakarya.edu.tr
* @since 22 Mayıs 2023
* <p>
* klasik main sınıfı gerekli classları çağırdığımız ve tactic ve üretimle ilgili sınıfları eklemek için kullandığımız yer
* </p>
*/
package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import logic.GameLogicA;
import logic.IGameLogic;
import production.*;
import tactic.*;


public class Main {

	public static void main(String[] args) {

		
		//12 8 162 35 7 95
		Scanner scanner = new Scanner(System.in);
		String consoleInput = scanner.nextLine();
		System.out.println(consoleInput);
		scanner.close();
		
		List<ITactic> tactics = new ArrayList<>();
		tactics.add(new TacticA());
		tactics.add(new TacticB());
		tactics.add(new TacticC());
		
		List<IProduction> productions = new ArrayList<>();
		productions.add(new ProductionA());
		productions.add(new ProductionB());
		productions.add(new ProductionC());
		
		IGameLogic gameLogic = new GameLogicA(tactics, productions); 
		gameLogic.startGame(consoleInput);
		
	}

}