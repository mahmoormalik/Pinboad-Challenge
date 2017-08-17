package com.mindvalleychallenge.pinboardchallenge.pinboard;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.util.Pair;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.mindvalleychallenge.pinboardchallenge.PinboardApplication;
import com.mindvalleychallenge.pinboardchallenge.R;
import com.mindvalleychallenge.pinboardchallenge.pinboard.adapter.PinboardAdapter;
import com.mindvalleychallenge.pinboardchallenge.pinboard.interfaces.ApiResponseNotifier;
import com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage;
import com.mindvalleychallenge.pinboardchallenge.pinboard.utils.API;
import com.mindvalleychallenge.pinboardchallenge.pinboard.utils.AppConstants;
import com.mindvalleychallenge.pinboardchallenge.pinboard.utils.PinboardScrollListener;

import io.realm.RealmResults;

import static com.mindvalleychallenge.pinboardchallenge.PinboardApplication.realm;

public class ImageBoardActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private SwipeRefreshLayout swipeRefreshLayout;

    private int TOTAL_PAGES = 5;
    private int currentPage = PAGE_START;
    private static final int PAGE_START = 1;
    private boolean isLoading;
    private boolean isLastPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_board);

        Toolbar toolbar = initToolbar();
        initNavDrawer(toolbar);
        initViews();

        swipeRefreshLayout.setRefreshing(true);
        fetchPins(currentPage);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.image_board, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private Toolbar initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.title_pinboard);
        setSupportActionBar(toolbar);
        return toolbar;
    }

    private void initNavDrawer(Toolbar toolbar) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ImageView profileIV = navigationView.getHeaderView(0).findViewById(R.id.profile_iv);
        PinboardApplication.getUniversalDownloader().loadImage(AppConstants.DUMMY_PROFILE_PIC_URL).into(profileIV);
    }

    private void initViews() {
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeToRefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // OnRefresh we are evicting cache so UniversalDownloader can fetch new data from server
                PinboardApplication.getUniversalDownloader().getCashManager().clearCash();
                fetchPins(currentPage);
            }
        });
        RecyclerView pinboardRecycler = (RecyclerView) findViewById(R.id.pin_board_recycler);
        pinboardRecycler.setItemAnimator(new DefaultItemAnimator());
        // Using staggered layout manager to achieve pinterest grid style
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, 1);
        pinboardRecycler.setLayoutManager(staggeredGridLayoutManager);

        pinboardRecycler.addOnScrollListener(new PinboardScrollListener(staggeredGridLayoutManager) {
            @Override
            protected void loadMoreItems() {
                isLoading = true;
                currentPage += 1;

                //fetchMorePins();
            }

            @Override
            public int getTotalPageCount() {
                return TOTAL_PAGES;
            }

            @Override
            public boolean isLastPage() {
                return isLastPage;
            }

            @Override
            public boolean isLoading() {
                return isLoading;
            }
        });


        RealmResults<PinImage> pinImages = PinImage.getAllPins(realm);
        pinboardRecycler.setAdapter(new PinboardAdapter(pinImages, true));
    }

    private void fetchPins(int pageNo) {

        // Page number will be used when our API will implement pagination support
        PinImage.fetchPins(API.urlGetPinboard(), new ApiResponseNotifier() {
            @Override
            public void onSuccess(RealmResults realmResults) {
                swipeRefreshLayout.setRefreshing(false);
                showError("", "");
            }

            @Override
            public void onError(Pair<String, String> error, RealmResults realmResults) {
                swipeRefreshLayout.setRefreshing(false);
                if (realmResults.size() < 1) {
                    showError(error.first, error.second);
                } else {
                    showError("", "");
                }
            }
        });
    }

    private void fetchMorePins(int pageNo) {
        // In this method we will ping API to load next page of pins
        // On API response we will check if this loaded page is last page also will set isLoading
        // isLoading = false;

        if (currentPage <= TOTAL_PAGES) {
            // add loading bar in footer
        } else {
            isLastPage = true;
        }
    }

    private void showError(String title, String desc) {
        ((TextView) findViewById(R.id.error_title)).setText(title);
        ((TextView) findViewById(R.id.error_description)).setText(desc);
    }
}
