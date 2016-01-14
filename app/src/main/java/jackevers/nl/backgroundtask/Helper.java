package jackevers.nl.backgroundtask;

import android.content.Context;
import android.content.Intent;

/**
 * Created by jack on 14-1-2016.
 */
public class Helper {

    public static void setAppState(int i, Context context)
    {
        Intent stateUpdate = new Intent("com.quicinc.Trepn.UpdateAppState");
        stateUpdate.putExtra("com.quicinc.Trepn.UpdateAppState.Value", i);
        context.sendBroadcast(stateUpdate);
    }
}
