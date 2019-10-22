# Use dates as labels

It is a common use-case that the labels on the x-axis should show a date or timestamp. To achieve this, you can use the unix timestamp (millis from 01/01/1970) as x-value of your data and use a your custom label formatter to convert the millis to your date object and format it as string.

There is also a build-in helper in GraphView that does exactly this job for you.  You can pass the date as Date object as x-value to your data and use the `DateAsXAxisLabelFormatter` to format it.

One important point: When using dates as X values, the rounding of the bounds to nice human-readable numbers does not make sense. So you should disable this feature via the method `graph.getGridLabelRenderer().setHumanRounding(false);`
​
Here is an example:

```java
// generate Dates
Calendar calendar = Calendar.getInstance();
Date d1 = calendar.getTime();
calendar.add(Calendar.DATE, 1);
Date d2 = calendar.getTime();
calendar.add(Calendar.DATE, 1);
Date d3 = calendar.getTime();

GraphView graph = (GraphView) findViewById(R.id.graph);

// you can directly pass Date objects to DataPoint-Constructor
// this will convert the Date to double via Date#getTime()
LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
    new DataPoint(d1, 1),
    new DataPoint(d2, 5),
    new DataPoint(d3, 3)
});

graph.addSeries(series);

// set date label formatter
graph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(getActivity()));
graph.getGridLabelRenderer().setNumHorizontalLabels(3); // only 4 because of the space

// set manual x bounds to have nice steps
graph.getViewport().setMinX(d1.getTime());
graph.getViewport().setMaxX(d3.getTime());
graph.getViewport().setXAxisBoundsManual(true);

// as we use dates as labels, the human rounding to nice readable numbers
// is not necessary
graph.getGridLabelRenderer().setHumanRounding(false);
```