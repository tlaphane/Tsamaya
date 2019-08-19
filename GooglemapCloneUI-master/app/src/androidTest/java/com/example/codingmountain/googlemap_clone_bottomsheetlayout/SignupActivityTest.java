package com.example.codingmountain.googlemap_clone_bottomsheetlayout;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.Test;

import static android.support.test.espresso.action.ViewActions.click;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;



public class SignupActivityTest {

    @Rule
    public ActivityTestRule<SignupActivity> activityActivityTestRule = new ActivityTestRule<>(SignupActivity.class);
    private SignupActivity signupActivity = null;

    @Before
    public void setUp() throws Exception {
        signupActivity = activityActivityTestRule.getActivity();
    }

    @Test
    public void onCreate() {
    }

    @Test
    public void signup() {

        ViewInteraction name = Espresso.onView( ViewMatchers.withId(R.id.input_name));
        name.perform(ViewActions.typeText("name"),ViewActions.closeSoftKeyboard());

        View n = signupActivity.findViewById(R.id.input_name);
        assertEquals(n,signupActivity._nameText);

        ViewInteraction user_email = Espresso.onView( ViewMatchers.withId( R.id.input_email));
        user_email.perform(ViewActions.typeText("spm@gmail.com"),ViewActions.closeSoftKeyboard());

        //ViewInteraction pass = onView(withId(R.id.input_password));
        //pass.perform(ViewActions.typeText("abc1") );

        ViewInteraction button = Espresso.onView(ViewMatchers.withId(R.id.btn_signup));
        button.perform(click());
    }

    @Test
    public void onSignupFailed() {
    }

    @Test
    public void validate() {
    }
}