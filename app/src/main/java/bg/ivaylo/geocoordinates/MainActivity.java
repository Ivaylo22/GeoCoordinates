package bg.ivaylo.geocoordinates;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private RadioGroup radioGroupInputCoordinate, radioGroupOutputCoordinate, radioGroupInputHeight, radioGroupOutputHeight;
    private RadioGroup radioGroupKS1970Suboptions, radioGroupOutputKS1970Suboptions;

    private String selectedInputCoordinate, selectedOutputCoordinate, selectedInputHeight, selectedOutputHeight;
    private String selectedInputSubCoordinate, selectedOutputSubCoordinate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroupInputCoordinate = findViewById(R.id.radio_group_input_coordinate);
        radioGroupOutputCoordinate = findViewById(R.id.radio_group_output_coordinate);
        radioGroupInputHeight = findViewById(R.id.radio_group_input_height);
        radioGroupOutputHeight = findViewById(R.id.radio_group_output_height);

        radioGroupKS1970Suboptions = findViewById(R.id.radio_group_ks_1970_suboptions);
        radioGroupOutputKS1970Suboptions = findViewById(R.id.radio_group_output_ks_1970_suboptions);

        Log.d(TAG, "onCreate: Setting up listeners");

        setupListeners();
    }

    private void setupListeners() {
        radioGroupInputCoordinate.setOnCheckedChangeListener((group, checkedId) -> {
            resetSubOptionsVisibility(true);
            RadioButton checkedRadioButton = findViewById(checkedId);
            selectedInputCoordinate = checkedRadioButton.getText().toString();
            Log.d(TAG, "Input Coordinate System Selected: " + selectedInputCoordinate);
            if (checkedId == R.id.radio_ks_1970) {
                findViewById(R.id.layout_ks_1970_suboptions).setVisibility(View.VISIBLE);
                Log.d(TAG, "Showing KS 1970 suboptions");
            }
        });

        radioGroupOutputCoordinate.setOnCheckedChangeListener((group, checkedId) -> {
            resetSubOptionsVisibility(false);
            RadioButton checkedRadioButton = findViewById(checkedId);
            selectedOutputCoordinate = checkedRadioButton.getText().toString();
            Log.d(TAG, "Output Coordinate System Selected: " + selectedOutputCoordinate);
            if (checkedId == R.id.radio_output_ks_1970) {
                findViewById(R.id.layout_output_ks_1970_suboptions).setVisibility(View.VISIBLE);
                Log.d(TAG, "Showing Output KS 1970 suboptions");
            }
        });

        radioGroupKS1970Suboptions.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton checkedRadioButton = findViewById(checkedId);
            selectedInputSubCoordinate = checkedRadioButton.getText().toString();
            Log.d(TAG, "Input Sub Coordinate Selected: " + selectedInputSubCoordinate);
        });

        radioGroupOutputKS1970Suboptions.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton checkedRadioButton = findViewById(checkedId);
            selectedOutputSubCoordinate = checkedRadioButton.getText().toString();
            Log.d(TAG, "Output Sub Coordinate Selected: " + selectedOutputSubCoordinate);
        });

        radioGroupInputHeight.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton checkedRadioButton = findViewById(checkedId);
            selectedInputHeight = checkedRadioButton.getText().toString();
            Log.d(TAG, "Input Height System Selected: " + selectedInputHeight);
        });

        radioGroupOutputHeight.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton checkedRadioButton = findViewById(checkedId);
            selectedOutputHeight = checkedRadioButton.getText().toString();
            Log.d(TAG, "Output Height System Selected: " + selectedOutputHeight);
        });
    }

    private void resetSubOptionsVisibility(boolean isInput) {
        if (isInput) {
            findViewById(R.id.layout_ks_1970_suboptions).setVisibility(View.GONE);
            Log.d(TAG, "Hiding input KS 1970 suboptions");
        } else {
            findViewById(R.id.layout_output_ks_1970_suboptions).setVisibility(View.GONE);
            Log.d(TAG, "Hiding output KS 1970 suboptions");
        }
    }


    public void onInputCoordinateSystemClicked(View view) {
        resetSubOptionsVisibility(true); // Hide only input sub-options
        RadioButton radioButton = (RadioButton) view;
        selectedInputCoordinate = radioButton.getText().toString();
        Log.d(TAG, "Input Coordinate System Clicked: " + selectedInputCoordinate);
        if (view.getId() == R.id.radio_ks_1970) {
            findViewById(R.id.layout_ks_1970_suboptions).setVisibility(View.VISIBLE);
            Log.d(TAG, "Showing input KS 1970 suboptions");
        }
    }


    public void onOutputCoordinateSystemClicked(View view) {
        resetSubOptionsVisibility(false); // Hide only output sub-options
        RadioButton radioButton = (RadioButton) view;
        selectedOutputCoordinate = radioButton.getText().toString();
        Log.d(TAG, "Output Coordinate System Clicked: " + selectedOutputCoordinate);
        if (view.getId() == R.id.radio_output_ks_1970) {
            findViewById(R.id.layout_output_ks_1970_suboptions).setVisibility(View.VISIBLE);
            Log.d(TAG, "Showing output KS 1970 suboptions");
        }
    }


    public void onInputSubCoordinateSystemClicked(View view) {
        RadioButton radioButton = (RadioButton) view;
        selectedInputSubCoordinate = radioButton.getText().toString();
        Log.d(TAG, "Input Sub Coordinate System Clicked: " + selectedInputSubCoordinate);
    }

    public void onOutputSubCoordinateSystemClicked(View view) {
        RadioButton radioButton = (RadioButton) view;
        selectedOutputSubCoordinate = radioButton.getText().toString();
        Log.d(TAG, "Output Sub Coordinate System Clicked: " + selectedOutputSubCoordinate);
    }

    public void onInputHeightSystemClicked(View view) {
        RadioButton radioButton = (RadioButton) view;
        selectedInputHeight = radioButton.getText().toString();
        Log.d(TAG, "Input Height System Clicked: " + selectedInputHeight);
    }

    public void onOutputHeightSystemClicked(View view) {
        RadioButton radioButton = (RadioButton) view;
        selectedOutputHeight = radioButton.getText().toString();
        Log.d(TAG, "Output Height System Clicked: " + selectedOutputHeight);
    }

    public void startTransformation(View view) {
        Intent intent = new Intent(this, InputFieldsActivity.class);
        intent.putExtra("inputCoordinate", selectedInputCoordinate);
        intent.putExtra("outputCoordinate", selectedOutputCoordinate);
        intent.putExtra("inputHeight", selectedInputHeight);
        intent.putExtra("outputHeight", selectedOutputHeight);
        intent.putExtra("inputSubCoordinate", selectedInputSubCoordinate);
        intent.putExtra("outputSubCoordinate", selectedOutputSubCoordinate);
        startActivity(intent);
    }
}