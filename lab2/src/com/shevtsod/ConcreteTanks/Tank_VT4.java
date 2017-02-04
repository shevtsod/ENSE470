package com.shevtsod.ConcreteTanks;

import com.shevtsod.Tank;

/**
 * @author Daniel Shevtsov (SID: 200351253)
 */
public class Tank_VT4 extends Tank {

	public Tank_VT4() {
		super();
		name = "VT-4 Tank";
		country = "China";

		hitPoints = currentHealth = 1500;
		armor = 15;
	}

}
