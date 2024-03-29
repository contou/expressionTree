package com.example.expressiontree;

import com.example.expressiontree.factory.PlatformFactory;
import com.example.expressiontree.reactor.InputDispatcher;
import com.example.expressiontree.reactor.InputHandler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @class CalculatorGUISuccint
 * 
 * @brief This class formats the succint GUI for the Android version
 *        of the expression tree application.     
 */
public class CalculatorGUISuccinct extends Activity   
{
    /** 
     * TextView object displays the output of the expression Tree
     * calculate button.
     */
    private static TextView textview;
		
    /** 
     * EditText object intakes user input for the interpreter. 
     */
    private static EditText edittext;
		
    /** 
     * EditText object intakes user input for the interpreter. 
     */
    private static Button b;
		
    /**
     * Creates eventhandler responsible for giving commands. 
     */
    private static InputHandler h;
		
    /**
     * Activity instance used as parameter for makehandler. 
     */
		
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
			
        /** Sets the content view to the xml file, activity_main. */
        setContentView(R.layout.succinct_activity_main);

        /** 
         * Creates the TextView object and coordinates the xml layout
         * with the respective java code. 
         */
        textview = (TextView)findViewById(R.id.tv);
			
        /** 
         * Creates the EditText object and coordinates the xml layout
         * with the respective java code. 
         */
        edittext = (EditText)findViewById(R.id.et);
			
        /** Creates generic button. */
        b = new Button(this);

        /** 
         * Initializes the Platform singleton with the appropriate
         * Platform strategy, which in this case will be the
         * AndroidPlatform.
         */
        Platform.instance (new PlatformFactory(edittext,
                                               textview,
                                               this).makePlatform());

        /** Initializes the Options singleton. */
        String args[] = new String[] { "CalculatorGUISuccinct" };
        Options.instance().parseArgs(args);
    }

    /** Creates the options menu (Succint and Verbose mode). */
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        /**
         * Inflate the menu; this adds items to the action bar if it
         * is present.
         */
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
		
    /** Adds two clickable cases to the options menu. */
    public boolean onOptionsItemSelected(MenuItem item) 
    {
        Intent intent = null;

        switch(item.getItemId()) 
            {
            case R.id.Succinct:
                Toast.makeText(getApplicationContext(),
                               "Switching to succinct mode",
                               Toast.LENGTH_SHORT).show();
                /** 
                 * Sets an intent for switching between the verbose
                 * and succinct activities.
                 */
                intent = new Intent(getApplicationContext(),
                                    CalculatorGUISuccinct.class);
                break;
                /* TBD
            case R.id.Verbose:
                Toast.makeText(getApplicationContext(),
                               "Switching to verbose mode",
                               Toast.LENGTH_SHORT).show();
                // Sets an intent for switching between the verbose
                // and succinct activities.
                intent = new Intent(getApplicationContext(),
                                    CalculatorGUIVerbose.class);
                break;
                */
            }

        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        return false;
    }
		
    /** Sets the action of the button on click state. */
    public void enterButtonClicked(View view) 
    {
        /**
         * Create an InputHandler to process the user input expression
         * where the edittext contains the input and the textview will
         * be the output.
         */
        InputDispatcher.instance().makeHandler(false,
                                               edittext,
                                               textview,
                                               this);

        /** Process the user input expression. */
        InputDispatcher.instance().dispatchOneInput();
    }
		
    /** Inputs the respective value in the calculator bar. */
    public void characterButtonClicked(View view) 
    {
        edittext.setText(edittext.getText().toString() 
                         + ((Button)view).getText());
    }
		
    /** Clears the editText box. */
    public void clrButtonClicked(View view) 
    {
        edittext.setText("");
    }
		
    /** 
     * Retrieves the previous answer in the textview and adds it to
     * the edittext box.
     */
    public void ansButtonClicked(View view) 
    {
        edittext.setText(edittext.getText().toString() 
                         + textview.getText().toString());
    }
		
    /** Back button removes character from input field. */
    public void backButtonClicked(View view) 
    {
    	if(!edittext.getText().toString().equals(""))
            {
                String textMinusLastChar = 
                    edittext.getText().toString().substring
                    (0, 
                     edittext.getText().length() - 1);

                edittext.setText(textMinusLastChar);
            }
    }
}	
		
