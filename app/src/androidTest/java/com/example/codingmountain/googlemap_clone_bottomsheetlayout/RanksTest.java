package com.example.codingmountain.googlemap_clone_bottomsheetlayout;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class RanksTest {

    @Rule
    public ActivityTestRule<LoginActivity> activityActivityTestRule = new ActivityTestRule<>(LoginActivity.class);
    private LoginActivity loginActivity = null;

    Instrumentation.ActivityMonitor mapMonitor = getInstrumentation().addMonitor(MapsActivity.class.getName(),null,false);

    Instrumentation.ActivityMonitor ranksMonitor = getInstrumentation().addMonitor(Ranks.class.getName(),null,false);


    @Before
    public void setUp() throws Exception {
        loginActivity = activityActivityTestRule.getActivity();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void OnCreate(){

        assertNotNull(loginActivity.findViewById(R.id.btn_login));
        assertNotNull(loginActivity.findViewById(R.id.input_email));
        assertNotNull(loginActivity.findViewById(R.id.input_password));

        onView(withId(R.id.input_email)).perform(typeText("alec@gmail.com"),closeSoftKeyboard());
        onView(withId(R.id.input_password)).perform(typeText("123456"),closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());

        Activity map = getInstrumentation().waitForMonitorWithTimeout(mapMonitor,10000);
        assertNotNull(map);

        assertNotNull(map.findViewById(R.id.floatingActionButtonMenu));
        onView(withId(R.id.floatingActionButtonMenu)).perform(click());

        assertNotNull(map.findViewById(R.id.ranks));
        onView(withId(R.id.ranks)).perform(click());

        Activity ranks = getInstrumentation().waitForMonitorWithTimeout(ranksMonitor,10000);
        assertNotNull(ranks);

        ranks.finish();

    }
}