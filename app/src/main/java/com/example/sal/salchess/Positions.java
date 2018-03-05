package com.example.sal.salchess;

import java.util.ArrayList;

/**
 * Created by Sal on 1/28/18.
 */

public class Positions {


    ArrayList<Integer> rows;
    ArrayList<Integer> cols;

    Positions(ArrayList<Integer> rows, ArrayList<Integer> cols){

        this.rows = rows;
        this.cols = cols;
    }

    public ArrayList<Integer> getRows(){

        return rows;
    }

    public ArrayList<Integer> getColumns(){

        return cols;
    }
}
