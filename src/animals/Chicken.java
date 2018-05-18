/*
 * This class represents the basic actions and attributes of every chicken.
 */
package animals;

/**
 *
 * @author Martim Ferreira, Nicole Vieira e Rui Iria
 */
public class Chicken extends Harvestable {
    
    public Chicken (String name, String resource, float resourceEnergy)
    {
        super(name, resource, resourceEnergy);
    }
    
    
    public Chicken()
    {
        super("Unnamed Chicken", "Eggs", 5);
    }
    
}
