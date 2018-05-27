package com.example.ihushevhive.myapplication.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppControl {
    private AppControl instance = new AppControl();

    private List<Dish> dishes = new ArrayList<>();
    private AppControl(){
        dishes = Arrays.asList(
                new Dish("Tefal Expertise 25", "pan, stewpan", 1319, "Tefal"),
                new Dish("Pensofal Uniqum Bio Stone","pan, stewpan", 369, "Pensofal" ),
                new Dish("BergHOFF Eclipse","pan, stewpan", 1606,"BergHOFF" ),
                new Dish("Pyrex Essence","pan, stewpan", 425,"Pyrex"  ),
                new Dish("Tefal Character","pan, stewpan", 1120,"Tefal" ),
                new Dish("Rondell Mocco&Latte","pan, stewpan", 939, "Rondell" ),

                new Dish("Tefal Character","pot, ladle", 849,"Tefal"),
                new Dish("Rondell Brilliance","pot, ladle", 999,"Rondell"),
                new Dish("Tefal Expertise","pot, ladle", 1431,"Tefal"),
                new Dish("Rondell Strike","pot, ladle", 849,"BergHOFF"),
                new Dish("Tefal Pleasure","pot, ladle", 999,"Tefal"),

                new Dish("Lora NA4PRT", "brazier", 799, "Lora"),
                new Dish("Lamart Olympia", "brazier", 870, "Lamart"),
                new Dish("Vinzer Cast Form Classic", "brazier", 1489, "Vinzer"),
                new Dish("Vinzer Premium Granite", "brazier", 2144, "Vinzer"),
                new Dish("Lamart Aroma", "brazier", 799, "Lamart"),

                new Dish("Ballarini Patisserie", "baking tray", 259, "Ballarini"),
                new Dish("BergHOFF Eclipse", "baking tray", 1611, "BergHOFF"),
                new Dish("BergHOFF EarthChef", "baking tray", 1770, "BergHOFF"),
                new Dish("Vinzer Whitford Xylan", "baking tray", 431, "Vinzer"),
                new Dish("Ballarini Cortina Granitium", "baking tray", 1263, "Ballarini")
        );
    };
}
