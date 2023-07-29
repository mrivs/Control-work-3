package Java;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import Java.Animals.*;

public class PetReg {
    // private static ArrayList<Animal> animals = new ArrayList<Animal>();
    private static int id = 0;
    private static HashMap<Integer, Animal> animals = new HashMap<>();

    public static void addAnimal(String name, Date date, int type)  {
            id++;
            switch (type) {
                case 1:
                    animals.put(id, new Cat(name, date));
                    break;
                case 2:
                    animals.put(id, new Dog(name, date));
                    break;
                case 3:
                    animals.put(id, new Hamster(name, date));
                    break;
                case 4:
                    animals.put(id, new Horse(name, date));
                    break;
                case 5:
                    animals.put(id, new Camel(name, date));
                    break;
                case 6:
                    animals.put(id, new Donkey(name, date));
                    break;

                default:
                    break;
            }


    }

    public static String getAnimals() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Integer, Animal> entry : animals.entrySet()) {
            stringBuilder.append(entry.getKey()).append(" - ").append(entry.getValue()).append("\n");
        }

        String result = stringBuilder.toString();
        return result;
    }

    public static String getAnimalCommands(int id) throws Exception {
        try {
            return animals.get(id).getCommands();
        } catch (Exception e) {
            throw e;
        }
    }

    public static void addAnimalCommands(int id, String command) throws Exception {
        try {
            animals.get(id).addCommand(command);
            
        } catch (Exception e) {
            throw e;
        }
    }



}
