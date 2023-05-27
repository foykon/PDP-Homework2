/**
*
* @author Furkan YILDIZ furkan.yildiz12@ogr.sakarya.edu.tr
* @since 22 Mayıs 2023
* <p>
* taktik sınıfı burda random sayı üretmek için math sınıfı kullanılmıştır
* </p>
*/
package tactic;

public class TacticB implements ITactic {

	@Override
	public int war() {
		int randomNumber = (int) (Math.random() * 1001);
		return randomNumber;
	}

}
