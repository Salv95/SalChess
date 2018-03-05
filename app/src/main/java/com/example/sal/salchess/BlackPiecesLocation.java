package com.example.sal.salchess;

import android.util.Log;

/**
 * Created by Sal on 1/20/18.
 */

public class BlackPiecesLocation {



    private int[] row;
    private int[] col;
    private char[] piece;

    private int[] count;
    /*
        5 - Pawns
        0 - Rooks
        1 - Knights
        2 - Bishops
        3 - Queen
        4 - King **should never go lower than 1
     */



    BlackPiecesLocation(){

        row = new int[]{0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1};
        col = new int[]{0,1,2,3,4,5,6,7,0,1,2,3,4,5,6,7};
        piece = new char[]{'r','h','b','q','k','b','h','r','p','p','p','p','p','p','p','p'};
        count = new int[]{2,2,2,1,1,8};


    }

    //need an helper update count function and a return count function that calls the update function


    public void printCount(Grid grid){

        updateCount(grid);
        Log.d("Paws Count", String.valueOf(count[5]));
        Log.d("Rooks Count", String.valueOf(count[0]));
        Log.d("Knights Count", String.valueOf(count[1]));
        Log.d("Bishops Count", String.valueOf(count[2]));
        Log.d("Queen Count", String.valueOf(count[3]));
        Log.d("King Count", String.valueOf(count[4]));
    }

    public void updateCount(Grid grid){

        int tempCount[] = {0,0,0,0,0,0};

        for(int i = 0; i < 16; i++){

            piece[i] = grid.getGridArr()[row[i]][col[i]];
        }

        //Pawns
        for(int i = 8; i < 16; i++){

            if(piece[i] == 'p'){
                tempCount[5]++;
            }
        }
        //Rooks
        if(piece[0] == 'r'){
            tempCount[0]++;
        }
        if(piece[7] == 'r'){
            tempCount[0]++;
        }
        //Knights
        if(piece[1] == 'h'){
            tempCount[1]++;
        }
        if(piece[6] == 'h'){
            tempCount[1]++;
        }
        //Bishops
        if(piece[2] == 'b'){
            tempCount[2]++;
        }
        if(piece[5] == 'b'){
            tempCount[2]++;
        }
        //Queen
        if(piece[3] == 'Q'){
            tempCount[3]++;
        }
        //King
        if(piece[4] == 'K'){
            tempCount[4]++;
        }

        Log.d("bbRook tempCount", String.valueOf(tempCount));

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
