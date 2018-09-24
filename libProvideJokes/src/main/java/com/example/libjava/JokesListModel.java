package com.example.libjava;

public class JokesListModel {
    private String joke="Can a kangaroo jump higher than a house?\n" +
            "-\n" +
            "Of course, a house doesn’t jump at all.\n"+", next"+
            "What does a snail say when he finds himself on a turtle’s back?\n" +
            "-\n" +
            "Wheeee!!!\n" +", next"+
            "What is the best season to jump on a trampoline?\n" +
            "-\n" +
            "Spring time.\n" +", next"+
            "What is the strongest creature in the world? The snail. It carries its whole house on its back.\n" +", next"+
            "What is orange and sounds like a parrot?\n" +
            "-\n" +
            "A carrot.\n" +", next"+
            "Bus driver to passenger: Don’t you want to sit down?\n" +
            "\n" +
            "Passenger: No, I am in a hurry.\n"
            ;

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }
}
