package com.example.sal.salchess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;


import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private int offset = 2131427423;
    private int previous_click = -1;
    private boolean first = true;//first clicked
    private int doubleClicked = 0;//when same location keps getting clicked

    private Grid grid = new Grid();

    private char first_piece = ' ';
    private int first_piece_row = -1;
    private int first_piece_col = -1;

    private char second_piece = ' ';
    private int second_piece_row = -1;
    private int second_piece_col = -1;

    ImageView first_view;
    ImageView second_view;

//    private int first_piece_num = -1;
//    private int second_piece_num = -1;

    public void gameLogic(View view){

        int id = 0;

        ImageView tappedView = (ImageView) view;
        id = tappedView.getId() - offset;


        if(first == true && previous_click != id){
            Log.d("item1", "First item");
            first = false;
            previous_click = id;
            doubleClicked = 0;

            first_piece_clicked(tappedView);

        }
        else if(previous_click == id){
            Log.d("item2", "Nothing happens");
            doubleClicked++;
            Log.d("item2", String.valueOf(doubleClicked));

            if(doubleClicked % 2 == 0){
                first = false;
                first_piece_clicked(tappedView);
            }
            else{
                first = true;
                second_piece_clicked(tappedView);
            }

        }
        //second location clicked
        else{
            Log.d("item3", "Second item");
            first = true;
            doubleClicked = 0;
            previous_click = id;
            second_piece_clicked(tappedView);
        }

    }

    public void first_piece_clicked(ImageView tappedView){

        first_piece = (char)((int) CheckWhatPiece(tappedView).get(0));
        first_piece_row = CheckWhatPiece(tappedView).get(1);
        first_piece_col = CheckWhatPiece(tappedView).get(2);

//        first_piece_num = CheckWhatPiece(tappedView).get(3);

        if(first_piece == '#'){
            doubleClicked = 0;
            previous_click = -1;
            first = true;
        }

        first_view = tappedView;
    }

    public void second_piece_clicked(ImageView tappedView){

        doubleClicked = 0;
        previous_click = -1;

        int piece_ascii =  CheckWhatPiece(tappedView).get(0);

        second_piece = (char) piece_ascii;

        second_piece_row = CheckWhatPiece(tappedView).get(1);
        second_piece_col = CheckWhatPiece(tappedView).get(2);
//        second_piece_num = CheckWhatPiece(tappedView).get(3);

        second_view = tappedView;

        actionBasedOnPiece();
    }

    public ArrayList<Integer> CheckWhatPiece(ImageView view){


        String imageName1 = view.getResources().getResourceEntryName(view.getId());
        String mydata = imageName1;
        String matched = "";

        Pattern pattern = Pattern.compile("[0-9][0-9]*");
        Matcher matcher = pattern.matcher(mydata);


        while(matcher.find())
        {
            matched = matcher.group();
        }

        int num = Integer.parseInt(matched);

        char chessPiece = grid.getItemAtLocation(num);

        int row = grid.numToTwoDIndex(num).get(0);
        int col = grid.numToTwoDIndex(num).get(1);


        ArrayList<Integer> pieceResults = new ArrayList<Integer>();

        pieceResults.add((int) chessPiece);
        pieceResults.add(row);
        pieceResults.add(col);
        pieceResults.add(num);

        return pieceResults;

    }

    public void actionBasedOnPiece(){

        Log.d("piece", String.valueOf(first_piece));

        boolean validMove = false;

        switch (first_piece){

            case 'R':
                Rook wRook = new Rook("White", grid);
                validMove = wRook.checkIfValidMove(first_piece,first_piece_row,first_piece_col, second_piece, second_piece_row, second_piece_col);

                //if valid move the chang the grid and the view
                if(validMove){
                    upDateGridAndView();
                    validMove = false;
                }
                break;
            case 'H':
                Knight wKnight = new Knight("White", grid);
                validMove = wKnight.checkIfValidMove(first_piece,first_piece_row,first_piece_col, second_piece, second_piece_row, second_piece_col);

                if(validMove){
                    upDateGridAndView();
                    validMove = false;
                }
                break;

            case 'P':
                Pawn wPawn = new Pawn("White", grid);
                validMove = wPawn.checkIfValidMove(first_piece,first_piece_row,first_piece_col, second_piece, second_piece_row, second_piece_col);

                Log.d("pass", String.valueOf(validMove));
                if(validMove){
                    upDateGridAndView();
                    validMove = false;
                }
                break;

            case 'Q':
                Rook wRookQ = new Rook("White", grid);
                Bishop wBishopQ = new Bishop("White", grid);

                boolean validMove2 = false;
                boolean validMove3 = false;

                validMove2 = wRookQ.checkIfValidMove(first_piece,first_piece_row,first_piece_col, second_piece, second_piece_row, second_piece_col);
                validMove3 = wBishopQ.checkIfValidMove(first_piece,first_piece_row,first_piece_col, second_piece, second_piece_row, second_piece_col);

                if(validMove2 || validMove3){
                    upDateGridAndView();
                }
                break;
            case 'B':
                Bishop wBishop = new Bishop("White", grid);
                validMove = wBishop.checkIfValidMove(first_piece,first_piece_row,first_piece_col, second_piece, second_piece_row, second_piece_col);
                Log.d("Bishop", String.valueOf(validMove));

                if(validMove){
                    upDateGridAndView();
                    validMove = false;
                }
                break;

            case 'K':
                King wKing = new King("White", grid);
                validMove = wKing.checkIfValidMove(first_piece,first_piece_row,first_piece_col, second_piece, second_piece_row, second_piece_col);


                if(validMove){
                    upDateGridAndView();
                    validMove = false;
                }
                break;


            default:
                break;

        }


    }

    public void upDateGridAndView(){


        char [][] new_grid = grid.getGridArr();

        char first_val = new_grid[first_piece_row][first_piece_col];

        Log.d("first_val", String.valueOf(first_val));
        new_grid[second_piece_row][second_piece_col] = first_val;

        new_grid[first_piece_row][first_piece_col] = '#';


        grid.setGridArr(new_grid);




        //now change view

        first_view.setImageResource(android.R.color.transparent);

        switch(first_piece){

            case 'R':
                second_view.setImageResource(R.drawable.w_rook);
                break;
            case 'H':
                second_view.setImageResource(R.drawable.w_knight);
                break;
            case 'B':
                second_view.setImageResource(R.drawable.w_bishop);
                break;
            case 'K':
                second_view.setImageResource(R.drawable.w_king);
                break;
            case 'Q':
                second_view.setImageResource(R.drawable.w_queen);
                break;
            case 'P':
                second_view.setImageResource(R.drawable.w_pawn);
                break;
        }




    }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
