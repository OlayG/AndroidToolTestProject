package com.example.admin.androidtooltestproject;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AppbookFragment extends Fragment {

    public AppbookFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_appbook, container, false);

        final ArrayList<MyApps> myApps = new ArrayList<>();

        MyApps calculator = new MyApps(
                getString(R.string.Calculator),
                "App that lets you do simple calculations",
                "Olay Gureje",
                "NONE");
        MyApps emiCalculator = new MyApps(
                getString(R.string.Emi_calculator),
                "App that lets you do calculate your equated montly installment (EMI)",
                "Olay Gureje",
                "NONE");
        MyApps pictureViewer = new MyApps(
                getString(R.string.pictureViewer),
                "App that lets you view a picture",
                "Olay Gureje",
                "NONE");

        myApps.add(calculator);
        myApps.add(emiCalculator);
        myApps.add(pictureViewer);

        BindDictionary<MyApps> dictionary = new BindDictionary<>();
        dictionary.addStringField(R.id.tvAppName, new StringExtractor<MyApps>() {
            @Override
            public String getStringValue(MyApps myApps, int position) {
                return "App Name: " +myApps.getAppName();
            }
        });
        dictionary.addStringField(R.id.tvAppDescription, new StringExtractor<MyApps>() {
            @Override
            public String getStringValue(MyApps myApps, int position) {
                return "Description: " + myApps.getDescription();
            }
        });
        dictionary.addStringField(R.id.tvAppAuthor, new StringExtractor<MyApps>() {
            @Override
            public String getStringValue(MyApps myApps, int position) {
                return "Dev Name: " + myApps.getAuthorName();
            }
        });

        FunDapter<MyApps> adapter = new FunDapter(AppbookFragment.this.getActivity(), myApps, R.layout.my_apps_layout, dictionary);
/*        ArrayAdapter<MyApps> adapter = new ArrayAdapter<MyApps>(
                AppbookFragment.this.getActivity(),
                android.R.layout.simple_list_item_1,
                myApps);*/

        ListView lvMyApps = view.findViewById(R.id.lvMyApps);
        lvMyApps.setAdapter(adapter);
        lvMyApps.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av, View v, int pos, long l) {
                MyApps selectedApp = myApps.get(pos);

                switch (pos){

                    case 0:
                        CalculatorFragment calculatorFragment = new CalculatorFragment();
                        FragmentManager manager = getFragmentManager();
                        manager.beginTransaction().replace(
                                R.id.relativelayout_for_fragment,
                                calculatorFragment,
                                calculatorFragment.getTag()
                        ).addToBackStack("calculatorFragment").commit();
                        break;
                    case 1:
                        EmiFragment emiFragment = new EmiFragment();
                        FragmentManager manager1 = getFragmentManager();
                        manager1.beginTransaction().replace(
                                R.id.relativelayout_for_fragment,
                                emiFragment,
                                emiFragment.getTag()
                        ).addToBackStack("emiFragment").commit();
                        break;
                    case 2:
                        PictureViewerFragment picViewerFragment = new PictureViewerFragment();
                        FragmentManager manager2 = getFragmentManager();
                        manager2.beginTransaction().replace(
                                R.id.relativelayout_for_fragment,
                                picViewerFragment,
                                picViewerFragment.getTag()
                        ).addToBackStack("picViewerFragment").commit();
                        break;
                    default:
                        Toast.makeText(AppbookFragment.this.getActivity(), "HELLO", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}
