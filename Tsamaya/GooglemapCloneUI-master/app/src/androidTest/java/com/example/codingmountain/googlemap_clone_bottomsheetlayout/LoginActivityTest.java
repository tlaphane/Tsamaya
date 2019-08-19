package com.example.codingmountain.googlemap_clone_bottomsheetlayout;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.view.View;



import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;


import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;



public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> activityActivityTestRule = new ActivityTestRule<>(LoginActivity.class);
    private LoginActivity loginActivity = null;

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
    public void login() {
        ViewInteraction user_email = Espresso.onView( ViewMatchers.withId( R.id.input_email));
        user_email.perform(ViewActions.typeText("spm@gmail.com"),ViewActions.closeSoftKeyboard());
        //ViewInteraction pass = onView(withId(R.id.input_password));
        //pass.perform(ViewActions.typeText("abc1") );

        ViewInteraction button = Espresso.onView(ViewMatchers.withId(R.id.btn_login));
        button.perform(click());
    }

    @Test
    public void onActivityResult() {

    }

    @Test
    public void onBackPressed() {
    }

    @Test
    public void onLoginSuccess() {

    }

    @Test
    public void onLoginFailed() {
    }

    @Test
    public void validate() {
    }
}