package com.example.sal.salchess;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Sal on 8/5/17.
 */

public class Pawn extends Piece {

    Pawn(String color, Grid grid) {
        super(color, "Pawn", false, false, grid);

    }

    @Override
    public boolean checkIfValidMove(char first_piece, int first_piece_row, int first_piece_col, char second_piece, int second_piece_row, int second_piece_col) {

        //for white pieces
        boolean one_up = first_piece_row >= 0;
        boolean attack_right = (first_piece_col + 1) < 8 && (first_piece_row - 1) >= 0;
        boolean attack_left = (first_piece_col - 1) >= 0 && (first_piece_row - 1) >= 0;

        //for black pieces
        boolean one_down = (first_piece_row + 1) < 8;
        boolean attack_down_right = (first_piece_col + 1) < 8 && (first_piece_row + 1) < 8;
        boolean attack_down_left = (first_piece_col - 1) >= 0 && (first_piece_row + 1) < 8;



        Grid temp_grid = new Grid();
        temp_grid = super.getGrid();
        char[][] arr = temp_grid.getGridArr();


        ArrayList<Character> opponents = new ArrayList<Character>();

        if (this.getColor() == "White") {
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
            opponents.add('r');
            opponents.add('h');
            opponents.add('b');
            opponents.add('k');
            opponents.add('q');
            opponents.add('p');

            if (first_piece_row == 6) {//works

                if (first_piece_col == second_piece_col) {
                    if ((first_piece_row - 1) == second_piece_row) {
                        if (second_piece == '#') {
                            return true;
                        }
                    }
                    if ((first_piece_row - 2) == second_piece_row) {
                        if (second_piece == '#' && arr[second_piece_row + 1][second_piece_col] == '#') {
                            return true;
                        }
                    }
                }

            }
            if (one_up) {//works
                if (first_piece_col == second_piece_col) {
                    if (((first_piece_row - 1) == second_piece_row)) {
                        if (!opponents.contains(second_piece)) {
                            return true;
                        }
                    }
                }
            }

            if (attack_right) {// works

                if ((second_piece_col == first_piece_col + 1) && (second_piece_row == first_piece_row - 1)) {

                    if (opponents.contains(second_piece)) {
                        return true;
                    }

                }
            }

            if (attack_left) {//does not work

                if ((second_piece_col == first_piece_col - 1) && (second_piece_row == first_piece_row - 1)) {

                    if (opponents.contains(second_piece)) {
                        return true;
                    }
                }
            }

        } else if(this.getColor() == "Black") {

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


            opponents.add('R');
            opponents.add('H');
            opponents.add('B');
            opponents.add('K');
            opponents.add('Q');
            opponents.add('P');

            if(first_piece_row == 1) {//works

                if (first_piece_col == second_piece_col) {
                    if ((first_piece_row + 1) == second_piece_row) {
                        if (second_piece == '#') {
                            return true;
                        }
                    }
                    if ((first_piece_row + 2) == second_piece_row) {
                        if (second_piece == '#' && arr[second_piece_row - 1][second_piece_col] == '#') {
                            return true;
                        }
                    }
                }

            }
            if(one_down) {//works
                if (first_piece_col == second_piece_col) {
                    if (((first_piece_row + 1) == second_piece_row)) {
                        if (second_piece == '#') {
                            return true;
                        }
                    }
                }
            }

            if(attack_down_right) {//this works

                if ((second_piece_col == first_piece_col + 1) && (second_piece_row == first_piece_row + 1)) {

                    if (opponents.contains(second_piece)) {
                        return true;
                    }

                }
            }

            if(attack_down_left) {//doesnt work
                Log.d("passes", "yes");

                if ((second_piece_col == first_piece_col - 1) && (second_piece_row == first_piece_row + 1)) {

                    if (opponents.contains(second_piece)) {
                        return true;
                    }
                }
            }


        }
        return false;
    }

    public void getPossiblePositions(char first_piece, int first_piece_row, int first_piece_col){//need to make this function not be O(2)


        ArrayList<Integer> cols = new ArrayList<Integer>();
        ArrayList<Integer> rows = new ArrayList<Integer>();

        ArrayList<Character> white_pieces = new ArrayList<Character>();

        white_pieces.add('R');
        white_pieces.add('H');
        white_pieces.add('K');
        white_pieces.add('B');
        white_pieces.add('P');


        for(int i = 0; i < 8; i++){

            for(int j = 0; j < 8; j++){

                if(!(white_pieces.contains(super.getGrid().getGridArr()[i][j]))){

                    if(checkIfValidMove(first_piece, first_piece_row, first_piece_col, super.getGrid().getGridArr()[i][j], i, j)){

                        if(!(first_piece_row == i && first_piece_col == j)){
                            cols.add(j);
                            rows.add(i);
                        }
                    }
                }

            }
        }

        int row_temp = 0;
        int col_temp = 0;
        String together = "";

        Log.d("Pawn Possibilities", "Pawn Possibilities");
        Log.d("Amount of item", Integer.toString(rows.size()));
        for(int i = 0; i < rows.size(); i++){

            row_temp = rows.get(i);
            col_temp = cols.get(i);
            together = "Row: " + Integer.toString(row_temp) + " - " + "Col: " + Integer.toString(col_temp);
            Log.d("Pawn poss location: ", together);
        }

    }


}

