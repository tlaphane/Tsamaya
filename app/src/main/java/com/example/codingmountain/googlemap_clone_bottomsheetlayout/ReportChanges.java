package com.example.codingmountain.googlemap_clone_bottomsheetlayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ReportChanges extends Activity implements View.OnClickListener {

    RatingBar ratingBar;
    LinearLayout master;
    //Button button;
    //clicikable textviews
    TextView belowThirty;
    TextView withinHour;
    TextView overHour;

    TextView taxiPresent;
    TextView taxiAbsent;

    TextView waitingtime;
    TextView waitTaxi;
    TextView price;

    TextView priceChanged;
    TextView priceNotchanged;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reports);
        master=(LinearLayout)findViewById(R.id.master);
        //map textviews to id

        waitingtime=(TextView)findViewById(R.id.waitingtime);
        waitTaxi=(TextView)findViewById(R.id.waitTaxi);
        price=(TextView)findViewById(R.id.price);

        belowThirty=(TextView)findViewById(R.id.belowThirty);
        withinHour=(TextView)findViewById(R.id.withinHour);
        overHour=(TextView)findViewById(R.id.overHour);

        taxiPresent=(TextView)findViewById(R.id.taxiPresent);
        taxiAbsent=(TextView)findViewById(R.id.taxiAbsent);

        priceChanged=(TextView)findViewById(R.id.priceChanged);
        priceNotchanged=(TextView)findViewById(R.id.priceNotchanged);

        //bind onclick listeners
        waitingtime.setOnClickListener(this);
        waitTaxi.setOnClickListener(this);
        price.setOnClickListener(this);

        belowThirty.setOnClickListener(this);
        withinHour.setOnClickListener(this);
        overHour.setOnClickListener(this);

        taxiPresent.setOnClickListener(this);
        taxiAbsent.setOnClickListener(this);

        priceChanged.setOnClickListener(this);
        priceNotchanged.setOnClickListener(this);

        /*ratingBar = (RatingBar) findViewById(R.id.ratingBar);
       //button =(Button) findViewById(R.id.reports);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(ReportChanges.this,"Stars"+rating,Toast.LENGTH_SHORT).show();
            }
        });*/

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(ReportChanges.this,"Stars", Toast.LENGTH_SHORT).show();
//            }
//        });
    }


    @Override
    public void onClick(View view) {
        /* do stuff send info to database depending on click*/

        //reliability
        if(view.equals(belowThirty)){
            ((ViewGroup)waitingtime.getParent()).removeView(waitingtime);
            ((ViewGroup) belowThirty.getParent()).removeView(belowThirty);
            ((ViewGroup) withinHour.getParent()).removeView(withinHour);
            ((ViewGroup) overHour.getParent()).removeView(overHour);

//            ((ViewGroup) taxiPresent.getParent()).removeView(taxiPresent);
//            ((ViewGroup) taxiAbsent.getParent()).removeView(taxiAbsent);

            Toast.makeText(getApplicationContext(),"less than 30",Toast.LENGTH_SHORT).show();
        }

        else if(view.equals(withinHour)){
            ((ViewGroup)waitingtime.getParent()).removeView(waitingtime);
            ((ViewGroup) belowThirty.getParent()).removeView(belowThirty);
            ((ViewGroup) withinHour.getParent()).removeView(withinHour);
            ((ViewGroup) overHour.getParent()).removeView(overHour);

            Toast.makeText(getApplicationContext(),"within 1 hour",Toast.LENGTH_SHORT).show();
        }

        else if(view.equals(overHour)){
            ((ViewGroup)waitingtime.getParent()).removeView(waitingtime);
            ((ViewGroup) belowThirty.getParent()).removeView(belowThirty);
            ((ViewGroup) withinHour.getParent()).removeView(withinHour);
            ((ViewGroup) overHour.getParent()).removeView(overHour);

            Toast.makeText(getApplicationContext(),"Over an hour",Toast.LENGTH_SHORT).show();
        }
        //taxi reliability
        else if(view.equals(taxiPresent)){
            ((ViewGroup)waitTaxi.getParent()).removeView(waitTaxi);
            ((ViewGroup) taxiPresent.getParent()).removeView(taxiPresent);
            ((ViewGroup) taxiAbsent.getParent()).removeView(taxiAbsent);

            Toast.makeText(getApplicationContext(),"Yes",Toast.LENGTH_SHORT).show();

        }
        else if(view.equals(taxiAbsent)){
            ((ViewGroup)waitTaxi.getParent()).removeView(waitTaxi);
            ((ViewGroup) taxiPresent.getParent()).removeView(taxiPresent);
            ((ViewGroup) taxiAbsent.getParent()).removeView(taxiAbsent);

            Toast.makeText(getApplicationContext(),"No",Toast.LENGTH_SHORT).show();

        }
        //taxi fees
        else if(view.equals(priceChanged)){
            ((ViewGroup)price.getParent()).removeView(price);
            ((ViewGroup) priceChanged.getParent()).removeView(priceChanged);
            ((ViewGroup) priceNotchanged.getParent()).removeView(priceNotchanged);

            Toast.makeText(getApplicationContext(),"Yes",Toast.LENGTH_SHORT).show();

        }
        else if(view.equals(priceNotchanged)){
            ((ViewGroup)price.getParent()).removeView(price);
            ((ViewGroup) priceChanged.getParent()).removeView(priceChanged);
            ((ViewGroup) priceNotchanged.getParent()).removeView(priceNotchanged);

            Toast.makeText(getApplicationContext(),"No",Toast.LENGTH_SHORT).show();

        }
    }
}
