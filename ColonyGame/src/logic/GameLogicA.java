/**
*
* @author Furkan YILDIZ furkan.yildiz12@ogr.sakarya.edu.tr
* @since 22 Mayıs 2023
* <p>
* oyunun kurallarını yazdığımız sınıf ayrıntılı olarak yorum satırlarında belirtilmiştir
* </p>
*/

package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entity.Colony;
import production.IProduction;
import tactic.ITactic;

public class GameLogicA implements IGameLogic {

	private static final String SPECIAL_CHARACTERS = "!@#$%^&*";
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
	
	//ekran çıktısı almak için kullandığımız fonksiyon
	public void output() {
		System.out.println("colonySymbol\tcolonyMember\tfoodStock\tcoutOfWin\tcountOfLose");
		for (Colony colony : colonies) {
			if(colony.isColonyAlive)
				System.out.println(colony.symbol + "\t\t" + colony.colonyMember + "\t\t" + colony.foodStock + "\t\t" + colony.countOfWin + "\t\t" + colony.countOfLose);
			else
				System.out.println(colony.symbol + "\t\t--\t\t--\t\t" + colony.countOfWin + "\t\t" + colony.countOfLose);
		}
	}
	
	//oyunun başlamasını sağlayan ve gerekli diğer fonksiyonları çağırdığımız method 
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
	
	//colony sınıfının kurucu fonksiyonu ila tek tek kolonileri oluşturduğumuz method
	@Override
	public void createColonies(String consoleInput) {
		numbers = consoleInput.split(" ");
		Random random = new Random();
		for (String number : numbers) {
			colonies.add(new Colony(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())),Integer.parseInt(number),tactics.get(random.nextInt(2)),productions.get(random.nextInt(2))));
			
		}

	}

	//savaş anın kuralları 
	@Override
	public void warTime() {
		countOfWar++;
		Colony[] arrayOfColonies = colonies.toArray(new Colony[colonies.size()]);
		for (int i = 0; i < arrayOfColonies.length-1; i++) {
			if(arrayOfColonies[i].isColonyAlive) {
				//eğer koloni canlı ise koloni gücünü değişkene atıyoruz 
				int iWarPower = arrayOfColonies[i].tactic.war();
				for (int j = i+1; j < arrayOfColonies.length; j++) {
					if(arrayOfColonies[j].isColonyAlive) {
						//eğer koloni canlı ise koloni gücünü değişkene atıyoruz 
						int jWarPower = arrayOfColonies[i].tactic.war();
						//kolonilerin gücünü karşılaştırdığımız if yapısı
						if(iWarPower > jWarPower) {
							difference = iWarPower - jWarPower;
							warReparations(arrayOfColonies[i], arrayOfColonies[j]);
							
						}else if (jWarPower > iWarPower) {
							difference = jWarPower - iWarPower;
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
	
	//savaşta kazanan ve kaybeden kolonilerin yaptırımları ve kazandıklarını uyguladığımız method
	@Override
	public void warReparations(Colony winner, Colony loser) {
		int percentDifference = difference * 100 / 1000;
		loser.colonyMember = loser.colonyMember * (100-percentDifference) / 100;
		winner.foodStock = winner.foodStock + (loser.foodStock * (percentDifference) / 100);
		loser.foodStock = loser.foodStock - (loser.foodStock * (percentDifference) / 100);
		winner.countOfWin++;
		loser.countOfLose++;
		
	}

	//her koloninin her tur yaşaması gerekn yaşamsal faliyerler
	@Override
	public void colonyLifeLoops() {
		for (Colony colony : colonies) {
			if(checkColonyIsAlive(colony)) {
				colony.colonyMember = colony.colonyMember * 120 / 100;
				colony.foodStock = colony.foodStock + colony.production.produce();
				colony.foodStock = colony.foodStock - (colony.colonyMember * 2);
				
			}
			
		}
		
	}

	//colony canlı mı değil mi diye kontrol edilen bool method
	@Override
	public boolean checkColonyIsAlive(Colony colony) {
		if(colony.foodStock <= 0 || colony.colonyMember <= 0) {
			colony.isColonyAlive = false;
			colony.colonyMember = 0;
			colony.foodStock = 0;
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
