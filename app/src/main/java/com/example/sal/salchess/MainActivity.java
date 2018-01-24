package com.example.sal.salchess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Random;


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

//    ArrayList<ImageView> views_clicked = new ArrayList<ImageView>();

    WhitePiecesLocation whitePiecesLoc = new WhitePiecesLocation();

    public void gameLogic(View view){

        int id = 0;

        ImageView tappedView = (ImageView) view;
        id = tappedView.getId() - offset;


        if(first == true && previous_click != id){
            first = false;
            previous_click = id;
            doubleClicked = 0;

            first_piece_clicked(tappedView);

        }
        else if(previous_click == id){
            doubleClicked++;

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
            first = true;
            doubleClicked = 0;
            previous_click = id;
            second_piece_clicked(tappedView);
        }

    }

    public void first_piece_clicked(ImageView tappedView){//add White index here?

        first_piece = (char)((int) CheckWhatPiece(tappedView).get(0));
        first_piece_row = CheckWhatPiece(tappedView).get(1);
        first_piece_col = CheckWhatPiece(tappedView).get(2);


        if(first_piece == '#'){
            doubleClicked = 0;
            previous_click = -1;
            first = true;
        }

        first_view = tappedView;

        Log.d("First White", String.valueOf(first_piece));
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
        //whitePiecesLoc.printLocations();
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

        int num = Integer.parseInt(matched);// 1D index

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

    //checks what White piece was clicked
    //I need to store the indexes of the white pieces and the tyoe for later analysis
    public void actionBasedOnPiece(){


        //whitePiecesLoc.printLocations();

        boolean validMove = false;

        switch (first_piece){

            case 'R':
                Rook wRook = new Rook("White", grid);
                validMove = wRook.checkIfValidMove(first_piece,first_piece_row,first_piece_col, second_piece, second_piece_row, second_piece_col);
                //if valid move the chang the grid and the view
                if(validMove){
                    whitePiecesLoc.upDateLocation(first_piece_row, first_piece_col, second_piece_row, second_piece_col);
                    upDateGridAndViewWhite();
                }
                break;
            case 'H':
                Knight wKnight = new Knight("White", grid);
                validMove = wKnight.checkIfValidMove(first_piece,first_piece_row,first_piece_col, second_piece, second_piece_row, second_piece_col);

                if(validMove){
                    whitePiecesLoc.upDateLocation(first_piece_row, first_piece_col, second_piece_row, second_piece_col);
                    upDateGridAndViewWhite();
                }
                break;

            case 'P':
                Pawn wPawn = new Pawn("White", grid);
                validMove = wPawn.checkIfValidMove(first_piece,first_piece_row,first_piece_col, second_piece, second_piece_row, second_piece_col);

                if(validMove){
                    whitePiecesLoc.upDateLocation(first_piece_row, first_piece_col, second_piece_row, second_piece_col);
                    upDateGridAndViewWhite();
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
                    whitePiecesLoc.upDateLocation(first_piece_row, first_piece_col, second_piece_row, second_piece_col);
                    upDateGridAndViewWhite();
                }
                break;
            case 'B':
                Bishop wBishop = new Bishop("White", grid);
                validMove = wBishop.checkIfValidMove(first_piece,first_piece_row,first_piece_col, second_piece, second_piece_row, second_piece_col);

                if(validMove){
                    whitePiecesLoc.upDateLocation(first_piece_row, first_piece_col, second_piece_row, second_piece_col);
                    upDateGridAndViewWhite();

                }
                break;

            case 'K':
                King wKing = new King("White", grid);
                validMove = wKing.checkIfValidMove(first_piece,first_piece_row,first_piece_col, second_piece, second_piece_row, second_piece_col);


                if(validMove){
                    whitePiecesLoc.upDateLocation(first_piece_row, first_piece_col, second_piece_row, second_piece_col);
                    upDateGridAndViewWhite();
                }
                break;


            default:
                break;

        }


    }

    public void activateAI(){



        boolean pass = false;

        do{
            Log.d("runs", "runs");
            ArrayList<Character> white_pieces = new ArrayList<Character>();
            white_pieces.add('R');
            white_pieces.add('H');
            white_pieces.add('B');
            white_pieces.add('Q');
            white_pieces.add('K');
            white_pieces.add('P');

            ArrayList<Character> black_pieces = new ArrayList<Character>();
            black_pieces.add('r');
            black_pieces.add('h');
            black_pieces.add('b');
            black_pieces.add('q');
            black_pieces.add('k');
            black_pieces.add('p');

            Random rn = new Random();
            int answer1 = rn.nextInt(64);
            int answer2 = rn.nextInt(64);

            int id1 = getViewID(answer1);
            int id2 = getViewID(answer2);

            ImageView image1 = (ImageView) findViewById(id1);
            ImageView image2 = (ImageView) findViewById(id2);

            ArrayList<Integer> vals1 = grid.numToTwoDIndex(answer1);
            ArrayList<Integer> vals2 = grid.numToTwoDIndex(answer2);
            char piece = grid.getItemAtLocation(answer1);
            char piece2 = grid.getItemAtLocation(answer2);


            //if first piece is empty, or if both pieces are black, or the first piece is white, the grid does not get upgraded
            if((piece == '#' || black_pieces.contains(piece2)) || (white_pieces.contains(piece))){
                pass = true;
            }
            else if(piece == 'b'){
                Log.d("Bishop","bishop selected");
                Bishop bishop = new Bishop("Black", grid);
                boolean bishop_valid_move = bishop.checkIfValidMove(piece,vals1.get(0),vals1.get(1),piece2, vals2.get(0),vals2.get(1));
                if(bishop_valid_move) {
                    upDateGridAndViewBlack(piece,vals1.get(0),vals1.get(1),vals2.get(0),vals2.get(1),image1, image2);
                    pass = false;
                }
                else{
                    pass = true;
                }
            }
            else if(piece == 'k'){
                Log.d("king","king selected");
                King king = new King("Black", grid);
                boolean king_valid_move = king.checkIfValidMove(piece,vals1.get(0),vals1.get(1),piece2, vals2.get(0),vals2.get(1));
                if(king_valid_move) {
                    upDateGridAndViewBlack(piece,vals1.get(0),vals1.get(1),vals2.get(0),vals2.get(1),image1, image2);
                    pass = false;
                }
                else{
                    pass = true;
                }
            }
            else if(piece == 'h'){
                Log.d("knight","knight selected");
                Knight knight = new Knight("Black", grid);
                boolean knight_valid_move = knight.checkIfValidMove(piece,vals1.get(0),vals1.get(1),piece2, vals2.get(0),vals2.get(1));
                if(knight_valid_move) {
                    upDateGridAndViewBlack(piece,vals1.get(0),vals1.get(1),vals2.get(0),vals2.get(1),image1, image2);
                    pass = false;
                }
                else{
                    pass = true;
                }
            }
            else if(piece == 'r'){
                Log.d("rook","rook selected");
                Rook rook = new Rook("Black", grid);
                boolean rook_valid_move = rook.checkIfValidMove(piece,vals1.get(0),vals1.get(1),piece2, vals2.get(0),vals2.get(1));
                if(rook_valid_move) {
                    upDateGridAndViewBlack(piece,vals1.get(0),vals1.get(1),vals2.get(0),vals2.get(1),image1, image2);
                    pass = false;
                }
                else{
                    pass = true;
                }
            }
            else if(piece == 'p'){
                Log.d("pawn","pawn selected");
                Pawn pawn = new Pawn("Black", grid);
                boolean pawn_valid_move = pawn.checkIfValidMove(piece,vals1.get(0),vals1.get(1),piece2, vals2.get(0),vals2.get(1));
                if(pawn_valid_move) {
                    upDateGridAndViewBlack(piece,vals1.get(0),vals1.get(1),vals2.get(0),vals2.get(1),image1, image2);
                    pass = false;
                }
                else{
                    pass = true;
                }
            }
            else if(piece == 'q'){
                Log.d("queen","queen selected");
                Rook rookQ = new Rook("Black", grid);
                Bishop bishopQ = new Bishop("Black", grid);
                boolean bishop_valid_moveQ = bishopQ.checkIfValidMove(piece,vals1.get(0),vals1.get(1),piece2, vals2.get(0),vals2.get(1));
                boolean rook_valid_moveQ = rookQ.checkIfValidMove(piece,vals1.get(0),vals1.get(1),piece2, vals2.get(0),vals2.get(1));

                if(rook_valid_moveQ || bishop_valid_moveQ) {
                    upDateGridAndViewBlack(piece,vals1.get(0),vals1.get(1),vals2.get(0),vals2.get(1),image1, image2);
                    pass = false;
                }
                else{
                    pass = true;
                }
            }
            else{
                upDateGridAndViewBlack(piece,vals1.get(0),vals1.get(1),vals2.get(0),vals2.get(1),image1, image2);
                pass = false;
            }
        }while(pass == true);


//        Rook wlRook = new Rook("White", grid);
//        wlRook.getPossiblePositions('R',whitePiecesLoc.get_rows()[8],whitePiecesLoc.get_columns()[8]);//to get left Rook

//
//        Rook wrRook = new Rook("White", grid);
//        wrRook.getPossiblePositions('R',whitePiecesLoc.get_rows()[15],whitePiecesLoc.get_columns()[15]);//to get right Rook

//        King wKing = new King("White", grid);
//        wKing.getPossiblePositions('K',whitePiecesLoc.get_rows()[12],whitePiecesLoc.get_columns()[12]);//to get king

        Knight wlKnight = new Knight("White", grid);
        wlKnight.getPossiblePositions('H', whitePiecesLoc.get_rows()[9], whitePiecesLoc.get_columns()[9]);// to get left Knight



    }

    public void upDateGridAndViewBlack(char firstPiece, int firstPieceRow, int firstPieceCol,
                                       int secondPieceRow, int secondPieceCol, ImageView firstView, ImageView secondView){


        //Switch tages between Image Views

        secondView.setTag(firstView.getTag());
        firstView.setTag(null);


        //Switch values in array

        char [][] new_grid = grid.getGridArr();

        char first_val = new_grid[firstPieceRow][firstPieceCol];

        new_grid[secondPieceRow][secondPieceCol] = first_val;
        new_grid[firstPieceRow][firstPieceCol] = '#';

        grid.setGridArr(new_grid);
        //switch values in in ImageView
       firstView.setImageResource(android.R.color.transparent);

        switch(firstPiece){

            case 'r':
                secondView.setImageResource(R.drawable.b_rook);
                secondView.setEnabled(true);
                break;
            case 'h':
                secondView.setImageResource(R.drawable.b_knight);
                secondView.setEnabled(true);
                break;
            case 'b':
                secondView.setImageResource(R.drawable.b_bishop);
                secondView.setEnabled(true);
                break;
            case 'k':
                secondView.setImageResource(R.drawable.b_king);
                secondView.setEnabled(true);
                break;
            case 'q':
                secondView.setImageResource(R.drawable.b_queen);
                secondView.setEnabled(true);
                break;
            case 'p':
                secondView.setImageResource(R.drawable.b_pawn);
                secondView.setEnabled(true);
                break;
            default:
                break;
        }



    }


    public void upDateGridAndViewWhite(){


        //Switch tages between Image Views
        String temp_tag = (String) first_view.getTag();
        first_view.setTag(null);
        second_view.setTag(temp_tag);


        //Switch values in array

        char [][] new_grid = grid.getGridArr();

        char first_val = new_grid[first_piece_row][first_piece_col];

        new_grid[second_piece_row][second_piece_col] = first_val;

        new_grid[first_piece_row][first_piece_col] = '#';


        grid.setGridArr(new_grid);

        //switch values in in ImageView
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
            default:
                break;
        }

        disableWhites(false);
        activateAI();
        disableWhites(true);
    }

    public void disableWhites(boolean enabled){

        ArrayList<String> white_tags = new ArrayList<String>();

        white_tags.add("w_pawn");
        white_tags.add("w_rook");
        white_tags.add("w_knight");
        white_tags.add("w_bishop");
        white_tags.add("w_queen");
        white_tags.add("w_king");


        for(int i = 0; i < 64; i++){

            ImageView image = (ImageView) findViewById(getViewID(i));
            if(white_tags.contains((String)image.getTag())){
                image.setEnabled(enabled);
            }
        }
    }

    public int getViewID(int index){

        ArrayList<Integer> viewIds = new ArrayList<Integer>();
        viewIds.add(R.id.box_0);
        viewIds.add(R.id.box_1);
        viewIds.add(R.id.box_2);
        viewIds.add(R.id.box_3);
        viewIds.add(R.id.box_4);
        viewIds.add(R.id.box_5);
        viewIds.add(R.id.box_6);
        viewIds.add(R.id.box_7);
        viewIds.add(R.id.box_8);
        viewIds.add(R.id.box_9);
        viewIds.add(R.id.box_10);
        viewIds.add(R.id.box_11);
        viewIds.add(R.id.box_12);
        viewIds.add(R.id.box_13);
        viewIds.add(R.id.box_14);
        viewIds.add(R.id.box_15);
        viewIds.add(R.id.box_16);
        viewIds.add(R.id.box_17);
        viewIds.add(R.id.box_18);
        viewIds.add(R.id.box_19);
        viewIds.add(R.id.box_20);
        viewIds.add(R.id.box_21);
        viewIds.add(R.id.box_22);
        viewIds.add(R.id.box_23);
        viewIds.add(R.id.box_24);
        viewIds.add(R.id.box_25);
        viewIds.add(R.id.box_26);
        viewIds.add(R.id.box_27);
        viewIds.add(R.id.box_28);
        viewIds.add(R.id.box_29);
        viewIds.add(R.id.box_30);
        viewIds.add(R.id.box_31);
        viewIds.add(R.id.box_32);
        viewIds.add(R.id.box_33);
        viewIds.add(R.id.box_34);
        viewIds.add(R.id.box_35);
        viewIds.add(R.id.box_36);
        viewIds.add(R.id.box_37);
        viewIds.add(R.id.box_38);
        viewIds.add(R.id.box_39);
        viewIds.add(R.id.box_40);
        viewIds.add(R.id.box_41);
        viewIds.add(R.id.box_42);
        viewIds.add(R.id.box_43);
        viewIds.add(R.id.box_44);
        viewIds.add(R.id.box_45);
        viewIds.add(R.id.box_46);
        viewIds.add(R.id.box_47);
        viewIds.add(R.id.box_48);
        viewIds.add(R.id.box_49);
        viewIds.add(R.id.box_50);
        viewIds.add(R.id.box_51);
        viewIds.add(R.id.box_52);
        viewIds.add(R.id.box_53);
        viewIds.add(R.id.box_54);
        viewIds.add(R.id.box_55);
        viewIds.add(R.id.box_56);
        viewIds.add(R.id.box_57);
        viewIds.add(R.id.box_58);
        viewIds.add(R.id.box_59);
        viewIds.add(R.id.box_60);
        viewIds.add(R.id.box_61);
        viewIds.add(R.id.box_62);
        viewIds.add(R.id.box_63);


        return viewIds.get(index);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
