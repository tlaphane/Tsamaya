# Labels and Label Formatter

Generally, you do not need to take care for the labels. GraphView will automatically generate and format the labels for you, so that the float-numbers won't get too big.
Anyway, you have the option to change how the labels are generated. For this, you have to set your own label formatter to the `GridLabelRenderer`.
The most simple way is to change the number format. For this you can use the `DefaultLabelFormatter` and pass your date formats as arguments.

```java
NumberFormat nf = NumberFormat.getInstance();
nf.setMinimumFractionDigits(3);
nf.setMinimumIntegerDigits(2);

graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(nf, nf));
```

You can do a complete custom label generation. For example if you want to use a suffix like a currency. To do so, you have to implement the `LabelFormatter` interface or extend the `DefaultLabelFormatter` and override the `formatLabel` method.

```java
// custom label formatter to show currency "EUR"
graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
    @Override
    public String formatLabel(double value, boolean isValueX) {
        if (isValueX) {
            // show normal x values
            return super.formatLabel(value, isValueX);
        } else {
            // show currency for y values
            return super.formatLabel(value, isValueX) + " €";
        }
    }
});
```
