package com.example.codingmountain.googlemap_clone_bottomsheetlayout;

import android.Manifest;
import android.app.Activity;
import android.app.Instrumentation;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.v4.content.ContextCompat;
import android.view.View;



import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;


import java.util.concurrent.TimeUnit;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;



public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> activityActivityTestRule = new ActivityTestRule<>(LoginActivity.class);
    private LoginActivity loginActivity = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(MapsActivity.class.getName(),null,false);

    @Before
    public void setUp() throws Exception {
        loginActivity = activityActivityTestRule.getActivity();
    }

    @Test
    public void onCreate() {
        View log = loginActivity.findViewById(R.id.input_email);
        assertEquals(log,loginActivity._emailText);
        View pass = loginActivity.findViewById(R.id.input_password);
        assertEquals(pass,loginActivity._passwordText);
        View b = loginActivity.findViewById(R.id.btn_login);
        assertEquals(b,loginActivity._loginButton);
        View up = loginActivity.findViewById(R.id.link_signup);
        assertEquals(up,loginActivity._signupLink);

    }

    @Test
    public void login() throws InterruptedException {
        assertNotNull(loginActivity.findViewById(R.id.btn_login));
        assertNotNull(loginActivity.findViewById(R.id.input_email));
        assertNotNull(loginActivity.findViewById(R.id.input_password));

        onView(withId(R.id.btn_login)).perform(click());

        onView(withId(R.id.input_email)).perform(typeText("alec@gmail.com"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.input_password)).perform(typeText("123457"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());

        TimeUnit.SECONDS.sleep(2);

        onView(withId(R.id.input_password)).perform(clearText(),typeText("123456"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());


        Activity MapActivity = getInstrumentation().waitForMonitorWithTimeout(monitor,10000);

        assertNotNull(MapActivity);
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
                            .index(0));
                    if (allowPermissions.exists()) {
                        allowPermissions.click();
                    }
                }
            } catch (UiObjectNotFoundException e) {
                System.out.println("There is no permissions dialog to interact with");
            }
        }

        MapActivity.finish();
    }

    public boolean checkPermission() {

        int FirstPermissionResult = ContextCompat.checkSelfPermission(loginActivity.getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION);
        int SecondPermissionResult = ContextCompat.checkSelfPermission(loginActivity.getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION);

        return FirstPermissionResult == PackageManager.PERMISSION_GRANTED &&
                SecondPermissionResult == PackageManager.PERMISSION_GRANTED;

    }

}