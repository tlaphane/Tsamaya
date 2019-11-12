package com.example.codingmountain.googlemap_clone_bottomsheetlayout;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;

public class Routes extends AppCompatActivity {

    public Firebase mRef;
    public ArrayList<String> mRoutes = new ArrayList<>();
    public ArrayList<String> mRoutesd = new ArrayList<>();
    public ArrayList<String> mRoutesp = new ArrayList<>();
    public ListView mListView;

    private Button back;

    Dialog myDialog;

    String name,prices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routes);
        myDialog = new Dialog(this);

        Intent intent = getIntent();

        getSupportActionBar().setTitle("Routes");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        back = (Button) findViewById(R.id.back);



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Routes.this, ReportChanges.class);
                startActivity(intent);
            }
        });

        final String TaxiRank = intent.getStringExtra("Rank_name1");
        String url = "https://tsamaya-42805.firebaseio.com/Ranks/"+TaxiRank;
        System.out.println(url);

        mRef = new Firebase(url);

        mListView = (ListView) findViewById(R.id.listRoutes);

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mRoutes);

        mListView.setAdapter(arrayAdapter);

        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                name = dataSnapshot.getKey();
                prices = dataSnapshot.getValue(String.class);

                mRoutes.add(name+" - "+ prices);
                mRoutesd.add(name);
                mRoutesp.add(prices);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {}

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {}

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {}

            @Override
            public void onCancelled(FirebaseError firebaseError) {}
        });


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
//                Intent intent = new Intent(getApplicationContext(), ReportChanges.class);
//                Intent intent = new Intent(getApplicationContext(), Questionnaire.class);
//                intent.putExtra("Rank_name",mRoutes.get(i));
//                startActivity(intent);
                ShowPopup(view,TaxiRank,mRoutesd.get(i),mRoutesp.get(i));


            }
        });


    }

    public void ShowPopup(View v, String TaxiRank,String name,String prices) {
        TextView txtclose;
        final TextView belowThirty;
        final TextView withinHour;
        final TextView overHour;

        final TextView taxiPresent;
        final TextView taxiAbsent;

        final TextView waitingtime;
        final TextView waitTaxi;
        final TextView price;

        final TextView priceChanged;
        final TextView priceNotchanged;

        final TextView t,n,p;



        //   Button btnFollow;
        myDialog.setContentView(R.layout.custompopup);
        txtclose =(TextView) myDialog.findViewById(R.id.txtclose);
        txtclose.setText("x");

        t=(TextView)myDialog.findViewById(R.id.tazirank);
        t.setText(TaxiRank);

        n=(TextView)myDialog.findViewById(R.id.dest);
        n.setText(name);

        p=(TextView)myDialog.findViewById(R.id.prices);
        p.setText(prices);


        waitingtime=(TextView)myDialog.findViewById(R.id.waitingtime);
        waitTaxi=(TextView)myDialog.findViewById(R.id.waitTaxi);
        price=(TextView)myDialog.findViewById(R.id.price);

        belowThirty=(TextView)myDialog.findViewById(R.id.belowThirty);
        withinHour=(TextView)myDialog.findViewById(R.id.withinHour);
        overHour=(TextView)myDialog.findViewById(R.id.overHour);

        taxiPresent=(TextView)myDialog.findViewById(R.id.taxiPresent);
        taxiAbsent=(TextView)myDialog.findViewById(R.id.taxiAbsent);

        priceChanged=(TextView)myDialog.findViewById(R.id.priceChanged);
        priceNotchanged=(TextView)myDialog.findViewById(R.id.priceNotchanged);

        //bind onclick listeners

        belowThirty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ViewGroup)waitingtime.getParent()).removeView(waitingtime);
                ((ViewGroup) belowThirty.getParent()).removeView(belowThirty);
                ((ViewGroup) withinHour.getParent()).removeView(withinHour);
                ((ViewGroup) overHour.getParent()).removeView(overHour);

                Toast.makeText(getApplicationContext(),"less than 30",Toast.LENGTH_SHORT).show();

            }
        });
        withinHour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((ViewGroup)waitingtime.getParent()).removeView(waitingtime);
                ((ViewGroup) belowThirty.getParent()).removeView(belowThirty);
                ((ViewGroup) withinHour.getParent()).removeView(withinHour);
                ((ViewGroup) overHour.getParent()).removeView(overHour);

                Toast.makeText(getApplicationContext(),"within 1 hour",Toast.LENGTH_SHORT).show();
            }
        });
        overHour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ViewGroup)waitingtime.getParent()).removeView(waitingtime);
                ((ViewGroup) belowThirty.getParent()).removeView(belowThirty);
                ((ViewGroup) withinHour.getParent()).removeView(withinHour);
                ((ViewGroup) overHour.getParent()).removeView(overHour);

                Toast.makeText(getApplicationContext(),"Over an hour",Toast.LENGTH_SHORT).show();
            }
        });

        taxiPresent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ViewGroup)waitTaxi.getParent()).removeView(waitTaxi);
                ((ViewGroup) taxiPresent.getParent()).removeView(taxiPresent);
                ((ViewGroup) taxiAbsent.getParent()).removeView(taxiAbsent);

                Toast.makeText(getApplicationContext(),"Yes",Toast.LENGTH_SHORT).show();
            }
        });
        taxiAbsent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((ViewGroup)waitTaxi.getParent()).removeView(waitTaxi);
                ((ViewGroup) taxiPresent.getParent()).removeView(taxiPresent);
                ((ViewGroup) taxiAbsent.getParent()).removeView(taxiAbsent);

                Toast.makeText(getApplicationContext(),"No",Toast.LENGTH_SHORT).show();
            }
        });

        priceChanged.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ViewGroup)price.getParent()).removeView(price);
                ((ViewGroup) priceChanged.getParent()).removeView(priceChanged);
                ((ViewGroup) priceNotchanged.getParent()).removeView(priceNotchanged);

                Toast.makeText(getApplicationContext(),"No",Toast.LENGTH_SHORT).show();
            }
        });
        priceNotchanged.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ViewGroup)price.getParent()).removeView(price);
                ((ViewGroup) priceChanged.getParent()).removeView(priceChanged);
                ((ViewGroup) priceNotchanged.getParent()).removeView(priceNotchanged);

                Toast.makeText(getApplicationContext(),"Yes",Toast.LENGTH_SHORT).show();
            }
        });

//        btnFollow = (Button) myDialog.findViewById(R.id.btnfollow);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();

    }
}
