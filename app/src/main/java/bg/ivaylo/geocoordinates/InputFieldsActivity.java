package bg.ivaylo.geocoordinates;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class InputFieldsActivity extends AppCompatActivity {

    private EditText inputX, inputY, inputHeight;
    private Button btnBack, btnCameraX, btnCameraY, btnCameraHeight, btnCalculate;

    private String inputCoordinate;
    private String outputCoordinate;
    private String inputHeightSystem;
    private String outputHeightSystem;
    private String inputSubCoordinate;
    private String outputSubCoordinate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_fields);

        inputX = findViewById(R.id.input_x);
        inputY = findViewById(R.id.input_y);
        inputHeight = findViewById(R.id.input_height);
        btnBack = findViewById(R.id.btn_back);
        btnCameraX = findViewById(R.id.btn_camera_x);
        btnCameraY = findViewById(R.id.btn_camera_y);
        btnCameraHeight = findViewById(R.id.btn_camera_height);
        btnCalculate = findViewById(R.id.btn_calculate);

        // Retrieve data from Intent
        Intent intent = getIntent();
        inputCoordinate = intent.getStringExtra("inputCoordinate");
        outputCoordinate = intent.getStringExtra("outputCoordinate");
        inputHeightSystem = intent.getStringExtra("inputHeightSystem");
        outputHeightSystem = intent.getStringExtra("outputHeightSystem");
        inputSubCoordinate = intent.getStringExtra("inputSubCoordinate");
        outputSubCoordinate = intent.getStringExtra("outputSubCoordinate");

        // Set listeners
        btnBack.setOnClickListener(v -> finish());

        btnCameraX.setOnClickListener(v -> {
            // Implement camera functionality for X coordinate
        });

        btnCameraY.setOnClickListener(v -> {
            // Implement camera functionality for Y coordinate
        });

        btnCameraHeight.setOnClickListener(v -> {
            // Implement camera functionality for height
        });

        btnCalculate.setOnClickListener(v -> {
            // Retrieve and use the values for transformation
            String x = inputX.getText().toString();
            String y = inputY.getText().toString();
            String height = inputHeight.getText().toString();

            // Validate inputs
            if (validateCoordinates(x, y)) {
                // Perform calculation or transformation with these values
                performTransformation(x, y, height);
            } else {
                Toast.makeText(this, "Невалидни координати", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validateCoordinates(String x, String y) {
        try {
            Double.parseDouble(x);
            Double.parseDouble(y);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void performTransformation(String x, String y, String height) {
        // Implement the transformation logic using the retrieved values and the data from the first page
        // Example: transformationService.transform(inputCoordinate, outputCoordinate, inputHeightSystem, outputHeightSystem, inputSubCoordinate, outputSubCoordinate, x, y, height);

        // Log the values for debugging purposes
        Log.d("InputFieldsActivity", "Transformation Parameters:");
        Log.d("InputFieldsActivity", "Input Coordinate: " + inputCoordinate);
        Log.d("InputFieldsActivity", "Output Coordinate: " + outputCoordinate);
        Log.d("InputFieldsActivity", "Input Height System: " + inputHeightSystem);
        Log.d("InputFieldsActivity", "Output Height System: " + outputHeightSystem);
        Log.d("InputFieldsActivity", "Input Sub Coordinate: " + inputSubCoordinate);
        Log.d("InputFieldsActivity", "Output Sub Coordinate: " + outputSubCoordinate);
        Log.d("InputFieldsActivity", "X: " + x);
        Log.d("InputFieldsActivity", "Y: " + y);
        Log.d("InputFieldsActivity", "Height: " + height);
    }
}
