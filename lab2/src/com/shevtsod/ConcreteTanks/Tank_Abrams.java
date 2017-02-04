package com.shevtsod.ConcreteTanks;

import com.shevtsod.Tank;

/**
 * @author Daniel Shevtsov (SID: 200351253)
 */
public class Tank_Abrams extends Tank {

	public Tank_Abrams() {
		super();
		name = "Abrams Tank";
		country = "United States";

		hitPoints = currentHealth = 1000;
		armor = 5;
	}

}
