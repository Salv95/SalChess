package com.example.sal.salchess;


import android.util.Log;

import java.lang.Math;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Sal on 8/2/17.
 */

public class Grid {


    private char [][] grid;


    Grid(){
        grid = new char[][]{{'r', 'h', 'b', 'q', 'k', 'b', 'h', 'r'},//white: uppercase, black: lowercase
                            {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
                            {'#', '#', '#', '#', '#', '#', '#', '#'},
                            {'#', '#', '#', '#', '#', '#', '#', '#'},
                            {'#', '#', '#', '#', '#', '#', '#', '#'},
                            {'#', '#', '#', '#', '#', '#', '#', '#'},
                            {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
                            {'R', 'H', 'B', 'Q', 'K', 'B', 'H', 'R'}};
    }

    public char[][] getGridArr(){

        return grid;
    }

    public void setGridArr(char [][] grid){

        this.grid = grid;
    }


    public char getItemAtLocation(int index){

        ArrayList<Integer> index2D = numToTwoDIndex(index);

        return (grid[index2D.get(0)][index2D.get(1)]);

    }

    public void printGrid(){

        for(int i = 0; i < 8; i++){

            for(int j = 0; j < 8; j++){
                Log.d("test1", String.valueOf(this.grid[i][j]));
            }
            Log.d("test2", String.valueOf("\n"));

        }
    }

    public ArrayList<Integer> numToTwoDIndex(int num){

        ArrayList<Integer> index2D = new ArrayList<Integer>();
        int row  = (int) Math.floor(num/8);
        int col = (int)(((num/8.0) - row) * 8);

        index2D.add(row);
        index2D.add(col);

        return index2D;

    }

    public int twoDIndexToNum(int row, int col){

        int num = (row * 8) + col;

        return num;
    }




}
