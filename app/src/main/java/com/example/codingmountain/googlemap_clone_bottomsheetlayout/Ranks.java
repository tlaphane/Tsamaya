package com.example.codingmountain.googlemap_clone_bottomsheetlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TooManyListenersException;

public class Ranks extends AppCompatActivity {

    public Firebase mRef;
    public ArrayList<String> mUsernames = new ArrayList<>();
    public ArrayList<String> mUsernames1 = new ArrayList<>();
    public ArrayList<Double> dist= new ArrayList<>();
    public double lat1,lon1;
    public double d;
//    Bundle b = getIntent().getExtras();
    public double latitude,longitude;
    public ListView mListView;
    private Button back;
    public String value;
    public int count;
    PriorityQueue<Rank>closestRank;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranks);

        getSupportActionBar().setTitle("Ranks");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        back = (Button) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ranks.this, MapsActivity.class);
            }
        });
        closestRank=new PriorityQueue<>();

        mRef = new Firebase("https://tsamaya-42805.firebaseio.com/Ranks");

        mListView = (ListView) findViewById(R.id.listView);

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mUsernames);
        final ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mUsernames1);


        mListView.setAdapter(arrayAdapter);

        count = 0;
        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                value = dataSnapshot.getKey();

//                latitude = b.getDouble("latitude");
//                longitude = b.getDouble("longitude");

                latitude =-26.192900;
                longitude= 28.030564;

                if(value.contains("Bara")){
                    lat1=-26.2599;
                    lon1=27.9424;
                }
                else if(value.contains("Bree")){
                    lat1=-26.2014;
                    lon1=28.0375;
                }
                else if(value.contains("Rosebank")){
                    lat1=-26.1428;
                    lon1=28.0416;
                }
                else if(value.contains("Alexandra")){
                    lat1=-26.1057;
                    lon1=28.1016;
                }
                else if(value.contains("Noord")){
                    lat1=-26.1994;
                    lon1=28.0471;
                }


               d = distance(lat1,lon1,latitude,longitude,"K");

                Map<Double, String> distloc = new HashMap<Double, String>()
                {
                    {
                        put(d, value);
                    }
                };

                closestRank.add(new Rank(dataSnapshot,d));

//                for(Rank r:closestRank){
//                    System.out.println(r.snapShot.getKey()+" distance in km "+r.distance);
//
                //dataSnapshot.get
//                Rank sa=closestRank.poll();
//                if(sa!=null)
//                    System.out.println(sa.snapShot.getKey()+" distance in km "+sa.distance);

                //mUsernames.add(value);
                //arrayAdapter.notifyDataSetChanged();

                count++;


                if(count >= dataSnapshot.getChildrenCount()) {
                    for (int i = 0; i < dataSnapshot.getChildrenCount(); i++) {
                        Rank sa = closestRank.remove();
                        if (sa != null) {
//                            Toast.makeText(getApplicationContext(), sa.snapShot.getKey() + " distance in km " + sa.distance, Toast.LENGTH_LONG).show();
                            mUsernames.add(sa.snapShot.getKey() + " distance in km " + sa.distance);
                            mUsernames1.add(sa.snapShot.getKey());


                            arrayAdapter.notifyDataSetChanged();
                            arrayAdapter1.notifyDataSetChanged();
                        }
                    }
                }

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
                Rank sa=closestRank.peek();
                if(sa!=null)
                     Toast.makeText(getApplicationContext(),sa.snapShot.getKey()+" distance in km "+sa.distance,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), Routes.class);
                intent.putExtra("Rank_name",mUsernames.get(i));
                intent.putExtra("Rank_name1",mUsernames1.get(i));
                startActivity(intent);
            }
        });




    }


    private static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
        if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0;
        }
        else {
            double theta = lon1 - lon2;
            double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
            if (unit == "K") {
                dist = dist * 1.609344;
            } else if (unit == "N") {
                dist = dist * 0.8684;
            }
            return (dist);
        }
    }
}
