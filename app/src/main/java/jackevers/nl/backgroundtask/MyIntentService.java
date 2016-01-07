package jackevers.nl.backgroundtask;

import android.app.IntentService;
import android.content.Intent;

import android.app.IntentService;
import android.content.Intent;

public class MyIntentService extends IntentService {
    public MyIntentService() {
        super("MyIntentService");
    }

    protected void onHandleIntent(Intent intent) {

        while (true) {
            Intent stateUpdate = new Intent("com.quicinc.Trepn.UpdateAppState");
            stateUpdate.putExtra("com.quicinc.Trepn.UpdateAppState.Value", 1);
            sendBroadcast(stateUpdate);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Intent stateUpdate2 = new Intent("com.quicinc.Trepn.UpdateAppState");
            stateUpdate2.putExtra("com.quicinc.Trepn.UpdateAppState.Value", 2);
            sendBroadcast(stateUpdate2);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}