package com.example.sal.salchess;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Sal on 1/28/18.
 */

public class PositionEvaluation {



    Grid grid;
    WhitePiecesLocation whitePiecesLoc;
    BlackPiecesLocation blackPiecesLoc;

    private Rook rook;

    PositionEvaluation(Grid grid, WhitePiecesLocation whitePiecesLoc, BlackPiecesLocation blackPiecesLoc){


        this.grid = grid;
        this.whitePiecesLoc = whitePiecesLoc;
        this.blackPiecesLoc = blackPiecesLoc;

    }




    public Positions calculateBestMove(){//needs to return best move


        Positions possPosWLRook;
        Positions possPosWRRook;
        Positions possPosWLKnight;
        Positions possPosWRKnight;
        Positions possPosWLBishop;
        Positions possPosWRBishop;
        Positions possPosWQueen;
        Positions possPosWKing;

        Positions possPosW0Pawn;
        Positions possPosW1Pawn;
        Positions possPosW2Pawn;
        Positions possPosW3Pawn;
        Positions possPosW4Pawn;
        Positions possPosW5Pawn;
        Positions possPosW6Pawn;
        Positions possPosW7Pawn;


        //White Rooks
        Rook wlRook = new Rook("White", grid);
        possPosWLRook = wlRook.getPossiblePositions('R', whitePiecesLoc.getPiece(grid)[8],whitePiecesLoc.get_rows(grid)[8],whitePiecesLoc.get_columns(grid)[8]);//to get left Rook



        //Black left Rook

        ;


        Positions hits = checkLeftBlackRook(possPosWLRook);

        return hits;

    }

    public Positions checkLeftBlackRook( Positions possPosWLRook){

        Positions possPosBLRook;

        Rook blRook = new Rook("Black", grid);
        possPosBLRook = blRook.getPossiblePositions('r', blackPiecesLoc.getPiece(grid)[0],blackPiecesLoc.get_rows(grid)[0],blackPiecesLoc.get_columns(grid)[0]);//to get left Rook

        ArrayList<Integer> hit_rows = new ArrayList<Integer>();
        ArrayList<Integer> hit_cols = new ArrayList<Integer>();

        boolean same_row = false;
        boolean same_col = false;


        if(whitePiecesLoc.get_rows(grid)[8] == blackPiecesLoc.get_rows(grid)[0]) {

            Log.d("same row", "same row");
            if(possPosBLRook != null && possPosWLRook != null){

                for (int i = 0; i < possPosBLRook.getRows().size(); i++) {

                    for (int j = 0; j < possPosWLRook.getRows().size(); j++) {

                        if (possPosBLRook.getRows().get(i) == possPosWLRook.getRows().get(j)) {

                            same_row = true;
                            break;
                        }
                    }
                    if (same_row) {
                        break;
                    }
                }
                if (same_row) {
                    hit_rows = possPosWLRook.getRows();
                    hit_cols = possPosWLRook.getColumns();
                }

            }

        }
        else if(whitePiecesLoc.get_columns(grid)[8] == blackPiecesLoc.get_columns(grid)[0]) {

            Log.d("same col", "same col");
            if(possPosBLRook != null && possPosWLRook != null){

                for (int i = 0; i < possPosBLRook.getColumns().size(); i++) {

                    for (int j = 0; j < possPosWLRook.getColumns().size(); j++) {

                        if (possPosBLRook.getColumns().get(i) == possPosWLRook.getColumns().get(j)) {

                            same_col = true;
                            break;
                        }
                    }
                    if (same_col) {
                        break;
                    }
                }
                if (same_col) {
                    hit_rows = possPosWLRook.getRows();
                    hit_cols = possPosWLRook.getColumns();
                }

            }
        }
        Log.d("neither", "neither");
        if(possPosBLRook != null && possPosWLRook != null){

            for(int i = 0; i < possPosBLRook.getRows().size(); i++){

                for(int j = 0; j < possPosWLRook.getRows().size(); j++){

                    if(possPosBLRook.getRows().get(i) == possPosWLRook.getRows().get(j) && possPosBLRook.getColumns().get(i) == possPosWLRook.getColumns().get(j)){

                        hit_rows.add(possPosBLRook.getRows().get(i));
                        hit_cols.add(possPosBLRook.getColumns().get(i));

                    }
                }
            }

        }


        Positions hits = new Positions(hit_rows, hit_cols);

        return  hits;
    }




}
