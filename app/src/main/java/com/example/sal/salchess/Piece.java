package com.example.sal.salchess;

/**
 * Created by Sal on 7/31/17.
 */

public abstract class Piece {

    private String color;
    private String name;

    private boolean underAttack;
    private boolean isDead;
    private boolean isStuck;

    private Grid grid;

    private char first_piece;
    private int first_piece_row;
    private int first_piece_col;

    private char second_piece;
    private int second_piece_row;
    private int second_piece_col;



    Piece(){
        color = "White";
        name = "Pawn";
        underAttack = false;
        isDead = false;
        isStuck = false;
        grid = new Grid();

        first_piece = ' ';
        int first_piece_row = -1;
        int first_piece_col = -1;

        char second_piece = ' ';
        int second_piece_row = -1;
        int second_piece_col = -1;

    }
    Piece(String color, String name, boolean underAttack, boolean isDead, Grid grid){

        this.color = color;
        this.name = name;
        this.underAttack = underAttack;
        this.isDead = isDead;
        this.grid = grid;
    }

    // Accessor Methods Start
    public String getColor(){

        return color;
    }

    public String getName(){

        return name;
    }

    public boolean getUnderAttack(){

        return underAttack;
    }

    public boolean getIsdead(){

        return isDead;
    }

    public boolean getIsStuck(){

        return isStuck;
    }

    public Grid getGrid(){

        return grid;
    }
    // Accessor Methods End

    // Mutator Methods Start
    public void setColor(String color){

        this.color = color;
    }

    public void setName(String name){

        this.name = name;
    }

    public void setUnderAttack(boolean underAttack){

        this.underAttack = underAttack;
    }

    public void setIsdead(boolean isDead){

        this.isDead = isDead;
    }

    public void setIsStuck(boolean isStuck){

        this.isStuck = isStuck;
    }

    // Mutator Methods End

    //Abstract Methods Begin
    public abstract boolean checkIfValidMove(char first_piece, int first_piece_row,int first_piece_col,
                                             char second_piece, int second_piece_row, int second_piece_col);

}
