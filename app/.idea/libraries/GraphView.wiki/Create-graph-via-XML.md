# Create graph via XML

**Important: The .jar file does not support XML integration, because the custom attributes to define the data and other options can not be used, when you include the library via .jar file.**

You can create a graph with data and some stylings directly in the XML Layout file. For this there is the helper class `GraphViewXML`.

To use the parameters you have to add a namespace for the auto-generated resources. Add this parameter to the top level item in the xml file:

```
xmlns:app="http://schemas.android.com/apk/res-auto"
```

The only attribute that is mandatory is the `app:seriesData`.
The Syntax is in that format: `X1=Y1;X2=Y2;X3=Y3...`

Here is a very simple example how to use it:

```xml
    <com.jjoe64.graphview.helper.GraphViewXML
        android:layout_width="match_parent"
        android:layout_height="100dip"
        app:seriesData="0=5;2=5;3=0;4=2" />
```

By default the example above will create a LineGraph. You can also change the Chart Type and some other stylings. The following attributes are supported:

* app:seriesData (mandatory)

  The data in the format: X=Y;X=Y;...

* app:seriesType

  Can be line, bar, points.
  Default: line

* app:seriesColor

  The color used for the series.
  Default: #0077cc

* app:seriesTitle

  The title of the series. If this property is set, the legend will be drawn.
  Default: empty

* android:title

  The title of the graph.

Here is a more complex example which will create a Line Graph with a specific color and titles.

```xml
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent" android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    android:paddingBottom="@dimen/activity_vertical_margin">

    <com.jjoe64.graphview.helper.GraphViewXML
        android:layout_width="match_parent"
        android:layout_height="200dip"
        app:seriesData="0=5;2=5;3=0;4=2"
        app:seriesType="line"
        app:seriesColor="#00cc00"
        app:seriesTitle="Foobar"
        android:title="Graph Title" />
</RelativeLayout>
```