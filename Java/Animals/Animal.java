package Java.Animals;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public abstract class Animal {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private String animalName;
    protected String className = "Animal";
    private Date birthday;
    private ArrayList<String> commands = new ArrayList<String>();

    public Animal(String animalName) {
        this.animalName = animalName;
    }

    public Animal(String animalName, Date birthday) {
        this.animalName = animalName;
        this.birthday = birthday;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getClassName() {
        return className;
    }

    public String getBirthday() {
        return birthday.toString();
    }

    public String getCommands() {
        if (commands.isEmpty()) {
            return "у животного команд нет";
        } else
            return "Команды: "+commands.toString();
    }

    public void addCommand(String command) {
        this.commands.add(command);
    }

    @Override
    public String toString() {
        return " " + className + " " + animalName + ",  birthday  " + dateFormat.format(birthday) + ";";
    }
}
