package com.example.onlineliquorfinal;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class SignUpTest {

    @Rule
    public ActivityTestRule<SignupActivity> activityTestRule =
            new ActivityTestRule<>(SignupActivity.class);

    @Test
    public void checkSignup() throws Exception
    {
        onView(withId(R.id.fname))
                .perform(typeText("seema"))
                .perform(closeSoftKeyboard());

        onView(withId(R.id.lname))
                .perform(typeText("rai"))
                .perform(closeSoftKeyboard());

        onView(withId(R.id.address))
                .perform(typeText("Anamnagar"))
                .perform(closeSoftKeyboard());

        onView(withId(R.id.email))
                .perform(typeText("seema12@gmail.com"))
                .perform(closeSoftKeyboard());

        onView(withId(R.id.phone))
                .perform(typeText("9805328518"))
                .perform(closeSoftKeyboard());

        onView(withId(R.id.susername))
                .perform(typeText("seema123"))
                .perform(closeSoftKeyboard());


        onView(withId(R.id.spassword))
                .perform(typeText("seema123"))
                .perform(closeSoftKeyboard());

        onView(withId(R.id.cpassword))
                .perform(typeText("seema123"))
                .perform(closeSoftKeyboard());

        onView(withId(R.id.btn_signup))
                .perform(click());

    }
}
