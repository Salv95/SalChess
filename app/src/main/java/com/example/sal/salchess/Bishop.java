package com.example.sal.salchess;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Sal on 8/6/17.
 */

public class Bishop extends Piece{


    Bishop(String color, Grid grid){
        super(color, "Bishop", false, false, grid);

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


        Grid temp_grid = new Grid();
        temp_grid = super.getGrid();
        char [][] arr = temp_grid.getGridArr();

        HashMap<Integer,Integer> possibles = new HashMap<Integer, Integer>();


        int temp_col = first_piece_col;
        int temp_row = first_piece_row;

        //up left
        if(second_piece_row < first_piece_row && second_piece_col < first_piece_col){

            while(temp_row > second_piece_row && temp_col > second_piece_col){
                Log.d("wtf1", "wtf1");
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
                Log.d("wtf2", "wtf2");
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
               Log.d("wtf3", "wtf3");
               temp_col--;
               temp_row++;
               possibles.put(temp_row, temp_col);
               Log.d("possibles_row3", String.valueOf(temp_row));
               Log.d("possibles_col3", String.valueOf(temp_col));

               Log.d("is it null3", String.valueOf(possibles.get(second_piece_row)));
               Log.d("row3", String.valueOf(second_piece_row));
               Log.d("col3", String.valueOf(second_piece_col));
               if(temp_row == second_piece_row && temp_col == second_piece_col){
                   break;
               }
               else{
                   if(arr[temp_row][temp_col] != '#'){
                       Log.d("vals", String.valueOf(arr[temp_row][temp_col]));
                       Log.d("roww", String.valueOf(temp_row));
                       Log.d("coll", String.valueOf(temp_col));
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
                Log.d("wtf4", "wtf4");
                temp_col++;
                temp_row++;
                possibles.put(temp_row, temp_col);
                Log.d("possibles_row4", String.valueOf(temp_row));
                Log.d("possibles_col4", String.valueOf(temp_col));
                if(temp_row == second_piece_row && temp_col == second_piece_col){
                    break;
                }
                else{
                    if(arr[temp_row][temp_col] != '#'){
                        return false;
                    }
                }


            }

            Log.d("is it null4", String.valueOf(possibles.get(second_piece_row)));
            Log.d("row4", String.valueOf(second_piece_row));
            Log.d("col4", String.valueOf(second_piece_col));

            if(possibles.get(second_piece_row) != null){

                if(possibles.get(second_piece_row) == second_piece_col){

                    return true;
                }

            }
        }


        return false ;


    }
}
