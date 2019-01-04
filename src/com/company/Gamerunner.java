package com.company;

public class Gamerunner
    {
        public String[][] board;
        public int sizeOfBoard;

        public Gamerunner(int boardSize)
            {
                sizeOfBoard = boardSize;
                board = new String[sizeOfBoard][sizeOfBoard];
                for (int i = 0; i<sizeOfBoard; i++)
                    {
                        for (int j = 0; j<sizeOfBoard; j++)
                            {
                                board[i][j] = "-";
                            }
                    }
            }

        public void Output()
            {
                for (int i = 0; i<sizeOfBoard; i++)
                    {
                        for (int j = 0; j<sizeOfBoard; j++)
                            {
                                System.out.print("| " + board[i][j] + " ");
                        }
                        System.out.println("|");
                        for (int k = 0; k<((4*sizeOfBoard)+1); k++)
                            {
                                System.out.print("_");
                            }
                        System.out.println();
                    }

            }

        public void PlaceX(int xpos, int ypos)
            {
                if (board[xpos][ypos].equalsIgnoreCase("-"))
                    {
                        board[xpos][ypos] = "X";
                    }
                else
                    {
                        System.out.println("INVALID PLACEMENT");
                    }
                determineWin();
            }

        public void PlaceO(int xpos, int ypos)
            {
                if (board[xpos][ypos].equalsIgnoreCase("-"))
                    {
                        board[xpos][ypos] = "O";
                    }
                else
                    {
                        System.out.println("INVALID PLACEMENT");
                    }
                determineWin();
            }

        public String getBoardConRow(int num)
            {
                String boardCon = "";
                for (int i = 0; i<sizeOfBoard; i++)
                    {
                        boardCon += board[i][num];
                    }
                return boardCon;
            }

            public String getBoardConColumn(int num)
                {
                    String boardCon = "";
                    for (int i = 0; i<sizeOfBoard; i++)
                    {
                        boardCon += board[num][i];
                    }
                    return boardCon;
                }

            public String getBoardConDiagonal(int num)
                {
                    String boardCon = "";
                    if(num == 0)
                    {
                        for (int i = 0; i<sizeOfBoard; i++)
                        {
                            boardCon += board[i][i];
                        }
                    }
                    if (num == 1)
                    {
                        int y = sizeOfBoard;
                        for (int x = 0; x<sizeOfBoard; x++)
                        {
                            y--;
                            boardCon += board[x][y];
                        }
                    }
                    return boardCon;
                }
            public void determineWin()
                {
                    String checker = "";
                    String winner = "";
                    String xCheck = "";
                    String oCheck = "";
                    boolean foundwinner = true;
                    for (int i = 0; i<sizeOfBoard; i++)
                        {
                            xCheck += "x";
                            oCheck += "o";
                        }
                    for (int i = 0; i<sizeOfBoard; i++)
                        {
                            checker = getBoardConRow(i);
                            if (checker.equalsIgnoreCase(xCheck))
                                {
                                    winner = "X";
                                    foundwinner = false;
                                    break;
                                }
                            else if (checker.equalsIgnoreCase(oCheck))
                                {
                                    winner = "O";
                                    foundwinner = false;
                                    break;
                                }
                        }
                    if(foundwinner)
                        {
                            for (int i = 0; i < sizeOfBoard; i++)
                                {
                                    checker = getBoardConColumn(i);
                                    if (checker.equalsIgnoreCase(xCheck))
                                        {
                                            winner = "X";
                                            foundwinner = false;
                                            break;
                                        }
                                    else if (checker.equalsIgnoreCase(oCheck))
                                        {
                                            winner = "O";
                                            foundwinner = false;
                                            break;
                                        }
                                }
                        }
                    if (foundwinner)
                        {
                            for(int i = 0; i<2;i++)
                                {
                                    checker = getBoardConDiagonal(i);
                                    if (checker.equalsIgnoreCase(xCheck))
                                        {
                                            winner = "X";
                                            foundwinner = false;
                                            break;
                                        }
                                    else if (checker.equalsIgnoreCase(oCheck))
                                        {
                                            winner = "O";
                                            foundwinner = false;
                                            break;
                                        }

                                }
                        }
                    if(!foundwinner)
                        {
                            System.out.println("The winner is " + winner + "s!\nHave a good day.");
                            System.exit(0);
                        }
                }

    }