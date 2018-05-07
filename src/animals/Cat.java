/*
 * This class represents the basic actions and attributes of every cat.
 */
package animals;

/**
 * @author Martim Ferreira - 05/05/2018
 */
public class Cat extends Hunter {
    
    /*
    * Custom constructor.
    */
    public Cat(String name, float runEnergyCost, float attackEnergyCost, float getAttackedEnergyCost) {
        super(name, runEnergyCost, attackEnergyCost, getAttackedEnergyCost);
    }
    
   /*
    * Default constructor.
    */
    public Cat() {
        super("Unnamed cat", 5, 10, (float) 15);
    }
    
}