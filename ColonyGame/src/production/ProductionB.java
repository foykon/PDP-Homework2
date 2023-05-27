/**
*
* @author Furkan YILDIZ furkan.yildiz12@ogr.sakarya.edu.tr
* @since 22 Mayıs 2023
* <p>
* üretim sınıfı burda random sayı üretmek için math sınıfı kullanılmıştır
* </p>
*/
package production;

public class ProductionB implements IProduction {

	@Override
	public int produce() {
		int randomNumber = (int) (Math.random() * 11);
		return randomNumber;
	}

}
