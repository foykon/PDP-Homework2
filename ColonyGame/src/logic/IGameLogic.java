/**
*
* @author Furkan YILDIZ furkan.yildiz12@ogr.sakarya.edu.tr
* @since 22 Mayıs 2023
* <p>
* game logic interface i mainde oyun mantığını bu interface üzerinden çağırıyoruz böylece yeni bir oyun yapısı yazılırsa kolayca değiştirlebilsin
* </p>
*/

package logic;

import entity.Colony;

public interface IGameLogic {

	void startGame(String consoleInput);
	void createColonies(String consoleInput);
	void warTime();
	void warReparations(Colony winner, Colony loser);
	void colonyLifeLoops();
	boolean checkColonyIsAlive(Colony colony);
	int countOfAliveColony();

}
