# Line Graph Series in detail

To plot a line diagram in GraphView you use the `LineGraphSeries` class.
By default this will plot a line between the single data points, no matter how much space is between the data points.
`LineGraphSeries` has some special options for styling:

* Thickness of the line

  You can change the thickness of the line via setThickness()

* Background

  The area below the line can be filled with a color. This feature can be activated via setDrawBackground(true).
  You can set the color via setBackgroundColor(). It is recommended to use a semi-transparent color.

* Data Points

  The single data points can be highlighted with a point in the graph. You activate this via setDrawDataPoints(true) and change the size of the points via setDataPointsRadius(). The points will always be in the same color than the line itself.

* Custom Paint object
  If you want to have some more freedom you can change the series to use your own custom paint object for plotting the lines. You could for example generate dotted lines. Set your custom paint via setCutomPaint();

```java
// styling series
series.setTitle("Random Curve 1");
series.setColor(Color.GREEN);
series.setDrawDataPoints(true);
series.setDataPointsRadius(10);
series.setThickness(8);

// custom paint to make a dotted line
Paint paint = new Paint();
paint.setStyle(Paint.Style.STROKE);
paint.setStrokeWidth(10);
paint.setPathEffect(new DashPathEffect(new float[]{8, 5}, 0));
series2.setCustomPaint(paint);
```