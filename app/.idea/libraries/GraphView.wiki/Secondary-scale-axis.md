# Secondary Scale / Right Side Labels

One great new feature in GraphView 4.0 is the opportunity to create Graphs with a second scale, which will show a second y-axis on the right side.
This second scale has some limits. First it can not stand alone, you have to use at least one series on the normal (left) scale.

Secondly the second scale doesn't have automatically bounds. It is mandatory to set the y bounds manually.

To use the second scale, you need to get the `SecondScale` object via `graphView.getSecondScale()`.

Then you can add series to it via `graphView.getSecondScale().addSeries(mSeries)`
and set the manual viewport via `graphView.getSecondScale().setMinY()` and `.setMaxY()`.

Here is an example:

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

LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(new DataPoint[] {
    new DataPoint(0, 30),
    new DataPoint(1, 30),
    new DataPoint(2, 60),
    new DataPoint(3, 20),
    new DataPoint(4, 50)
});

// set second scale
graph.getSecondScale().addSeries(series2);
// the y bounds are always manual for second scale
graph.getSecondScale().setMinY(0);
graph.getSecondScale().setMaxY(100);
series2.setColor(Color.RED);
graph.getGridLabelRenderer().setVerticalLabelsSecondScaleColor(Color.RED);
```