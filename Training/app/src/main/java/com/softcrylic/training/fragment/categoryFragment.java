package com.softcrylic.training.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softcrylic.training.R;
import com.softcrylic.training.Category.MyAdapter;
import com.softcrylic.training.Category.ProductData;
import com.softcrylic.training.activity.main2Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link categoryFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link categoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class categoryFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    RecyclerView mRecyclerView;
    List<ProductData> mProductList;
    ProductData mProductData;
    public categoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment categoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static categoryFragment newInstance(String param1, String param2) {
        categoryFragment fragment = new categoryFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_category,container,false );
        mRecyclerView = rootView.findViewById(R.id.recyclerview);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(getActivity(),2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);

        mProductList = new ArrayList<>();

        mProductData = new ProductData("Remote Toys",getString(R.string.description_category_RemoteToys),R.drawable.remotetoys);
        mProductList.add(mProductData);

        mProductData = new ProductData("Action Toys",getString(R.string.description_category_ActionFigureToys),R.drawable.actionfiguretoys);
        mProductList.add(mProductData);

        mProductData = new ProductData("Soft Toys",getString(R.string.description_category_SoftToys),R.drawable.softtoys);
        mProductList.add(mProductData);

        mProductData = new ProductData("Toddler Toys",getString(R.string.description_category_ToddlerToys),R.drawable.toddlertoys);
        mProductList.add(mProductData);

        mProductData = new ProductData("Outdoor Toys",getString(R.string.description_category_OutdoorToys),R.drawable.outdoortoys);
        mProductList.add(mProductData);


        main2Activity.navlayoutIndex = 1;
        MyAdapter myAdapter  = new MyAdapter(getActivity(), mProductList);
        mRecyclerView.setAdapter(myAdapter);
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
