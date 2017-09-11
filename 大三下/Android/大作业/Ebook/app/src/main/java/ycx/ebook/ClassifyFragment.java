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


public class ClassifyFragment extends Fragment
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
                R.layout.list_classify,  //ListItem的XML布局实现
                new String[] {"ItemID","ItemButton",},     //动态数组与ImageItem对应的子项
                new int[ ] {R.id.UserID,R.id.userEditButton}      //list_book.xml布局文件里面的一个ImageView的ID,一个TextView 的ID
        );
        listView.setAdapter(listItemAdapter);
    }
    private void getUserArrayList()
    {
        DataBase dataBase = new DataBase(getActivity(),"Ebooks",null,1);
        SQLiteDatabase dbo = dataBase.getWritableDatabase();
        String sql = "select * from BooksClassify";
        Cursor cursor = dbo.rawQuery(sql,null);
        while (cursor.moveToNext())
        {
            HashMap<String, Object> map = new HashMap<String, Object>();
            String id = cursor.getString(cursor.getColumnIndex("Classify_ID"));
            String name = cursor.getString(cursor.getColumnIndex("Name"));
            map.put("ItemID","编号：" + id + "\t类别：" + name);   //存储id
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
}
