package kr.hs.dimigo.meal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class InfoActivity extends AppCompatActivity {

    private Toolbar infoToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        infoToolbar = findViewById(R.id.infoToolbar);
        setSupportActionBar(infoToolbar);
        getSupportActionBar().setTitle("디미밥 정보");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home :
                finish();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
