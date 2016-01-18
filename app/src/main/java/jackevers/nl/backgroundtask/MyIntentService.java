package jackevers.nl.backgroundtask;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import android.app.IntentService;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

import java.math.BigInteger;

public class MyIntentService extends IntentService implements SensorEventListener{
    public MyIntentService() {
        super("MyIntentService");
    }

    private SensorManager mSensorManager;
    private Sensor mSensor;

    protected void onHandleIntent(Intent intent) {

        for (int i = 0; i < 10; i++) {


            Helper.setAppState(0, getApplicationContext());

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // starting of state 1. factorial calculation
            Helper.setAppState(1, getApplicationContext());

            // algoritm to calculate factorial from: http://www.programmingsimplified.com/java/source-code/java-program-find-factorial
            int n, c;
            BigInteger inc = new BigInteger("1");
            BigInteger fact = new BigInteger("1");

            System.out.println("Input an integer");

            n = 20_000;

            for (c = 1; c <= n; c++) {
                fact = fact.multiply(inc);
                inc = inc.add(BigInteger.ONE);
            }

            Log.d("service", "factorial of " + n + " is " + fact);

            //end of calculations

            Helper.setAppState(0, getApplicationContext());

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //start of sensors

            Helper.setAppState(4, getApplicationContext());

            mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
            mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

            mSensorManager.registerListener(this, mSensor, 100);

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            mSensorManager.unregisterListener(this);

        }

        Intent it = new Intent(this, LocationServiceActivity.class);
        it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(it);
    }

    private long lastUpdate = 0;

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor mySensor = event.sensor;

        if (mySensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            long curTime = System.currentTimeMillis();

            if ((curTime - lastUpdate) > 100) {
                long diffTime = (curTime - lastUpdate);
                lastUpdate = curTime;
            }
        }

        Log.d("sensorChanged", event.toString());
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}