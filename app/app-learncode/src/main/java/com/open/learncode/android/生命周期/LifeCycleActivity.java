package com.open.learncode.android.生命周期;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.oepn.config.MyConfig;

/**
 * LifeCycleActivity
 *
 * @Description: 生命周期打印
 * @Author: xing.tang
 */
public class LifeCycleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(MyConfig.Companion.getTAG(), "Activity &&&& onCreate...");
        if (getFragmentManager().findFragmentById(android.R.id.content) == null) {
            ArrayListFragment list = new ArrayListFragment();
            getFragmentManager().beginTransaction().add(android.R.id.content, list).commit();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(MyConfig.Companion.getTAG(), "Activity &&&& onStart...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(MyConfig.Companion.getTAG(), "Activity &&&& onResume...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(MyConfig.Companion.getTAG(), "Activity &&&& onStop...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(MyConfig.Companion.getTAG(), "Activity &&&& onPause...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(MyConfig.Companion.getTAG(), "Activity &&&& onDestroy...");
    }

    public static class ArrayListFragment extends ListFragment {

        @Override
        public void onAttach(Activity activity) {
            Log.d(MyConfig.Companion.getTAG(), "ArrayListFragment **** onAttach...");
            super.onAttach(activity);
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            Log.d(MyConfig.Companion.getTAG(), "ArrayListFragment **** onCreate...");
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            Log.d(MyConfig.Companion.getTAG(), "ArrayListFragment **** onCreateView...");
            return super.onCreateView(inflater, container, savedInstanceState);
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            Log.d(MyConfig.Companion.getTAG(), "ArrayListFragment **** onActivityCreated...");
            String[] array = new String[]{"C++", "JAVA", "PYTHON"};
            setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, array));
        }

        @Override
        public void onStart() {
            Log.d(MyConfig.Companion.getTAG(), "ArrayListFragment **** onStart...");
            super.onStart();
        }

        @Override
        public void onResume() {
            Log.d(MyConfig.Companion.getTAG(), "ArrayListFragment **** onResume...");
            super.onResume();
        }

        @Override
        public void onPause() {
            Log.d(MyConfig.Companion.getTAG(), "ArrayListFragment **** onPause...");
            super.onPause();
        }

        @Override
        public void onStop() {
            Log.d(MyConfig.Companion.getTAG(), "ArrayListFragment **** onStop...");
            super.onStop();
        }

        @Override
        public void onDestroyView() {
            Log.d(MyConfig.Companion.getTAG(), "ArrayListFragment **** onDestroyView...");
            super.onDestroyView();
        }

        @Override
        public void onDestroy() {
            Log.d(MyConfig.Companion.getTAG(), "ArrayListFragment **** onDestroy...");
            super.onDestroy();
        }

        @Override
        public void onDetach() {
            Log.d(MyConfig.Companion.getTAG(), "ArrayListFragment **** onDetach...");
            super.onDetach();
        }

        @Override
        public void onListItemClick(ListView l, View v, int position, long id) {
            Log.i(MyConfig.Companion.getTAG(), "Item clicked: " + id);
        }
    }
}