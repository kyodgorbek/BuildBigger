package com.example.lib100;

import java.util.Random;

public class Joker {

    private static final String[] jokes = new String[]{
            "What do you call a boomerang that won't come back? A stick.",
            "Can a kangaroo jump higher than a house? Of course, a house doesn’t jump at all\n",
            "Doctor: \"I'm sorry but you suffer from a terminal illness and have only 10 to live.\"\n" +
                    "\n" +
                    "Patient: \"What do you mean, 10? 10 what? Months? Weeks?!",
            "What do clouds wear under their shorts?Thunderpants",
           " Why do ghosts love elevators?Because they lift their spirits!",
           "What's brown and sounds like a bell? DUNGGGgggg",
           "What does an elephant use for a tampon? A sheep!",
           "How much does a hipster weigh? An instagram!",
           "Where do Volkswagens go when they get old? The Old Volks home!",
           "What kind of shoes does a pedophile wear? White vans."};



    String randomStr = jokes[new Random().nextInt(jokes.length - 1)];




    public String getJoke(){

        return randomStr;
    }



}
