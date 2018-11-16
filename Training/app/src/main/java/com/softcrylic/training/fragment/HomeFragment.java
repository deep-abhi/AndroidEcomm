package com.softcrylic.training.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.softcrylic.training.R;
import com.softcrylic.training.Products.AllProductAdapter;
import com.softcrylic.training.Category.ProductData;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private DrawerLayout mDrawerLayout;
    GridView simpleGrid;
    private ViewFlipper simpleViewFlipper;
    RecyclerView mRecyclerView;
    List <ProductData> mProductList;
    ProductData mProductData;

   public View rootView;
    int[] images = {R.drawable.nature_1, R.drawable.nature_2, R.drawable.nature_3};
    int[] logos = {R.drawable.nature_1, R.drawable.nature_2, R.drawable.nature_3};



    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
     //   flipper();
        rootView = inflater.inflate(R.layout.fragment_home,container,false );
        mRecyclerView = rootView.findViewById(R.id.recyclerviewproduct);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(getActivity(),2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);

        mProductList = new ArrayList<>();

        mProductData = new ProductData("Helicopter",getString(R.string.description_category_RemoteToys),R.drawable.helicopter,"20");
        mProductList.add(mProductData);

        mProductData = new ProductData("Robot",getString(R.string.description_category_ActionFigureToys),R.drawable.robot,"30");
        mProductList.add(mProductData);

        mProductData = new ProductData("Gardner",getString(R.string.description_category_SoftToys),R.drawable.outdoor1,"40");
        mProductList.add(mProductData);

        mProductData = new ProductData("Wind Spinner",getString(R.string.description_category_ToddlerToys),R.drawable.windspinner,"60");
        mProductList.add(mProductData);

        mProductData = new ProductData("Tower Ring",getString(R.string.description_category_OutdoorToys),R.drawable.ring,"70");
        mProductList.add(mProductData);

        mProductData = new ProductData("Sound Toy",getString(R.string.description_category_OutdoorToys),R.drawable.soundtoys,"80");
        mProductList.add(mProductData);

        mProductData = new ProductData("Tower Ring",getString(R.string.description_category_OutdoorToys),R.drawable.ring,"100");
        mProductList.add(mProductData);

        mProductData = new ProductData("Sound Toy",getString(R.string.description_category_OutdoorToys),R.drawable.soundtoys,"150");
        mProductList.add(mProductData);
        mProductData = new ProductData("Tower Ring",getString(R.string.description_category_OutdoorToys),R.drawable.ring,"158");
        mProductList.add(mProductData);

        mProductData = new ProductData("Sound Toy",getString(R.string.description_category_OutdoorToys),R.drawable.soundtoys,"582");
        mProductList.add(mProductData);


       // main2Activity.navlayoutIndex = 0;
        AllProductAdapter myAdapter  = new AllProductAdapter(getActivity(), mProductList);
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
    public View flipper() {

        simpleViewFlipper = (ViewFlipper) rootView.findViewById(R.id.simpleViewFlipper);
        for (int i = 0; i < images.length; i++) {
            // create the object of ImageView
            ImageView imageView = new ImageView(getActivity());
            imageView.setImageResource(images[i]); // set image in ImageView
            simpleViewFlipper.addView(imageView); // add the created ImageView in ViewFlipper
        }
        Animation in = AnimationUtils.loadAnimation(getActivity(), android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(getActivity(), android.R.anim.slide_out_right);
        // set the animation type's to ViewFlipper
        simpleViewFlipper.setInAnimation(in);
        simpleViewFlipper.setOutAnimation(out);
        // set interval time for flipping between views
        simpleViewFlipper.setFlipInterval(3000);
        // set auto start for flipping between views
        simpleViewFlipper.setAutoStart(true);
        return rootView;
    }
}
