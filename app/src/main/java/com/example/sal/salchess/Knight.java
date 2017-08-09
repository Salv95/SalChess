package com.example.sal.salchess;

/**
 * Created by Sal on 8/5/17.
 */

public class Knight extends Piece{



    Knight(String color, Grid grid){
        super(color, "Horse", false, false, grid);

    }
    @Override
    public boolean checkIfValidMove(char first_piece, int first_piece_row, int first_piece_col, char second_piece, int second_piece_row, int second_piece_col) {



        Grid grid = super.getGrid();

        char [][] temp_grid = grid.getGridArr();

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
}
