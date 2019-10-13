package com.example.codingmountain.googlemap_clone_bottomsheetlayout;

import android.Manifest;
import android.app.Activity;
import android.app.Instrumentation;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.test.rule.ActivityTestRule;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.v4.content.ContextCompat;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.anything;
import static org.junit.Assert.*;

public class RanksTest {

    @Rule
    public ActivityTestRule<LoginActivity> activityActivityTestRule = new ActivityTestRule<>(LoginActivity.class);
    private LoginActivity loginActivity = null;

    Instrumentation.ActivityMonitor mapMonitor = getInstrumentation().addMonitor(MapsActivity.class.getName(),null,false);

    Instrumentation.ActivityMonitor ranksMonitor = getInstrumentation().addMonitor(Ranks.class.getName(),null,false);

    Instrumentation.ActivityMonitor routesMonitor = getInstrumentation().addMonitor(Routes.class.getName(),null,false);


    @Before
    public void setUp() throws Exception {
        loginActivity = activityActivityTestRule.getActivity();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void OnCreate() throws InterruptedException {

        assertNotNull(loginActivity.findViewById(R.id.btn_login));
        assertNotNull(loginActivity.findViewById(R.id.input_email));
        assertNotNull(loginActivity.findViewById(R.id.input_password));

        onView(withId(R.id.input_email)).perform(typeText("alec@gmail.com"),closeSoftKeyboard());
        onView(withId(R.id.input_password)).perform(typeText("123456"),closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());

        Activity map = getInstrumentation().waitForMonitorWithTimeout(mapMonitor,10000);
        assertNotNull(map);

        if(checkPermission()){
            System.out.println("Alec has permission");
        }else{
            System.out.println("Alec no permision");
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    //sleep(PERMISSIONS_DIALOG_DELAY);
                    UiDevice device = UiDevice.getInstance(getInstrumentation());
                    UiObject allowPermissions = device.findObject(new UiSelector()
                            .clickable(true)
                            .checkable(false)
                            .index(0));
                    if (allowPermissions.exists()) {
                        allowPermissions.click();
                    }
                }
            } catch (UiObjectNotFoundException e) {
                System.out.println("There is no permissions dialog to interact with");
            }
        }

        assertNotNull(map.findViewById(R.id.floatingActionButtonMenu));
        onView(withId(R.id.floatingActionButtonMenu)).perform(click());

        assertNotNull(map.findViewById(R.id.fab_action1));
        onView(withId(R.id.fab_action1)).perform(click());
        onView(withId(R.id.fab_action1)).perform(click());
        TimeUnit.SECONDS.sleep(5);

        Activity ranks = getInstrumentation().waitForMonitorWithTimeout(ranksMonitor,10000);
        assertNotNull(ranks);

        assertNotNull(ranks.findViewById(R.id.listView));
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());

        Activity routes = getInstrumentation().waitForMonitorWithTimeout(routesMonitor,10000);
        assertNotNull(routes);
        TimeUnit.SECONDS.sleep(5);

        routes.finish();

    }

    public boolean checkPermission() {

        int FirstPermissionResult = ContextCompat.checkSelfPermission(loginActivity.getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION);
        int SecondPermissionResult = ContextCompat.checkSelfPermission(loginActivity.getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION);

        return FirstPermissionResult == PackageManager.PERMISSION_GRANTED &&
                SecondPermissionResult == PackageManager.PERMISSION_GRANTED;

    }
}