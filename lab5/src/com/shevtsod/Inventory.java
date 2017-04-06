package com.shevtsod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author Daniel Shevtsov (SID: 200351253)
 */
public class Inventory {
    private List<Reservoir> reservoirs;

    /**
     * Constructor, creates anew Inventory object
     */
    public Inventory() {
        reservoirs = new ArrayList<>();
    }

    /**
     * Adds a new Reservoir to this Inventory, unless it already exists in the Inventory
     * @param name String name of the new Reservoir
     * @param price double price of the new Reservoir's contents per unit of the contents
     * @param capacity int capacity of the Reservoir
     */
    public void addReservoir(String name, double price, int capacity) {
        name = name.toLowerCase();

        // First check if this Reservoir does not exist in the Inventory
        // If it does, exit out of this method
        for(Reservoir reservoir : reservoirs) {
            if(reservoir.getName().equals(name))
                return;
        }

        // If reach here, we add a new reservoir to the inventory
        Reservoir res = new Reservoir();
        res.setName(name);
        res.setPrice(price);
        res.setCapacity(capacity);

        reservoirs.add(res);

    }

    /**
     * Edits an existing Reservoir's details, if it exists in this Inventory
     * @param name String original name of the Reservoir
     * @param newName String new name of the Reservoir
     * @param newPrice double new price of the Reservoir's contents per unit of the contents
     * @param newCapacity int new capacity of the Reservoir
     */
    public void editReservoir(String name, String newName, double newPrice, int newCapacity) {
        name = name.toLowerCase();
        newName = newName.toLowerCase();

        for(Reservoir res : reservoirs) {
            if(res.getName().equals(name)) {
                res.setName(newName);
                res.setPrice(newPrice);
                res.setCapacity(newCapacity);
            }
        }
    }

    /**
     * Removes an existing Reservoir, if it exists in this Inventory
     * @param name String name of the Reservoir
     */
    public void removeReservoir(String name) {
        name = name.toLowerCase();

        Iterator<Reservoir> i = reservoirs.iterator();

        while(i.hasNext()) {
            Reservoir res = i.next();

            if(res.getName().equals(name)) {
                i.remove();
            }
        }
    }

    /**
     * Get a reference to iterate through the list of reservoirs
     * @return List of Reservoirs
     */
    public List<Reservoir> getReservoirs() {
        return reservoirs;
    }
}
