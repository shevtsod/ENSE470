package com.shevtsod;

/**
 * @author Daniel Shevtsov (SID: 200351253)
 * Note: Portions of this class have been provided courtesy of T. Douglas
 */
public abstract class Tank {
	protected String name, 
				     country;
	protected int hitPoints,
				  armor,
				  shellDamage = 0,
				  currentHealth;
	protected boolean destroyed = false;
	
	/**
	 * Cause the tank to take damage.
	 * Check isDestroyed() after calling this
	 * to see whether the Tank survived the hit
	 * 
	 * @param damage
	 * 		integer damage taken by the Tank
	 * @param penetration
	 * 		integer penetration multiplier (must be higher than armor to cause damage)
	 */
	public void receiveHit(int damage, int penetration) {
		double shotDamage = 0.0;
		double shellPenetration = 0.0;
		
		if(destroyed)
			return;
		
		if(penetration > armor) {
			shellPenetration = (penetration - armor) / 100.0;
			shotDamage = damage * shellPenetration;
			
			if(shotDamage >= currentHealth) {
				currentHealth = 0;
				destroyed = true;
			} else {
				currentHealth -= shotDamage;
			}
		}
	}

	//Getters and setters
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public int getHitPoints() {
		return hitPoints;
	}
	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	public int getArmor() {
		return armor;
	}
	public void setArmor(int armor) {
		this.armor = armor;
	}

	public int getShellDamage() {
		return shellDamage;
	}
	public void setShellDamage(int shellDamage) {
		this.shellDamage = shellDamage;
	}

	public int getCurrentHealth() {
		return currentHealth;
	}
	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}

	public boolean isDestroyed() {
		return destroyed;
	}
}
