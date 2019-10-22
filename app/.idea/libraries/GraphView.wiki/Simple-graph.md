# How to create a simple Graph

## Create a line graph from Java

This is the recommended way use GraphView: Create a GraphView element in the XML layout file and do the initialization in the Java code.

XML Layout file:

```xml
<com.jjoe64.graphview.GraphView
        android:layout_width="match_parent"
        android:layout_height="200dip"
        android:id="@+id/graph" />
```

Initialize the GraphView with a series and some data: 

```java
GraphView graph = (GraphView) findViewById(R.id.graph);
LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
          new DataPoint(0, 1),
          new DataPoint(1, 5),
          new DataPoint(2, 3),
          new DataPoint(3, 2),
          new DataPoint(4, 6)
});
graph.addSeries(series);
```

![example chart](https://raw.githubusercontent.com/jjoe64/GraphView/master/doc-assets/Screenshot_20161011_210215_1.png)

## Create a line graph from XML

You can create a graph with data and some stylings in XML layout file via a helper class. If you want to use all features of GraphView it is recommended to do the setup on Java side.

**Important: The .jar file integration does not support XML integration, because the custom attributes to define the data and other options can not be used, when you include the library via .jar file.**

```xml
<com.jjoe64.graphview.helper.GraphViewXML
        android:layout_width="match_parent"
        android:layout_height="100dip"
        app:seriesData="0=5;2=5;3=0;4=2"
        app:seriesType="line"
        app:seriesColor="#ee0000" />
```

![xml graph](https://raw.githubusercontent.com/jjoe64/GraphView/master/doc-assets/5901645_1.png)

Read more information about [[XML integration]]. 

## Change the diagram type

To change the type of the graph, you have to use another implementation of the series. Instead of `LineGraphSeries` you can use those alternatives:

* [[LineGraphSeries|Line Graph]]
* [[BarGraphSeries|Bar Graph]]
* [[PointsGraphSeries|Point Graph]]

If you use the GraphViewXML helper you can switch the type via the `app:seriesType` attribute:

```
app:seriesType="line"
app:seriesType="bar"
app:seriesType="points"
```