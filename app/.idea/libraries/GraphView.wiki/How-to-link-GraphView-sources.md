# How to link the project in Android Studio

If you want to do modifications on the codebase of GraphView, it is meaningful to include GraphView as submodule into your application. If you can use the default implementation of GraphView it is recommended to include GraphView via gradle or as .jar file. See here for instructions about that.

Here are the steps, how to link the GraphView module into your Android project, to have to opportunity to do modifications on the codebase of GraphView.

**Step #1:** Clone or download git repository
```
$ git clone https://github.com/jjoe64/GraphView.git
```

**Step #2:** Import GraphView as Module

In the Android Studio select the menu item "File > Import Module..." and select the folder of GraphView that you have clones before.

**Step #3:** Add dependency

Open the build.gradle file of your app-project submodule, this is typically located at `[project-folder]/app/build.gradle`.

Add this line to the dependencies block:

```
    implementation project(':GraphView')
```