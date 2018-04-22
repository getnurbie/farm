/*
 * 
 * This class represents the basic actions and attributes of every animal.
 * 
 */
package animals;

import java.util.Random;

/**
 *
 * @author Martim Ferreira - 21/04/2018
 * 
 */
public abstract class Animal {
    
    private int age;
    private String gender;
    private float moveSpeed, walkSpeed, runSpeed;
    private float belly, currentEnergy, maxEnergy, runEnergyCost;
    private boolean alive;
    
    public Animal(float walkSpeed, float runSpeed, float runEnergyCost) {
        age = 0;
        
        Random rand = new Random();
        int val = rand.nextInt(1);
        switch (val) {
            case 0:
                gender = "Female";
                break;
            case 1:
                gender = "Male";
                break;
        }
        
        moveSpeed = walkSpeed;
        this.walkSpeed = walkSpeed;
        this.runSpeed = runSpeed;
        belly = 100;
        currentEnergy = 100;
        maxEnergy = 100;
        this.runEnergyCost = runEnergyCost;
        alive = true;
    }
    
    /*
    * "rat" fills belly by 15 points.
    * "smallRation" fills belly by 33 points.
    * "mediumRation" fills belly by 50 points.
    * "largeRation" completely fills belly.
    */
    public void eat(String mealType) {
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
    public void sleep(int hours) {
        currentEnergy += (100 * hours) / 8;
        if (currentEnergy > maxEnergy) currentEnergy = maxEnergy;
    }
    
    /*
    * Change movement speed to walking speed.
    */
    public void walk() {
        moveSpeed = walkSpeed;
    }
    
    /*
    * Change movement speed to run speed.
    * Performing this action costs energy.
    * The animal cannot perform it if it does not have the necessary energy.
    */
    public void run() {
        if (currentEnergy >= runEnergyCost) {
            moveSpeed = runSpeed;
            currentEnergy -= runEnergyCost;
        } else System.out.println("Not enough energy!");
    };
    
    /*
    * Change alive variable to false, meaning dead.
    */
    public void die() {
        alive = false;
    };
    
    /*
    * TODO
    */
    public void reproduce() {};

    /*
    * Ages animal by 1 year.
    */
    public void age() {
        age += 1;
    }

    /*
    * Returns the animal's current age.
    */
    public int getAge() {
        return age;
    }

    /*
    * Returns the animal's gender.
    */
    public String getGender() {
        return gender;
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

    /*
    * Modifies the animal's age.
    */
    public void setAge(int age) {
        this.age = age;
    }

    /*
    * Modifies the animal's gender.
    */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /*
    * Modifies the animal's movement speed.
    */
    public void setMoveSpeed(float moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    /*
    * Modifies the animal's walking speed.
    */
    public void setWalkSpeed(float walkSpeed) {
        this.walkSpeed = walkSpeed;
    }

    /*
    * Modifies the animal's running speed.
    */
    public void setRunSpeed(float runSpeed) {
        this.runSpeed = runSpeed;
    }

    /*
    * Modifies the animal's bully fullness.
    */
    public void setBelly(float belly) {
        this.belly = belly;
    }

    /*
    * Modifies the animal's current energy.
    */
    public void setCurrentEnergy(float currentEnergy) {
        this.currentEnergy = currentEnergy;
    }

    /*
    * Modifies the animal's maximum energy.
    */
    public void setMaxEnergy(float maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    /*
    * Modifies the animal's running energy cost.
    */
    public void setRunEnergyCost(float runEnergyCost) {
        this.runEnergyCost = runEnergyCost;
    }

    /*
    * Modifies the animal's alive status.
    */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    
}