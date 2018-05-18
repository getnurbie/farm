/*
 * Debug (test) class.
 */
package farm;
import animals.*;
import java.util.ArrayList;
import java.util.Random;

import java.util.Scanner;

/**
 * @author Martim - 07/05/2018, Nicole Vieira e Rui Iria
 */
public class Farm {
    
    public static void main(String[] args) {
        
        int hour = 0; //time that passed on each event
        
        ArrayList<Hunter> hunters = new ArrayList<Hunter>(); //arraylist type hunter
        hunters.add(new Dog()); //adding the dog to the arraylist
        hunters.add(new Cat()); //adding the cat to the arraylist
        
        ArrayList<Bird> birds = new ArrayList<Bird>(); //arraylist type bird
        birds.add(new Bird()); //adding the bird to the arraylist
        
        ArrayList<Rat> rats = new ArrayList<Rat>(); //arraylist type rat
        rats.add(new Rat()); //adding the rat to the arraylist
        
        ArrayList<Chicken> chickens = new ArrayList<Chicken>(); //arraylist type chicken
        chickens.add(new Chicken()); //adding the chicken to the arraylist
        
        ArrayList<Pig> pigs = new ArrayList<Pig>(); //arraylist type pig
        pigs.add(new Pig()); //adding the pig to the arraylist
        
        ArrayList<Cow> cows = new ArrayList<Cow>(); //arraylist type cow
        cows.add(new Cow()); //adding the cow to the arraylist
        
        ArrayList<RandomEvent> randomEvents = new ArrayList<RandomEvent>(); //arraylist to randomize the events that should happen
        randomEvents.add(new RandomEvent("")); //function fighting
        randomEvents.add(new RandomEvent("A bird soars through the sky!"));
        randomEvents.add(new RandomEvent("A rodent eats in some corner!"));
        randomEvents.add(new RandomEvent("One more year passed! The animals are getting older!"));
        randomEvents.add(new RandomEvent("The dog is having the time of his live while running like a mad dog!"));
        randomEvents.add(new RandomEvent("The dog barks while hunting the rat!"));
        randomEvents.add(new RandomEvent("A bird eats on the perch!"));
        randomEvents.add(new RandomEvent("A dog eats on the floor like there is no tomorrow!"));
        randomEvents.add(new RandomEvent("A cat eats in a elegant way!"));
        randomEvents.add(new RandomEvent("The rat is exercising in a healthy way!"));
        randomEvents.add(new RandomEvent("The lazy cat has too many energy stored, so he is running to be lazy again!"));
        randomEvents.add(new RandomEvent("The dog is jumping around in order to hunt the bird!"));
        randomEvents.add(new RandomEvent("The cat waits to get a chance to hunt the rat!"));
        randomEvents.add(new RandomEvent("The pig eats more than his share!"));
        randomEvents.add(new RandomEvent("The cow eats the green land!"));
        randomEvents.add(new RandomEvent("The chicken spouts the food!"));
        randomEvents.add(new RandomEvent("The cow gives warm milk!"));
        randomEvents.add(new RandomEvent("The chicken lays eggs under the sun!"));
        randomEvents.add(new RandomEvent("The pig gives bacon!"));
        randomEvents.add(new RandomEvent("The cow runs scared!"));
        randomEvents.add(new RandomEvent("The pig does a little exercise!"));
        randomEvents.add(new RandomEvent("The cow gives beef!"));
        randomEvents.add(new RandomEvent("The chicken gives chicken breasts!"));
        randomEvents.add(new RandomEvent(""));
        
        
        for (;;) {
            // if it's day time
            if (hour < 22 && hour > 6) {
                // Generate integer to find out if an event should happen.
                Random rand = new Random();
                int prob = rand.nextInt(100);

                // Generate integer to find out which ration to eat
                Random ration = new Random();
                int quantity = ration.nextInt(75);
                            
                if (prob >= 50) {
                    // What event should happen.
                    prob = rand.nextInt(24);

                    switch(prob) {
                        case 0: //the dog and the cat fighting
                            hunters.get(0).fight(hunters.get(0), hunters.get(1));
                            System.out.println("Current energy: " + hunters.get(0).getCurrentEnergy());
                            System.out.println("Belly fullness: " + hunters.get(0).getBelly());
                            break;
                        case 1: //the bird flies
                            birds.get(0).fly();
                            birds.get(0).setCurrentEnergy(birds.get(0).getCurrentEnergy()-10, birds.get(0).getClass().getName());
                            birds.get(0).setBelly(birds.get(0).getBelly() - 5);
                            System.out.println("Current energy: " + birds.get(0).getCurrentEnergy());
                            System.out.println("Belly fullness: " + birds.get(0).getBelly());
                            break;
                        case 2: //the rat eats
                            if(quantity >= 0 && quantity <= 25) rats.get(0).eat("smallRation");
                            if(quantity >= 25 && quantity <= 50) rats.get(0).eat("mediumRation");
                            if(quantity >= 50 && quantity <= 75) rats.get(0).eat("largeRation");
                            System.out.println("Belly fullness: " + rats.get(0).getBelly());
                            break;
                        case 3: //animals aged
                            hunters.get(0).age();
                            hunters.get(1).age();
                            birds.get(0).age();
                            rats.get(0).age();
                            pigs.get(0).age();
                            cows.get(0).age();
                            chickens.get(0).age();
                            System.out.println(hunters.get(0).getName() + " age: " + hunters.get(0).getAge());
                            System.out.println(hunters.get(1).getName() + " age: " + hunters.get(1).getAge());
                            System.out.println(birds.get(0).getClass().getName() + " age: " + birds.get(0).getAge());
                            System.out.println(rats.get(0).getClass().getName() + " age: " + rats.get(0).getAge());
                            System.out.println(pigs.get(1).getName() + " age: " + pigs.get(1).getAge());
                            System.out.println(cows.get(0).getClass().getName() + " age: " + cows.get(0).getAge());
                            System.out.println(chickens.get(0).getClass().getName() + " age: " + chickens.get(0).getAge());
                            break;
                        case 4: //dog runs
                            hunters.get(0).run(hunters.get(0).getName());
                            hunters.get(0).setCurrentEnergy(hunters.get(0).getCurrentEnergy()-10, hunters.get(0).getName());
                            hunters.get(0).setBelly(hunters.get(0).getBelly() - 15);
                            System.out.println("Current energy: " + hunters.get(0).getCurrentEnergy());
                            System.out.println("Belly fullness: " + hunters.get(0).getBelly());
                            break;
                        case 5: //dog hunts rat
                            hunters.get(0).hunt(hunters.get(0), rats.get(0), hour);
                            break;
                        case 6: //bird eats
                            if(quantity >= 0 && quantity <= 25) birds.get(0).eat("smallRation");
                            if(quantity >= 25 && quantity <= 50) birds.get(0).eat("mediumRation");
                            if(quantity >= 50 && quantity <= 75) birds.get(0).eat("largeRation");
                            System.out.println("Belly fullness: " + birds.get(0).getBelly());
                            break;
                        case 7: //dog eats
                            if(quantity >= 0 && quantity <= 25) hunters.get(0).eat("smallRation");
                            if(quantity >= 25 && quantity <= 50) hunters.get(0).eat("mediumRation");
                            if(quantity >= 50 && quantity <= 75) hunters.get(0).eat("largeRation");
                            System.out.println("Belly fullness: " + hunters.get(0).getBelly());
                            break;
                        case 8: //cat eats
                            if(quantity >= 0 && quantity <= 25) hunters.get(1).eat("smallRation");
                            if(quantity >= 25 && quantity <= 50) hunters.get(1).eat("mediumRation");
                            if(quantity >= 50 && quantity <= 75) hunters.get(1).eat("largeRation");
                            System.out.println("Belly fullness: " + hunters.get(1).getBelly());
                            break;
                        case 9: //rat runs
                            rats.get(0).run(rats.get(0).getClass().getName());
                            rats.get(0).setCurrentEnergy(rats.get(0).getCurrentEnergy()-10, rats.get(0).getClass().getName());
                            rats.get(0).setBelly(rats.get(0).getBelly() - 15);
                            System.out.println("Current energy: " + rats.get(0).getCurrentEnergy());
                            System.out.println("Belly fullness: " + rats.get(0).getBelly());
                            break;
                        case 10: //cat runs
                            hunters.get(1).run(hunters.get(1).getName());
                            hunters.get(1).setCurrentEnergy(hunters.get(1).getCurrentEnergy()-10, hunters.get(1).getName());
                            hunters.get(1).setBelly(hunters.get(1).getBelly() - 15);
                            System.out.println("Current energy: " + hunters.get(1).getCurrentEnergy());
                            System.out.println("Belly fullness: " + hunters.get(1).getBelly());
                            break;
                        case 11: //dog hunt bird
                            hunters.get(0).hunt(hunters.get(0), birds.get(0), hour);
                            break;
                        case 12: //cat hunt rat
                            hunters.get(1).hunt(hunters.get(1), rats.get(0), hour);
                            break;
                        case 13: //cat hunt bird
                            hunters.get(1).hunt(hunters.get(1), birds.get(0), hour);
                            break;
                        case 14: //the cat and the dog fighting
                            hunters.get(1).fight(hunters.get(1), hunters.get(0));
                            System.out.println("Current energy: " + hunters.get(1).getCurrentEnergy());
                            System.out.println("Belly fullness: " + hunters.get(1).getBelly());
                            break;
                        case 15: //the pig eats
                            if(quantity >= 0 && quantity <= 25) pigs.get(0).eat("smallRation");
                            if(quantity >= 25 && quantity <= 50) pigs.get(0).eat("mediumRation");
                            if(quantity >= 50 && quantity <= 75) pigs.get(0).eat("largeRation");
                            System.out.println("Belly fullness: " + pigs.get(0).getBelly());
                            break;
                        case 16: //the cow eats
                            if(quantity >= 0 && quantity <= 25) cows.get(0).eat("smallRation");
                            if(quantity >= 25 && quantity <= 50) cows.get(0).eat("mediumRation");
                            if(quantity >= 50 && quantity <= 75) cows.get(0).eat("largeRation");
                            System.out.println("Belly fullness: " + cows.get(0).getBelly());
                            break;
                        case 17: //the chicken eats
                            if(quantity >= 0 && quantity <= 25) chickens.get(0).eat("smallRation");
                            if(quantity >= 25 && quantity <= 50) chickens.get(0).eat("mediumRation");
                            if(quantity >= 50 && quantity <= 75) chickens.get(0).eat("largeRation");
                            System.out.println("Belly fullness: " + chickens.get(0).getBelly());
                            break;
                        case 18: //harvest the cow
                            cows.get(0).harvestResource(cows.get(0), hour);
                            break;
                        case 19: //harvest the chicken
                            chickens.get(0).harvestResource(chickens.get(0), hour);
                            break;
                        case 20: //harvest the pig's meat
                            pigs.get(0).harvestMeat(pigs.get(0));
                            break;
                        case 21: //the cow runs
                            cows.get(0).run(cows.get(0).getName());
                            cows.get(0).setCurrentEnergy(cows.get(0).getCurrentEnergy()-8, cows.get(0).getName());
                            cows.get(0).setBelly(cows.get(0).getBelly() - 15);
                            System.out.println("Current energy: " + cows.get(0).getCurrentEnergy());
                            System.out.println("Belly fullness: " + cows.get(0).getBelly());
                            break;
                        case 22: //the pigs runs
                            pigs.get(0).run(pigs.get(0).getName());
                            pigs.get(0).setCurrentEnergy(pigs.get(0).getCurrentEnergy()-15, pigs.get(0).getName());
                            pigs.get(0).setBelly(pigs.get(0).getBelly() - 15);
                            System.out.println("Current energy: " + pigs.get(0).getCurrentEnergy());
                            System.out.println("Belly fullness: " + pigs.get(0).getBelly());
                            break;
                        case 23: //harvest the cow's meat
                            cows.get(0).harvestMeat(cows.get(0));
                            break;
                        case 24: //harvest the chicken's meat
                            chickens.get(0).harvestMeat(chickens.get(0));
                            break;
                    }
                    
                    System.out.println(randomEvents.get(prob).getDescription());
                }
                else{
                    System.out.println("Nothing happened.");
                    hunters.get(0).setBelly(hunters.get(0).getBelly()-5);
                    hunters.get(1).setBelly(hunters.get(1).getBelly()-5);
                    rats.get(0).setBelly(rats.get(0).getBelly()-3);
                    birds.get(0).setBelly(birds.get(0).getBelly()-3);
                    pigs.get(0).setBelly(pigs.get(0).getBelly()-7);
                    cows.get(0).setBelly(cows.get(0).getBelly()-5);
                    chickens.get(0).setBelly(chickens.get(0).getBelly()-4);
                    hunters.get(0).setCurrentEnergy(hunters.get(0).getCurrentEnergy()-1, hunters.get(0).getName());
                    hunters.get(1).setCurrentEnergy(hunters.get(1).getCurrentEnergy()-1, hunters.get(1).getName());
                    rats.get(0).setCurrentEnergy(rats.get(0).getCurrentEnergy()-1, rats.get(0).getClass().getName());
                    birds.get(0).setCurrentEnergy(birds.get(0).getCurrentEnergy()-1, birds.get(0).getClass().getName());
                    pigs.get(0).setCurrentEnergy(pigs.get(0).getCurrentEnergy()-1, pigs.get(0).getName());
                    cows.get(0).setCurrentEnergy(cows.get(0).getCurrentEnergy()-1, cows.get(0).getName());
                    chickens.get(0).setCurrentEnergy(chickens.get(0).getCurrentEnergy()-1, chickens.get(0).getName());
                }
                
                System.out.println("Continue? y or n");
                Scanner scan = new Scanner(System.in);
                String response = scan.nextLine();
                if (response.equals("y")) {

                } else if (response.equals("n")) {
                    break;
                }
            }
            else{
                System.out.println("Do you want to skip the night? y or n");
                Scanner scanAnswer = new Scanner(System.in);
                String skip = scanAnswer.nextLine();
                if (skip.equals("y")) {
                    hour = 7;
                }
            }
            // if hour >= 22 && hour <= 6 animals should be sleeping
            if(hour == 22){
                for(int i= 0; i < hunters.size(); i++){
                    hunters.get(i).sleep(22, hunters.get(i).getName());
                }
                for(int i= 0; i < birds.size(); i++){
                    birds.get(i).sleep(22, birds.get(i).getClass().getName());
                }
                for(int i= 0; i < rats.size(); i++){
                    rats.get(i).sleep(22, rats.get(i).getClass().getName());
                }
                for(int i= 0; i < pigs.size(); i++){
                    pigs.get(i).sleep(22, pigs.get(i).getClass().getName());
                }
                for(int i= 0; i < cows.size(); i++){
                    cows.get(i).sleep(22, cows.get(i).getClass().getName());
                }
                for(int i= 0; i < chickens.size(); i++){
                    chickens.get(i).sleep(22, chickens.get(i).getClass().getName());
                }
            }
            // each hour every animal should lose energy and belly
            for(int i= 0; i < hunters.size(); i++){
                hunters.get(i).passTime();
            }
            for(int i= 0; i < birds.size(); i++){
                birds.get(i).passTime();
            }
            for(int i= 0; i < rats.size(); i++){
                rats.get(i).passTime();
            }
            for(int i= 0; i < pigs.size(); i++){
                pigs.get(i).passTime();
            }
            for(int i= 0; i < cows.size(); i++){
                cows.get(i).passTime();
            }
            for(int i= 0; i < chickens.size(); i++){
                chickens.get(i).passTime();
            }
            
            if (hour == 24) hour = 0;
            else hour++;
            
            
            System.out.println("Time has passed. Now: " + hour + ":00\n\n");
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