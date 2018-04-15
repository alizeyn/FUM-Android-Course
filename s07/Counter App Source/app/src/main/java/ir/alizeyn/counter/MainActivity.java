package ir.alizeyn.counter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

// activity ( https://developer.android.com/reference/android/app/Activity.html )
// resources and resource ids
// event listeners
// intents ( https://developer.android.com/reference/android/content/Intent.html )
// change activity

public class MainActivity extends AppCompatActivity {

    private TextView tvCounter;
    private EditText etInit;
    private Button bSetInit;  // setOnClickListener
    private Button bAdd;      // setOnClickListener

    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCounter = findViewById(R.id.tvCounter);
        etInit = findViewById(R.id.etInit);
        bSetInit = findViewById(R.id.bSetInit);
        bAdd = findViewById(R.id.bAdd);

        //use keyboard done button
        etInit.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (KeyEvent.KEYCODE_ENTER == i) {
                    bSetInit.performClick();
                }
                return false;
            }
        });
    }

    public void setInit(View view) {
        String init = etInit.getText().toString();
        counter = Integer.valueOf(init);
        tvCounter.setText(String.valueOf(counter));
    }

    public void Add(View view) {
        counter++;
        tvCounter.setText(String.valueOf(counter));
    }

    //life cycle and handling rotation
//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        outState.putInt("Counter", counter);
//        super.onSaveInstanceState(outState);
//    }
//
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        counter = savedInstanceState.getInt("Counter", 0);
//        tvCounter.setText(String.valueOf(counter));
//        super.onRestoreInstanceState(savedInstanceState);
//    }
}
