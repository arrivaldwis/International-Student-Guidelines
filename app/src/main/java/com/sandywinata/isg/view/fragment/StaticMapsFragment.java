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
import android.widget.ImageView;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdateFactory;
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
 * {@link StaticMapsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StaticMapsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StaticMapsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @BindView(R.id.spCampus)
    Spinner spCampus;
    @BindView(R.id.btnFind)
    Button btnFind;
    @BindView(R.id.imgMap)
    ImageView imgMap;

    private ArrayAdapter<String> adapter;

    public StaticMapsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StaticMapsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StaticMapsFragment newInstance(String param1, String param2) {
        StaticMapsFragment fragment = new StaticMapsFragment();
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
        return inflater.inflate(R.layout.fragment_static_maps, container, false);
    }

    @OnClick(R.id.btnFind)
    public void cari() {
        if(spCampus.getSelectedItemPosition()==0){
            imgMap.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.zgcmap));
        } else {
            imgMap.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.lxmap));
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, Constants.campus);
        spCampus.setAdapter(adapter);
        imgMap.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.zgcmap));
    }
}
