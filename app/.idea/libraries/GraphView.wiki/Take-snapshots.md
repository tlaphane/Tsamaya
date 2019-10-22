# Take snapshot and share

GraphView provides build-in functionality to generate a screenshot to save as file or to share it directly via Android share screen.

It's also possible to just generate the snapshot and use the image data for your own purpose.

This are the simple calls:

```java
// directly share it
graph.takeSnapshotAndShare(mActivity, "exampleGraph", "GraphViewSnapshot");

// get the bitmap
Bitmap bitmap = graph.takeSnapshot();
```

**Notice:**

The runtime permission `WRITE_EXTERNAL_STORAGE` is needed!

![snapshot share](https://raw.githubusercontent.com/jjoe64/GraphView/master/doc-assets/snapshotshare_1.png)