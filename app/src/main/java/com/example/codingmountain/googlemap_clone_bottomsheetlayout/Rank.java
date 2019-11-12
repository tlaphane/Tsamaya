package com.example.codingmountain.googlemap_clone_bottomsheetlayout;

import android.support.annotation.NonNull;

import com.firebase.client.DataSnapshot;

import java.util.Comparator;

public class Rank implements Comparable {
    DataSnapshot snapShot;
    double distance;
    public Rank(DataSnapshot snapShot,double distance){
        this.distance=distance;
        this.snapShot=snapShot;
    }

    @Override
    public int compareTo(@NonNull Object o) {
        Rank other=(Rank)o;
        if(this.distance<other.distance)
            return  -1;

        else if(this.distance>other.distance)
            return 1;

        return 0;
    }
}
