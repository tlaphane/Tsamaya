package com.example.codingmountain.googlemap_clone_bottomsheetlayout;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;

import java.util.concurrent.TimeUnit;


public class SignupActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> activityActivityTestRule = new ActivityTestRule<>(LoginActivity.class);
    private LoginActivity loginActivity = null;
    Instrumentation.ActivityMonitor signUpmonitor = getInstrumentation().addMonitor(SignupActivity.class.getName(),null,false);
    Instrumentation.ActivityMonitor loginMonitor = getInstrumentation().addMonitor(LoginActivity.class.getName(),null,false);

    @Before
    public void setUp() throws Exception {
        loginActivity = activityActivityTestRule.getActivity();
    }


    @Test
    public void signup() throws InterruptedException {

        assertNotNull(loginActivity.findViewById(R.id.link_signup));

        onView(withId(R.id.link_signup)).perform(click());

        Activity signUpActivity = getInstrumentation().waitForMonitorWithTimeout(signUpmonitor,10000);

        assertNotNull(signUpActivity.findViewById(R.id.input_name));
        assertNotNull(signUpActivity.findViewById(R.id.input_email));
        assertNotNull(signUpActivity.findViewById(R.id.input_email));
        assertNotNull(signUpActivity.findViewById(R.id.btn_signup));
        assertNotNull(signUpActivity.findViewById(R.id.link_login));


        //have account yet, back to login
        onView(withId(R.id.link_login)).perform(click());
        Activity log = getInstrumentation().waitForMonitorWithTimeout(loginMonitor,10000);


        assertNotNull(log.findViewById(R.id.link_signup));
        onView(withId(R.id.link_signup)).perform(click());

        //empty
        onView(withId(R.id.btn_signup)).perform(click());

        //already existing email
        onView(withId(R.id.input_name)).perform(typeText("name"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.input_email)).perform(typeText("alec@gmail.com"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.input_password)).perform(typeText("123456Swdd"), ViewActions.closeSoftKeyboard());

        onView(withId(R.id.btn_signup)).perform(click());


        //new email
//         onView(withId(R.id.input_name)).perform(clearText(),typeText("name"), ViewActions.closeSoftKeyboard());
//         onView(withId(R.id.input_email)).perform(clearText(),typeText("viledwdjya@gmail.com"), ViewActions.closeSoftKeyboard());
//         onView(withId(R.id.input_password)).perform(clearText(),typeText("123456"), ViewActions.closeSoftKeyboard());
//
//         onView(withId(R.id.btn_signup)).perform(click());


        signUpActivity.finish();
    }


//    @Test
//    public void ShowToast_name() {
//        //ViewInteraction name = onView( withId(R.id.input_name));
//        //name.perform(ViewActions.typeText("name"),ViewActions.closeSoftKeyboard());
//        onView(withId(R.id.input_email)).perform(typeText("alec@gmail.com"), ViewActions.closeSoftKeyboard());
//        onView(withId(R.id.input_password)).perform(typeText("12346"), ViewActions.closeSoftKeyboard());
//        onView(withId(R.id.btn_signup)).perform(click());
//        onView(withText("at least 3 characters")).inRoot(withDecorView(not(is(activityActivityTestRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
//    }
//    @Test
//    public void ShowToast_email() {
//
//        ViewInteraction name = onView( withId(R.id.input_name));
//        name.perform(ViewActions.typeText("name"),ViewActions.closeSoftKeyboard());
//       // onView(withId(R.id.input_email)).perform(typeText("alec@gmail.com"), ViewActions.closeSoftKeyboard());
//        onView(withId(R.id.input_password)).perform(typeText("12346"), ViewActions.closeSoftKeyboard());
//        onView(withId(R.id.btn_signup)).perform(click());
//
//        onView(withText("enter a valid email address")).inRoot(withDecorView(not(is(activityActivityTestRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
//
//    }
//
//    @Test
//    public void ShowToast_password() {
//
//        ViewInteraction name = onView( withId(R.id.input_name));
//        name.perform(ViewActions.typeText("name"),ViewActions.closeSoftKeyboard());
//        onView(withId(R.id.input_email)).perform(typeText("alec@gmail.com"), ViewActions.closeSoftKeyboard());
//        //onView(withId(R.id.input_password)).perform(typeText("12346"), ViewActions.closeSoftKeyboard());
//        onView(withId(R.id.btn_signup)).perform(click());
//
//        onView(withText("between 6 and 15 alphanumeric characters")).inRoot(withDecorView(not(is(activityActivityTestRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
//
//    }

}
