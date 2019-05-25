package cool.zhoujie.note;

import org.litepal.crud.LitePalSupport;

public class NoteBean extends LitePalSupport {

    private int id;

    private String writeContent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWriteContent() {
        return writeContent;
    }

    public void setWriteContent(String writeContent) {
        this.writeContent = writeContent;
    }
}
