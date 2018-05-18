/*
 * This class represents the basic actions and attributes of every animal.
 */
package animals;

import java.util.Random;

/**
 * @author Martim Ferreira - 21/04/2018, Nicole Vieira e Rui Iria
 */
public abstract class Animal {
    
    private int age;
    private String gender;
    private float belly, currentEnergy, maxEnergy, runEnergyCost;
    private boolean alive;
    
    public Animal(float runEnergyCost) {
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
        belly = 100;
        currentEnergy = 100;
        maxEnergy = 100;
        this.runEnergyCost = runEnergyCost;
        alive = true;
    }
    
    /*
    * "smallRation" fills belly by 33 points.
    * "mediumRation" fills belly by 50 points.
    * "largeRation" completely fills belly.
    */
    public void eat(String mealType) {
        switch (mealType) {
            case "smallRation":
                setBelly(belly += 33);
                break;
            case "mediumRation":
                setBelly(belly += 50);
                break;
            case "largeRation":
                setBelly(100);
                break;
        }
        
        if (belly > 100) belly = 100;
    }
    
    public void passTime(){
        setCurrentEnergy(getCurrentEnergy()-7, "");
        setBelly(getBelly()-7);
    }
    
    /*
    * Recovers energy depending on the amount of hours slept.
    * Formula: re = (100 * hours) / 8
    * TODO: wake up earlier if max energy is reached
    */
    public void sleep(int hours, String name) {
        currentEnergy += (100 * hours) / 8;
        if (currentEnergy > maxEnergy) currentEnergy = maxEnergy;
        
        System.out.println(name + " sleeps for " + hours + " hours. It recovers some energy.");
    }
    
    /*
    * Performing this action costs energy.
    * The animal cannot perform it if it does not have the necessary energy.
    */
    public void run(String name) {
        if (currentEnergy >= runEnergyCost) {
            currentEnergy -= runEnergyCost;
        } else { 
            System.out.println("Not enough energy!"); 
            sleep(8, name);
        }
    };
    
    /*
    * Kill animal.
    */
    public void die() {
        belly = 0;
        currentEnergy = 0;
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
    * Modifies the animal's bully fullness.
    */
    public void setBelly(float belly) {
        if (this.belly + belly > 100) this.belly = 100;
        else this.belly = belly;
    }

    /*
    * Modifies the animal's current energy.
    * If it's out of energy go to sleep.
    */
    public void setCurrentEnergy(float currentEnergy, String name) {
        if (this.currentEnergy - currentEnergy < 0) {
            currentEnergy = 0;
            sleep(8, name);
        }
        else this.currentEnergy = currentEnergy;
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