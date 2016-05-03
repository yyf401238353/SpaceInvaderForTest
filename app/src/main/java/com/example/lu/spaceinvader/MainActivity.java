package com.example.lu.spaceinvader;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
       // new mainGameView(this);
        //setContentView(new mainGameView(this));
        setContentView(R.layout.test_layout);
        if(savedInstanceState==null){
            getFragmentManager().beginTransaction().add(R.id.container,new PlaceholderFragment()).commit();
        }

    }
   // protected void dialog() {
    //    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
   //     builder.setMessage("确认退出吗？");
//
  //      builder.setTitle("提示");

     //   builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {

      //      @Override
     ///       public void onClick(DialogInterface dialog, int which) {
      //          dialog.dismiss();
      //          MainActivity.this.finish();
     //       }
     //   });

   //     builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

   //         @Override
    ////        public void onClick(DialogInterface dialog, int which) {
 //               dialog.dismiss();
    //        }
   //     });
   //     builder.create().show();
  //  }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
