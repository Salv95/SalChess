package com.example.sal.salchess;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Sal on 8/5/17.
 */

public class Knight extends Piece{



    Knight(String color, Grid grid){
        super(color, "Horse", false, false, grid);

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

        boolean upper_right = ((first_piece_col + 1) < 8) && ((first_piece_row - 2) >= 0);
        boolean upper_mid_right = ((first_piece_col + 2) < 8) && ((first_piece_row - 1) >= 0);
        boolean lower_mid_right = ((first_piece_col + 2) < 8) && ((first_piece_row + 1) < 8);
        boolean lower_right = ((first_piece_col + 1) < 8) && ((first_piece_row + 2) < 8);

        boolean upper_left = ((first_piece_col - 1) >= 0) && ((first_piece_row - 2) >= 0);
        boolean upper_mid_left = ((first_piece_col - 2) >= 0) && ((first_piece_row - 1) >= 0);
        boolean lower_mid_left = ((first_piece_col - 2) >= 0) && ((first_piece_row + 1) < 8);
        boolean lower_left = ((first_piece_col - 1) >= 0) && ((first_piece_row + 2) < 8);

        if(upper_right){
            if(second_piece_col == (first_piece_col + 1) && second_piece_row == (first_piece_row - 2)){

                return true;
            }
        }
        if(upper_mid_right){
            if(second_piece_col == (first_piece_col + 2) && second_piece_row == (first_piece_row - 1)){

                return true;
            }
        }
        if(lower_mid_right){
            if(second_piece_col == (first_piece_col + 2) && second_piece_row == (first_piece_row + 1)){

                return true;
            }
        }
        if(lower_right){
            if(second_piece_col == (first_piece_col + 1) && second_piece_row == (first_piece_row + 2)){

                return true;
            }
        }
        if(upper_left){
            if(second_piece_col == (first_piece_col - 1) && second_piece_row == (first_piece_row - 2)){

                return true;
            }
        }
        if(upper_mid_left){
            if(second_piece_col == (first_piece_col - 2) && second_piece_row == (first_piece_row - 1)){

                return true;
            }
        }
        if(lower_mid_left){
            if(second_piece_col == (first_piece_col - 2) && second_piece_row == (first_piece_row + 1)){

                return true;
            }
        }
        if(lower_left){
            if(second_piece_col == (first_piece_col - 1) && second_piece_row == (first_piece_row + 2)){

                return true;
            }
        }


        return false;
    }

    public Positions getPossiblePositions(char first_piece, int first_piece_row, int first_piece_col){

        ArrayList<Integer> cols = new ArrayList<Integer>();
        ArrayList<Integer> rows = new ArrayList<Integer>();

        Positions possPos;

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

        boolean upper_right = ((first_piece_col + 1) < 8) && ((first_piece_row - 2) >= 0);
        boolean upper_mid_right = ((first_piece_col + 2) < 8) && ((first_piece_row - 1) >= 0);
        boolean lower_mid_right = ((first_piece_col + 2) < 8) && ((first_piece_row + 1) < 8);
        boolean lower_right = ((first_piece_col + 1) < 8) && ((first_piece_row + 2) < 8);

        boolean upper_left = ((first_piece_col - 1) >= 0) && ((first_piece_row - 2) >= 0);
        boolean upper_mid_left = ((first_piece_col - 2) >= 0) && ((first_piece_row - 1) >= 0);
        boolean lower_mid_left = ((first_piece_col - 2) >= 0) && ((first_piece_row + 1) < 8);
        boolean lower_left = ((first_piece_col - 1) >= 0) && ((first_piece_row + 2) < 8);


        if(upper_right){//works

            if(!(white_pieces.contains(super.getGrid().getGridArr()[first_piece_row - 2][first_piece_col + 1]))){//if the upward  right piece is not a friendly white piece
                cols.add(first_piece_col + 1);
                rows.add(first_piece_row - 2);
            }

        }
        if(upper_mid_right){//works

            if(!(white_pieces.contains(super.getGrid().getGridArr()[first_piece_row - 1][first_piece_col + 2]))){
                cols.add(first_piece_col + 2);
                rows.add(first_piece_row - 1);
            }


        }
        if(lower_mid_right){// works

            if(!(white_pieces.contains(super.getGrid().getGridArr()[first_piece_row +1 ][first_piece_col + 2]))){
                cols.add(first_piece_col + 2);
                rows.add(first_piece_row + 1);
            }

        }
        if(lower_right){//works

            if(!(white_pieces.contains(super.getGrid().getGridArr()[first_piece_row + 2 ][first_piece_col + 1]))){
                cols.add(first_piece_col + 1);
                rows.add(first_piece_row + 2);
            }

        }
        if(upper_left){//works

            if(!(white_pieces.contains(super.getGrid().getGridArr()[first_piece_row - 2 ][first_piece_col - 1]))){
                cols.add(first_piece_col - 1);
                rows.add(first_piece_row - 2);
            }

        }
        if(upper_mid_left){// works

            if(!(white_pieces.contains(super.getGrid().getGridArr()[first_piece_row - 1][first_piece_col - 2]))){
                cols.add(first_piece_col - 2);
                rows.add(first_piece_row - 1);
            }

        }
        if(lower_mid_left){//works

            if(!(white_pieces.contains(super.getGrid().getGridArr()[first_piece_row + 1][first_piece_col - 2]))){
                cols.add(first_piece_col - 2);
                rows.add(first_piece_row + 1);
            }

        }

        if(lower_left){// works

            if(!(white_pieces.contains(super.getGrid().getGridArr()[first_piece_row + 2][first_piece_col - 1]))){
                cols.add(first_piece_col - 1);
                rows.add(first_piece_row + 2);
            }
        }

        int row_temp = 0;
        int col_temp = 0;
        String together = "";

        Log.d("Knight Possibilities", "Knight Possibilities");
        for(int i = 0; i < rows.size(); i++){

            row_temp = rows.get(i);
            col_temp = cols.get(i);
            together = "Row: " + Integer.toString(row_temp) + " - " + "Col: " + Integer.toString(col_temp);
            Log.d("Knight poss location: ", together);
        }

        possPos = new Positions(rows, cols);

        return possPos;
    }
}
