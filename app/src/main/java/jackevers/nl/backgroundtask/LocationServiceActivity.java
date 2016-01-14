package jackevers.nl.backgroundtask;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class LocationServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        //

        stopService(new Intent(this, MyIntentService.class));

        Helper.setAppState(0, getApplicationContext());

        Intent j = new Intent(this, MyLocationService.class);
        startService(j);

//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        stopService(j);

        Helper.setAppState(0, getApplicationContext());
    }

}
