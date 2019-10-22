# Styling options

GraphView offers many options to style your charts individually. The styles are so ordered that they are to the specific modules like the Series, the Legend, the Grid and some general styles. So if you are looking for styling options you have to take a look into these objects.

**Hint: New styles are coming by time and not all features are listed here. Please take a look at the API reference documentation, to see all options.**

## General options

These are options that are general and therefore on the `GraphView` object.

* Graph Title

  This title will be displayed above the viewport.

```
graphView.setTitle("foo");
```

* Title font color and size

  By default it will use the font of your app theme. You can set the font size and color via the methods:

```
graphView.setTitleTextSize()
graphView.setTitleColor()
```

## Label and Grid options

The styles regarding the labels and the grid belong to the GridLabelRenderer, which you can access via `graphView.getGridLabelRenderer();`

There are many options:

* Horizontal and Vertical Axis Titles, colors and font size
* Use a fixed count of horizontal/vertical labels that will be generated
* Show/Hide horizontal/vertical labels
* Labels color for horizontal, vertical and the second scale axis
* Labels text alignment
* Label Formatter. Get more information about [[Labels and label formatter]].
* Padding
* Highlight zero lines. This is a flag whether the line for zero points (Y=0 or X=0) should be highlighted with a more fat line.
* Grid color
* Grid Style. It's possible to define the grid style. You can choose between HORIZONTAL, VERTICAL and BOTH or NONE direction grid lines.

## Viewport options

Viewport options are about the what you actually see in the area where the data gets plotted.
You can set the options to the `graphView.getViewport()` object.

* Set Manual or Automatic axis bounds

  To set manual bounds you use setMinX(), setMaxX(), setMinY(), setMaxY() and you have to flag it via `setYAxisBoundsManual(true), setXAxisBoundsManual(true)`

* Set whether is is scalable and scrollable
* Background Color

## Legend options

To change the legend options you use the graphView.getLegendRenderer() object. The most important options is this:

* setVisible()

Find more information about [[Legend]] here.

## Series options

Some options are related to the series, so you set them at the Series object. The most options are related to the type of the series and so you have to take a deeper look at the specific types here.

This are the general options regardless of the type:

* Title
* Color
* OnDataPointTapListener. Get more information about [[Tap listener on data]].
