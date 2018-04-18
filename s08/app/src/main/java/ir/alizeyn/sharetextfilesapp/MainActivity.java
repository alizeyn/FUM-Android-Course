package ir.alizeyn.sharetextfilesapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 120;
    /**
     * pro tips :
     * Butter Knife
     * Gradle properties
     * <p>
     * Reminder :
     * Activity
     * Bundle
     * Life Cycle
     * <p>
     * <p>
     * This Session :
     * Intent
     * docs : https://developer.android.com/reference/android/content/Intent.html
     * <p>
     * Explicit Intents have specified a component (via setComponent(ComponentName) or setClass(Context, Class)),
     * which provides the exact class to be run. Often these will not include any other information, simply being a way for an application to launch various internal activities it has as the user interacts with the application.
     * <p>
     * Implicit Intents have not specified a component; instead, they must include enough information for the system to
     * determine which of the available components is best to run for that intent.
     * <p>
     * <p>
     * <p>
     * Permissions
     * docs : https://developer.android.com/guide/topics/permissions/overview.html#normal-dangerous
     * stackoverflow list  : https://stackoverflow.com/a/36937109/5629011
     * request permission : https://developer.android.com/training/permissions/requesting.html#java
     */


    private View vShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vShare = findViewById(R.id.vShare);

        vShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkRuntimePermissions())
                    goToShareActivity();
            }
        });
    }

    private void goToShareActivity() {
        Intent intent = new Intent(MainActivity.this, ShareActivity.class);
        startActivity(intent);
    }


    private boolean checkRuntimePermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    Toast.makeText(this, "We need read Permission and you are not giving :)", Toast.LENGTH_SHORT).show();
                } else {
                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                            PERMISSION_REQUEST_CODE);
                }
                return false;
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                goToShareActivity();
            } else {
                Toast.makeText(this, "You need to grant permission :)", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
