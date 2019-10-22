# Multiple series and mix up chart types

GraphView can plot multiple series simultaneously. As everything, it's very easy to create a chart with multiple series of data.

Just create and add more Series objects of the type you want to have.For every series you can choose the type (Line, Bar, Points), set the title that will be shown in the legend and set some stylings.

Here is an example:

```java
GraphView graph = (GraphView) findViewById(R.id.graph);
BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[] {
    new DataPoint(0, -2),
    new DataPoint(1, 5),
    new DataPoint(2, 3),
    new DataPoint(3, 2),
    new DataPoint(4, 6)
});
graph.addSeries(series);

LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(new DataPoint[] {
    new DataPoint(0, 3),
    new DataPoint(1, 3),
    new DataPoint(2, 6),
    new DataPoint(3, 2),
    new DataPoint(4, 5)
});
graph.addSeries(series2);
```