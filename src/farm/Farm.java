/*
 * Debug (test) class.
 */
package farm;
import animals.*;
import java.util.ArrayList;
import java.util.Random;

import java.util.Scanner;

/**
 * @author Martim - 07/05/2018
 */
public class Farm {
    
    public static void main(String[] args) {
        
        int hour = 0;
        
        ArrayList<Hunter> hunters = new ArrayList<Hunter>();
        hunters.add(new Dog());
        hunters.add(new Cat());
        
        ArrayList<Bird> birds = new ArrayList<Bird>();
        birds.add(new Bird());
        
        ArrayList<Rat> rats = new ArrayList<Rat>();
        rats.add(new Rat());
        
        ArrayList<RandomEvent> randomEvents = new ArrayList<RandomEvent>();
        randomEvents.add(new RandomEvent("Dog fights cat."));
        randomEvents.add(new RandomEvent("Bird flies."));
        randomEvents.add(new RandomEvent("Rat eats."));
        
        for (;;) {
            // Generate integer to find out if an event should happen.
            Random rand = new Random();
            int prob = rand.nextInt(100);
            
            if (prob >= 50) {
                // What event should happen.
                prob = rand.nextInt(2);
                
                switch(prob) {
                    case 0:
                        hunters.get(0).fight(hunters.get(0), hunters.get(1));
                        break;
                    case 1:
                        birds.get(0).fly();
                        break;
                    case 2:
                        rats.get(0).eat("small");
                        break;
                }
            }
            
            
            // if hour >= 22 && hour <= 6 animals should be sleeping
            // each hour every animal should lose energy and belly
            
            
            
            if (hour == 24) hour = 0;
            else hour++;
        }
        
        /*
        Scanner scan = new Scanner(System.in);
        
        System.out.println("1 - Dog hunts rat");
        System.out.println("2 - Cat hunts rat");
        System.out.println("3 - Cat hunts bird");
        System.out.println("4 - Dog attacks cat");
        System.out.println("5 - Cat attacks dog");
        System.out.println("6 - Dog sleeps");
        System.out.println("7 - Cat sleeps");
        System.out.println("");
        
        int choice = scan.nextInt();
        System.out.println("");
        
        switch (choice) {
            case 1:
                Dog dog = new Dog();
                Rat rat = new Rat();
                
                System.out.println("Dog energy: " + dog.getCurrentEnergy());
                System.out.println("Dog belly: " + dog.getBelly());
                System.out.println("Rat energy: " + rat.getCurrentEnergy());
                System.out.println("Rat alive: " + rat.isAlive());
                System.out.println("");
                
                dog.hunt(dog, rat, 23);
                
                System.out.println("");
                System.out.println("Dog energy: " + dog.getCurrentEnergy());
                System.out.println("Dog belly: " + dog.getBelly());
                System.out.println("Rat energy: " + rat.getCurrentEnergy());
                System.out.println("Rat alive: " + rat.isAlive());
                
                break;
            case 2:
                Cat cat = new Cat();
                Rat rat2 = new Rat();
                
                System.out.println("Cat energy: " + cat.getCurrentEnergy());
                System.out.println("Cat belly: " + cat.getBelly());
                System.out.println("Rat energy: " + rat2.getCurrentEnergy());
                System.out.println("Rat alive: " + rat2.isAlive());
                System.out.println("");
                
                cat.hunt(cat, rat2, 23);
                
                System.out.println("");
                System.out.println("Cat energy: " + cat.getCurrentEnergy());
                System.out.println("Cat belly: " + cat.getBelly());
                System.out.println("Rat energy: " + rat2.getCurrentEnergy());
                System.out.println("Rat alive: " + rat2.isAlive());
                
                break;
            case 3:
                Cat cat2 = new Cat();
                Bird bird = new Bird();
                
                System.out.println("Cat energy: " + cat2.getCurrentEnergy());
                System.out.println("Cat belly: " + cat2.getBelly());
                System.out.println("Bird energy: " + bird.getCurrentEnergy());
                System.out.println("Bird alive: " + bird.isAlive());
                System.out.println("");
                
                cat2.hunt(cat2, bird, 23);
                
                System.out.println("");
                System.out.println("Cat energy: " + cat2.getCurrentEnergy());
                System.out.println("Cat belly: " + cat2.getBelly());
                System.out.println("Bird energy: " + bird.getCurrentEnergy());
                System.out.println("Bird alive: " + bird.isAlive());
                
                break;
            case 4:
                Dog dog2 = new Dog();
                Cat cat3 = new Cat();
                
                System.out.println("Dog energy: " + dog2.getCurrentEnergy());
                System.out.println("Dog belly: " + dog2.getBelly());
                System.out.println("Cat energy: " + cat3.getCurrentEnergy());
                System.out.println("Cat belly: " + cat3.getBelly());
                System.out.println("");
                
                dog2.fight(dog2, cat3);
                
                System.out.println("");
                System.out.println("Dog energy: " + dog2.getCurrentEnergy());
                System.out.println("Dog belly: " + dog2.getBelly());
                System.out.println("Cat energy: " + cat3.getCurrentEnergy());
                System.out.println("Cat belly: " + cat3.getBelly());
                break;
            case 5:
                Dog dog3 = new Dog();
                Cat cat4 = new Cat();
                
                System.out.println("Dog energy: " + dog3.getCurrentEnergy());
                System.out.println("Dog belly: " + dog3.getBelly());
                System.out.println("Cat energy: " + cat4.getCurrentEnergy());
                System.out.println("Cat belly: " + cat4.getBelly());
                System.out.println("");
                
                cat4.fight(cat4, dog3);
                
                System.out.println("");
                System.out.println("Dog energy: " + dog3.getCurrentEnergy());
                System.out.println("Dog belly: " + dog3.getBelly());
                System.out.println("Cat energy: " + cat4.getCurrentEnergy());
                System.out.println("Cat belly: " + cat4.getBelly());
                
                break;
            case 6:
                Dog dog4 = new Dog();
                
                
                float val = dog4.getCurrentEnergy();
                val -= 50;
                dog4.setCurrentEnergy(val, dog4.getName());
                System.out.println("Dog energy: " + dog4.getCurrentEnergy());
                System.out.println("Dog belly: " + dog4.getBelly());
                System.out.println("");
                
                dog4.sleep(8, dog4.getName());
                
                System.out.println("");
                System.out.println("Dog energy: " + dog4.getCurrentEnergy());
                System.out.println("Dog belly: " + dog4.getBelly());
                
                break;
            case 7:
                Cat cat5 = new Cat();
                
                
                float val2 = cat5.getCurrentEnergy();
                val2 -= 50;
                cat5.setCurrentEnergy(val2, cat5.getName());
                System.out.println("Cat energy: " + cat5.getCurrentEnergy());
                System.out.println("Cat belly: " + cat5.getBelly());
                System.out.println("");
                
                cat5.sleep(8, cat5.getName());
                
                System.out.println("");
                System.out.println("Cat energy: " + cat5.getCurrentEnergy());
                System.out.println("Cat belly: " + cat5.getBelly());
                
                break;
        }
        */
    }
    
}