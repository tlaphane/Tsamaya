package com.example.codingmountain.googlemap_clone_bottomsheetlayout;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class ResetPasswordActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> activityActivityTestRule = new ActivityTestRule<>(LoginActivity.class);
    private LoginActivity loginActivity = null;
    Instrumentation.ActivityMonitor resetMonitor = getInstrumentation().addMonitor(ResetPasswordActivity.class.getName(),null,false);

    @Before
    public void setUp() throws Exception {
        loginActivity = activityActivityTestRule.getActivity();
    }

    @Test
    public void resetPassword() throws InterruptedException {


        assertNotNull(loginActivity.findViewById(R.id.link_ForgetP));

        onView(withId(R.id.link_ForgetP)).perform(click());

        Activity resetPasswordActivity = getInstrumentation().waitForMonitorWithTimeout(resetMonitor,10000);

        assertNotNull(resetPasswordActivity.findViewById(R.id.send_mail));
        assertNotNull(resetPasswordActivity.findViewById(R.id.btn_reset));

        //empty email
        onView(withId(R.id.btn_reset)).perform(click());
        TimeUnit.SECONDS.sleep(2);

        //non registered email
        onView(withId(R.id.send_mail)).perform(typeText("ale@gmail.com"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.btn_reset)).perform(click());
        TimeUnit.SECONDS.sleep(2);

        //registered valid email
        onView(withId(R.id.send_mail)).perform(clearText(),typeText("alec@gmail.com"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.btn_reset)).perform(click());

        TimeUnit.SECONDS.sleep(10);


//
//        assertNotNull(signUpActivity.findViewById(R.id.input_email));
//        assertNotNull(signUpActivity.findViewById(R.id.input_email));
//        assertNotNull(signUpActivity.findViewById(R.id.btn_signup));
//
//
//        onView(withId(R.id.btn_signup)).perform(click());
//        TimeUnit.SECONDS.sleep(2);
//
//
//        onView(withId(R.id.input_name)).perform(typeText("name"), ViewActions.closeSoftKeyboard());
//        onView(withId(R.id.input_email)).perform(typeText("redeyee2@gmail.com"), ViewActions.closeSoftKeyboard());
//        onView(withId(R.id.input_password)).perform(typeText("123456"), ViewActions.closeSoftKeyboard());
//
//        onView(withId(R.id.btn_signup)).perform(click());


    }
}