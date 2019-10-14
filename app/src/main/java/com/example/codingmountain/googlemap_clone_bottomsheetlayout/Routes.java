package com.example.codingmountain.googlemap_clone_bottomsheetlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;

public class Routes extends AppCompatActivity {

    public Firebase mRef;
    public ArrayList<String> mRoutes = new ArrayList<>();
    public ListView mListView;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routes);

        Intent intent = getIntent();

//        button = (Button) findViewById(R.id.reports);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Routes.this, ReportChanges.class);
//                startActivity(intent);
//            }
//        });

        String TaxiRank = intent.getStringExtra("Rank_name");
        String url = "https://tsamaya-42805.firebaseio.com/Ranks/"+TaxiRank;
        mRef = new Firebase(url);

        mListView = (ListView) findViewById(R.id.listRoutes);

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mRoutes);

        mListView.setAdapter(arrayAdapter);

        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String name = dataSnapshot.getKey();
                String price = dataSnapshot.getValue(String.class);

                mRoutes.add(name+" - "+ price);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), ReportChanges.class);
                intent.putExtra("Rank_name",mRoutes.get(i));
                startActivity(intent);
            }
        });


    }
}
