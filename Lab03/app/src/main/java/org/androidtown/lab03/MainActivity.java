package org.androidtown.lab03;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtn = (Button) findViewById(R.id.colorChangeBtn);
        registerForContextMenu(mBtn);
    }

    public void onCreateContextMenu (ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Button Menu");

        MenuItem menu1 = menu.add(0, 0, 0, "Red");
        MenuItem menu2 = menu.add(0, 1, 0, "Green");
        MenuItem menu3 = menu.add(0, 2, 0, "Blue");
    }

    public boolean onContextItemSelected(MenuItem item)
    {
        int curId = item.getItemId();

        switch(curId)
        {
            case 0:
                mBtn.setTextColor(Color.RED);
                break;
            case 1:
                mBtn.setTextColor(Color.GREEN);
                break;
            case 2:
                mBtn.setTextColor(Color.BLUE);
                break;
            default:break;
        }
        return super.onContextItemSelected(item);
    }


}
