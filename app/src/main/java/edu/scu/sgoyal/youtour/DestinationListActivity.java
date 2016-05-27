package edu.scu.sgoyal.youtour;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

/**
 * Created by shubhamgoyal on 5/24/16.
 */

public class DestinationListActivity extends MenuActivity {
static List<Destination> destinations;
    public final static String POSITION_ID= "rama";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);

        destinations = Destination.getDestinations();
        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(new DestinationAdapter(this, R.layout.custom_row, destinations));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Destination d = Destination.getDestinations().get(position);
                Intent intent = new Intent(DestinationListActivity.this, ViewDestination.class);
                intent.putExtra("DESTINATION", d);
                startActivity(intent);

            }
        });


    }}

