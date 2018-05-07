/*
 * This class represents the basic actions and attributes of every hunter animal.
 */
package animals;

import java.util.Random;

/**
 * @author Martim Ferreira - 23/04/2018
 */
public abstract class Hunter extends Animal {
    
    private String name;
    private float attackEnergyCost, getAttackedEnergyCost;
    
    public Hunter(String name, float runEnergyCost, float attackEnergyCost, float getAttackedEnergyCost) {
        super(runEnergyCost);
        
        this.name = name;
        this.attackEnergyCost = attackEnergyCost;
        this.getAttackedEnergyCost = getAttackedEnergyCost;        
    }
    
    /*
    * Hunt bird/rat.
    */
    public void hunt(Hunter hunter, Prey prey, int hour) {
        hunter.run(name);
        prey.run("Prey");
        
        boolean success = false;
        
        /* 
            Dog has 4% chance of successfully hunting a rat.
            Cat has 20% chance of successfully hunting a rat.
            Cat has 10% chance of successfully hunting a rat.
        
            If the prey is sleeping chance is 50%.
        */
        
        // Roll.
        Random rand = new Random();
        int val = rand.nextInt(100);
        
        if (hunter.getClass().getName().equals("animals.Dog")) {
            super.run(name);
                
            // Prey is sleeping.
            if (hour >= 22 && prey.getClass().getName().equals("animals.Rat")) if (val >= 0 && val <= 50) success = true;

            // Prey is awake.
            else if (hour < 22 && prey.getClass().getName().equals("animals.Rat")) if (val >= 0 && val <= 4) success = true;
        } else if (hunter.getClass().getName().equals("animals.Cat")) {
            super.run(name);
                
            // Prey is sleeping.
            if (hour >= 22) if (val >= 0 && val <= 50) success = true;

            // Prey is awake.
            else if (hour < 22 && prey.getClass().getName().equals("animals.Rat")) if (val >= 0 && val <= 20) success = true;
            else if (hour < 22 && prey.getClass().getName().equals("animals.Bird")) if (val >= 0 && val <= 10) success = true;
        }
        
        if (success) {
            super.setBelly(super.getBelly() + 15);
            System.out.println("Prey successfully hunted!");
        }
        else System.out.println("The prey got away...");
        
        prey.getHunted(success);
    }
    
    /*
    * Have two animals fight (dog and cat).
    */
    public void fight(Hunter attacker, Hunter defender) {
        System.out.println(attacker.getName() + " attacks " + defender.getName() + "!");
        
        float val;
        
        val = attacker.getCurrentEnergy() - attacker.getAttackEnergyCost();
        attacker.setCurrentEnergy(val, name);

        val = defender.getCurrentEnergy() - defender.getGetAttackedEnergyCost();
        defender.setCurrentEnergy(val, name);
        
        System.out.println("They both lose some energy.");
    }

    /*
    * Get hunter's name.
    */
    public String getName() {
        return name;
    }

    /*
    * Modifies hunter's name.
    */
    public void setName(String name) {
        this.name = name;
    }

    /*
    * Get hunter's attack energy cost.
    */
    public float getAttackEnergyCost() {
        return attackEnergyCost;
    }

    /*
    * Modifies hunter's attack energy cost.
    */
    public void setAttackEnergyCost(float attackEnergyCost) {
        this.attackEnergyCost = attackEnergyCost;
    }

    /*
    * Get the energy cost when the hunter is attacked. 
    */
    public float getGetAttackedEnergyCost() {
        return getAttackedEnergyCost;
    }

    /*
    * Modifies the energy cost when the hunter is attacked. 
    */
    public void setGetAttackedEnergyCost(float getAttackedEnergyCost) {
        this.getAttackedEnergyCost = getAttackedEnergyCost;
    }
}