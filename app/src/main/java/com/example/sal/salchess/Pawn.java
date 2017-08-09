package com.example.sal.salchess;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Sal on 8/5/17.
 */

public class Pawn extends Piece {

    Pawn(String color, Grid grid){
        super(color, "Pawn", false, false, grid);

    }
    @Override
    public boolean checkIfValidMove(char first_piece, int first_piece_row, int first_piece_col, char second_piece, int second_piece_row, int second_piece_col) {

        boolean one_up = (first_piece - 1) >= 0;
        boolean attack_right = (first_piece_col + 1) < 8 && (first_piece_row - 1) >= 0;
        boolean attack_left = (first_piece_col - 1) >= 0 && (first_piece_row - 1) >= 0;


        Grid temp_grid = new Grid();
        temp_grid = super.getGrid();
        char [][] arr = temp_grid.getGridArr();

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

        ArrayList<Character> blacks = new ArrayList<Character>();
        blacks.add('r');
        blacks.add('h');
        blacks.add('b');
        blacks.add('k');
        blacks.add('q');
        blacks.add('p');

        if(first_piece_row == 6){

            if(first_piece_col == second_piece_col){
                if((first_piece_row - 1) == second_piece_row){
                    if(second_piece == '#'){
                        return true;
                    }
                }
                if((first_piece_row - 2) == second_piece_row){
                    if(second_piece == '#' && arr[second_piece_row + 1][second_piece_col] == '#'){
                        return true;
                    }
                }
            }

        }
        if(one_up){
            if(first_piece_col == second_piece_col){
                if(((first_piece_row - 1) == second_piece_row)){
                    if(!blacks.contains(second_piece)){
                        return true;
                    }
                }
            }
        }

        if(attack_right){

            if((second_piece_col == first_piece_col + 1) && (second_piece_row == first_piece_row - 1)){

                if(blacks.contains(second_piece)){
                    return true;
                }

            }
        }

        if(attack_left){

            if((second_piece_col == first_piece_col - 1) && (second_piece_row == first_piece_row - 1)){

                if(blacks.contains(second_piece)){
                    return true;
                }
            }
        }



        return false;
    }
}
