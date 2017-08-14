package br.ufrn.eaj.tads.exemploloop;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Boolean running = true;
    int count = 0;
    TextView tv ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.texto);

        startTimerThread();
    }

    private void startTimerThread() {

        final Handler handler = new Handler();

        new Thread (new Runnable() {
            public void run() {
                while (running) {
                    try {
                        Thread.sleep(250);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.post(new Runnable(){
                        public void run() {
                            tv.setText(""+count);
                            count++;
                        }
                    });
                }
            }
        }).start();
    }

}
