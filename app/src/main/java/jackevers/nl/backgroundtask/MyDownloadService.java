package jackevers.nl.backgroundtask;

import android.app.DownloadManager;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by jack on 18-1-2016.
 */
public class MyDownloadService extends IntentService {


    public MyDownloadService() {
        super("MyDownloadService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        for(int i = 1; i <= 7; i++)
        {
            Helper.setAppState(0, getApplicationContext());


            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Helper.setAppState(9, getApplicationContext());


            String file_url = "http://tostring.nl/picture" + i + ".jpg";

            downloadFile(file_url);


            Helper.setAppState(0, getApplicationContext());
        }
    }


    //method: http://stackoverflow.com/questions/15758856/android-how-to-download-file-from-webserver
    // stream to byte array from: http://stackoverflow.com/questions/1264709/convert-inputstream-to-byte-array-in-java
    void downloadFile(String _url) {
        try {
            URL u = new URL(_url);
            DataInputStream stream = new DataInputStream(u.openStream());

            ByteArrayOutputStream buffer = new ByteArrayOutputStream();

            int nRead;
            byte[] data = new byte[16384];

            while ((nRead = stream.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }

            buffer.flush();

            byte[] byteArray = buffer.toByteArray();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
}
