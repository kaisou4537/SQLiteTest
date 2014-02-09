package com.example.app;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        DatabaseDao databaseDao = new DatabaseDao(db);


        DBData newDBData = new DBData();
        newDBData.setMemo("hogehoge");
        newDBData.setPriority(1);
        databaseDao.insert(newDBData);

        newDBData = new DBData();
        newDBData.setMemo("fugafuga");
        newDBData.setPriority(3);
        databaseDao.insert(newDBData);

        List<DBData> dbDataList = databaseDao.findAll();
        db.close();

        StringBuffer buf = new StringBuffer();
        buf.append("     Date     | Plan");
        buf.append(System.getProperty("line.separator"));
        for(DBData dbData: dbDataList){
            buf.append(dbData.getMemo());
            buf.append("|");
            buf.append(dbData.getPriority());
            buf.append(System.getProperty("line.separator"));
        }
        TextView tv = new TextView(this);
        tv.setText(buf.toString());
        setContentView(tv);



//        TextView tv = new TextView(this);
//        tv.setText("hogehoge");
//        setContentView(tv);

//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.container, new PlaceholderFragment())
//                    .commit();
//        }



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
