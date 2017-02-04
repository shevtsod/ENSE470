package com.shevtsod;

/**
 * @author Daniel Shevtsov (SID: 200351253)
 */
public class Client2 {

	//The number of concrete tank classes we have defined to test
	private final static int NUM_TANKS = 5;
	//Display more information on every shot taken, outputs a lot of text to the console
	private final static boolean DISPLAY_VERBOSE_LOG = false;

    /**
     * Main program entry point
     * @param args String arguments from console to program (unused)
     */
	public static void main(String[] args) {
		System.out.println("TANK FACTORY TEST PROGRAM");
		System.out.println("\tThis program tests tanks created through a Factory pattern and " +
				"\n\tapplied to the same damage calculation algorithm");
        System.out.println();

		Client2 client = new Client2();
		TankFactory tf = new TankFactory();

		for(int i = 0; i < NUM_TANKS; i++) {
		    client.testReceiveHitOnTank(tf.makeTank(i));
        }

        System.out.println("Program completed successfully.");

	}

    /**
     *
     * @param tank
     */
	private void testReceiveHitOnTank(Tank tank) {

	    int shotsTaken = 0;
	    int damage = 100;
	    int penetration = 0;

        System.out.println("=======================================");
        System.out.println("TANK DESCRIPTION: ");
        System.out.println(" - Name:\t\t" + tank.getName());
        System.out.println(" - Country:\t\t" + tank.getCountry());
        System.out.println(" - HP:\t\t\t" + tank.getHitPoints());
        System.out.println(" - Armor:\t\t" + tank.getArmor());
        System.out.println();

        while(!tank.isDestroyed()) {

            int healthBeforeShot = tank.getCurrentHealth();

            tank.receiveHit(damage, penetration);
            shotsTaken++;

            if(DISPLAY_VERBOSE_LOG) {
                System.out.println("DAMAGE TAKEN: " + (healthBeforeShot - tank.getCurrentHealth()) +
                                    " (" + healthBeforeShot + " HP -> " + tank.getCurrentHealth() +
                                    " HP), damage = " + damage + " penetration = " + penetration);
            }

            //Continuously increase penetration until tank is destroyed
            penetration += 5;
        }

        System.out.println(tank.getName() + " destroyed after " + shotsTaken + " shots\n");
    }

}
