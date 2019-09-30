package com.example.codingmountain.googlemap_clone_bottomsheetlayout;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class MapsActivityTest {


    @Rule
    public ActivityTestRule<MapsActivity> activityActivityTestRule = new ActivityTestRule<>(MapsActivity.class);
    private MapsActivity loginActivity = null;

    //Instrumentation.ActivityMonitor mapMonitor = getInstrumentation().addMonitor(MapsActivity.class.getName(),null,false);

    @Before
    public void setUp() throws Exception {
        loginActivity = activityActivityTestRule.getActivity();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void onCreate() throws InterruptedException {

        assertNotNull(loginActivity.findViewById(R.id.floatingActionButtonMenu));
        assertNotNull(loginActivity.findViewById(R.id.toolbar));
        assertNotNull(loginActivity.findViewById(R.id.fab));
        assertNotNull(loginActivity.findViewById(R.id.tap_action_layout));

        onView(withId(R.id.floatingActionButtonMenu)).perform(click());
        TimeUnit.SECONDS.sleep(2);
        assertNotNull(loginActivity.findViewById(R.id.ranks));
        onView(withId(R.id.floatingActionButtonMenu)).perform(click());


        onView(withId(R.id.tap_action_layout)).perform(click());
        TimeUnit.SECONDS.sleep(2);



    }
}