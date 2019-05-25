package cool.zhoujie.note;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    private FloatingActionButton create;

    private ArrayAdapter<String> adapter;

    private List<NoteBean> notelist = new ArrayList<>();

    private List<String> datalist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        create = findViewById(R.id.create);
        listView = findViewById(R.id.list_view);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String content = datalist.get(position);
                Intent intent = new Intent(MainActivity.this, LookNote.class);
                intent.putExtra("key", content);
                startActivity(intent);
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WriteNote.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1
                , datalist);
        notelist = LitePal.findAll(NoteBean.class);
        if (notelist.size() > 0) {
            datalist.clear();
            for (NoteBean noteBean : notelist) {
                datalist.add(noteBean.getWriteContent());
            }
        }
        listView.setAdapter(adapter);
    }
}
