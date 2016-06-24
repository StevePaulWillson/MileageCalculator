package com.ctrl.mileagecalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double mileage = 0, fuelCostValue = 0, fuelFilledValue = 0, distanceDrivenValue = 0, capacityFilledValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mileageCalculator(View view) {
        String fuelCost = ((EditText) findViewById(R.id.fuelCost)).getText().toString();
        String fuelFilled = ((EditText) findViewById(R.id.fuelFilled)).getText().toString();
        String distanceDriven = ((EditText) findViewById(R.id.distanceDriven)).getText().toString();
        TextView mileageResultTextView = (TextView) findViewById(R.id.mileageResult);
        if (fuelCost.matches("") && fuelFilled.matches("") && distanceDriven.matches("")) {
            mileageResultTextView.setText("Mileage");
            Toast.makeText(this, "Enter the current Fuel Cost, Cost of Fuel filled and Distance Driven after Refueling", Toast.LENGTH_SHORT).show();
            return;
        } else if (fuelCost.matches("") && fuelFilled.matches("")) {
            mileageResultTextView.setText("Mileage");
            Toast.makeText(this, "Enter the current Fuel Cost and Cost of Fuel filled", Toast.LENGTH_SHORT).show();
            return;
        }else if (fuelCost.matches("") && distanceDriven.matches("")) {
            mileageResultTextView.setText("Mileage");
            Toast.makeText(this, "Enter the current Fuel Cost and Distance Driven after Refueling", Toast.LENGTH_SHORT).show();
            return;
        }else if (fuelFilled.matches("") && distanceDriven.matches("")) {
            mileageResultTextView.setText("Mileage");
            Toast.makeText(this, "Enter the Cost of Fuel filled and Distance Driven after Refueling", Toast.LENGTH_SHORT).show();
            return;
        } else if (fuelCost.matches("")) {
            mileageResultTextView.setText("Mileage");
            Toast.makeText(this, "Enter the current Fuel Cost", Toast.LENGTH_SHORT).show();
            return;
        } else if (fuelFilled.matches("")) {
            mileageResultTextView.setText("Mileage");
            Toast.makeText(this, "Enter the Cost of Fuel filled", Toast.LENGTH_SHORT).show();
            return;
        } else if (distanceDriven.matches("")) {
            mileageResultTextView.setText("Mileage");
            Toast.makeText(this, "Enter the Distance Driven after Refueling", Toast.LENGTH_SHORT).show();
            return;
        } else {
            fuelCostValue = Double.parseDouble(fuelCost);
            fuelFilledValue = Double.parseDouble(fuelFilled);
            distanceDrivenValue = Double.parseDouble(distanceDriven);
            capacityFilledValue = fuelFilledValue / fuelCostValue;
            mileage = distanceDrivenValue / capacityFilledValue;
            DecimalFormat form = new DecimalFormat("0.00");
            mileageResultTextView.setText("Mileage: " + form.format(mileage));
        }
    }
}