package com.example.sal.salchess;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Sal on 8/8/17.
 */

public class King extends  Piece{

    King(String color, Grid grid) {
        super(color, "King", false, false, grid);
    }

    @Override
    public boolean checkIfValidMove(char first_piece, int first_piece_row, int first_piece_col, char second_piece, int second_piece_row, int second_piece_col) {


        if(this.getColor() == "White") {
            if (second_piece == 'R') {
                return false;
            } else if (second_piece == 'H') {
                return false;
            } else if (second_piece == 'B') {
                return false;
            } else if (second_piece == 'K') {
                return false;
            } else if (second_piece == 'Q') {
                return false;
            } else if (second_piece == 'P') {
                return false;
            }
        }

        if(this.getColor() == "Black") {
            if (second_piece == 'r') {
                return false;
            } else if (second_piece == 'h') {
                return false;
            } else if (second_piece == 'b') {
                return false;
            } else if (second_piece == 'k') {
                return false;
            } else if (second_piece == 'q') {
                return false;
            } else if (second_piece == 'p') {
                return false;
            }
        }

        boolean up = (first_piece_row - 1) >= 0;
        boolean up_left = (first_piece_row - 1) >= 0 && (first_piece_col - 1) >= 0;
        boolean up_right = (first_piece_row - 1) >= 0 && (first_piece_col + 1) < 8;
        boolean right = (first_piece_col + 1) < 8;
        boolean down_right = (first_piece_row + 1) < 8 && (first_piece_col + 1) < 8;
        boolean down = (first_piece_row + 1) < 8;
        boolean down_left = (first_piece_row + 1) < 8 && (first_piece_col - 1) >= 0;
        boolean left = (first_piece_col - 1) >= 0;

        if(up){
            if((second_piece_row + 1) == first_piece_row && second_piece_col == first_piece_col){
                return true;
            }
        }
        if(up_left){
            if((second_piece_row + 1) == first_piece_row && (second_piece_col + 1) == first_piece_col){
                return true;
            }
        }
        if(up_right){
            if((second_piece_row + 1) == first_piece_row && (second_piece_col - 1) == first_piece_col){
                return true;
            }
        }
        if(right){
            if(second_piece_row == first_piece_row && (second_piece_col - 1) == first_piece_col){
                return true;
            }
        }
        if(down_right){
            if((second_piece_row - 1) == first_piece_row && (second_piece_col - 1) == first_piece_col){
                return true;
            }
        }
        if(down){
            if((second_piece_row - 1) == first_piece_row && second_piece_col  == first_piece_col){
                return true;
            }
        }
        if(down_left){
            if((second_piece_row - 1) == first_piece_row && (second_piece_col + 1)  == first_piece_col){
                return true;
            }
        }
        if(left){
            if(second_piece_row == first_piece_row && (second_piece_col + 1)  == first_piece_col){
                return true;
            }
        }


        return false;
    }

    public void getPossiblePositions(char first_piece, int first_piece_row, int first_piece_col){


        ArrayList<Integer> cols = new ArrayList<Integer>();
        ArrayList<Integer> rows = new ArrayList<Integer>();

        ArrayList<Character> white_pieces = new ArrayList<Character>();

        if(super.getColor() == "White"){
            white_pieces.add('R');
            white_pieces.add('H');
            white_pieces.add('K');
            white_pieces.add('B');
            white_pieces.add('P');
        }
        else{
            white_pieces.add('r');
            white_pieces.add('h');
            white_pieces.add('k');
            white_pieces.add('b');
            white_pieces.add('p');
        }


        boolean up = (first_piece_row - 1) >= 0;
        boolean up_left = (first_piece_row - 1) >= 0 && (first_piece_col - 1) >= 0;
        boolean up_right = (first_piece_row - 1) >= 0 && (first_piece_col + 1) < 8;
        boolean right = (first_piece_col + 1) < 8;
        boolean down_right = (first_piece_row + 1) < 8 && (first_piece_col + 1) < 8;
        boolean down = (first_piece_row + 1) < 8;
        boolean down_left = (first_piece_row + 1) < 8 && (first_piece_col - 1) >= 0;
        boolean left = (first_piece_col - 1) >= 0;

        if(up){

            if(!(white_pieces.contains(super.getGrid().getGridArr()[first_piece_row - 1][first_piece_col]))){//if the upward piece is not a friendly white piece
                rows.add(first_piece_row - 1);
                cols.add(first_piece_col);
            }
        }
        if(up_left){

            if(!(white_pieces.contains(super.getGrid().getGridArr()[first_piece_row - 1][first_piece_col - 1]))){//if the upward piece is not a friendly white piece
                rows.add(first_piece_row - 1);
                cols.add(first_piece_col - 1);
            }
        }
        if(up_right){

            if(!(white_pieces.contains(super.getGrid().getGridArr()[first_piece_row - 1][first_piece_col + 1]))){//if the upward piece is not a friendly white piece
                rows.add(first_piece_row - 1);
                cols.add(first_piece_col + 1);
            }
        }
        if(right){

            if(!(white_pieces.contains(super.getGrid().getGridArr()[first_piece_row][first_piece_col + 1]))){//if the upward piece is not a friendly white piece
                rows.add(first_piece_row);
                cols.add(first_piece_col + 1);
            }

        }
        if(down_right){

            if(!(white_pieces.contains(super.getGrid().getGridArr()[first_piece_row + 1][first_piece_col + 1]))){//if the upward piece is not a friendly white piece
                rows.add(first_piece_row + 1);
                cols.add(first_piece_col + 1);
            }

        }
        if(down){

            if(!(white_pieces.contains(super.getGrid().getGridArr()[first_piece_row + 1][first_piece_col]))){//if the upward piece is not a friendly white piece

                rows.add(first_piece_row + 1);
                cols.add(first_piece_col);
            }

        }
        if(down_left){

            if(!(white_pieces.contains(super.getGrid().getGridArr()[first_piece_row + 1][first_piece_col - 1]))){//if the upward piece is not a friendly white piece

                rows.add(first_piece_row + 1);
                cols.add(first_piece_col - 1);
            }

        }
        if(left){

            if(!(white_pieces.contains(super.getGrid().getGridArr()[first_piece_row][first_piece_col - 1]))){//if the upward piece is not a friendly white piece

                rows.add(first_piece_row);
                cols.add(first_piece_col - 1);
            }


        }


        int row_temp = 0;
        int col_temp = 0;
        String together = "";

        Log.d("Possibilities", "Possibilities");
        for(int i = 0; i < rows.size(); i++){

            row_temp = rows.get(i);
            col_temp = cols.get(i);
            together = "Row: " + Integer.toString(row_temp) + " - " + "Col: " + Integer.toString(col_temp);
            Log.d("King poss location: ", together);
        }

    }
}
