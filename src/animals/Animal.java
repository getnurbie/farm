/*
 * 
 * This class represents the basic actions and attributes of every animal.
 * 
 */
package animals;

/**
 *
 * @author Martim Ferreira - 21/04/2018
 * 
 */
public abstract class Animal {
    
    private int age;
    private String color, gender;
    private float height, weight;
    private float moveSpeed, walkSpeed, runSpeed;
    private float belly, currentEnergy, maxEnergy, runEnergyCost;
    private boolean alive;
    
    /*
    * "rat" fills belly by 15 points.
    * "smallRation" fills belly by 33 points.
    * "mediumRation" fills belly by 50 points.
    * "largeRation" completely fills belly.
    */
    protected void eat(String mealType) {
        switch (mealType) {
            case "rat":
                belly += 15;
                break;
            case "smallRation":
                belly += 33;
                break;
            case "mediumRation":
                belly += 50;
                break;
            case "largeRation":
                belly = 100;
                break;
        }
        
        if (belly > 100) belly = 100;
    }
    
    /*
    * Recovers energy depending on the amount of hours slept.
    * Formula: re = (100 * hours) / 8
    */
    protected void sleep(int hours) {
        currentEnergy += (100 * hours) / 8;
        if (currentEnergy > maxEnergy) currentEnergy = maxEnergy;
    }
    
    /*
    * Change movement speed to walking speed.
    */
    protected void walk() {
        moveSpeed = walkSpeed;
    }
    
    /*
    * Change movement speed to run speed.
    * Performing this action costs energy.
    * The animal cannot perform it if it does not have the necessary energy.
    */
    protected void run() {
        if (currentEnergy >= runEnergyCost) {
            moveSpeed = runSpeed;
            currentEnergy -= runEnergyCost;
        } else System.out.println("Not enough energy!");
    };
    
    /*
    * Change alive variable to false, meaning dead.
    */
    protected void die() {
        alive = false;
    };
    
    /*
    * TODO
    */
    protected void reproduce() {};

    /*
    * Ages animal by 1 year.
    */
    protected void age() {
        age += 1;
    }

    /*
    * Returns the animal's current age.
    */
    public int getAge() {
        return age;
    }

    /*
    * Returns the animal's color.
    */
    public String getColor() {
        return color;
    }

    /*
    * Returns the animal's gender.
    */
    public String getGender() {
        return gender;
    }

    /*
    * Returns the animal's height.
    */
    public float getHeight() {
        return height;
    }

    /*
    * Modifies the animal's height.
    */
    public void setHeight(float height) {
        this.height = height;
    }

    /*
    * Returns the animal's weight.
    */
    public float getWeight() {
        return weight;
    }

    /*
    * Modifies the animal's weight.
    */
    public void setWeight(float weight) {
        this.weight = weight;
    }

    /*
    * Returns the animal's current movement speed.
    */
    public float getMoveSpeed() {
        return moveSpeed;
    }

    /*
    * Returns the animal's current walk speed.
    */
    public float getWalkSpeed() {
        return walkSpeed;
    }

    /*
    * Returns the animal's current running speed.
    */
    public float getRunSpeed() {
        return runSpeed;
    }

    /*
    * Returns the animal's belly fullness.
    */
    public float getBelly() {
        return belly;
    }

    /*
    * Returns the animal's current energy.
    */
    public float getCurrentEnergy() {
        return currentEnergy;
    }

    /*
    * Returns the animal's maximum energy.
    */
    public float getMaxEnergy() {
        return maxEnergy;
    }

    /*
    * Returns the animal's run energy cost.
    */
    public float getRunEnergyCost() {
        return runEnergyCost;
    }

    /*
    * Returns false if animal is dead.
    */
    public boolean isAlive() {
        return alive;
    }
      
}