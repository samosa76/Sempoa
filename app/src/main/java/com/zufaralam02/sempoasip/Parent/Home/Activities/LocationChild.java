package com.zufaralam02.sempoasip.Parent.Home.Activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.zufaralam02.sempoasip.Parent.Home.Adapters.AdapterChildLocation;
import com.zufaralam02.sempoasip.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LocationChild extends FragmentActivity implements OnMapReadyCallback {
    @BindView(R.id.viewPagerChildMaps)
    ViewPager viewPagerChildMaps;

    private GoogleMap mMap;
    AdapterChildLocation adapterChildLocation;
    List<String[]> listChild = new ArrayList<String[]>();

    String[] childOne = {
            "Middlestone",
            "111222",
            "Tangerang"
    };
    String[] childTwo = {
            "Mark",
            "333444",
            "jakarta"
    };
    String[] childThree = {
            "Martin",
            "555666",
            "Depok"
    };

//    String[] childOne, childTwo, childThree;
//
//    public String[] getChildOne() {
//        return childOne;
//    }
//
//    public void setChildOne(String[] childOne) {
//        this.childOne = childOne;
//    }
//
//    public String[] getChildTwo() {
//        return childTwo;
//    }
//
//    public void setChildTwo(String[] childTwo) {
//        this.childTwo = childTwo;
//    }
//
//    public String[] getChildThree() {
//        return childThree;
//    }
//
//    public void setChildThree(String[] childThree) {
//        this.childThree = childThree;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_child);
        ButterKnife.bind(this);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        if (adapterChildLocation == null) {
//            Instead of :
//            HotelDetailPagerAdapter adapter = new HotelDetailPagerAdapter(getFragmentManager());
//            Try :
//            HotelDetailPagerAdapter adapter = new HotelDetailPagerAdapter(getChildFragmentManager());
//            and
//            Instead of :
//            FragmentTransaction ft = getBaseActivity().getFragmentManager().beginTransaction();
//            Try :
//            FragmentTransaction ft = getChildFragmentManager().beginTransaction();
//            adapterChildHome = new AdapterChildHome(getActivity().getSupportFragmentManager());
            adapterChildLocation = new AdapterChildLocation(getSupportFragmentManager());
            listChild.add(childOne);
            listChild.add(childTwo);
            listChild.add(childThree);
            adapterChildLocation.setListChild(listChild);
//            adapterChildHome.setTvChildRank(tvChildRank);
//            adapterChildHome.setTvChildWallet(tvChildRank);

            viewPagerChildMaps.setClipToPadding(false);
            viewPagerChildMaps.setPadding(100, 0, 100, 0);
            viewPagerChildMaps.setPageMargin(20);
            viewPagerChildMaps.setSaveFromParentEnabled(false);
        }
        viewPagerChildMaps.setAdapter(adapterChildLocation);
        adapterChildLocation.notifyDataSetChanged();
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-6.222833, 106.653819);
        mMap.addMarker(new MarkerOptions().position(sydney));
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

}
