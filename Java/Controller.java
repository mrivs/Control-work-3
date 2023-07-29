package Java;

import java.util.Date;
import java.util.Scanner;

public class Controller {

    static Scanner scanner = new Scanner(System.in);
    private static String menu = " 1. Новое животное  2. Показать животных  3. Список команд животного  4. Добавить команду  5. Выход";
    private static String addmenu = " 1. Кошка  2. Пес  3. Хомяк  4. Конь  5. Верблюд  6. Осел";

    public static void start() {
        while (true) {
            System.out.println(menu);
            System.out.print("введите значение: ");
            int n = input();

            if (n == 1) {
                addAnimal();
            } else if (n == 2) {
                System.out.println(PetReg.getAnimals());
            } else if (n == 3) {
                System.out.print("введите ид: ");
                try {
                    System.out.println(PetReg.getAnimalCommands(input()));

                } catch (Exception e) {
                    System.out.println("Неверный ид");
                }

            } else if (n == 4) {
                System.out.print("введите ид: ");
                int id =input();
                System.out.print("введите команду: ");
                String command =scanner.nextLine();
                try {
                    PetReg.addAnimalCommands(id,command);

                } catch (Exception e) {
                    System.out.println("Неверный ид");
                }

            } else if (n == 5) {
                break;
            }
        }

    }

    public static void addAnimal() {
        System.out.println("Кого добавить?");
        System.out.println(addmenu);
        int n = input();
        if (n > 6 || n < 1)
            return;
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите дату рождения (dd-MM-yyyy): ");
        String date = scanner.nextLine();
        try {
            Date birthday = DateConverter.convertStringToDate(date);
            PetReg.addAnimal(name, birthday, n);

        } catch (Exception e) {
            System.out.println("Неверный формат даты");
            
        }

    }

    public static int input() {
        int inp;
        String input = scanner.nextLine();
        if (isInteger(input)) {
            inp = Integer.parseInt(input);
        } else {
            inp = -1;
        }
        if (inp < 0)
            inp = -2;
        return inp;
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
