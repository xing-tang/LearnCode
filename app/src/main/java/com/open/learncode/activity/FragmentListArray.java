package com.open.learncode.activity;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Stack;

/**
 * Demonstration of using ListFragment to show a list of items
 * from a canned array.
 */
public class FragmentListArray extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("xing", "Activity &&&& onCreate...");
        // Create the list fragment and add it as our sole content.
        if (getFragmentManager().findFragmentById(android.R.id.content) == null) {
            ArrayListFragment list = new ArrayListFragment();
            getFragmentManager().beginTransaction().add(android.R.id.content, list).commit();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("xing", "Activity &&&& onStart...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("xing", "Activity &&&& onResume...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("xing", "Activity &&&& onStop...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("xing", "Activity &&&& onPause...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("xing", "Activity &&&& onDestroy...");
    }

    public static class ArrayListFragment extends ListFragment {

        @Override
        public void onAttach(Activity activity) {
            Log.e("xing", "ArrayListFragment **** onAttach...");
            super.onAttach(activity);
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            Log.e("xing", "ArrayListFragment **** onCreate...");
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            Log.e("xing", "ArrayListFragment **** onCreateView...");
            return super.onCreateView(inflater, container, savedInstanceState);
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            Log.e("xing", "ArrayListFragment **** onActivityCreated...");
            String[] array = new String[]{"C++", "JAVA", "PYTHON"};
            setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, array));
        }

        @Override
        public void onStart() {
            Log.e("xing", "ArrayListFragment **** onStart...");
            super.onStart();
        }

        @Override
        public void onResume() {
            Log.e("xing", "ArrayListFragment **** onResume...");
            super.onResume();
        }

        @Override
        public void onPause() {
            Log.e("xing", "ArrayListFragment **** onPause...");
            super.onPause();
        }

        @Override
        public void onStop() {
            Log.e("xing", "ArrayListFragment **** onStop...");
            super.onStop();
        }

        @Override
        public void onDestroyView() {
            Log.e("xing", "ArrayListFragment **** onDestroyView...");
            super.onDestroyView();
        }

        @Override
        public void onDestroy() {
            Log.e("xing", "ArrayListFragment **** onDestroy...");
            super.onDestroy();
        }

        @Override
        public void onDetach() {
            Log.e("xing", "ArrayListFragment **** onDetach...");
            super.onDetach();
        }

        @Override
        public void onListItemClick(ListView l, View v, int position, long id) {
            Log.i("FragmentList", "Item clicked: " + id);
        }
    }
}