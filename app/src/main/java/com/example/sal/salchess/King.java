package com.example.sal.salchess;

/**
 * Created by Sal on 8/8/17.
 */

public class King extends  Piece{

    King(String color, Grid grid) {
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
}
