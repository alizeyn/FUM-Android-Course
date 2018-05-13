package ir.alizeyn.s13;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LongOperation operation = new LongOperation();
        operation.execute("start");
    }


    private class LongOperation extends AsyncTask<String, Integer, String> {
        TextView tvOutput = findViewById(R.id.tvOutput);
        @Override
        protected String doInBackground(String... params) {
            for (int i = 0; i < 10; i++) {
                try {
                    publishProgress((i + 1) * 10);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.interrupted();
                }
            }
            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }
            tvOutput.setText("Done"); // txt.setText(result);

        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Integer... values) {
            int percentage = values[0];
            tvOutput.setText(percentage + " % ");
        }
    }
}
