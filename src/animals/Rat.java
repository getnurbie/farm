/*
 * This class represents the basic actions and attributes of every rat animal.
 */
package animals;

/**
 * @author Martim Ferreira - 05/05/2018, Nicole Vieira e Rui Iria
 */
public class Rat extends Prey {
    
    /*
    * Custom constructor.
    */
    public Rat(float runEnergyCost) {
        super(runEnergyCost);
    }
    
    /*
    * Default constructor.
    */
    public Rat() {
        super(4);
    }
    
}
