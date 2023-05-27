package production;

import java.util.concurrent.ThreadLocalRandom;

public class ProductionC implements IProduction{

	@Override
	public int produce() {
		int randomNumber = ThreadLocalRandom.current().nextInt(0, 11);
		return randomNumber;
	}

}
