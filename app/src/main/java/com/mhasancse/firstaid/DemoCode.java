package com.mhasancse.firstaid;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

public class DemoCode extends AppCompatActivity {
    private final String htmlText =
            "<br><br><br>" +


                    "<font color='#E91E63'><b></b></font><br>" +
                    "<br>" +
                    "<br>" +
                    "<br>" +
                    "<br>" +
                    "<br>" +
                    "<br>" +
                    "<br>" +
                    "<br>" +


                    "<font color='#E91E63'><b></b></font><br>";
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
        des.setText(Html.fromHtml(htmlText, new DemoCode.ImageGetter(), null));
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
