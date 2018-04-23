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
    
    public Hunter(String name, float runEnergyCost) {
        super(runEnergyCost);
        
        this.name = name;
    }
    
    public void hunt(String hunter, String prey, int hour) {
        boolean success = false;
        
        /* 
            Dog has 4% chance of successfully hunting a rat
            Cat has 20% chance of successfully hunting a rat
            Cat has 10% chance of successfully hunting a rat
        
            If the prey is sleeping chance is 50%
        */
        
        // Roll the die!
        Random rand = new Random();
        int val = rand.nextInt(100);
        
        switch (hunter) {
            case "dog":
                super.run();
                
                // Prey is sleeping
                if (hour >= 22 && prey.equals("rat")) if (val >= 0 && val <= 50) success = true;
                
                // Prey is awake
                else if (hour < 22 && prey.equals("rat")) if (val >= 0 && val <= 4) success = true;
                
                break;
            case "cat":
                super.run();
                
                // Prey is sleeping
                if (hour >= 22) if (val >= 0 && val <= 50) success = true;
                
                // Prey is awake
                else if (hour < 22 && prey.equals("rat")) if (val >= 0 && val <= 20) success = true;
                else if (hour < 22 && prey.equals("bird")) if (val >= 0 && val <= 10) success = true;
                
                break;
        }
        
        if (success) super.setBelly(super.getBelly() + 15);
        else System.out.println("The prey got away...");
    }
    
}