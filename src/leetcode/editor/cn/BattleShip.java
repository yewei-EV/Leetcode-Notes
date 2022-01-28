/*
 * Copyright (c) 2016 Tianbao Travel Ltd.
 * www.tianbaotravel.com
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Tianbao Travel Ltd. ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you
 * entered into with Tianbao Travel Ltd.
 */
package leetcode.editor.cn;

import java.awt.*;
import java.util.Scanner;

/**
 * @author Yewei Wang
 */
// ship可以任意形状但是要注两个ship挨在一起怎么区分
// 如果hit了一个sunk的ship应该是返回hit-and-sunk
public class BattleShip {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}

class Game {
    private Player[] players;

    public Game() {
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        this.players = new Player[] {player1, player2};
    }

    public void start() {
        this.players[0].placeShips();
        this.players[1].placeShips();
        int winnerId = -1;
        int count = 0;
        while (players[0].getTotalLivesLeft() > 0 && players[1].getTotalLivesLeft() > 0) {
            if (count % 2 == 0) {
                players[0].fireAt(players[1]);
            } else {
                players[1].fireAt(players[0]);
            }
            count++;
            if (players[0].getTotalLivesLeft() == 0) {
                winnerId = 1;
            } else if (players[1].getTotalLivesLeft() == 0) {
                winnerId = 0;
            }
        }
        System.out.println("Congrats Player %d, you won! " + winnerId);
    }
}

class Board {
    private static final char WATER = '~';
    private static final int BOARD_SIZE = 10;
    private static final String HORIZONTAL = "H";
    private static final String VERTICAL = "V";
    private Scanner scanner;
    private GameField[][] board;
    private int[][] shown = new int[BOARD_SIZE][BOARD_SIZE];
    private Ship ship = new Ship("Submarine", 3);

    public Board() {
        this.scanner = new Scanner(System.in);
        this.board = new GameField[BOARD_SIZE][BOARD_SIZE];
        for(int i = 0; i < BOARD_SIZE; i++) {
            for(int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = new WaterField();
            }
        }
    }

    public void placeShipsOnBoard() {
        boolean horizontal = askValidShipDirection();
        Point startingPoint = askValidStartingPoint(ship, horizontal);
        placeValidShip(ship, startingPoint, horizontal);
        printBoard();
    }

    public GameField getField(int x, int y) {
        if (!isInsideBoard(x, y)) {
            throw new IllegalArgumentException("Outside board - try again: ");
        }
        return board[y][x];
    }

