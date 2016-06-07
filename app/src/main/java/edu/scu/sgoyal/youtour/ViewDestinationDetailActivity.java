package edu.scu.sgoyal.youtour;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

;

public class ViewDestinationDetailActivity extends MenuActivity
{

    private static final int RECOVERY_REQUEST = 1;
    private String destinationName;
    private  Destination d;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        Intent intent = getIntent();
        destinationName = (String) intent.getExtras().get("DESTINATION");
        d = Destination.getDestinationBasedOnName(destinationName);

        final TextView textView = (TextView) findViewById(R.id.textView);

        Log.i(this.getClass().getName(), "Destination = " + d.toString());
        textView.setText(d.getName());

        final TextView textView2= (TextView) findViewById(R.id.textView1);

        textView2.setText(d.getDescription());
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setVisibility(View.VISIBLE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                takePicture();

                Intent view360 = new Intent(ViewDestinationDetailActivity.this,View360Activity.class);
                startActivity(view360);
            }
        });
        final Button button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {

                                          Intent in = new Intent(ViewDestinationDetailActivity.this, Rating.class);
                                          in.putExtra("DESTINATION" , d );
                                          startActivity(in);
                                      }
                                  }
        );

        YouTubeFragment fragment = new YouTubeFragment(d);
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.main, fragment)
                .addToBackStack(null)
                .commit();


//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });




    }




}
