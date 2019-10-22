# Tap Listener on Data Points

It is possible to add a tap listener, that will be called if the user taps on a single data point. You have to add the listener to the series object. So if you have multiple series, you can use specific tap handler for any series.

Here is an example: 

```java
series.setOnDataPointTapListener(new OnDataPointTapListener() {
    @Override
    public void onTap(Series series, DataPointInterface dataPoint) {
        Toast.makeText(getActivity(), "Series1: On Data Point clicked: "+dataPoint, Toast.LENGTH_SHORT).show();
    }
});
```

Notice:

* If there is overlapping data because of multiple series, multiple listeners can be called due a single tap.
* The tap listener works also for bar charts

![example](https://raw.githubusercontent.com/jjoe64/GraphView/master/doc-assets/6316193_orig_1.png)
