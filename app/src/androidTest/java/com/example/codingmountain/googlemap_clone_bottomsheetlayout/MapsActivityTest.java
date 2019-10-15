package com.example.codingmountain.googlemap_clone_bottomsheetlayout;

import android.Manifest;
import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.v4.content.ContextCompat;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.longClick;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

public class MapsActivityTest {


    @Rule public ActivityTestRule<LoginActivity> activityActivityTestRule = new ActivityTestRule<>(LoginActivity.class);



    private LoginActivity loginActivity = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(MapsActivity.class.getName(),null,false);
    Instrumentation.ActivityMonitor LoginMonitor = getInstrumentation().addMonitor(LoginActivity.class.getName(),null,false);



    @Before
    public void setUp() throws Exception {
        loginActivity = activityActivityTestRule.getActivity();
    }

    @After
    public void tearDown() throws Exception {
    }


//    @Rule public  GrantPermissionRule mRuntimePermissionRule = GrantPermissionRule.grant(android.Manifest.permission.ACCESS_FINE_LOCATION).grant(android.Manifest.permission.ACCESS_COARSE_LOCATION);

    @Test
    public void onCreate() throws InterruptedException {

        assertNotNull(loginActivity.findViewById(R.id.btn_login));
        assertNotNull(loginActivity.findViewById(R.id.input_email));
        assertNotNull(loginActivity.findViewById(R.id.input_password));



        onView(withId(R.id.input_email)).perform(typeText("alec@gmail.com"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.input_password)).perform(typeText("123456"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());

        Activity MapActivity = getInstrumentation().waitForMonitorWithTimeout(monitor,10000);


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
        TimeUnit.SECONDS.sleep(2);

        assertNotNull(MapActivity.findViewById(R.id.map));
        onView(withId(R.id.map)).perform(swipeRight());
        onView(withId(R.id.map)).perform(swipeRight());
        onView(withId(R.id.map)).perform(longClick());
        TimeUnit.SECONDS.sleep(2);

        assertNotNull(MapActivity.findViewById(R.id.floatingActionButtonMenu));
        assertNotNull(MapActivity.findViewById(R.id.fab));
        onView(withId(R.id.fab)).perform(click());
        TimeUnit.SECONDS.sleep(2);
        onView(withId(R.id.floatingActionButtonMenu)).perform(click());
        TimeUnit.SECONDS.sleep(2);
        assertNotNull(MapActivity.findViewById(R.id.fab_action1));
        onView(withId(R.id.fab_action3)).perform(click());
        onView(withId(R.id.fab_action3)).perform(click());
        TimeUnit.SECONDS.sleep(2);
        Activity LoginActivityAfterLogOut = getInstrumentation().waitForMonitorWithTimeout(LoginMonitor,10000);

        assertNotNull(LoginActivityAfterLogOut.findViewById(R.id.btn_login));
        assertNotNull(LoginActivityAfterLogOut.findViewById(R.id.input_email));
        assertNotNull(LoginActivityAfterLogOut.findViewById(R.id.input_password));

        LoginActivityAfterLogOut.finish();
    }

    @Test
    public void LocationPermissionDeny() throws InterruptedException {
        assertNotNull(loginActivity.findViewById(R.id.btn_login));
        assertNotNull(loginActivity.findViewById(R.id.input_email));
        assertNotNull(loginActivity.findViewById(R.id.input_password));



        onView(withId(R.id.input_email)).perform(typeText("alec@gmail.com"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.input_password)).perform(typeText("123456"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());

        Activity MapActivity = getInstrumentation().waitForMonitorWithTimeout(monitor,10000);

        TimeUnit.SECONDS.sleep(2);

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
                            .index(2));
                    if (allowPermissions.exists()) {
                        allowPermissions.click();
                    }
                }
            } catch (UiObjectNotFoundException e) {
                System.out.println("There is no permissions dialog to interact with");
            }
        }
        TimeUnit.SECONDS.sleep(2);
        assertNotNull(MapActivity.findViewById(R.id.map));

        MapActivity.finish();

    }

    @Test
    public void SearchBarYesToGoogle() throws InterruptedException {
        assertNotNull(loginActivity.findViewById(R.id.btn_login));
        assertNotNull(loginActivity.findViewById(R.id.input_email));
        assertNotNull(loginActivity.findViewById(R.id.input_password));

        onView(withId(R.id.input_email)).perform(typeText("alec@gmail.com"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.input_password)).perform(typeText("123456"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());

        Activity MapActivity = getInstrumentation().waitForMonitorWithTimeout(monitor,10000);


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
        TimeUnit.SECONDS.sleep(2);
        assertNotNull(MapActivity.findViewById(R.id.map));

        assertNotNull(MapActivity.findViewById(R.id.input_search));
        onView(withId(R.id.input_search)).perform(typeText("katle"));

        TimeUnit.SECONDS.sleep(2);

        onView(withText("Katlehong - R18.00 - Bree Taxi Rank")).inRoot(RootMatchers.isPlatformPopup()).perform(click());
        TimeUnit.SECONDS.sleep(2);

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                //sleep(PERMISSIONS_DIALOG_DELAY);
                UiDevice device = UiDevice.getInstance(getInstrumentation());
                UiObject allowPermissions = device.findObject(new UiSelector()
                        .clickable(true)
                        .checkable(false)
                        .index(1));
                if (allowPermissions.exists()) {
                    allowPermissions.click();
                }
            }
        } catch (UiObjectNotFoundException e) {
            System.out.println("There is no permissions dialog to interact with");
        }

        TimeUnit.SECONDS.sleep(5);

        MapActivity.finish();
    }

    @Test
    public void SearchBarNoToGoogle() throws InterruptedException {
        assertNotNull(loginActivity.findViewById(R.id.btn_login));
        assertNotNull(loginActivity.findViewById(R.id.input_email));
        assertNotNull(loginActivity.findViewById(R.id.input_password));

        onView(withId(R.id.input_email)).perform(typeText("alec@gmail.com"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.input_password)).perform(typeText("123456"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());

        Activity MapActivity = getInstrumentation().waitForMonitorWithTimeout(monitor,10000);


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
        TimeUnit.SECONDS.sleep(2);
        assertNotNull(MapActivity.findViewById(R.id.map));

        assertNotNull(MapActivity.findViewById(R.id.input_search));
        onView(withId(R.id.input_search)).perform(typeText("katle"));

        TimeUnit.SECONDS.sleep(2);

        onView(withText("Katlehong - R18.00 - Bree Taxi Rank")).inRoot(RootMatchers.isPlatformPopup()).perform(click());
        TimeUnit.SECONDS.sleep(2);

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

        TimeUnit.SECONDS.sleep(5);

        MapActivity.finish();
    }

    public boolean checkPermission() {

        int FirstPermissionResult = ContextCompat.checkSelfPermission(loginActivity.getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION);
        int SecondPermissionResult = ContextCompat.checkSelfPermission(loginActivity.getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION);

        return FirstPermissionResult == PackageManager.PERMISSION_GRANTED &&
                SecondPermissionResult == PackageManager.PERMISSION_GRANTED;

    }
}