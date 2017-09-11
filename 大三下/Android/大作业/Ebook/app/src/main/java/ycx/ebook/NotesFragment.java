package ycx.ebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.database.sqlite.SQLiteDatabase;


public class NotesFragment extends Fragment
{
    private ArrayList<HashMap<String, Object>> listItems = new ArrayList<HashMap<String, Object>>();;    //存放文字、图片信息
    private SimpleAdapter listItemAdapter;           //适配器
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState)
    {
        listView = (ListView)inflater.inflate(R.layout.fragment,null);
        return listView;
    }

    private void initListView()
    {
        listItems.clear();
        getUserArrayList();
        //生成适配器的Item和动态数组对应的元素
        listItemAdapter = new SimpleAdapter(getActivity(),
                listItems,   // listItems数据源
                R.layout.list_notes,  //ListItem的XML布局实现
                new String[] {"NotesID","BooksID","Content","ItemButton",},     //动态数组与ImageItem对应的子项
                new int[ ] {R.id.notes_ID,R.id.book_ID,R.id.content,R.id.notesEditButton}      //list_book.xml布局文件里面的一个ImageView的ID,一个TextView 的ID
        );
        listView.setAdapter(listItemAdapter);
    }
    private void getUserArrayList()
    {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("User",Context.MODE_PRIVATE);
        String student_ID = sharedPreferences.getString("student_ID","");
        DataBase dataBase = new DataBase(getActivity(),"Ebooks",null,1);
        SQLiteDatabase dbo = dataBase.getWritableDatabase();
        String sql = "select * from Notes Where Student_ID = '" + student_ID + "'";
        Cursor cursor = dbo.rawQuery(sql,null);
        while (cursor.moveToNext())
        {
            HashMap<String, Object> map = new HashMap<String, Object>();
            String notes_ID = cursor.getString(cursor.getColumnIndex("Notes_ID"));
            String books_ID = cursor.getString(cursor.getColumnIndex("Books_ID"));
            String content = cursor.getString(cursor.getColumnIndex("Content"));
            map.put("NotesID",notes_ID);   //存储id
            map.put("BooksID",getBookName(books_ID));   //存储id
            map.put("Content",content);   //存储id
            map.put("ItemButton","编辑");   //按钮
            listItems.add(map);
        }
        dataBase.close();
    }

    @Override
    public void onResume()
    {
        super.onResume();
        initListView();
    }

    private String getBookName(String book_ID)
    {
        DataBase dataBase = new DataBase(getActivity(),"Ebooks",null,1);
        SQLiteDatabase dbo = dataBase.getWritableDatabase();
        String sql = "select * from Books Where Books_ID = '" + book_ID + "'";
        Cursor cursor = dbo.rawQuery(sql,null);
        cursor.moveToNext();
        String bookName = cursor.getString(cursor.getColumnIndex("Name"));
        dataBase.close();
        return bookName;
    }
}
