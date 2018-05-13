package ir.alizeyn.s13;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;

public class GuiProgressActivity extends AppCompatActivity {

    private ProgressBar pb;
    private TextView tvOutput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gui_progress);
        pb = findViewById(R.id.pb);
        tvOutput = findViewById(R.id.tvOutput);
        LongOperation operation = new LongOperation();
        operation.execute("start");
    }


    private class LongOperation extends AsyncTask<String, Integer, String> {
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
            tvOutput.setText("Done!");
        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Integer... values) {
            int percentage = values[0];
            pb.setProgress(percentage, true);
        }
    }
}
