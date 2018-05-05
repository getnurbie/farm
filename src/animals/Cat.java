/*
 * This class represents the basic actions and attributes of every cat.
 */
package animals;

/**
 * @author Martim Ferreira - 05/05/2018
 */
public class Cat extends Hunter {
    
    public Cat(String name, float runEnergyCost) {
        super(name, runEnergyCost);
    }
    
    public Cat(String name) {
        super(name, 5);
    }
    
}