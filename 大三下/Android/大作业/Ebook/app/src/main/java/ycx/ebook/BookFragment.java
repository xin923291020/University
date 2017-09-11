package ycx.ebook;

import android.database.Cursor;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.database.sqlite.SQLiteDatabase;


public class BookFragment extends Fragment
{
    private ArrayList<HashMap<String, Object>> listItems = new ArrayList<>();    //存放文字、图片信息
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState)
    {
        listView = (ListView)inflater.inflate(R.layout.fragment,this.listView);
        return listView;
    }

    private void initListView()
    {
        listItems.clear();
        getBooksArrayList();
        //生成适配器的Item和动态数组对应的元素
        SimpleAdapter listItemAdapter = new SimpleAdapter(getActivity(),
                listItems,   // listItems数据源
                R.layout.list_book,  //ListItem的XML布局实现
                new String[] {"ItemImage","ItemID","ItemTitle","ItemButton",},     //动态数组与ImageItem对应的子项
                new int[ ] {R.id.BookImage,R.id.BookID,R.id.BookTitle,R.id.bookReviseButton}      //list_book.xml布局文件里面的一个ImageView的ID,一个TextView 的ID
        );
        listView.setAdapter(listItemAdapter);
    }
    private void getBooksArrayList()
    {
        DataBase dataBase = new DataBase(getActivity(),"Ebooks",null,1);
        SQLiteDatabase dbo = dataBase.getWritableDatabase();
        String sql = "select * from Books";
        Cursor cursor = dbo.rawQuery(sql,null);
        while (cursor.moveToNext())
        {
            HashMap<String, Object> map = new HashMap<>();
            String id = cursor.getString(cursor.getColumnIndex("Books_ID"));
            String name = cursor.getString(cursor.getColumnIndex("Name"));
            String author = cursor.getString(cursor.getColumnIndex("Author"));
            map.put("ItemID",id);   //存储id
            map.put("ItemImage", R.drawable.camera);   //图片
            map.put("ItemTitle", "\t" + name +  "\t" + author);
            map.put("ItemButton","编辑");   //按钮
            listItems.add(map);
        }
        cursor.close();
        dataBase.close();
    }

    @Override
    public void onResume()
    {
        super.onResume();
        initListView();
    }
}
