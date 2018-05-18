/*
 * This class represents the basic actions and attributes of every cow.
 */
package animals;

/**
 *
 * @author Martim Ferreira, Nicole Vieira e Rui Iria
 */
public class Cow extends Harvestable {
    
    public Cow (String name, String resource, float resourceEnergy)
    {
        super(name, resource, resourceEnergy);
    }
    
    
    public Cow()
    {
        super("Unnamed Cow", "Milk", 10);
    }
}
