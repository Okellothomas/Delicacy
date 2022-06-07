package com.pro.delicacy;

import static org.junit.Assert.*;

import android.content.Intent;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.shadows.ShadowActivity;

@RunWith(RobolectricTestRunner.class)
public class DelicaciesTest {
    private Delicacies activity;
    @Before
    public void setUp() throws Exception {
       activity = Robolectric.buildActivity(Delicacies.class)
               .create()
               .resume()
               .get();
    }

    @Test
    public void validateMealContentName() {
        TextView error = activity.findViewById(R.id.mealButton);
        assertTrue("+".equals(error.getText().toString()));
    }

    @Test
    public void secondActivityStarted(){
        activity.findViewById(R.id.mealButton).performClick();
        Intent expectedIntent = new Intent(activity, Meals.class);
        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
    }

    @After
    public void tearDown() throws Exception {
    }
}