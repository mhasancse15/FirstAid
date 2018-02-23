package com.mhasancse.firstaid.navActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupExpandListener;

import com.mhasancse.firstaid.R;
import com.mhasancse.firstaid.Utile.ExpandableListAdapter;
import com.mhasancse.firstaid.detailsActivity.prathomikaid.GanHaraleActivity;
import com.mhasancse.firstaid.detailsActivity.prathomikaid.JointBathActivity;
import com.mhasancse.firstaid.detailsActivity.prathomikaid.MerudondhoBethaActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FirstAidActivity extends ActionBarActivity {
    private static ExpandableListView expandableListView;
    private static ExpandableListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_aid);

        getSupportActionBar().setTitle(R.string.first_aid);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        expandableListView = (ExpandableListView) findViewById(R.id.simple_expandable_listview);

        // Setting group indicator null for custom indicator
        expandableListView.setGroupIndicator(null);

        setItems();
        setListener();

    }

    // Setting headers and childs to expandable listview
    void setItems() {

        // Array list for header
        ArrayList<String> header = new ArrayList<String>();

        // Array list for child items
        List<String> child1 = new ArrayList<String>();
        List<String> child2 = new ArrayList<String>();
        List<String> child3 = new ArrayList<String>();
        List<String> child4 = new ArrayList<String>();
        List<String> child5 = new ArrayList<String>();
        List<String> child6 = new ArrayList<String>();
        List<String> child7 = new ArrayList<String>();
        List<String> child8 = new ArrayList<String>();


        // Hash map for both header and child
        HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();

        // Adding headers to list
        for (int i = 1; i < 9; i++) {
            if (i == 1) {
                header.add(getString(R.string.prathomikaid));
            } else if (i == 2) {
                header.add("2 Physical Layer");
            } else if (i == 3) {
                header.add("3 Data Link Layer");
            } else if (i == 4) {
                header.add("4 Network Layer");
            } else if (i == 5) {
                header.add("5 Transport Layer");
            } else if (i == 6) {
                header.add("6 Session Layer");
            } else if (i == 7) {
                header.add("7 Presentation Layer");
            } else if (i == 8) {
                header.add("8 Application Layer");
            }


        }


        // Adding child data of Computer Networks
        for (int i = 1; i < 10; i++) {

            if (i == 1) {
                child1.add("১.১" + " অজ্ঞান হলে যা করতে হবে");
            } else if (i == 2) {
                child1.add("১.২" + " ঘাড় মেরুদন্ড ও কোমরে ব্যাথা রোগীর জন্য পরামর্শ");
            } else if (i == 3) {
                child1.add("১.৩" + " বয়স্করা সাধারণত যে সকল জয়েন্টের সমস্যায় ভোগেন");
            } else if (i == 4) {
                child1.add("১.৪" + " বাতজ্বর ");
            } else if (i == 5) {
                child1.add("১.৫" + " অসংক্রামক রোগে আক্রান্ত হওয়ার কারণ");
            } else if (i == 6) {
                child1.add("১.৬" + " সর্পদংশন বা সাপে কাটা");
            } else if (i == 7) {
                child1.add("১.৭" + " প্রাথমিক চিকিৎসাঃ সামগ্রী ও উপকরণ");
            } else if (i == 8) {
                child1.add("১.৮" + " আগুনে পোড়ার ৬টি প্রাথমিক চিকিৎসা");
            } else if (i == 9) {
                child1.add("১.৯" + " পসড়ক দুর্ঘটনায় প্রাথমিক চিকিৎসা");
            }


        }


        // Adding child data of Physical Layer
        for (int i = 1; i < 12; i++) {

            if (i == 1) {
                child2.add("2.1" + " Physical Layer Introduction");
            } else if (i == 2) {
                child2.add("2.2" + " Data & Signals");
            } else if (i == 3) {
                child2.add("2.3" + " Physical Media Data Rates");
            } else if (i == 4) {
                child2.add("2.4" + " Transmission Media");
            } else if (i == 5) {
                child2.add("2.5" + " Twisted Pair");
            } else if (i == 6) {
                child2.add("2.6" + " Unshielded Twisted Pair (UTP)");
            } else if (i == 7) {
                child2.add("2.7" + " Shielded Twisted Pair (STP)");
            } else if (i == 8) {
                child2.add("2.8" + " Co-axial Cable");
            } else if (i == 9) {
                child2.add("2.9" + " Connectors");
            } else if (i == 10) {
                child2.add("2.10" + " Optical Fiber");
            }


        }


        // Adding child data of Data Link Layer
        for (int i = 1; i < 6; i++) {
            if (i == 1) {
                child3.add("3.1" + " Data Link Layer Introduction");
            } else if (i == 2) {
                child3.add("3.2" + " Data Link Protocols");
            } else if (i == 3) {
                child3.add("3.3" + " Data Link Error Detection");
            } else if (i == 4) {
                child3.add("3.4" + " Data Link Error Control");
            }


        }


        // Adding child data of Network Layer
        for (int i = 1; i < 7; i++) {
            if (i == 1) {
                child4.add("4.1" + " Data Link Layer Introduction" + i);
            } else if (i == 2) {
                child4.add("4.2" + " : Child" + i);
            } else if (i == 3) {
                child4.add("4.3" + " : Child" + i);
            } else if (i == 4) {
                child4.add("4.4" + " : Child" + i);
            }


        }


        // Adding child data of Network Layer
        for (int i = 1; i < 7; i++) {
            child5.add("3.3" + " : Child" + i);

        }

        // Adding child data of Transport Layer
        for (int i = 1; i < 7; i++) {
            child6.add("3.4" + " : Child" + i);

        }
        // Adding child data of Session Layer
        for (int i = 1; i < 7; i++) {
            child7.add("3.5" + " : Child" + i);

        }
        // Adding child data of Presentation Layer
        for (int i = 1; i < 7; i++) {
            child8.add("3.6" + " : Child" + i);

        }


        // Adding header and childs to hash map
        hashMap.put(header.get(0), child1);
        hashMap.put(header.get(1), child2);
        hashMap.put(header.get(2), child3);
        hashMap.put(header.get(3), child4);
        hashMap.put(header.get(4), child5);
        hashMap.put(header.get(5), child6);
        hashMap.put(header.get(6), child7);
        hashMap.put(header.get(7), child8);


        adapter = new ExpandableListAdapter(FirstAidActivity.this, header, hashMap);

        // Setting adpater over expandablelistview
        expandableListView.setAdapter(adapter);
    }

    // Setting different listeners to expandablelistview
    void setListener() {

        // This listener will show toast on group click
        expandableListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView listview, View view,
                                        int group_pos, long id) {

                return false;
            }
        });

        // You can remove this listener for expanding all groups
        expandableListView
                .setOnGroupExpandListener(new OnGroupExpandListener() {
                    int previousGroup = -1;

                    @Override
                    public void onGroupExpand(int groupPosition) {
                        if (groupPosition != previousGroup)
                            expandableListView.collapseGroup(previousGroup);
                        previousGroup = groupPosition;
                    }

                });

        // This listener will show toast on child click
        expandableListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView listview, View view,
                                        int groupPosition, int childPosition, long id) {


                // Adding child data of Basic Computer networking
                if (groupPosition == 0) {
                    switch (childPosition) {
                        case 0:
                            Intent mb = new Intent(FirstAidActivity.this, GanHaraleActivity.class);
                            startActivity(mb);

                            break;
                        case 1:
                            Intent mb1 = new Intent(FirstAidActivity.this, MerudondhoBethaActivity.class);
                            startActivity(mb1);


                            break;
                        case 2:
                            Intent mb2 = new Intent(FirstAidActivity.this, JointBathActivity.class);
                            startActivity(mb2);

                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        case 6:
                            break;

                    }
                }

                // Adding child data of Physical Layer
                else if (groupPosition == 1) {
                    switch (childPosition) {
                        case 0:

                            break;
                        case 1:

                            break;
                        case 2:

                            break;
                        case 3:

                            break;

                        //Transmission Media

                        case 4:

                            break;

                        case 5:

                            break;
                        case 6:

                            break;
                        case 7:

                            break;
                        case 8:

                            break;
                        case 9:

                            break;


                    }
                }


                // Adding child data of Physical Layer
                else if (groupPosition == 2) {
                    switch (childPosition) {
                        case 0:

                            break;
                        case 1:

                            break;
                        case 2:

                            break;
                        case 3:

                            break;


                    }
                }


                // Adding child data of Physical Layer
                else if (groupPosition == 3) {
                    switch (childPosition) {
                        case 0:

                            break;
                        case 1:

                            break;
                        case 2:

                            break;
                        case 3:

                            break;


                    }
                }


                return false;
            }
        });


    }


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}