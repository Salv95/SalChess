package com.example.sal.salchess;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Sal on 1/20/18.
 */

public class WhitePiecesLocation {



    private int[] row;
    private int[] col;
    private char[] piece;



    WhitePiecesLocation(){

        row = new int[]{6,6,6,6,6,6,6,6,7,7,7,7,7,7,7,7};
        col = new int[]{0,1,2,3,4,5,6,7,0,1,2,3,4,5,6,7};
        piece = new char[]{'P','P','P','P','P','P','P','P','R','H','B','Q','K','B','H','R'};
    }


    public void printLocations(){

        int row_temp = 0;
        int col_temp = 0;
        String together = "";

        for(int i = 0; i < 16; i++){

            row_temp = row[i];
            col_temp = col[i];
            together = "Row: " + Integer.toString(row_temp) + " - " + "Col: " + Integer.toString(col_temp) + " Piece: " + piece[i];

            Log.d("White piece Location: ", together);
        }
    }

    public void upDateLocation(int first_piece_row, int first_piece_col, int second_piece_row, int second_piece_col){


        for(int i = 0; i < 16; i++){

            if(row[i] == first_piece_row && col[i] == first_piece_col){

                row[i] = second_piece_row;
                col[i] = second_piece_col;
            }
        }

    }
}
