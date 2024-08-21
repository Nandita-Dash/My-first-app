package com.example.additiontime;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText ev1;
    private EditText ev2;
    private TextView tv1;
    private TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        ev1 = findViewById(R.id.editTextNumber3);
        ev2 = findViewById(R.id.editTextNumber2);
        tv1 = findViewById(R.id.textView5);
        tv2 = findViewById(R.id.textView4);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String t1=ev1.getText().toString().trim();
                String t2=ev2.getText().toString().trim();

                if (t1.isEmpty()||t2.isEmpty()){
                    Toast.makeText(MainActivity.this,"Please enter both numbers",Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    int t11=Integer.parseInt(t1);
                    int t22=Integer.parseInt(t2);
                    int sum=t11+t22;
                    tv1.setText("The sum of "+t11+" and "+t22+" is:");
                    tv2.setText(String.valueOf(sum));
                    Toast.makeText(MainActivity.this,"Operation Successful",Toast.LENGTH_SHORT).show();
                }
                catch (NumberFormatException e){
                    Toast.makeText(MainActivity.this,"Invalid number format.Please enter valid integers.",Toast.LENGTH_SHORT).show();
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}