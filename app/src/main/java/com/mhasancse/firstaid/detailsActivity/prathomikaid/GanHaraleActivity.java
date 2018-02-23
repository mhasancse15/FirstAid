package com.mhasancse.firstaid.detailsActivity.prathomikaid;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

import com.mhasancse.firstaid.R;


public class GanHaraleActivity extends AppCompatActivity {
    private final String htmlText =
            "মস্তিষ্কের রক্তক্ষরণ, শরীরে পানি ও লবণের ঘাটতি, রক্তে সুগারের মাত্রা অনেক কমে যাওয়া ইত্যাদি বিভিন্ন কারণে অজ্ঞান হওয়ার সমস্যা হয়। অনেক সময় এটি মারাত্মক স্বাস্থ্যঝুঁকি তৈরি করতে পারে।<br><br>" +


                    "<font color='#E91E63'><b>কেউ অজ্ঞান হলে যা করবেন :</b></font><br>" +
                    "১. অজ্ঞান লোককে লম্বা করে সমতল স্থানে শুইয়ে দিন। খেয়াল রাখতে হবে, পা যেন মাথার চেয়ে উঁচুতে অবস্থান করে।" +
                    "<br>" +
                    "২. সব জামা ঢিলে করে দিন।" +
                    "<br>" +
                    "৩. মাথার পেছনের দিকে সামান্য হেলিয়ে দিন, যেন মুখ খোলা থাকে। এতে শ্বাস-প্রশাস নিতে সহজ হয়।" +
                    "<br>" +
                    "৪. বাতাসের ব্যবস্থা করুন। ফ্যান না থাকলে পত্রিকা বা যেকোনো বস্তু দিয়ে বাতাস করুন।" +
                    "<br>" +
                    "৫. ভেজা কাপড় দিয়ে মুখ ও ঘাড় মুছে দিতে থাকুন।" +
                    "<br>" +
                    "৬. এ সময় খিঁচুনিও হতে পারে। খিঁচুনি হলে আঘাত লাগতে পারে, এমন কিছু থাকলে সামনে থেকে সরিয়ে দিন। দয়া করে খিঁচুনি রোগীকে জোর করে ধরে রাখার চেষ্টা করবেন না। দ্রুত একপাশ ফিরিয়ে শুইয়ে দিন।" +
                    "<br>" +
                    "৭. পাশাপাশি রোগীকে যত দ্রুত সম্ভব নিরাপদ জায়গায় সরিয়ে আনুন। " +
                    "<br>" +
                    "৮. শ্বাস বন্ধ থাকলে কৃত্রিম শ্বাস-প্রশ্বাস দিতে হবে।" +
                    "<br>" +
                    "সাধারণত অজ্ঞান হওয়ার এক থেকে দুই মিনিটের মধ্যেই মানুষ আবার জ্ঞান ফিরে পায়। এর চেয়ে বেশি সময় ধরে কেউ অজ্ঞান থাকলে দ্রুত চিকিৎসকের কাছে যান।<br><br>" +


                    "<font color='#E91E63'><b>যা করবেন না :</b></font><br>" +
                    "১. কোনো অবস্থাতেই রোগীকে ঝাঁকাবেন না। অজ্ঞান রোগীর মুখে বা গালে চড়-থাপ্পড় মেরে জাগানোর চেষ্টা করবেন না।" +
                    "<br>" +
                    "২. পরিপূর্ণভাবে জ্ঞান ফিরে না পাওয়া পর্যন্ত কিছু পান করতে দেবেন না। এতে গলায় পানীয় আটকে যাওয়ার আশঙ্কা থাকে।" +
                    "<br>" +
                    "৩. বিনা কারণে তাকে সরাতে চেষ্টা করবেন না।" +
                    "<br>" +
                    "৪. অজ্ঞান ব্যক্তিকে কখনোই বসা বা দাঁড় করানোর চেষ্টা করবেন না।";
    //https://www.youtube.com/watch?v=SoVO3xOq4dg
    private TextView title, des;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_design);

        //TitleBarView
        getSupportActionBar().setTitle("অজ্ঞান হলে যা করতে হবে");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //AppBarTitle
        title = (TextView) findViewById(R.id.intrTitleTV);
        Spanned text = Html.fromHtml("<font color='#E91E63'><b>১.১ অজ্ঞান হলে যা করতে হবে</b></font>");


        title.setText(text);
        des = (TextView) findViewById(R.id.titleDesTV);
        des.setText(Html.fromHtml(htmlText, new ImageGetter(), null));
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private class ImageGetter implements Html.ImageGetter {

        public Drawable getDrawable(String source) {
            int id;

            if (source.equals("point.png")) {
                id = R.drawable.play;
            } else if (source.equals("multipoint.png")) {
                id = R.drawable.aid;
            } else {
                return null;
            }

            Drawable d = getResources().getDrawable(id);
            d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
            return d;
        }
    }
}
