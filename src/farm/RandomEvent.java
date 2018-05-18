/*
 * This class serves to give the description of the random event
 */
package farm;

/**
 *
 * @author Martim Ferreira, Nicole Vieira, Rui Iria
 */
public class RandomEvent {
    public String description; //variable description
    //modifier and selector
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    //constructor
    public RandomEvent(String description) {
        this.description = description;
    }
    
}
