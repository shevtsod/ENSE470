package com.shevtsod.ConcreteTanks;

import com.shevtsod.Tank;

/**
 * @author Daniel Shevtsov (SID: 200351253)
 */
public class Tank_Leopard extends Tank {

	public Tank_Leopard() {
		super();
		name = "Leopard Tank";
		country = "Germany";

		hitPoints = currentHealth = 750;
		armor = 20;
	}

}
