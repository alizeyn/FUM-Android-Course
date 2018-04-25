package ir.alizeyn.s10;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "S10";
    private RegisterHelper registerHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerHelper = RegisterHelper.getInstance(getBaseContext());
        if (!registerHelper.isRegistered()) {
            Intent intent = new Intent(this, RegisterActivity.class);
            /**
             * explain back stack and tasks
             */
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivityForResult(intent, 101);
        } else {
            sayHi();
        }

    }

    public void sayHi() {
        TextView name = findViewById(R.id.tvName);
        String username = registerHelper.getUserName();
        name.setText("Hi " + username);
    }

    public void notifHi() {
        Intent actionIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://medium.com/"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, actionIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        long[] pattern = {500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500};
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_action_heart)
                .setContentTitle("Learning is Great")
                .setContentText("Because You Love Learning You Can Go To this site and watch some information.")
                .setColor(ContextCompat.getColor(this, R.color.colorAccent))
                .setContentIntent(pendingIntent)
                .setStyle(new NotificationCompat.BigTextStyle())
                .setVibrate(pattern)
                .setDefaults(Notification.DEFAULT_SOUND)
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1, builder.build());
    }

    public void talk(View view) {
        notifHi();
    }
}
