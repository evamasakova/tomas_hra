package com.company;

import com.company.entities.Player;
import com.company.entities.Race;

import java.util.Locale;

public class Game {

    private final String gameName = "Kindergarden - SPSMB DLC";
    private final double version = 0.2;
    private final String author = "Masakova Jr.";
    private Dialog dialog;
    private Player player;

    public Game() {
        dialog = new Dialog();
        player = new Player();
    }

    public void start() {
        dialog.welcome(gameName, version, author);
        welcomeMenu();
        storyIntro();
    }

    private void welcomeMenu() {
        dialog.say("Vzbudili jste se a zjistujete, ze se vase spoluzacka Karla ztratila. Naposledy byla videna vcera ve skole na posledni hodine programovani. I presto jste nedostali reditelske volno a tak se vydavate do skoly. ");
        dialog.say("Zvol si svoji rasu.", "red");
        for (Race value : Race.values()) {
            dialog.say(value.toString(), "red");
        }
        selectRace();
    }

    private void selectRace() {
        String userInput = dialog.userInput();
        boolean check = false;
        for (Race value : Race.values()) {
            if (userInput.trim().equalsIgnoreCase(value.toString())){
                check = true;
                player.setRace(value);
                break;
            }
        }
        if(!check){
            selectRace();
            return;
        }

    }

    private void storyIntro(){
        dialog.say("zvolil sis " + player.getRace(), "red");
        dialog.say("-----------------------------", "white");
        dialog.say("Hra začíná", "white");
        dialog.say("-----------------------------");
        dialog.say("Hey. You! You're finally awake. Tomasi musis nam pomoct najit Kaju! Ztratila se pred dvema dnemi a nikdo nevi kde je. ", "red");

    }


}
