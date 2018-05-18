/*
 * This class represents the basic actions and attributes of every farm animal.
 */
package animals;

/**
 *
 * @author Martim Ferreira, Nicole Vieira e Rui Iria
 */
public abstract class FarmAnimal extends Animal {
    
    private String name;
    
    public FarmAnimal(String name, float runEnergyCost) {
        super(runEnergyCost);
        this.name = name;
    }
    

    public void harvestMeat(FarmAnimal FarmAnimal)
    {
        System.out.println("You harvested meat worth "+super.getCurrentEnergy()+" energy from "+name);
        super.die();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
