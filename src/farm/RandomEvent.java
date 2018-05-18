/*
 * This class serves to show the event that should happen and the description of the event
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
