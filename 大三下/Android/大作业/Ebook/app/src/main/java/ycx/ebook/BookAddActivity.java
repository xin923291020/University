package ycx.ebook;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class BookAddActivity extends AppCompatActivity
{
    private List<String> classifyID = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_add);

        Cursor cursor = getClassify();
        Spinner spinner = (Spinner) findViewById(R.id.classifyAddSpinner);
        List<String> classifyName = new ArrayList<>();
        while(cursor.moveToNext())
        {
            classifyName.add(cursor.getString(cursor.getColumnIndex("Name")));
            classifyID.add(cursor.getString(cursor.getColumnIndex("Classify_ID")));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner,classifyName);
        spinner.setAdapter(adapter);
    }

    private Cursor getClassify()
    {
        DataBase dataBase = new DataBase(this,"Ebooks",null,1);
        SQLiteDatabase dbo = dataBase.getWritableDatabase();
        String sql = "select * from BooksClassify";
        Cursor cursor = dbo.rawQuery(sql,null);
        cursor.moveToNext();
        dataBase.close();
        return cursor;
    }

    public void addButton_Click(View view)
    {
        TextView nameTextView = (TextView)findViewById(R.id.bookNameAddText);
        String name = nameTextView.getText().toString();
        TextView authorTextView = (TextView)findViewById(R.id.authorAddText);
        String author = authorTextView.getText().toString();
        TextView publisherTextView = (TextView)findViewById(R.id.publisherAddText);
        String publisher = publisherTextView.getText().toString();
        TextView ISBNTextView = (TextView)findViewById(R.id.ISBNAddText);
        String ISBN = ISBNTextView.getText().toString();
        Spinner spinner = (Spinner) findViewById(R.id.classifyAddSpinner);
        int index = spinner.getSelectedItemPosition();
        String classify = classifyID.get(index);
        addBook(name,author,publisher,ISBN,classify);
    }

    private void addBook(String name,String author,String publisher,String ISBN,String classify)
    {
        DataBase dataBase = new DataBase(this,"Ebooks",null,1);
        SQLiteDatabase dbo = dataBase.getWritableDatabase();
        String sql = "select Books_ID from Books Order By Books_ID DESC limit 1";
        Cursor cursor = dbo.rawQuery(sql,null);
        cursor.moveToNext();
        int book_ID = cursor.getInt(0);
        sql = "Insert Into Books Values('" + String.valueOf(book_ID + 1) +
                "','" + name + "','" + author + "','" + publisher + "','" + ISBN + "','" + classify + "')";
        dbo.execSQL(sql);
        cursor.close();
        dataBase.close();
        finish();
    }
}
