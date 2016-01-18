package jackevers.nl.backgroundtask;

import android.app.DownloadManager;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by jack on 18-1-2016.
 */
public class MyDownloadService extends IntentService {

    private String file_url = "http://tostring.nl/picture.jpg";

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MyDownloadService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        for(int i = 0; i < 10; i++)
        {
            Helper.setAppState(0, getApplicationContext());

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Helper.setAppState(9, getApplicationContext());

            DownloadManager dlm = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);

            Uri uri = Uri.parse(file_url);

            dlm.enqueue(new DownloadManager.Request(uri));


            Helper.setAppState(0, getApplicationContext());
        }
    }
}
