package org.example;
import org.example.controller.MatchController;


public class Main {
    public static void main(String[] args) {

        MatchController matchController = MatchController.getInstance();
        MatchController.getNewMatch();

    }
}