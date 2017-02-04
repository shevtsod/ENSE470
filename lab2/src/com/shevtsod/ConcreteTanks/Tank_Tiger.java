package com.shevtsod.ConcreteTanks;

import com.shevtsod.Tank;

/**
 * @author Daniel Shevtsov (SID: 200351253)
 */
public class Tank_Tiger extends Tank {

	public Tank_Tiger() {
		super();
		name = "Tiger Tank";
		country = "Germany";

		hitPoints = currentHealth = 200;
		armor = 100;
	}

}
