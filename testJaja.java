package com.example.jorgehernandez.tienda;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class WizardActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    static SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    static ViewPager mViewPager;

    static SharedPreferences appSharedPreferences;
    static SharedPreferences.Editor preferencesEditor;
    static String PREFS_NAME = "generalAppInfo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wizard);

        appSharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        preferencesEditor = appSharedPreferences.edit();

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_wizard, container, false);
            ImageView imgFragment = (ImageView) rootView.findViewById(R.id.imgFragment);
            int pos = mViewPager.getCurrentItem();
            Log.d("Wizard", "onCreateView: " + pos);
            Log.d("Wizard", "onCreateView: getArguments" + getArguments().getInt(ARG_SECTION_NUMBER))
            switch (getArguments().getInt(ARG_SECTION_NUMBER)){
                case 1:
//                     rootView.setBackgroundResource(R.drawable.face2);
                    imgFragment.setImageResource(R.mipmap.categorias);
                    break;
                case 2:
                    preferencesEditor.putInt("prevPos", pos);
                    imgFragment.setImageResource(R.mipmap.extracto_de_puntos);
                    break;
                case 3:
                    imgFragment.setImageResource(R.mipmap.perfil);
                    break;
                case 4:
                    imgFragment.setImageResource(R.mipmap.historial_de_compras);
                    break;
                case 5:
                    imgFragment.setImageResource(R.mipmap.configuracion);
                    break;
                case 6:
                    imgFragment.setImageResource(R.mipmap.busqueda);
                    break;
                case 7:
                    imgFragment.setImageResource(R.mipmap.carrito_de_compras);
                    break;
                default:
                    imgFragment.setImageResource(R.mipmap.categorias);

            }

            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position - 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 7;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }
}
