package ycx.ebook;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class NotesReviseActivity extends AppCompatActivity
{
    private String notes_ID;
    private String content;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_revise);
        Bundle bundle = this.getIntent().getExtras();
        notes_ID = bundle.getString("notes_ID");
        content = bundle.getString("content");
        final EditText notesEditText = (EditText)findViewById(R.id.NotesReviseText);
        notesEditText.setText(content);
        notesEditText.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {
            }
            @Override
            public void afterTextChanged(Editable editable)
            {
                updateNotes(notesEditText.getText().toString());
            }
        });
    }

    private void updateNotes(String content)
    {
        DataBase dataBase = new DataBase(this,"Ebooks",null,1);
        SQLiteDatabase dbo = dataBase.getWritableDatabase();
        String sql = "Update Notes Set Content = '" + content + "' Where Notes_ID = '" + notes_ID + "'";
        dbo.execSQL(sql);
        dataBase.close();
    }
}
