# Static Labels

Static labels are labels that are not bound to the data. In other words they are statically drawn on the axis and don't interact with the data in the viewport. This is useful to show text like "Low, Middle, High" or something like that.

Static labels can be combined with normal (dynamic) labels, to have for instance for the y-axis static and for the x-axis dynamic labels.

You have to use the `StaticLabelsFormatter`. Here you can set the horizontal and/or the vertical static labels, and you have to option to define a custom label formatter for the dynamic labels - if you have.

```java
// use static labels for horizontal and vertical labels
StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);
staticLabelsFormatter.setHorizontalLabels(new String[] {"old", "middle", "new"});
staticLabelsFormatter.setVerticalLabels(new String[] {"low", "middle", "high"});
graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
```
