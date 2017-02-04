package com.shevtsod.ConcreteTanks;

import com.shevtsod.Tank;

/**
 * @author Daniel Shevtsov (SID: 200351253)
 */
public class Tank_T90 extends Tank {

	public Tank_T90() {
		super();
		name = "T-90 Tank";
		country = "Russia";

		hitPoints = currentHealth = 5000;
		armor = 0;
	}

}
