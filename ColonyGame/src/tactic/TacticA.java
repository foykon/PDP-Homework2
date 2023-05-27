/**
*
* @author Furkan YILDIZ furkan.yildiz12@ogr.sakarya.edu.tr
* @since 22 Mayıs 2023
* <p>
* taktika sınıfı random sayı üretmek için random classı kullanılmıştır
* </p>
*/
package tactic;

import java.util.Random;

public class TacticA implements ITactic {

	@Override
	public int war() {
		Random random = new Random();
        int randomNumber = random.nextInt(1001); // 0 ile 1000 arasında bir rastgele sayı üretiyor
		return randomNumber;
	}

}
