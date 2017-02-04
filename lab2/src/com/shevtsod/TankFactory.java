package com.shevtsod;

import com.shevtsod.ConcreteTanks.*;

/**
 * @author Daniel Shevtsov (SID: 200351253)
 */
public class TankFactory {
	public Tank makeTank(int type) {
		switch(type) {
			case 0: return new Tank_Abrams();
			case 1: return new Tank_Leopard();
			case 2: return new Tank_T90();
			case 3: return new Tank_Tiger();
			case 4: return new Tank_VT4();
				//Add new concrete tanks below
			default:
				return null;
		}
	}
}
