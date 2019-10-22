# Summary and Features

GraphView is a library for Android to programmatically create
flexible and nice-looking diagrams.
It is **easy** to understand, to integrate and to customize.
Create Line Graphs, Bar Graphs, Point Graphs
or implement your own custom types.

 XML Layout file:

```xml
<com.jjoe64.graphview.GraphView
        android:layout_width="match_parent"
        android:layout_height="200dip"
        android:id="@+id/graph" />
```

Java code: 

```java
GraphView graph = (GraphView) findViewById(R.id.graph);
LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
          new DataPoint(0, 1),
          new DataPoint(1, 5),
          new DataPoint(2, 3)
});
graph.addSeries(series);
```

## Key Features

* Different plotting types

  Line Chart, Bar Chart and Points Chart
  and they can be plotted together as a combination. [[learn more|Mix up chart types]]

* Draw multiple series of data

  Let the diagram show more that one series in a graph. You can set a color and a description for every series. [[learn more|Mix up chart types]]

* Realtime / Live Chart

  Append new data live or reset the whole data. [[learn more|Realtime chart]]

* Secondary Scale [[learn more|Secondary scale axis]]
* Tap Listener

  Handle tap events on specific data points. [[learn more|Tap listener on data]]

* Show legend

  A legend can be displayed inline the chart. You can set the width and the vertical align (top, middle, bottom). [[learn more|Legend]]

* Custom label formatter

  The labels for the x- and y-axis are generated automatically. But you can set your own labels, Strings are possible. [[learn more|Labels and label formatter]]

* Handle incomplete data

  It's possible to give the data in different frequency.

* Viewport

  You can limit the viewport so that only a part of the data will be displayed. [[learn more|Basics of GraphView]]

* Scrolling and Scaling / Zooming

  You can scroll with a finger touch move gesture.
  With two-fingers touch scale gesture (Multi-touch), the viewport can be changed. [[learn more|Zooming and scrolling]]

* XML Integration [[learn more|Create graph via XML]]

* Optional Axis Titles

  Set vertical and horizontal axis titles. [[learn more|Style options]]

* Many Styles

  change the color and thickness, label font size/color and more [[learn more|Style options]]

* Very customizable

  There are many hooks to use in order to do custom rendering or changing the paint objects. [[learn more|Style options]]

* Take snapshots and share [[learn more|Take snapshots]]

* .. and many more

* Take a look at the [[GraphView-Demo|https://play.google.com/store/apps/details?id=com.jjoe64.graphview_demos]] project.
