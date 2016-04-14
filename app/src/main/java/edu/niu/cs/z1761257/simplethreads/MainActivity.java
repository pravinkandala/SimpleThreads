package edu.niu.cs.z1761257.simplethreads;

import android.app.Activity;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import android.os.Handler;
import java.util.logging.LogRecord;

public class MainActivity extends Activity {

    private TextView countTV;
    private Integer counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counter = 0;

        countTV = (TextView)findViewById(R.id.counterTextView);

        Thread thread = new Thread(countRunnable);

        thread.start();


    }//end of onCreate

    @Override
    protected void onStart() {

        super.onStart();

        counter = 0;

    }//end of onStart


    private Runnable countRunnable = new Runnable() {
        @Override
        public void run() {

            while(true){
                counter++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                threadHandler.sendEmptyMessage(0);
            }

        }
    };//end of countRunnable


    public Handler threadHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
         //   super.handleMessage(msg);
            countTV.setText(counter.toString());
        }
    };//end of threadHandler


}//end of MainActivity
