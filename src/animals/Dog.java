/*
 * This class represents the basic actions and attributes of every dog.
 */
package animals;

/**
 * @author Martim Ferreira - 23/04/2018
 */
public class Dog extends Hunter {
    
    public Dog(String name, float runEnergyCost) {
        super(name, runEnergyCost);
    }
    
    public Dog(String name) {
        super(name, 5);
    }
    
}
