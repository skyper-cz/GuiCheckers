package cz.chesters.checkers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static java.util.Objects.isNull;

public class EksuelCheckers {
    JFrame frame = new JFrame("Checkers");
    Cell[][] cellField = new Cell[8][8];
    JButton[][] buttonField = new JButton[8][8];
    boolean isSelected = false;
    int xSelected = -1;
    int ySelected = -1;
    boolean isBlacksTurn = false;
    JButton playAgain = new JButton("Play again");
    JButton quit = new JButton("Quit");
    JLabel blackWon = new JLabel(new ImageIcon("resources/checkers/Victory screens/black wins.png"));
    JLabel whiteWon = new JLabel(new ImageIcon("resources/checkers/Victory screens/white wins.png"));
    JLabel turnDisplay = new JLabel("It should be white's turn");

    public void play() {
        System.out.println("Started checkers.");
        frame.setSize(860, 935);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        initializeButtons();

        initializeCells();

        System.out.println("Game ready!");
        render();
    }

    public void initializeButtons() {
        System.out.println("Initializing buttons...");
        int x;
        int y = 55;

        for (int ix = 0; ix < buttonField.length; ix++) {
            x = 5;
            for (int iy = 0; iy < buttonField[ix].length; iy++) {
                buttonField[ix][iy] = new JButton();
                buttonField[ix][iy].setBounds(x, y, 100, 100);
                frame.add(buttonField[ix][iy]);
                buttonField[ix][iy].setVisible(true);
                buttonField[ix][iy].addActionListener(this::click);
                x = x + 105;
            }
            System.out.println("x = " + x);
            y = y + 105;
        }
        System.out.println("y = " + y);

        blackWon.setBounds(23, 81, 800, 664);
        whiteWon.setBounds(23, 81, 800, 664);
        frame.add(blackWon);
        frame.add(whiteWon);
        blackWon.setVisible(false);
        whiteWon.setVisible(false);

        quit.setBounds(176, 782, 240, 70);
        playAgain.setBounds(444, 782, 240, 70);
        frame.add(quit);
        frame.add(playAgain);
        quit.setVisible(false);
        playAgain.setVisible(false);
        quit.addActionListener(this::click);
        playAgain.addActionListener(this::click);

        turnDisplay.setBounds(245, 5, 355, 40);
        frame.add(turnDisplay);
        turnDisplay.setVisible(true);
        turnDisplay.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));

        System.out.println("Done!");
    }

    public void initializeCells() {
        System.out.println("Initializing cells...");
        int x = 0;
        int y = 0;

        // Lord, have mercy.
        for (int ix = 0; ix < cellField.length; ix++) {
            x = 0;
            for (int iy = 0; iy < cellField[ix].length; iy++) {
                if (((x % 2) + (y % 2)) % 2 == 1) {
                    if (y < 3)
                        cellField[ix][iy] = new Cell(true, true);
                    else if (y > 4)
                        cellField[ix][iy] = new Cell(true, false);
                    else cellField[ix][iy] = new Cell(true);
                } else cellField[ix][iy] = new Cell(false);
                x++;
            }
            y++;
        }
        System.out.println("Done!");
    }

    public void click(ActionEvent e) {
        for (int x = 0; x < buttonField.length; x++) {
            for (int y = 0; y < buttonField[x].length; y++) {
                if (e.getSource() == buttonField[x][y]) {
                    System.out.println("button " + x + " " + y + " has been clicked");
                    if (this.isSelected) {
                        System.out.println("Something has already been selected...");
                        if (!cellField[x][y].isSelected) {
                            System.out.println("This tile is not selected.");
                            this.isSelected = false;
                        } else {
                            switch (cellField[x][y].selectReason) {
                                default:
                                    this.isSelected = false;
                                    break;

                                case JUMP:
                                    if (x > this.xSelected) {
                                        if (y > this.ySelected) {
                                            this.cellField[x - 1][y - 1].piece = null;
                                        } else if (y < this.ySelected) {
                                            this.cellField[x - 1][y + 1].piece = null;
                                        }
                                    } else if (x < this.xSelected) {
                                        if (y > this.ySelected) {
                                            this.cellField[x + 1][y - 1].piece = null;
                                        } else if (y < this.ySelected) {
                                            this.cellField[x + 1][y + 1].piece = null;
                                        }
                                    }
                                case MOVE:
                                    cellField[x][y].piece = cellField[xSelected][ySelected].piece;
                                    cellField[xSelected][ySelected].piece = null;
                                    this.isSelected = false;
                                    isBlacksTurn = !cellField[x][y].piece.isBlack;
                                    if ((x == 0 && !cellField[x][y].piece.isBlack) || (x == 7 && cellField[x][y].piece.isBlack)) {
                                        cellField[x][y].piece.promote();
                                    }
                                    break;
                            }
                        }

                        deselectAll();
                        render();
                    }

                    // klikáme na věc poprvé, nic zatim neni selected
                    // TODO: fix movement

                    else {
                        System.out.println("Nothing selected yet");

                        if (cellField[x][y].isBlack) {
                            cellField[x][y].select(true, Cell.Reason.NONE);
                            this.isSelected = true;
                        }
                        if (!isNull(cellField[x][y].piece)) {
                            System.out.println("Clicked cell has a non-null piece on it");
                            if (cellField[x][y].piece.isDama) {
                                System.out.println("Piece is a queen");
                                // tady se pro kazdou polaritu pojede až na okraj šachovnice a budou se označovat
                                // všechny tily a bude jim přiřazenej příslušnej SelectReason
                                for (int yPol = -1; yPol < 2; yPol = yPol + 2) {
                                    for (int xPol = -1; xPol < 2; xPol = xPol + 2) {
                                        try {
                                            for (int i = 1; i < 8; i++) {
                                                if (isNull(cellField[y + i * yPol][x + i * xPol].piece)) {
                                                    cellField[y + i * yPol][x + i * xPol].select(true, Cell.Reason.MOVE);
                                                } else if (cellField[y + i * yPol][x + i * xPol].piece.isBlack != cellField[y][x].piece.isBlack) {
                                                    if (isNull(cellField[y + (i + 1) * yPol][x + (i + 1) * xPol].piece)) {
                                                        this.cellField[y + (i + 1) * yPol][x + (i + 1) * xPol].select(true, Cell.Reason.JUMP);
                                                        break;
                                                    }
                                                } else {
                                                    break;
                                                }
                                            }
                                        } catch (Exception ignored) {
                                        }
                                    }
                                }
                            } else {
                                System.out.println("Clicked piece is not a queen");
                                if (cellField[x][y].piece.isBlack) {
                                    System.out.println("Clicked piece is black");

                                    try {
                                        if (!isNull(cellField[x + 1][y - 1].piece)) {
                                            if (cellField[x][y].piece.isBlack != cellField[x + 1][y - 1].piece.isBlack) {
                                                cellField[x + 2][y - 2].select(true, Cell.Reason.JUMP);
                                            }
                                        } else cellField[x + 1][y - 1].select(true, Cell.Reason.MOVE);
                                    } catch (Exception ignored) {
                                    }

                                    try {
                                        if (!isNull(cellField[x - 1][y - 1].piece)) {
                                            if (cellField[x][y].piece.isBlack != cellField[x - 1][y - 1].piece.isBlack) {
                                                cellField[x - 2][y - 2].select(true, Cell.Reason.JUMP);
                                            }
                                        }
                                    } catch (Exception ignored) {
                                    }

                                    try {

                                        if (!isNull(cellField[x + 1][y + 1].piece)) {
                                            if (cellField[x][y].piece.isBlack != cellField[x + 1][y + 1].piece.isBlack) {
                                                cellField[x + 2][y + 2].select(true, Cell.Reason.JUMP);
                                            }
                                        } else cellField[x + 1][y + 1].select(true, Cell.Reason.MOVE);
                                    } catch (Exception ignored) {
                                    }

                                    try {
                                        if (!isNull(cellField[x - 1][y + 1].piece)) {
                                            if (cellField[x][y].piece.isBlack != cellField[x - 1][y + 1].piece.isBlack) {
                                                cellField[x - 2][y + 2].select(true, Cell.Reason.JUMP);
                                            }
                                        }
                                    } catch (Exception ignored) {
                                    }

                                }

                                // figurka je bílá
                                else {
                                    System.out.println("Clicked piece is white");
                                    try {
                                        if (!isNull(cellField[x + 1][y - 1].piece)) {
                                            if (cellField[x][y].piece.isBlack != cellField[x + 1][y - 1].piece.isBlack) {
                                                cellField[x + 2][y - 2].select(true, Cell.Reason.JUMP);
                                            }
                                        }
                                    } catch (Exception ignored) {
                                    }

                                    try {
                                        if (!isNull(cellField[x - 1][y - 1].piece)) {
                                            if (cellField[x][y].piece.isBlack != cellField[x - 1][y - 1].piece.isBlack) {
                                                cellField[x - 2][y - 2].select(true, Cell.Reason.JUMP);
                                            }
                                        } else cellField[x - 1][y - 1].select(true, Cell.Reason.MOVE);
                                    } catch (Exception ignored) {
                                    }

                                    try {
                                        if (!isNull(cellField[x + 1][y + 1].piece)) {
                                            if (cellField[x][y].piece.isBlack != cellField[x + 1][y + 1].piece.isBlack) {
                                                cellField[x + 2][y + 2].select(true, Cell.Reason.JUMP);
                                            }
                                        }
                                    } catch (Exception ignored) {
                                    }

                                    try {
                                        if (!isNull(cellField[x - 1][y + 1].piece)) {
                                            if (cellField[x][y].piece.isBlack != cellField[x - 1][y + 1].piece.isBlack) {
                                                cellField[x - 2][y + 2].select(true, Cell.Reason.JUMP);
                                            }
                                        } else cellField[x - 1][y + 1].select(true, Cell.Reason.MOVE);
                                    } catch (Exception ignored) {
                                    }


                                }
                            }
                        } else System.out.println("Clicked tile has a null piece.");
                        xSelected = x;
                        ySelected = y;
                        render();
                    }

                }
            }
        }

        if (e.getSource() == playAgain) {
            for (int x = 0; x < cellField.length; x++) {
                for (int y = 0; y < cellField[x].length; y++) {
                    buttonField[x][y].setVisible(true);
                }
            }
            turnDisplay.setVisible(true);
            playAgain.setVisible(false);
            quit.setVisible(false);
            blackWon.setVisible(false);
            whiteWon.setVisible(false);
            initializeCells();
            render();
        } else if (e.getSource() == quit) {
            System.exit(0);
        } else whoWon();
    }

    public void deselectAll() {
        for (int x = 0; x < cellField.length; x++) {
            for (int y = 0; y < cellField[x].length; y++) {
                cellField[x][y].isSelected = false;
            }
        }
    }

    public void select(int x, int y) {
        this.cellField[x][y].isSelected = true;
    }


    public void deselect(int x, int y) {
        this.cellField[x][y].isSelected = false;
    }

    public void whoWon() {
        boolean isItBlack = true;
        boolean isItWhite = true;
        for (int x = 0; x < cellField.length; x++) {
            for (int y = 0; y < cellField[x].length; y++) {
                if (!isNull(cellField[x][y].piece)) {
                    if (cellField[x][y].piece.isBlack) {
                        isItWhite = false;
                    } else {
                        isItBlack = false;
                    }
                }
            }
        }
        if (isItBlack && isItWhite) {
            System.out.println(Mik.BG_YELLOW + Mik.BLACK + "WARN:" + Mik.RESET + Mik.YELLOW + " Vyhráli oba zároveň!" + Mik.RESET);
        }


        if (isItBlack || isItWhite) {
            System.out.println("Somebody won!");
            for (int x = 0; x < cellField.length; x++) {
                for (int y = 0; y < cellField[x].length; y++) {
                    buttonField[x][y].setVisible(false);
                }
            }
            turnDisplay.setVisible(false);
            playAgain.setVisible(true);
            quit.setVisible(true);

            if (isItBlack) {
                blackWon.setVisible(true);
            } else if (isItWhite) {
                whiteWon.setVisible(true);
            }
        } else
            System.out.println("Nobody won!");
    }


    public void render() {
        System.out.println("Rendering...");

        for (int x = 0; x < cellField.length; x++) {
            for (int y = 0; y < cellField[x].length; y++) {
                if (!cellField[x][y].isBlack) {
                    buttonField[x][y].setIcon(new ImageIcon("resources/checkers/white.png"));
                    System.out.print("WWW ");
                } else if (isNull(cellField[x][y].piece)) {
                    if (cellField[x][y].isSelected) {
                        buttonField[x][y].setIcon(new ImageIcon("resources/checkers/blank highlighted.png"));
                        System.out.print("XXH ");
                    } else {
                        buttonField[x][y].setIcon(new ImageIcon("resources/checkers/blank.png"));
                        System.out.print("XXX ");
                    }
                } else if (cellField[x][y].piece.isBlack) {
                    if (cellField[x][y].piece.isDama) {
                        if (cellField[x][y].isSelected) {
                            buttonField[x][y].setIcon(new ImageIcon("resources/checkers/black double checker highlighted.png"));
                            System.out.print("BDH ");
                        } else {
                            buttonField[x][y].setIcon(new ImageIcon("resources/checkers/black double checker.png"));
                            System.out.print("BDX ");
                        }
                    } else {
                        if (cellField[x][y].isSelected) {
                            buttonField[x][y].setIcon(new ImageIcon("resources/checkers/black checker highlighted.png"));
                            System.out.print("BCH ");
                        } else {
                            buttonField[x][y].setIcon(new ImageIcon("resources/checkers/black checker.png"));
                            System.out.print("BCX ");
                        }
                    }
                } else {
                    if (cellField[x][y].piece.isDama) {
                        if (cellField[x][y].isSelected) {
                            buttonField[x][y].setIcon(new ImageIcon("resources/checkers/white double checker highlighted.png"));
                            System.out.print("WDH ");
                        } else {
                            buttonField[x][y].setIcon(new ImageIcon("resources/checkers/white double checker.png"));
                            System.out.print("WDX ");
                        }
                    } else {
                        if (cellField[x][y].isSelected) {
                            buttonField[x][y].setIcon(new ImageIcon("resources/checkers/white checker highlighted.png"));
                            System.out.print("WCH ");
                        } else {
                            buttonField[x][y].setIcon(new ImageIcon("resources/checkers/white checker.png"));
                            System.out.print("WCX ");
                        }
                    }
                }
            }
            System.out.println();
        }
        if (isBlacksTurn) {
            turnDisplay.setText("It should be black's turn");
        } else {
            turnDisplay.setText("It should be white's turn");
        }

        System.out.println("Done!");
    }
}
