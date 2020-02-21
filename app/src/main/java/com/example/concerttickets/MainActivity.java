package com.example.concerttickets;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private double costPerTicket = 79.99;
    private int numberOfTickets;
    private double totalCost;
    private String groupChoice;
    private DecimalFormat currency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currency = new DecimalFormat("$###,###.00");

        final EditText tickets = findViewById(R.id.txtTickets);
        final Spinner group = findViewById(R.id.txtGroup);
        final Button cost = findViewById(R.id.btnCost);
        final TextView result = findViewById(R.id.textResult);

        cost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ticketsEntered = tickets.getText().toString();
                numberOfTickets = ticketsEntered.equals("") ? 0 : Integer.parseInt(ticketsEntered);

                totalCost = costPerTicket * numberOfTickets;

                groupChoice = group.getSelectedItem().toString();

                result.setText("The Cost of " + numberOfTickets + " tickets for\n"+ groupChoice + " is " + currency.format(totalCost) + ".");

                // Hide the keyboard, if it is shown
                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(),0);
            }
        });
    }
}
