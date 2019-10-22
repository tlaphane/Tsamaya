# Include dependency

This is the recommended way if you use Android Studio / Gradle. You can require the library from the Maven Central Repository.

Add that line to your `build.gradle` file under your `app` directory into the dependencies block:

```
implementation 'com.jjoe64:graphview:4.2.2'
```

Now you can proceed with [[creating a simple line graph|Simple Graph]]. 

# Alternative way

Clone the github repository and [[link your project with the GraphView library project|How to link GraphView sources]]. Then you have full control over the sources and can modify or debug it directly. 
