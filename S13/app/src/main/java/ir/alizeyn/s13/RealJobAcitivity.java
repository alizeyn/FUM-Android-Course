package ir.alizeyn.s13;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class RealJobAcitivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 101;
    private TextView tvTitle;
    private ProgressBar pb;
    private TextView tvDlFileDetails;
    private EditText etLink;
    private Button bDownload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_job_acitivity);
        checkRuntimePermissions();
        tvTitle = findViewById(R.id.tvTitle);
        pb = findViewById(R.id.pb);
        bDownload = findViewById(R.id.bDownload);
        etLink = findViewById(R.id.etLink);
        tvDlFileDetails = findViewById(R.id.tvDlFileDetails);

        setFont();

    }


    private boolean checkRuntimePermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED
                    &&
                    ContextCompat.checkSelfPermission(this,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE)
                            != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        PERMISSION_REQUEST_CODE);
                return false;
            }
        }
        return true;
    }

    public void setFont() {
        Typeface typeface = Typeface.createFromAsset(getResources().getAssets(), "irsans.ttf");
        tvTitle.setTypeface(typeface);
    }

    public void back(View view) {
        onBackPressed();
    }

    public void download(View view) {

        DownlaodTask downlaodTask = new DownlaodTask();
        downlaodTask.execute(etLink.getText().toString());
    }

    class DownlaodTask extends AsyncTask<String, Integer, String> {

        @Override
        protected void onPreExecute() {
            tvTitle.setText("در حال دانلود ...");
        }

        @Override
        protected String doInBackground(String... strings) {
            int count;
            try {
                String root = Environment.getExternalStorageDirectory().toString();

                System.out.println("Downloading");
                URL url = new URL(strings[0]);

                URLConnection conection = url.openConnection();
                conection.connect();
                // getting file

                int lenghtOfFile = conection.getContentLength();
                InputStream input = new BufferedInputStream(url.openStream());

                // Output stream to write file

                OutputStream output = new FileOutputStream(root+"/downloadedfile");
                byte data[] = new byte[1024];

                long total = 0;

                while ((count = input.read(data)) != -1) {
                    total += count;

                    // writing data to file
                    output.write(data, 0, count);
                    publishProgress((int)((total * 100 /lenghtOfFile)));
                    Log.i("REAL_JOB", "doInBackground: p " + ((total * 100/lenghtOfFile)));
                    Log.i("REAL_JOB", "doInBackground: size " + (lenghtOfFile));
                    Log.i("REAL_JOB", "doInBackground: count " + (count));

                }

                publishProgress(100);
                // flushing output
                output.flush();

                // closing streams
                output.close();
                input.close();

            } catch (Exception e) {
                Log.e("Error: ", e.getMessage());
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            pb.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            tvTitle.setText("دانلود انجام شد.");
        }
    }
}
