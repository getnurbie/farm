/*
 * This class represents the basic actions and attributes of every hasvestable.
 */
package animals;

/**
 *
 * @author Martim Ferreira, , Nicole Vieira e Rui Iria
 */
public abstract class Harvestable extends FarmAnimal {
    
    public String resource;
    public float resourceEnergy;
    
    public Harvestable(String name, String resource, float resourceEnergy) {
        super(name, resourceEnergy);
        this.resource = resource;
        this.resourceEnergy = resourceEnergy;
    }
    
    public void harvestResource(Harvestable FarmAnimal, int hour)
    {
        boolean success = false;
        // FarmAnimal is Asleep
        if (hour >= 22 || super.getCurrentEnergy() - resourceEnergy < 0)
        success = false;
        // FarmAnimal is Awake
        else if (hour < 22)
        {
            success = true;
            
        }
        if(success)
        {
            super.setCurrentEnergy(super.getCurrentEnergy() - resourceEnergy, super.getName());
            System.out.println("You harvested "+resource+" worth "+resourceEnergy+" energy from "+FarmAnimal.getName());
        }
        else
            System.out.println("You cannot harvest the "+FarmAnimal.getName()+" right now.");
    }
    
    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public float getResourceEnergy() {
        return resourceEnergy;
    }

    public void setResourceEnergy(float resourceEnergy) {
        this.resourceEnergy = resourceEnergy;
    }
    
}