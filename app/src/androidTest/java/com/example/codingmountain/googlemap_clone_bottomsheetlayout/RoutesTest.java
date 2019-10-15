package com.example.codingmountain.googlemap_clone_bottomsheetlayout;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.view.View;
import android.widget.Toast;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class RoutesTest {
// @Rule
//    public ActivityTestRule<Routes>  RoutesTestRule= new ActivityTestRule<Routes>(Routes.class);
//    private Routes RoutesTest =null;
//
//    Instrumentation.ActivityMonitor monitor= getInstrumentation().addMonitor(Routes.class.getName(),null,false);
//
// @Before
// public void setUp() throws Exception {
//     RoutesTest = RoutesTestRule.getActivity();
//    }
// @Test
// public void testLaunchofSecondActivityOnButtonClick(){
//    assertNotNull(RoutesTest.findViewById(R.id.button));
//    onView(withId(R.id.button)).perform(click());
//    Activity secondActivity =getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
//
//    assertNotNull(secondActivity);
//     secondActivity.finish();
//
// }
// @After
//public void tearDown() throws Exception{
//     RoutesTest=null;
// }

}