package com.company;

public class TicTacAI
    {
        public Gamerunner gameboard;
        public int sizeOfBoard;

        public TicTacAI(Gamerunner game)
            {
                gameboard = game;
                sizeOfBoard = gameboard.sizeOfBoard;
            }

        public void Move()
            {
                String checker = "";
                boolean end = true;
                for(int i = 0; i<sizeOfBoard; i++)
                    {
                        checker = gameboard.getBoardConRow(i).toLowerCase();
                        if (checker.contains("x") && checker.contains("-"))
                            {
                                gameboard.PlaceO(i, checker.indexOf("-"));
                                end = false;
                                break;
                            }
                    }
                if (end)
                    {
                        for(int i = 0; i<sizeOfBoard; i++)
                            {
                                checker = gameboard.getBoardConColumn(i).toLowerCase();
                                if (checker.contains("x") && checker.contains("-"))
                                    {
                                        gameboard.PlaceO(checker.indexOf("-"), i);
                                        end = false;
                                        break;
                                    }
                            }
                        checker = gameboard.getBoardConDiagonal(0);
                        if (checker.contains("x") && checker.contains("-") && end)
                            {
                                gameboard.PlaceO(checker.indexOf("-"), checker.indexOf("-"));
                                end = false;
                            }
                        checker = gameboard.getBoardConDiagonal(1);
                        if (checker.contains("x") && checker.contains("-") && end)
                            {
                                gameboard.PlaceO(checker.indexOf("-"),(sizeOfBoard - checker.indexOf("-")-1));
                            }
                        if(end)
                            {
                                gameboard.PlaceO(0,0);
                            }
                    }

            }
    }
