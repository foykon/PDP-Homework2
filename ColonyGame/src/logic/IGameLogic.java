package logic;

import entity.Colony;

public interface IGameLogic {

	void startGame(String consoleInput);
	void createColonies(String consoleInput);
	void warTime();
	void warReparations(Colony winner, Colony loser);
	void colonyLifeLoops();
	void checkColonyIsAlive(Colony colony);

}
