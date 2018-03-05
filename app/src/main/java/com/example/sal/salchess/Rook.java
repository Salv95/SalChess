package com.example.sal.salchess;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Sal on 7/31/17.
 */

public class Rook extends Piece {


    Grid grid = super.getGrid();
    char [][] grid_arr = grid.getGridArr();



    Rook(String color, Grid grid){
        super(color, "Rook", false, false, grid);
    }


    @Override
    //in the case the the Rook is selected first
    public boolean checkIfValidMove(char first_piece, int first_piece_row, int first_piece_col,
                                    char second_piece, int second_piece_row, int second_piece_col){


        if((second_piece_row !=  first_piece_row) &&  (second_piece_col !=  first_piece_col)){//if piece not in range, tower can't attack
            return false;
        }
        if(first_piece_row == second_piece_row && first_piece_col == second_piece_col){//Rook can't attak itself
            return false;
        }

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

            //check if there are any pieces intersecting the path of the Rook



            if(first_piece_row == second_piece_row){

                if(first_piece_col < second_piece_col){

                    for(int j = first_piece_col + 1; j < second_piece_col; j++){//runs through the pieces in between the two selected

                        if(grid_arr[first_piece_row][j] != '#'){
                            return false;
                        }
                    }
                }
                else if(first_piece_col > second_piece_col){

                    for(int j = second_piece_col + 1; j < first_piece_col; j++){

                        if(grid_arr[first_piece_row][j] != '#'){
                            return false;
                        }
                    }
                }
            }

            if(first_piece_col == second_piece_col){

                if(first_piece_row < second_piece_row){
                    for(int i = first_piece_row + 1; i < second_piece_row; i++){

                        if(grid_arr[i][first_piece_col] != '#'){
                            return false;
                        }
                    }
                }
                else if(first_piece_row > second_piece_row){

                    for(int i = second_piece_row + 1; i < first_piece_row; i++){

                        if(grid_arr[i][first_piece_col] != '#'){
                            return false;
                        }
                    }
                }
            }


        return true;
    }

    //need to create function that returns an array with all the possible positions the Rook can land on


    public Positions getPossiblePositions(char original_piece, char first_piece, int first_piece_row, int first_piece_col){


        if(first_piece != original_piece){
            return null;
        }

        Log.d(String.valueOf(first_piece_row), String.valueOf(first_piece_col));//current position


        ArrayList<Integer> cols = new ArrayList<Integer>();
        ArrayList<Integer> rows = new ArrayList<Integer>();

        Positions possPos;


        for(int row = 0; row < 8; row++){

            if(row != first_piece_row){//Skip the row where the piece is currently located
                if(checkIfValidMove(first_piece, first_piece_row, first_piece_col,grid_arr[row][first_piece_col], row, first_piece_col )){

                    rows.add(row);
                    cols.add(first_piece_col);
                }
            }
        }

        for(int col = 0; col < 8; col++){

            if(col != first_piece_col){//Skip the column where the piece is currently located
                if(checkIfValidMove(first_piece, first_piece_row, first_piece_col,grid_arr[first_piece_row][col], first_piece_row, col )){

                    rows.add(first_piece_row);
                    cols.add(col);
                }
            }
        }

        int row_temp = 0;
        int col_temp = 0;
        String together = "";

        Log.d("RookPossibilities", "Rook Possibilities");
        for(int i = 0; i < rows.size(); i++){

            row_temp = rows.get(i);
            col_temp = cols.get(i);
            together = "Row: " + Integer.toString(row_temp) + " - " + "Col: " + Integer.toString(col_temp);
            Log.d("Rook poss location: ", together);
        }

        possPos = new Positions(rows, cols);

        MemoryUsed memoryUsed = new MemoryUsed();

        memoryUsed.Memory();

        return  possPos;


    }
}

