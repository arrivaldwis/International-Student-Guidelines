package com.sandywinata.isg.view.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.sandywinata.isg.R;
import com.sandywinata.isg.config.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RealtimeMapsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RealtimeMapsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RealtimeMapsFragment extends Fragment implements OnMapReadyCallback {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private GoogleMap mMap;

    @BindView(R.id.spCampus)
    Spinner spCampus;
    @BindView(R.id.btnFind)
    Button btnFind;

    private ArrayAdapter<String> adapter;

    public RealtimeMapsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RealtimeMapsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RealtimeMapsFragment newInstance(String param1, String param2) {
        RealtimeMapsFragment fragment = new RealtimeMapsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_realtime_maps, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, Constants.campus);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        spCampus.setAdapter(adapter);
    }

    @OnClick(R.id.btnFind)
    public void cari() {
        mMap.clear();
        if(spCampus.getSelectedItemPosition()==0){
            LatLng sydney = new LatLng(39.9571221, 116.3093644);
            mMap.addMarker(new MarkerOptions().position(sydney).title(spCampus.getSelectedItem().toString()+" Campus"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 15.0f));
        } else {
            LatLng sydney = new LatLng(39.7372751, 116.1690373);
            mMap.addMarker(new MarkerOptions().position(sydney).title(spCampus.getSelectedItem().toString()+" Campus"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 15.0f));
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng sydney = new LatLng(39.9571221, 116.3093644);
        mMap.addMarker(new MarkerOptions().position(sydney).title(spCampus.getSelectedItem().toString()+" Campus"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
