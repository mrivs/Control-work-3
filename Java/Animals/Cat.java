package Java.Animals;

import java.util.Date;

public class Cat extends Pet {

    public Cat(String animalName, Date birthday) {
        super(animalName, birthday);
        this.className="Cat";
        this.addCommand("Maaaay");
        
    }
    
}
