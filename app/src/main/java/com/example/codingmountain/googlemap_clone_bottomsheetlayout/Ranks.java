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

import java.util.ArrayList;
import java.util.TooManyListenersException;

public class Ranks extends AppCompatActivity {

    public Firebase mRef;
    public ArrayList<String> mUsernames = new ArrayList<>();
    public ListView mListView;
    private Button back;

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


        mRef = new Firebase("https://tsamaya-42805.firebaseio.com/Ranks");

        mListView = (ListView) findViewById(R.id.listView);

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mUsernames);

        mListView.setAdapter(arrayAdapter);

        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value = dataSnapshot.getKey();
                //dataSnapshot.get
                mUsernames.add(value);
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
                Intent intent = new Intent(getApplicationContext(), Routes.class);
                intent.putExtra("Rank_name",mUsernames.get(i));
                startActivity(intent);
            }
        });




    }
}
