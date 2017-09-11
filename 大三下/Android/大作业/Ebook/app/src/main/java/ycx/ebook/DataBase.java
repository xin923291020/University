package ycx.ebook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBase extends SQLiteOpenHelper
{
    public DataBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context,name,factory,version);
    }

    public void onCreate(SQLiteDatabase db)
    {
        String sql = "Create Table User" +
                "(" +
                    "Student_ID text not null," +
                    "Password text not null," +
                    "constraint PK_Studnet primary key(Student_ID)" +
                ")";
        db.execSQL(sql);
        sql = "Insert into User Values('123','123')";
        db.execSQL(sql);
        sql  = "Create Table BooksClassify" +
                "(" +
                "Classify_ID text not null," +
                "Name text not null," +
                "constraint PK_Studnet primary key(Classify_ID)" +
                ")";
        db.execSQL(sql);
        sql = "Insert into BooksClassify Values('0','玄幻');";
        db.execSQL(sql);
        sql = "Insert into BooksClassify Values('1','奇幻');";
        db.execSQL(sql);
        sql = "Insert into BooksClassify Values('2','言情');";
        db.execSQL(sql);
        sql = "Insert into BooksClassify Values('3','科幻');";
        db.execSQL(sql);
        sql = "Insert into BooksClassify Values('4','异能');";
        db.execSQL(sql);
        sql = "Insert into BooksClassify Values('5','网游');";
        db.execSQL(sql);
        sql = "Create Table Books" +
                "(" +
                "Books_ID text not null," +
                "Name text not null," +
                "Author text not null," +
                "Publisher text not null," +
                "ISBN text not null," +
                "Classify_ID text not null," +
                "constraint PK_Studnet primary key(Books_ID)," +
                "constraint FK_Classify foreign key(Classify_ID) references BooksClassify(Classify_ID)" +
                ")";
        db.execSQL(sql);
        sql = "Insert into Books Values('0','机破星河','骷髅精灵','不知道','ISBN0000','3');";
        db.execSQL(sql);
        sql = "Insert into Books Values('1','斗破苍穹','天蚕土豆','不知道','ISBN0001','0');";
        db.execSQL(sql);
        sql = "Insert into Books Values('2','盘龙','我吃西红柿','不知道','ISBN0002','1');";
        db.execSQL(sql);
        sql = "Create Table Notes" +
                "(" +
                "Notes_ID text not null," +
                "Books_ID text not null," +
                "Student_ID text not null," +
                "Content text not null," +
                "constraint PK_Studnet primary key(Notes_ID)," +
                "constraint FK_Classify foreign key(Books_ID) references Books(Books_ID)" +
                "constraint FK_Classify foreign key(Student_ID) references User(Student_ID)" +
                ")";
        db.execSQL(sql);
        sql = "Insert into Notes Values('0','0','123','不知道');";
        db.execSQL(sql);
        Log.d("Ebooks","调用DB.onCreate()");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        Log.d("Ebooks","调用DB.onUpgrade()");
    }
}
