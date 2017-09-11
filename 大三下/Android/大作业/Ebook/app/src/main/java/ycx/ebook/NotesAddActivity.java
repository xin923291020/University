package ycx.ebook;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class NotesAddActivity extends AppCompatActivity
{
    private String student_ID;
    private String book_ID;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_add);
        Bundle bundle = this.getIntent().getExtras();
        student_ID = bundle.getString("student_ID");
        book_ID = bundle.getString("book_ID");
    }

    public void notesAddButton_Click(View view)
    {
        EditText notesEditText = (EditText)findViewById(R.id.NotesText);
        addNotes(notesEditText.getText().toString());
        finish();
    }

    private void addNotes(String content)
    {
        DataBase dataBase = new DataBase(this,"Ebooks",null,1);
        SQLiteDatabase dbo = dataBase.getWritableDatabase();
        String sql = "select Notes_ID from Notes Order By Notes_ID DESC limit 1";
        Cursor cursor = dbo.rawQuery(sql,null);
        cursor.moveToNext();
        int Notes_ID = cursor.getInt(0);
        sql = "Insert Into Notes Values('" + String.valueOf(Notes_ID + 1) +
                "','" + book_ID + "','" + student_ID + "','" + content + "')";
        dbo.execSQL(sql);
        dataBase.close();
    }
}
