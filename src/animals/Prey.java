/*
 * This class represents the basic actions and attributes of every prey animal.
 */
package animals;

/**
 * @author Martim Ferreira - 05/05/2018
 */
public abstract class Prey extends Animal {
    
    public Prey(float runEnergyCost) {
        super(runEnergyCost);
    }
    
    public void getHunted(boolean huntResult) {
        if (huntResult) super.die();
        else {
            // Not really eating, just using it to recover energy.
            super.eat("smallRation");
        }
    }
    
}