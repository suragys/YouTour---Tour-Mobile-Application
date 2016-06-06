package edu.scu.sgoyal.youtour;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Rating extends MenuActivity
{

    EditText comment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        Intent intent = getIntent();
        final Destination d = (Destination) intent.getExtras().get("DESTINATION");
        Log.i(this.getClass().getName(), "============= coming to rating  "+d.getName());

        comment = (EditText) findViewById(R.id.commentEditText);

        Button submitComment = (Button) findViewById(R.id.submitComment);

        submitComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i(this.getClass().getName(), "============= On click  ");

                String newComment = comment.getText().toString();

                d.getComments().add(newComment);
                int index = Destination.getDestinations().indexOf(Destination.getDestinationBasedOnName(d.getName()));
                Log.i("Index of Sdsfai", "=============INdex = "+ index + d.getName());

                MapsActivity.myFirebaseRef.child(String.valueOf(index))
                        .child("comments").setValue(d.getComments());

                Intent i = new Intent(Rating.this.getApplicationContext(), MapsActivity.class);
//                Intent i = new Intent(appContext, ViewDestinationDetailActivity.class);
                startActivity(i);






            }
        });

    }
}
