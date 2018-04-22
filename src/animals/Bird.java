/*
 * 
 * This class represents the basic actions and attributes of every bird.
 * 
 */
package animals;

/**
 *
 * @author Martim Ferreira - 22/04/2018
 * 
 */
public class Bird extends Animal {
    
    private float flySpeed, flyEnergyCost;
    
    public Bird(float walkSpeed, float runSpeed, float runEnergyCost, float flySpeed, float flyEnergyCost) {
        super(walkSpeed, runSpeed, runEnergyCost);
        this.flySpeed = flySpeed;
        this.flyEnergyCost = flyEnergyCost;
    }
    
    /*
    * Change movement speed to fly speed.
    * Performing this action costs energy.
    * The bird cannot perform it if it does not have the necessary energy.
    */
    private void fly() {
        if (super.getCurrentEnergy() >= super.getRunEnergyCost()) {
            super.setMoveSpeed(flySpeed);
            
            float newEnergy = super.getCurrentEnergy();
            newEnergy -= flyEnergyCost;
            super.setCurrentEnergy(newEnergy);
        } else System.out.println("Not enough energy!");
    }

    /*
    * Returns the bird's fly speed.
    */
    public float getFlySpeed() {
        return flySpeed;
    }

    /*
    * Modifies the bird's fly speed.
    */
    public void setFlySpeed(float flySpeed) {
        this.flySpeed = flySpeed;
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