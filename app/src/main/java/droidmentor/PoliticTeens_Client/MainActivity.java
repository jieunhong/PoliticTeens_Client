package droidmentor.PoliticTeens_Client;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import droidmentor.PoliticTeens_Client.Fragment.CongressFragment;
import droidmentor.PoliticTeens_Client.Fragment.MyJungdangFragment;
import droidmentor.PoliticTeens_Client.Fragment.MyJungdangFragment_Null;
import droidmentor.PoliticTeens_Client.Fragment.PlazaFragment;
import droidmentor.PoliticTeens_Client.Fragment.MagazineFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;


    //This is our viewPager
    private ViewPager viewPager;
    int result=0;


    //Fragments

    MyJungdangFragment myJungdangFragment;
    MyJungdangFragment_Null myJungdangFragmentNull;
    CongressFragment congressFragment;
    PlazaFragment plazaFragment;
    MagazineFragment magazineFragment;
    MenuItem prevMenuItem;


    private String[] navItems = {"Brown", "Cadet Blue", "Dark Olive Green",
            "Dark Orange", "Golden Rod"};
    private ListView lvNavList;
    private FrameLayout flContainer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //layout을 가지고 와서 actionbar에 포팅을 시킵니다.


        Toolbar parent = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(parent);
        parent.setPadding(0, 0, 0, 0);//for tab otherwise give space in tab
        parent.setContentInsetsAbsolute(0, 0);




        viewPager = (ViewPager) findViewById(R.id.viewpager);
        //Initializing the bottomNavigationView
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        /*lvNavList = (ListView)findViewById(R.id.activity_main_setting);
        flContainer = (FrameLayout)findViewById(R.id.fl_activity_main_container);

        lvNavList.setAdapter(
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, navItems));
        lvNavList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        flContainer.setBackgroundColor(Color.parseColor("#A52A2A"));
                        break;
                    case 1:
                        flContainer.setBackgroundColor(Color.parseColor("#5F9EA0"));
                        break;
                    case 2:
                        flContainer.setBackgroundColor(Color.parseColor("#556B2F"));
                        break;
                    case 3:
                        flContainer.setBackgroundColor(Color.parseColor("#FF8C00"));
                        break;
                    case 4:
                        flContainer.setBackgroundColor(Color.parseColor("#DAA520"));
                        break;

                }
            }
        });*/



        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_congress:
                                viewPager.setCurrentItem(0);
                                break;
                            case R.id.action_myjungdang:
                                viewPager.setCurrentItem(1);
                                break;
                            case R.id.action_plaza:
                                viewPager.setCurrentItem(2);
                                break;
                            case R.id.action_magazine:
                                viewPager.setCurrentItem(3);
                                break;
                        }
                        return false;
                    }
                });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: " + position);
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

       /*  //Disable ViewPager Swipe

       viewPager.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                return true;
            }
        });

        */

        setupViewPager(viewPager);
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        congressFragment = new CongressFragment();
        myJungdangFragment = new MyJungdangFragment();
        plazaFragment = new PlazaFragment();
        magazineFragment = new MagazineFragment();
        myJungdangFragmentNull = new MyJungdangFragment_Null();
        adapter.addFragment(congressFragment);

        if(result==1) adapter.addFragment(myJungdangFragmentNull);
        else adapter.addFragment(myJungdangFragment);
        adapter.addFragment(plazaFragment);
        adapter.addFragment(magazineFragment);
        viewPager.setAdapter(adapter);
    }
}
