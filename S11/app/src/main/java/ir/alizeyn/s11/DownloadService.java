package ir.alizeyn.s11;

import android.app.IntentService;
import android.content.Intent;
import android.os.Environment;
import android.support.annotation.Nullable;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 * Created by Ali Zeynali on 5/6/2018.
 */

public class DownloadService extends IntentService {

    public DownloadService() {
        super("DownloadService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        startDownloadProcess();
    }

    private void startDownloadProcess() {

        String root = Environment.getExternalStorageDirectory().toString();
        try {
            String addr = "http://um.ac.ir/themes/FumNewTheme/images/ferdowsi-img.png";
            String[] addrArr = addr.split("/");
            String fileName = addrArr[addrArr.length -1];

            File file = new File(root + "/Download/" + fileName);
            URL url = new URL(addr);
            InputStream in = new BufferedInputStream(url.openStream());
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int n;
            while (-1 != (n = in.read(buf))) {
                out.write(buf, 0, n);
            }
            out.flush();
            out.close();
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
