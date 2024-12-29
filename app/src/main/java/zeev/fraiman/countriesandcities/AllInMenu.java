package zeev.fraiman.countriesandcities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

public class AllInMenu extends AppCompatActivity {

    String[][] sities={{"Wien","Graz","Salzburg","Bregenz","Linz"},
            {"Warsaw","Krakow","Poznan","Lodz","Pulawy","Radom","Wroclaw","Olsztyn"},
            {"Berlin","Bonn","Hannover"},
            {"Paris","Nantes","Bergerac","Mont-Dore","Montpellier","Toulouse","Toulon","Marsielle"},
            {"Roma","Bologna","Napoli","Venezia","Milano"},
            {"Madrid","Toledo","Barcelona","Malaga","Sevilla"}};
    String[] towns=null;
    String[] main;
    Context context=AllInMenu.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_in_menu);

        main=getResources().getStringArray(R.array.category);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        SubMenu[] subMenus=new SubMenu[main.length-2];
        for (int i = 2; i < main.length; i++) {
            subMenus[i-2]=menu.addSubMenu(main[i]);
            towns=sities[i];
            for (int j = 0; j < towns.length; j++) {
                subMenus[i-2].add(0,i*100+j,0,towns[j]);
            }
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();

        Toast.makeText(context, ""+id+"="+item.getTitle(), Toast.LENGTH_SHORT).show();

        return super.onContextItemSelected(item);
    }

}