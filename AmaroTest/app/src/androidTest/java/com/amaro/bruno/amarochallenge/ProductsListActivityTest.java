package com.amaro.bruno.amarochallenge;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingResource;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.TextView;

import com.amaro.bruno.amarochallenge.catalogue.products.model.Product;
import com.amaro.bruno.amarochallenge.catalogue.products.remote.RestApi;
import com.amaro.bruno.amarochallenge.catalogue.products.ui.ProductsListActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;

import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.Matchers.instanceOf;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

@RunWith(AndroidJUnit4.class)
public class ProductsListActivityTest {

    @Rule
    public ActivityTestRule<ProductsListActivity> mActivityRule = new ActivityTestRule<>(ProductsListActivity.class);

    @Before
    public void setup(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = RestApi.Builder.getOkHttpClient(interceptor);

        IdlingResource idlingResource = OkHttp3IdlingResource.create("OkHttp", okHttpClient);

        Espresso.registerIdlingResources(idlingResource);
    }

    @Test
    public void testToolbarTitle(){
        onView(allOf(instanceOf(TextView.class), withParent(withId(R.id.toolbar)))).check(matches(withText(R.string.app_name)));
    }

    @Test
    public void testClickFirstItem(){
        onData(anything()).inAdapterView(withId(R.id.grid_products)).atPosition(0).
                onChildView(withId(R.id.card_item)).perform(click());
    }

}
