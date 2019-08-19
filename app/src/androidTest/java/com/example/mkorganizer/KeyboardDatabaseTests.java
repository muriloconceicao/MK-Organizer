package com.example.mkorganizer;

import android.content.Context;

import androidx.room.Room;
import androidx.test.runner.AndroidJUnit4;
import com.example.mkorganizer.activities.MainActivity;
import com.example.mkorganizer.dao.KeyboardDao;
import com.example.mkorganizer.database.KeyboardDatabase;
import com.example.mkorganizer.entity.Keyboard;
import com.example.mkorganizer.utils.AppContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.List;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import androidx.test.rule.ActivityTestRule;



import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class KeyboardDatabaseTests {
    private KeyboardDao keyboardDao;
    private KeyboardDatabase keyboardDatabase;
    private Keyboard keyboard;

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void createKeyboardDatabase() {
        keyboard = new Keyboard();
        keyboard.setBrand("Ducky");
        keyboard.setModel("Mini");
        keyboard.setSwitches("Brown");
        Context context = AppContext.getContext();
        keyboardDatabase = Room.inMemoryDatabaseBuilder(context, KeyboardDatabase.class).build();
        keyboardDao = keyboardDatabase.keyboardDao();
    }

    @After
    public void closeKeyboardDatabase() {
        keyboardDatabase.close();
    }

    @Test
    public void writeKeyboardAndReadBrandTest() {
        keyboardDao.addKeyboard(keyboard);
        List<Keyboard> keyboardList = keyboardDao.getKeyboards();
        assertEquals(keyboardList.get(0).getBrand(), keyboard.getBrand());
    }

    @Test
    public void writeKeyboardAndReadModelTest() {
        keyboardDao.addKeyboard(keyboard);
        List<Keyboard> keyboardList = keyboardDao.getKeyboards();
        assertEquals(keyboardList.get(0).getModel(), keyboard.getModel());
    }

    @Test
    public void writeKeyboardAndReadSwitchesTest() {
        keyboardDao.addKeyboard(keyboard);
        List<Keyboard> keyboardList = keyboardDao.getKeyboards();
        assertEquals(keyboardList.get(0).getSwitches(), keyboard.getSwitches());
    }

    @Test
    public void editTextsTest() {
        onView(withId(R.id.edtBrand)).check(matches(isDisplayed()));
        onView(withId(R.id.edtModel)).check(matches(isDisplayed()));
        onView(withId(R.id.edtSwitch)).check(matches(isDisplayed()));
        onView(withId(R.id.edtBrand)).perform(typeText("Ducky"), closeSoftKeyboard());
        onView(withId(R.id.edtModel)).perform(typeText("Mini"), closeSoftKeyboard());
        onView(withId(R.id.edtSwitch)).perform(typeText("Brown"), closeSoftKeyboard());
    }

}