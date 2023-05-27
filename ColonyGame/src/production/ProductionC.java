/**
*
* @author Furkan YILDIZ furkan.yildiz12@ogr.sakarya.edu.tr
* @since 22 Mayıs 2023
* <p>
* bu üretim sınıfında da işlemciden yararlanarak random sayı üretiliyor
* </p>
*/

package production;

import java.util.concurrent.ThreadLocalRandom;

public class ProductionC implements IProduction{

	@Override
	public int produce() {
		int randomNumber = ThreadLocalRandom.current().nextInt(0, 11);
		return randomNumber;
	}

}
