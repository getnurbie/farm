/*
 * This class represents the basic actions and attributes of every pig.
 */
package animals;

/**
 *
 * @author Martim Ferreira, Nicole Vieira e Rui Iria
 */
public class Pig extends FarmAnimal {
    
    public Pig(String name, float runEnergyCost)
    {
        super(name, runEnergyCost);
    }
    
    
    public Pig()
    {
        super("Unnamed Pig", 10);
    }
    
}