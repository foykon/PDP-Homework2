/**
*
* @author Furkan YILDIZ furkan.yildiz12@ogr.sakarya.edu.tr
* @since 22 Mayıs 2023
* <p>
* bu taktik sınıfında da işlemciden yararlanarak random sayı üretiliyor
* </p>
*/

package tactic;

import java.util.concurrent.ThreadLocalRandom;

public class TacticC implements ITactic {

	@Override
	public int war() {
		int randomNumber = ThreadLocalRandom.current().nextInt(0, 1001);
		return randomNumber;
	}

}
