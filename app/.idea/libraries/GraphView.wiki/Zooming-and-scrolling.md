# Zooming and scrolling graph

With GraphView is is easy to create a chart for Android, where the user can zoom in/out and scroll via touch gestures. GraphView supports horizontal and vertical zooming and scrolling.

All you need to do is set a fixed manual viewport and enable the scaling and/or scrolling.  Of course you need a graph with enough data.

Here are the lines to activate the scaling and scrolling:


```java
        // first series is a line
        DataPoint[] points = new DataPoint[100];
        for (int i = 0; i < points.length; i++) {
            points[i] = new DataPoint(i, Math.sin(i*0.5) * 20*(Math.random()*10+1));
        }
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(points);

        // set manual X bounds
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(-150);
        graph.getViewport().setMaxY(150);

        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(4);
        graph.getViewport().setMaxX(80);

        // enable scaling and scrolling
        graph.getViewport().setScalable(true);
        graph.getViewport().setScalableY(true);

        graph.addSeries(series);
```

So enable/disable only the scrolling and not the zooming, you can use this methods: 

```java
graph.getViewport().setScrollable(true); // enables horizontal scrolling
graph.getViewport().setScrollableY(true); // enables vertical scrolling
graph.getViewport().setScalable(true); // enables horizontal zooming and scrolling
graph.getViewport().setScalableY(true); // enables vertical zooming and scrolling
```
