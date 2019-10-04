package com.example.codingmountain.googlemap_clone_bottomsheetlayout;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.hsalf.smilerating.SmileRating;

public class RatingActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ratings);

        SmileRating smileRating = (SmileRating) findViewById(R.id.smile_rating);
        smileRating.setOnSmileySelectionListener(new SmileRating.OnSmileySelectionListener() {
            @Override
            public void onSmileySelected(int smiley, boolean reselected) {

                switch (smiley) {
                    case SmileRating.BAD:
                        Toast.makeText(RatingActivity.this, "BAD", Toast.LENGTH_SHORT).show();
                        break;
                    case SmileRating.GOOD:
                        Toast.makeText(RatingActivity.this, "GOOD", Toast.LENGTH_SHORT).show();
                        ;
                        break;
                    case SmileRating.GREAT:
                        Toast.makeText(RatingActivity.this, "GREAT", Toast.LENGTH_SHORT).show();
                        break;
                    case SmileRating.OKAY:
                        Toast.makeText(RatingActivity.this, "OKAY", Toast.LENGTH_SHORT).show();
                        break;
                    case SmileRating.TERRIBLE:
                        Toast.makeText(RatingActivity.this, "TERRIBLE", Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });
        smileRating.setOnRatingSelectedListener(new SmileRating.OnRatingSelectedListener() {
            @Override
            public void onRatingSelected(int level, boolean reselected) {
                Toast.makeText(RatingActivity.this,"Selected rating"+level, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
