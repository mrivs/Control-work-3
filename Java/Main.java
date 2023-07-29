package Java;

import java.text.SimpleDateFormat;

import Java.Animals.*;



public class Main {

    public static void main(String[] args) {

        PetReg.addAnimal("Murka",DateConverter.easyConv("20-11-2022"),1);
        PetReg.addAnimal("Polo",DateConverter.easyConv("20-10-2012"),2);
        PetReg.addAnimal("Spirit",DateConverter.easyConv("10-10-2013"),4);

       Controller.start(); 
    }
}