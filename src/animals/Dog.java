/*
 * This class represents the basic actions and attributes of every dog.
 */
package animals;

/**
 * @author Martim Ferreira - 23/04/2018, Nicole Vieira e Rui Iria
 */
public class Dog extends Hunter {
    
    /*
    * Custom constructor.
    */
    public Dog(String name, float runEnergyCost, float attackEnergyCost, float getAttackedEnergyCost) {
        super(name, runEnergyCost, attackEnergyCost, getAttackedEnergyCost);
    }
    
    /*
    * Default constructor.
    */
    public Dog() {
        super("Unnamed dog", 5, 10, (float) 15);
    }
}
