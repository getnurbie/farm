/*
 * 
 * This class represents the basic actions and attributes of every bird.
 * 
 */
package animals;

/**
 * @author Martim Ferreira - 22/04/2018
 */
public class Bird extends Animal {
    
    private float flyEnergyCost;
    
    public Bird(float runEnergyCost, float flyEnergyCost) {
        super(runEnergyCost);
        this.flyEnergyCost = flyEnergyCost;
    }
    
    /*
    * Change movement speed to fly speed.
    * Performing this action costs energy.
    * The bird cannot perform it if it does not have the necessary energy.
    */
    private void fly() {
        if (super.getCurrentEnergy() >= flyEnergyCost) {
            float newEnergy = super.getCurrentEnergy();
            newEnergy -= flyEnergyCost;
            super.setCurrentEnergy(newEnergy);
        } else System.out.println("Not enough energy!");
    }

    /*
    * Returns the bird's flying energy cost.
    */
    public float getFlyEnergyCost() {
        return flyEnergyCost;
    }

    /*
    * Modifies the bird's flying energy cost.
    */
    public void setFlyEnergyCost(float flyEnergyCost) {
        this.flyEnergyCost = flyEnergyCost;
    }
    
}