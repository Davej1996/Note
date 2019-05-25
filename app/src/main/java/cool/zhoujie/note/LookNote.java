package cool.zhoujie.note;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.LitePal;

public class LookNote extends AppCompatActivity {

    private Button delete;

    private EditText input;

    private FloatingActionButton save;

    NoteBean noteBean = new NoteBean();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look_note);
        delete = findViewById(R.id.delete);
        input = findViewById(R.id.input);
        save = findViewById(R.id.save);
        final Intent intent = getIntent();
        final String oldContent = intent.getStringExtra("key");
        input.setText(oldContent);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newContent = input.getText().toString();
                noteBean.setWriteContent(newContent);
                noteBean.updateAll("writeContent=?", oldContent);
                Toast.makeText(LookNote.this, "保存成功", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LitePal.deleteAll(NoteBean.class, "writeContent=?", oldContent);
                Toast.makeText(LookNote.this, "删除成功", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
