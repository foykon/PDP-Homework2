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