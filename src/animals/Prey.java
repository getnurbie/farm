/*
 * This class represents the basic actions and attributes of every prey animal.
 */
package animals;

/**
 * @author Martim Ferreira - 05/05/2018, Nicole Vieira e Rui Iria
 */
public abstract class Prey extends Animal {
    
    public Prey(float runEnergyCost) {
        super(runEnergyCost);
    }
    
    /*
    * If prey escapes recover some energy (after running).
    */
    public void getHunted(boolean huntResult) {
        if (huntResult) super.die();
        else {
            this.run("Prey");
            
            float val = super.getCurrentEnergy();
            val += 10;
            super.setCurrentEnergy(val, "Prey");
        }
    }
    
}