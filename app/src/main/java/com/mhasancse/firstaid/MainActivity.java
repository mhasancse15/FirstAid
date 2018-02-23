package com.mhasancse.firstaid;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.mhasancse.firstaid.adapter.ViewPagerAdapter;
import com.mhasancse.firstaid.navActivity.AboutActivity;
import com.mhasancse.firstaid.navActivity.FirstAidActivity;
import com.mhasancse.firstaid.navActivity.InformationActivity;
import com.mhasancse.firstaid.navActivity.TrainingActivity;
import com.mhasancse.firstaid.netCheck.SessionManager;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private static final String TAG = "MainActivity";
    ViewPager viewPager;
    LinearLayout sliderDotspanel;
    Context context;
    SessionManager sessionManager;
    private int dotscount;
    /* private AdView adView, mAdView;
     private InterstitialAd interstitial;
     private String INTERSTITIAL_AD_UNIT_ID = "ca-app-pub-9581837121576451/9539064432";*/
    private ImageView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        makeAdView();
        displayInterstitial();*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);




        /*View Image page code*/
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        sliderDotspanel = (LinearLayout) findViewById(R.id.SliderDots);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);

        viewPager.setAdapter(viewPagerAdapter);

        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        for (int i = 0; i < dotscount; i++) {

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 2000, 4000);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            exit();
            /*super.onBackPressed();*/
        }
    }

/*    private AdListener getAdListener() {
        return new AdListener() {

            @Override
            public void onAdFailedToLoad(int errorCode) {
                Log.e("ad failed to load", errorCode + "");
                switch (errorCode) {
                    case AdRequest.ERROR_CODE_INTERNAL_ERROR:
                        Log.e("INTERSTITIAL: ", "internal error");
                        break;
                    case AdRequest.ERROR_CODE_INVALID_REQUEST:
                        Log.e("INTERSTITIAL : ", "invalid request");
                        break;
                    case AdRequest.ERROR_CODE_NETWORK_ERROR:
                        Log.e("INTERSTITIAL: ", "network error");
                        break;
                    case AdRequest.ERROR_CODE_NO_FILL:
                        Log.e("INTERSTITIAL : ", "no fill");
                        break;
                }
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                interstitial.show();
            }
        };
    }

    public void displayInterstitial() {
        interstitial = new InterstitialAd(this);
        interstitial.setAdUnitId(INTERSTITIAL_AD_UNIT_ID);
        AdRequest adRequest = new AdRequest.Builder().build();
        interstitial.loadAd(adRequest);
        interstitial.setAdListener(getAdListener());

        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }

    private void makeAdView() {
        AdRequest adRequest = new AdRequest.Builder().build();
        adView = (AdView) findViewById(R.id.adView);
        adView.loadAd(adRequest);
        adView.setAdListener(getAdListener(adRequest));
        adView.bringToFront();
    }

    private AdListener getAdListener(final AdRequest adRequest) {
        return new AdListener() {
            @Override
            public void onAdFailedToLoad(int errorCode) {
                adView.loadAd(adRequest);
                switch (errorCode) {
                    case AdRequest.ERROR_CODE_INTERNAL_ERROR:
                        break;
                    case AdRequest.ERROR_CODE_INVALID_REQUEST:
                        break;
                    case AdRequest.ERROR_CODE_NETWORK_ERROR:
                        break;
                    case AdRequest.ERROR_CODE_NO_FILL:
                        break;
                }
            }

            @Override
            public void onAdLoaded() {
                findViewById(R.id.adView).setVisibility(View.VISIBLE);
                super.onAdLoaded();
            }
        };
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify activity_thre parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            Uri uri = Uri.parse("https://play.google.com/store/apps/developer?id=Smart%20Soft%20Studio&hl=en");
            Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
            goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                    Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                    Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
            try {
                startActivity(goToMarket);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://play.google.com/store/apps/details?id=" + context.getPackageName())));
            }
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_Home) {

            Intent i = new Intent(MainActivity.this, MainActivity.class);
            startActivity(i);


        } else if (id == R.id.nav_First_aid) {

            Intent i = new Intent(MainActivity.this, FirstAidActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_Information) {


            Intent i = new Intent(MainActivity.this, InformationActivity.class);
            startActivity(i);


        } else if (id == R.id.nav_Training) {

            Intent i = new Intent(MainActivity.this, TrainingActivity.class);
            startActivity(i);


        } else if (id == R.id.nav_share) {

            try {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, R.string.app_name);
                String sAux = "\nLet me recommend you this application\n\n";
                sAux = sAux + "https://play.google.com/store/apps/details?id=com.mhasancse.openglprojectwithsourcecode\n\n";
                i.putExtra(Intent.EXTRA_TEXT, sAux);
                startActivity(Intent.createChooser(i, "choose one"));
            } catch (Exception e) {
                //e.toString();
            }


        } else if (id == R.id.nav_rate) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            //Try Google play
            intent.setData(Uri.parse("market://details?id=com.mhasancse.openglprojectwithsourcecode&hl=en"));
            if (!MyStartActivity(intent)) {
                //Market (Google play) app seems not installed, let's try to open a webbrowser
                intent.setData(Uri.parse("http://play.google.com/store/apps/details?id=" + context.getPackageName()));
                if (!MyStartActivity(intent)) {
                    //Well if this also fails, we have run out of options, inform the user.
                    Toast.makeText(this, "Could not open Android market, please install the market app.", Toast.LENGTH_SHORT).show();
                }
            }
        } else if (id == R.id.nav_about_us) {
            Intent i = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_exit) {
            exit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

    @Override
    public void onClick(View v) {

    }

    private boolean MyStartActivity(Intent aIntent) {
        try {
            startActivity(aIntent);
            return true;
        } catch (ActivityNotFoundException e) {
            return false;
        }
    }


    /*Start DashBoard*/

    public void exit() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        // Setting Alert Dialog Title
        alertDialogBuilder.setTitle("Confirm Exit..!!!");
        // Icon Of Alert Dialog
        alertDialogBuilder.setIcon(R.drawable.aids);
        // Setting Alert Dialog Message
        alertDialogBuilder.setMessage("Are you sure,You want to exit");
        alertDialogBuilder.setCancelable(false);

        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                finish();
            }
        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialogBuilder.setNeutralButton("More Apps", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Uri uri = Uri.parse("https://play.google.com/store/apps/developer?id=Smart%20Soft%20Studio&hl=en");
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + context.getPackageName())));
                }
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    /* Start Main Menu in Dash board*/
    public void goToFirstAid(View view) {
        Intent i = new Intent(MainActivity.this, FirstAidActivity.class);
        startActivity(i);
    }

    public void goToInformation(View view) {

        Intent i = new Intent(MainActivity.this, InformationActivity.class);
        startActivity(i);
    }

    public void goToTraining(View view) {

        Intent i = new Intent(MainActivity.this, TrainingActivity.class);
        startActivity(i);
    }

    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if (viewPager.getCurrentItem() == 0) {
                        viewPager.setCurrentItem(1);
                    } else if (viewPager.getCurrentItem() == 1) {
                        viewPager.setCurrentItem(2);
                    } else {
                        viewPager.setCurrentItem(0);
                    }

                }
            });

        }
    }

}

