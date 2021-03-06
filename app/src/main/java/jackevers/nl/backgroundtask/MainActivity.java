package jackevers.nl.backgroundtask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent i = new Intent(this, MyIntentService.class);
//        startService(i);


//        Intent it = new Intent(this, LocationServiceActivity.class);
//        startActivity(it);

        Log.i(TAG, "intent creation");
        Intent intent = new Intent(this, MyDownloadService.class);
        startService(intent);
        Log.i(TAG, "intent started");
    }
}
