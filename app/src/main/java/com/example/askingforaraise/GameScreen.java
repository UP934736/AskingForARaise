package com.example.askingforaraise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.VerifiedInputEvent;
import android.view.View;
import android.widget.*;

import java.io.FileNotFoundException;
import java.nio.channels.ScatteringByteChannel;


public class GameScreen extends AppCompatActivity {

    TextView nodeDesc;
    Button yesButton, noButton, conButton, finButton;
    DecisionNode node;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        // creating variables to be able to access the assets of the app
        conButton = (Button)findViewById(R.id.btnCon);
        yesButton = (Button)findViewById(R.id.btnYes);
        noButton = (Button)findViewById(R.id.btnNo);
        finButton = (Button)findViewById(R.id.btnFin);
        nodeDesc = (TextView)findViewById(R.id.descriptionText);
        conButton.setVisibility(View.GONE);
        finButton.setVisibility(View.GONE);
        DecisionMap perec = null;
        try {
            perec = new DecisionMap(this);
        } catch (CustomException e) {
            //nodeDesc.setText(e.getMessage());
        }

        try {
            // finding the starting point
            node = perec.entryPoint();

            // displaying the message
            nodeDesc.setText(node.getDescription() + "\n" + "\n" + node.getQuestion());
            navigateMap();
        } catch (CustomException ce){
            nodeDesc.setText(ce.getMessage());
        }

    }

    // get yes node and display the text of that node when yes button is clicked
    public void btnYesClicked (View view){
        node = node.getYesNode();
        nodeDesc.setText(node.getDescription() + "\n" + "\n" + node.getQuestion());
        navigateMap();
    }

    // get no node and display the text of tthat node when noo button is clicked
    public void btnNoClicked(View view){
        node = node.getNoNode();
        nodeDesc.setText(node.getDescription() + "\n" + "\n" + node.getQuestion());
        navigateMap();
    }

    // move to the next node as there is no questions to be asked
    public void btnContClicked(View view){
        node = node.getYesNode();
        nodeDesc.setText(node.getDescription() + "\n" + "\n" + node.getQuestion());
        navigateMap();
        //check if the user reached the final (winning) node
        checkWin();
    }

    // go back to main menu by clicking finish button after completing the game
    public void btnFinClicked(View view){
        Intent switchActs = new Intent(GameScreen.this, MainActivity.class);
        startActivity(switchActs);
    }


    public void navigateMap(){
        // check if there is no questions in the node
        if (node.getQuestion().equals("-")){
            // set yes & no to invisible and set continue to visible
            changeVis();
            // display the description
            nodeDesc.setText(node.getDescription());
        }
        // check if the next node is not depending on user input
        else if( node.getYesNode().getNodeID() == node.getNoNode().getNodeID()){
            // check if description is empty
            if (node.getDescription().equals("-")){
                // set yes & no to invisible and set continue to visible
                changeVis();
                // display the question
                nodeDesc.setText(node.getQuestion());
            }
            else{
                // set yes & no to invisible and set continue to visible
                changeVis();
                // display both the description and the question
                nodeDesc.setText(node.getDescription() + "\n" + "\n" + node.getQuestion());
            }
        }
        else{
            // revert the effects of the function "changeVis"
            yesButton.setVisibility(View.VISIBLE);
            noButton.setVisibility(View.VISIBLE);
            conButton.setVisibility(View.GONE);
        }

        // check if there is no description of the node
        if(node.getDescription().equals("-")){
            nodeDesc.setText(node.getQuestion());
        }
    }

    public void checkWin(){
        // check if the user reached the winning node
        if (node.getNodeID() == 50){
            // set finish button to be visible
            finButton.setVisibility(View.VISIBLE);
            // set continue button to be invisible
            conButton.setVisibility(View.GONE);
        }
    }

    public void changeVis(){
        // set the yes button to be invisible
        yesButton.setVisibility(View.GONE);
        // set the no button to be invisible
        noButton.setVisibility(View.GONE);
        // set the continue button to be visible
        conButton.setVisibility(View.VISIBLE);
    }

}