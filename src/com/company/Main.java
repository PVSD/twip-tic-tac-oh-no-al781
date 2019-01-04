package com.company;

import java.util.Scanner;

public class Main
    {

        public static void main(String[] args)
            {
                Scanner strInput = new Scanner(System.in);
                Scanner intInput = new Scanner(System.in);
                System.out.println("Hello.\nI'm Timothy, the Tic Tack Toe AI.\nWhat size board do you want to play on?");
                Gamerunner game = new Gamerunner(intInput.nextInt());
                TicTacAI Timothy = new TicTacAI(game);
                System.out.println("I'll be Os.");
                System.out.println("Be Careful about placing your Xs because if you enter in a space that already has one, I am going to consider your turn void.");
                System.out.println("Do you want to go first?(y/n)");
                if(strInput.nextLine().equalsIgnoreCase("n"))
                    {
                        Timothy.Move();
                    }
                while(true)
                    {
                        game.Output();
                        System.out.println("Enter the X coordinate.");
                        int myX = intInput.nextInt();
                        System.out.println("Enter the Y coordinate.");
                        game.PlaceX(myX,intInput.nextInt());
                        game.Output();
                        Timothy.Move();
                    }
            }
    }
