package com.example.sal.salchess;


import java.util.ArrayList;
import java.util.HashMap;
import android.util.Log;

/**
 * Created by Sal on 8/6/17.
 */

public class Bishop extends Piece{


    Bishop(String color, Grid grid){
        super(color, "Bishop", false, false, grid);

    }
    @Override
    public boolean checkIfValidMove(char first_piece, int first_piece_row, int first_piece_col, char second_piece, int second_piece_row, int second_piece_col){


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


        Grid temp_grid;

        temp_grid = super.getGrid();
        char [][] arr = temp_grid.getGridArr();

        HashMap<Integer,Integer> possibles = new HashMap<Integer, Integer>();


        int temp_col = first_piece_col;
        int temp_row = first_piece_row;

        //up left
        if(second_piece_row < first_piece_row && second_piece_col < first_piece_col){

            while(temp_row > second_piece_row && temp_col > second_piece_col){
                temp_col--;
                temp_row--;
                possibles.put(temp_row, temp_col);


                if(temp_row == second_piece_row && temp_col == second_piece_col){
                    break;
                }
                else{
                    if(arr[temp_row][temp_col] != '#'){
                        return false;
                    }
                }


            }


            if(possibles.get(second_piece_row) != null){

                if(possibles.get(second_piece_row) == second_piece_col){
//                    Log.d("up left Bishop", Integer.toString(possibles.get(second_piece_row)));
                    return true;
                }

            }
        }

            //up right
        else if(second_piece_row < first_piece_row && second_piece_col > first_piece_col){
            possibles = new HashMap<Integer, Integer>();
            temp_col = first_piece_col;
            temp_row = first_piece_row;


            while(temp_row > 0 && temp_col < 7){
                temp_col++;
                temp_row--;
                possibles.put(temp_row, temp_col);


                if(temp_row == second_piece_row && temp_col == second_piece_col){
                    break;
                }
                else{
                    if(arr[temp_row][temp_col] != '#'){
                        return false;
                    }
                }

            }


            if(possibles.get(second_piece_row) != null){

                if(possibles.get(second_piece_row) == second_piece_col){

                    return true;
                }

            }
        }

        //down left
       else if(second_piece_row > first_piece_row && second_piece_col < first_piece_col){
           possibles = new HashMap<Integer, Integer>();
           temp_col = first_piece_col;
           temp_row = first_piece_row;


           while(temp_row < 7 && temp_col > 0){//something wrong here
               temp_col--;
               temp_row++;
               possibles.put(temp_row, temp_col);

               if(temp_row == second_piece_row && temp_col == second_piece_col){
                   break;
               }
               else{
                   if(arr[temp_row][temp_col] != '#'){
                       return false;
                   }
               }

           }


           if(possibles.get(second_piece_row) != null){

               if(possibles.get(second_piece_row) == second_piece_col){

                   return true;
               }

           }

       }

        //down right
        else if(second_piece_row > first_piece_row && second_piece_col > first_piece_col){
            possibles = new HashMap<Integer, Integer>();
            temp_col = first_piece_col;
            temp_row = first_piece_row;


            while(temp_row < 7 && temp_col < 7){
                temp_col++;
                temp_row++;
                possibles.put(temp_row, temp_col);

                if(temp_row == second_piece_row && temp_col == second_piece_col){
                    break;
                }
                else{
                    if(arr[temp_row][temp_col] != '#'){
                        return false;
                    }
                }

            }

            if(possibles.get(second_piece_row) != null){

                if(possibles.get(second_piece_row) == second_piece_col){

                    return true;
                }

            }
        }


        return false ;

    }

    public void getPossiblePositions(char first_piece, int first_piece_row, int first_piece_col){


        ArrayList<Integer> cols = new ArrayList<Integer>();
        ArrayList<Integer> rows = new ArrayList<Integer>();

        ArrayList<Character> white_pieces = new ArrayList<Character>();

        white_pieces.add('R');
        white_pieces.add('H');
        white_pieces.add('K');
        white_pieces.add('Q');
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

        Log.d("Bishop Possibilities", "Bishop Possibilities");
        for(int i = 0; i < rows.size(); i++){

            row_temp = rows.get(i);
            col_temp = cols.get(i);
            together = "Row: " + Integer.toString(row_temp) + " - " + "Col: " + Integer.toString(col_temp);
            Log.d("Bishop poss location: ", together);
        }

    }
}
