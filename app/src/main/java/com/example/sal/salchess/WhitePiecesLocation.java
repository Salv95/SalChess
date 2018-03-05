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

    private int[] count;
    /*
        0 - Pawns
        1 - Rooks
        2 - Knights
        3 - Bishops
        4 - Queen
        5 - King **should never go lower than 1
     */



    WhitePiecesLocation(){

        row = new int[]{6,6,6,6,6,6,6,6,7,7,7,7,7,7,7,7};
        col = new int[]{0,1,2,3,4,5,6,7,0,1,2,3,4,5,6,7};
        piece = new char[]{'P','P','P','P','P','P','P','P','R','H','B','Q','K','B','H','R'};
        count = new int[]{8,2,2,2,1,1};


    }

    //need an helper update count function and a return count function that calls the update function


    public void printCount(Grid grid){

        updateCount(grid);
        Log.d("Paws Count", String.valueOf(count[0]));
        Log.d("Rooks Count", String.valueOf(count[1]));
        Log.d("Knights Count", String.valueOf(count[2]));
        Log.d("Bishops Count", String.valueOf(count[3]));
        Log.d("Queen Count", String.valueOf(count[4]));
        Log.d("King Count", String.valueOf(count[5]));
    }

    public void updateCount(Grid grid){//problems

        int tempCount[] = {0,0,0,0,0,0};

        for(int i = 0; i < 16; i++){

            piece[i] = grid.getGridArr()[row[i]][col[i]];
        }

        //Pawns
        for(int i = 0; i < 8; i++){

            if(piece[i] == 'P'){
                tempCount[0]++;
            }
        }
        //Rooks
        if(piece[8] == 'R'){
            tempCount[1]++;
        }
        if(piece[15] == 'R'){
            tempCount[1]++;
        }
        //Knights
        if(piece[9] == 'H'){
            tempCount[2]++;
        }
        if(piece[14] == 'H'){
            tempCount[2]++;
        }
        //Bishops
        if(piece[10] == 'B'){
            tempCount[3]++;
        }
        if(piece[13] == 'B'){
            tempCount[3]++;
        }
        //Queen
        if(piece[11] == 'Q'){
            tempCount[4]++;
        }
        //King
        if(piece[12] == 'K'){
            tempCount[5]++;
        }

        count = tempCount;

    }


    int[] get_rows(Grid grid){

        updateCount(grid);
        return row;
    }

    int[] get_columns(Grid grid){

        updateCount(grid);
        return col;
    }

    int[] getCount(Grid grid){

        updateCount(grid);
        return count;
    }

    char[] getPiece(Grid grid){

        updateCount(grid);
        return piece;
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

    public void upDateLocation(int first_piece_row, int first_piece_col, int second_piece_row, int second_piece_col, Grid grid){


        for(int i = 0; i < 16; i++){

            if(row[i] == first_piece_row && col[i] == first_piece_col){

                row[i] = second_piece_row;
                col[i] = second_piece_col;
                piece[i] = grid.getGridArr()[row[i]][col[i]];
            }
        }

    }


}