    public void printBoard() {
        System.out.print("\t");
        for(int i = 1; i <= BOARD_SIZE; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();
        for(int i = 0; i < BOARD_SIZE; i++) {
            System.out.print((i+1) + "\t");
            for(int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j].getIcon() + "\t");
            }
            System.out.println();
        }
    }

    // 0 for not hit
    // 1 for miss
    // 2 for hit
    public void markBoard(int x, int y, int value) {
        this.shown[x][y] = value;
        for(int i = 0; i < BOARD_SIZE; i++) {
            System.out.print((i+1) + "\t");
            for(int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(shown[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private boolean askValidShipDirection() {
        System.out.printf("%nDo you want to place the ship horizontally (H) or vertically (V)?");
        String direction;
        do {
            direction = scanner.nextLine().trim();
        } while (!HORIZONTAL.equals(direction) && !VERTICAL.equals(direction));
        return HORIZONTAL.equals(direction);
    }

    private Point askValidStartingPoint(Ship ship, boolean horizontal) {
        Point from;
        do {
            System.out.printf("%nEnter position: ");
            from = new Point(scanner.nextInt(), scanner.nextInt());
        } while(!isValidStartingPoint(from, ship.getSize(), horizontal));

        return from;
    }

    private boolean isValidStartingPoint(Point from, int length, boolean horizontal) {
        int xDiff = 0;
        int yDiff = 0;
        if(horizontal) {
            xDiff = 1;
        } else {
            yDiff = 1;
        }

        int x = (int)from.getX() - 1;
        int y = (int)from.getY() - 1;
        if(!isInsideBoard(x, y) ||
                (!isInsideBoard(x + length,y) && horizontal) ||
                (!isInsideBoard(x, y + length) && !horizontal)
        ) {
            return false;
        }

        for(int i = 0; i < length; i++) {
            if(board[(int)from.getY() + i *yDiff - 1]
                    [(int)from.getX() + i *xDiff - 1].getIcon() != WATER){
                return false;
            }
        }
        return true;
    }

    private void placeValidShip(Ship ship, Point startingPoint, boolean horizontal) {
        int xDiff = 0;
        int yDiff = 0;
        if(horizontal) {
            xDiff = 1;
        } else {
            yDiff = 1;
        }
        for(int i = 0; i < ship.getSize() ; i++) {
            board[(int)startingPoint.getY() + i*yDiff - 1]
                    [(int)startingPoint.getX() + i*xDiff - 1] = new ShipField(ship);
        }
    }
    private boolean isInsideBoard(int x, int y){
        return x <= BOARD_SIZE && x >= 0
                && y <= BOARD_SIZE && y >= 0;
    }
}

interface GameField {
    char getIcon();
    Result shootAt();
}

class ShipField implements GameField {
    private final Ship ship;

    public ShipField(Ship ship) {
        this.ship = ship;
    }

    @Override
    public char getIcon() {
        char icon;
        Result shipState = ship.getState();
        switch (shipState) {
            case PARTIAL_HIT:
            case DESTROYED:
                icon = 'O';
                break;
            case NO_HIT: icon = 'X';
                break;
            default: icon = ' ';
                break;
        }
        return icon;
    }

    @Override
    public Result shootAt() {
        ship.hit();
        return ship.getState();
    }
}

class WaterField implements GameField {
    private boolean isThisFieldHit = false;

    @Override
    public char getIcon() {
        return isThisFieldHit ? 'M' : '~';
    }

    @Override
    public Result shootAt() {
        isThisFieldHit = true;
        return Result.NO_HIT;
    }
}

class Ship {
    private String name;
    private int size;
    private int lives;

    public Ship(String name, int size) {
        this.name = name;
        this.size = size;
        this.lives = size;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public void hit() {
        if (lives > 0) {
            System.out.printf("%nGood shot! The %s was hit", name);
            System.out.println(" ");
            lives--;
        } else {
            System.out.println("Ship is destroyed");
        }
    }

    public Result getState() {
        if (lives == 0) {
            return Result.DESTROYED;
        } else if (lives < size) {
            return Result.PARTIAL_HIT;
        } else {
            return Result.NO_HIT;
        }
    }
}

class Player {
    private int totalLivesLeft = 3;
    private int id;
    private Board board;
    private Scanner scanner;

    public Player(int id) {
        this.id = id;
        this.board = new Board();
        this.scanner = new Scanner(System.in);
    }

    public int getId() {
        return id;
    }

    public Board getBoard() {
        return board;
    }

    public void placeShips() {
        System.out.printf("%n======== Player %d - Time to place out your ships ========%n", id);
        board.placeShipsOnBoard();
    }

    public void fireAt(Player opponent) {
        System.out.printf("%n Alright Player %d - Enter coordinates for your attack: ", id);
        boolean isPointValid = false;
        while (!isPointValid) {
            try {
                Point point = new Point(scanner.nextInt(), scanner.nextInt());
                int x = (int)point.getX() - 1;
                int y = (int)point.getY() - 1;
                Result result = opponent.getBoard().getField(x, y).shootAt();
                if (result == Result.PARTIAL_HIT || result == Result.DESTROYED) {
                    opponent.getBoard().markBoard(x, y, 2);
                    opponent.reduceTotalLivesLeft();
                } else {
                    opponent.getBoard().markBoard(x, y, 1);
                }
                isPointValid = true;
//                opponent.getBoard().printBoard();
            } catch (IllegalArgumentException e) {
                System.out.printf(e.getMessage());
            }
        }
    }

    public int getTotalLivesLeft() {
        return totalLivesLeft;
    }

    public void reduceTotalLivesLeft() {
        totalLivesLeft = totalLivesLeft - 1;
    }
}

enum Result {
    NO_HIT,
    PARTIAL_HIT,
    DESTROYED
}
