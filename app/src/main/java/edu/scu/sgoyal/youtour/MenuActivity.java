package edu.scu.sgoyal.youtour;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by shubhamgoyal on 5/24/16.
 */

public class MenuActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Santa Clara tour");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setIcon(R.mipmap.ic_launcher);



    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Uninstall:
                Uri packageURI = Uri.parse("package:" + ViewDestination.class.getPackage().getName());
                Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI);
                startActivity(uninstallIntent);
                break;
            case android.R.id.home:
                finish();
                break;
            case R.id.survey:
                Intent survey = new Intent(MenuActivity.this,Survey.class);
                startActivity(survey);
                break;
            case R.id.faq:
                Intent faq = new Intent(MenuActivity.this,Faq.class);
                startActivity(faq);
                break;
            case R.id.rating:
                Intent rating = new Intent(MenuActivity.this,Rating.class);
                startActivity(rating);
                break;
            case R.id.view360:
                Intent view360 = new Intent(MenuActivity.this,View360Activity.class);
                startActivity(view360);
                break;
//            case R.id.gallery:
//                Intent gallery = new Intent(MenuActivity.this,Gallery.class);
//                startActivity(gallery);
//                break;
        }

        return super.onOptionsItemSelected(item);
    }


}
