package com.example.sal.salchess;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Sal on 1/25/18.
 */

public class Queen extends Piece{




    Queen(String color, Grid grid){
        super(color, "Queen", false, false, grid);

    }

    @Override
    public boolean checkIfValidMove(char first_piece, int first_piece_row, int first_piece_col, char second_piece, int second_piece_row, int second_piece_col) {


        Rook wRookQ = new Rook("White", super.getGrid());
        Bishop wBishopQ = new Bishop("White", super.getGrid());

        boolean validMove2;
        boolean validMove3;

        validMove2 = wRookQ.checkIfValidMove(first_piece,first_piece_row,first_piece_col, second_piece, second_piece_row, second_piece_col);
        validMove3 = wBishopQ.checkIfValidMove(first_piece,first_piece_row,first_piece_col, second_piece, second_piece_row, second_piece_col);


        if(validMove2 || validMove3){

            Log.d("valid move Queen", "valid move queen");
            return true;
        }

        return false;
    }

    public void getPossiblePositions(char first_piece, int first_piece_row, int first_piece_col){//need to make this function not be O(3)


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

        Log.d("Queen Possibilities", "Queen Possibilities");
        Log.d("Amount of item", Integer.toString(rows.size()));
        for(int i = 0; i < rows.size(); i++){

            row_temp = rows.get(i);
            col_temp = cols.get(i);
            together = "Row: " + Integer.toString(row_temp) + " - " + "Col: " + Integer.toString(col_temp);
            Log.d("Queen poss location: ", together);
        }

    }
}
