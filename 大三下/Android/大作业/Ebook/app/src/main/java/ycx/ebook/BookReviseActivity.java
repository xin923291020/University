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

public class BookReviseActivity extends AppCompatActivity
{
    private List<String> classifyID = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_revise);

        Cursor cursor = getClassify();
        Spinner spinner = (Spinner) findViewById(R.id.classifyReviseSpinner);
        List<String> classifyName = new ArrayList<>();
        while(cursor.moveToNext())
        {
            classifyName.add(cursor.getString(cursor.getColumnIndex("Name")));
            classifyID.add(cursor.getString(cursor.getColumnIndex("Classify_ID")));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner,classifyName);
        spinner.setAdapter(adapter);
        Bundle bundle = this.getIntent().getExtras();
        String book_ID = bundle.get("book_ID").toString();
        cursor = getBook(book_ID);
        TextView nameTextView = (TextView)findViewById(R.id.bookNameEditText);
        nameTextView.setText(cursor.getString(cursor.getColumnIndex("Name")));
        TextView authorTextView = (TextView)findViewById(R.id.authorEditText);
        authorTextView.setText(cursor.getString(cursor.getColumnIndex("Author")));
        TextView publisherTextView = (TextView)findViewById(R.id.publisherEditText);
        publisherTextView.setText(cursor.getString(cursor.getColumnIndex("Publisher")));
        TextView ISBNTextView = (TextView)findViewById(R.id.ISBNEditText);
        ISBNTextView.setText(cursor.getString(cursor.getColumnIndex("ISBN")));
        String classify = cursor.getString(cursor.getColumnIndex("Classify_ID"));
        for(int i = 0;i < classifyID.size();i++)
        {
            if(classifyID.get(i).equals(classify))
            {
                spinner.setSelection(i,true);
            }
        }
    }

    public void reviseButton_Click(View view)
    {
        Bundle bundle = this.getIntent().getExtras();
        String book_ID = bundle.get("Book_ID").toString();
        TextView nameTextView = (TextView)findViewById(R.id.bookNameEditText);
        String newName = nameTextView.getText().toString();
        TextView authorTextView = (TextView)findViewById(R.id.authorEditText);
        String newAuthor = authorTextView.getText().toString();
        TextView publisherTextView = (TextView)findViewById(R.id.publisherEditText);
        String newPublisher = publisherTextView.getText().toString();
        TextView ISBNTextView = (TextView)findViewById(R.id.ISBNEditText);
        String newISBN = ISBNTextView.getText().toString();
        Spinner spinner = (Spinner) findViewById(R.id.classifyReviseSpinner);
        int index = spinner.getSelectedItemPosition();
        String classify = classifyID.get(index);
        updateBook(book_ID,newName,newAuthor,newPublisher,newISBN,classify);
    }

    private Cursor getBook(String book_ID)
    {
        DataBase dataBase = new DataBase(this,"Ebooks",null,1);
        SQLiteDatabase dbo = dataBase.getWritableDatabase();
        String sql = "select * from Books Where Books_ID = '" + book_ID + "'";
        Cursor cursor = dbo.rawQuery(sql,null);
        cursor.moveToNext();
        dataBase.close();
        return cursor;
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

    private void updateBook(String book_ID,String name,String author,String publisher,String ISBN,String classifyID)
    {
        DataBase dataBase = new DataBase(this,"Ebooks",null,1);
        SQLiteDatabase dbo = dataBase.getWritableDatabase();
        String sql = "update Books set Name = '" + name + "',Author = '" + author +
                "',Publisher = '" + publisher + "',ISBN = '" + ISBN + "',Classify_ID = '" +
                classifyID + "' Where Books_ID = '" + book_ID + "'";
        dbo.execSQL(sql);
        dataBase.close();
        finish();
    }
}
