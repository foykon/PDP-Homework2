/**
*
* @author Furkan YILDIZ furkan.yildiz12@ogr.sakarya.edu.tr
* @since 22 Mayıs 2023
* <p>
* üretim sınıfı random sayı üretmek için random classı kullanılmıştır
* </p>
*/
package production;

import java.util.Random;

public class ProductionA implements IProduction {

	@Override
	public int produce() {
		Random random = new Random();
        int randomNumber = random.nextInt(11); // 0 ile 10 arasında bir rastgele sayı üretiyor
		return randomNumber;
	}

	
}
