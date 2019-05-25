package cool.zhoujie.note;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class WriteNote extends AppCompatActivity {

    private EditText input;

    private FloatingActionButton save;

    private String content;

    NoteBean noteBean = new NoteBean();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_note);
        input = findViewById(R.id.input);
        save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                content = input.getText().toString();
                noteBean.setWriteContent(content);
                noteBean.save();
                Toast.makeText(WriteNote.this, "保存成功", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
