package com.pro.delicacy;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class DelicaciesInstrumentationTest {

    @Rule
    public ActivityScenarioRule<Delicacies> activityRule = new ActivityScenarioRule<Delicacies>(Delicacies.class);

    @Test
    public void validateEditText() {
        onView(withId(R.id.editeMealName)).perform(typeText("fish"))
                .check(matches(withText("fish")));
    }

    @Test
    public void mealIsSentToMealsActivity() {
        String meal = "fish";
        onView(withId(R.id.editeMealName)).perform(typeText(meal)).perform(closeSoftKeyboard());
        try {
            Thread.sleep(300);
        }catch (InterruptedException e){
            System.out.println("Got interrupted somewhere i know not");
        }
        onView(withId(R.id.mealButton)).perform(click());
//        onView(withId(R.id.locationTextView)).check(matches(withText("Here are all the restaurants near: " + location)));
        //
    }
}
