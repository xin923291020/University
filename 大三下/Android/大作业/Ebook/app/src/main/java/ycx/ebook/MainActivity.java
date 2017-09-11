package ycx.ebook;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private Fragment fragment;
    private int fragmentFlag = 1;
    private String student_ID;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle bundle = this.getIntent().getExtras();
        student_ID = bundle.getString("student_ID");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.book_add);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(fragmentFlag == 1)
                {
                    Intent intent = new Intent(MainActivity.this,BookAddActivity.class);
                    startActivity(intent);
                }
                else if(fragmentFlag == 2)
                {
                    Intent intent = new Intent(MainActivity.this,UserAddActivity.class);
                    startActivity(intent);
                }
                else if(fragmentFlag == 3)
                {
                    LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
                    final View classifyReviseView = layoutInflater.inflate(R.layout.classify_add, null);
                    Dialog alertDialog = new AlertDialog.Builder(MainActivity.this).
                            setTitle("新增类别").
                            setView(classifyReviseView).
                            setNegativeButton("确认", new DialogInterface.OnClickListener()
                            {
                                @Override
                                public void onClick(DialogInterface dialog, int which)
                                {
                                    EditText classifyReviseEditView = (EditText)classifyReviseView.findViewById(R.id.classifyAdd);
                                    String classify = classifyReviseEditView.getText().toString();
                                    addClassify(classify);
                                    initClassifyFragment();
                                }
                            }).
                            setPositiveButton("取消", new DialogInterface.OnClickListener()
                            {
                                @Override
                                public void onClick(DialogInterface dialog, int which)
                                {
                                }
                            }).
                            create();
                    alertDialog.show();
                }
                else if(fragmentFlag == 4)
                {
                    String message = notesCount();
                    Dialog alertDialog = new AlertDialog.Builder(MainActivity.this).
                            setTitle("数量汇总").
                            setMessage(message).
                            create();
                    alertDialog.show();
                }
                else if(fragmentFlag == 5)
                {
                    Toast.makeText(MainActivity.this,"未定义操作",Toast.LENGTH_SHORT);
                }
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initBookFragment();
    }

    private void initBookFragment()
    {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragment = new BookFragment();
        fragmentTransaction.replace(R.id.content_main,fragment);
        fragmentTransaction.commit();
    }

    private void initUserFragment()
    {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragment = new UserFragment();
        fragmentTransaction.replace(R.id.content_main,fragment);
        fragmentTransaction.commit();
    }

    private void initClassifyFragment()
    {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragment = new ClassifyFragment();
        fragmentTransaction.replace(R.id.content_main,fragment);
        fragmentTransaction.commit();
    }

    private void initNotesFragment()
    {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragment = new NotesFragment();
        fragmentTransaction.replace(R.id.content_main,fragment);
        fragmentTransaction.commit();
    }

    private void initCountFragment()
    {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragment = new CountFragment();
        fragmentTransaction.replace(R.id.content_main,fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.writeOff)
        {
            finish();
            Intent intent = new Intent(this,Login.class);
            startActivity(intent);
        }
        else if(id == R.id.about)
        {
            Dialog alertDialog = new AlertDialog.Builder(MainActivity.this).
                    setTitle("关于").
                    setMessage("版本：V1.0\n开发人员：杨程鑫\n开发时间：2017/4/7-2017/4/13").
                    create();
            alertDialog.show();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.book)
        {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content_main,new BookFragment());
            fragmentTransaction.commit();
            fragmentFlag = 1;
        }
        else if (id == R.id.user)
        {
            initUserFragment();
            fragmentFlag = 2;
        }
        else if (id == R.id.classify)
        {
            initClassifyFragment();
            fragmentFlag = 3;
        }
        else if (id == R.id.notes)
        {
            initNotesFragment();
            fragmentFlag = 4;
        }
        else if(id == R.id.notesCount)
        {
            initCountFragment();
            fragmentFlag = 5;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void bookReviseButton_Click(View view)
    {
        showBookPopupMenu(view);
    }
    private void showBookPopupMenu(final View view)
    {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.book_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener()
        {
            @Override
            public boolean onMenuItemClick(MenuItem item)
            {
                LinearLayout linearLayout = (LinearLayout) view.getParent();
                TextView textView = (TextView) linearLayout.getChildAt(0);
                String book_ID = textView.getText().toString();
                if(item.getItemId() == R.id.notes_add)
                {
                    Bundle bundle = new Bundle();
                    bundle.putString("student_ID",student_ID);
                    bundle.putString("book_ID",book_ID);
                    Intent intent = new Intent(MainActivity.this,NotesAddActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.book_revise)
                {
                    Bundle bundle = new Bundle();
                    bundle.putString("book_ID",book_ID);
                    Intent intent = new Intent(MainActivity.this,BookReviseActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.info_show)
                {
                    Cursor cursor = getBook(book_ID);
                    String name = cursor.getString(cursor.getColumnIndex("Name"));
                    String author = cursor.getString(cursor.getColumnIndex("Author"));
                    String publisher = cursor.getString(cursor.getColumnIndex("Publisher"));
                    String ISBN = cursor.getString(cursor.getColumnIndex("ISBN"));
                    String classify_id = cursor.getString(cursor.getColumnIndex("Classify_ID"));
                    String classify = getClassifyName(classify_id);
                    Dialog alertDialog = new AlertDialog.Builder(MainActivity.this).
                            setTitle(name).
                            setMessage("作者：" + author + "\n" + "分类：" + classify + "\n"
                                    + "出版社：" + publisher + "\n" + "ISBN：" + ISBN).
                            create();
                    alertDialog.show();
                }
                else if(item.getItemId() == R.id.book_del)
                {
                    bookDelete(book_ID);
                    initBookFragment();
                }
                return false;
            }
        });
        popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener()
        {
            @Override
            public void onDismiss(PopupMenu menu)
            {
                return;
            }
        });
        popupMenu.show();
    }

    public void notesReviseButton_Click(View view)
    {
        showNotesPopupMenu(view);
    }
    private void showNotesPopupMenu(final View view)
    {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.notes_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener()
        {
            @Override
            public boolean onMenuItemClick(MenuItem item)
            {
                LinearLayout linearLayout = (LinearLayout) view.getParent();
                TextView notesTextView = (TextView) linearLayout.getChildAt(0);
                String notes_ID = notesTextView.getText().toString();
                TextView contentTextView = (TextView) linearLayout.getChildAt(2);
                String content = contentTextView.getText().toString();
                if(item.getItemId() == R.id.notes_revise)
                {
                    Bundle bundle = new Bundle();
                    bundle.putString("notes_ID",notes_ID);
                    bundle.putString("content",content);
                    Intent intent = new Intent(MainActivity.this,NotesReviseActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.notes_del)
                {
                    notesDelete(notes_ID);
                    initNotesFragment();
                }
                return false;
            }
        });
        popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener()
        {
            @Override
            public void onDismiss(PopupMenu menu)
            {
                return;
            }
        });
        popupMenu.show();
    }

    public void userEditButton_Click(View view)
    {
        showUserPopupMenu(view);
    }
    private void showUserPopupMenu(final View view)
    {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.user_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener()
        {
            @Override
            public boolean onMenuItemClick(MenuItem item)
            {
                LinearLayout linearLayout = (LinearLayout) view.getParent();
                TextView textView = (TextView) linearLayout.getChildAt(0);
                String[] textViewString = textView.getText().toString().split("：");
                final String student_ID = textViewString[1];
                if(item.getItemId() == R.id.password_revise)
                {
                    LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
                    final View passwordReviseView = layoutInflater.inflate(R.layout.password_revise, null);
                    Dialog alertDialog = new AlertDialog.Builder(MainActivity.this).
                            setTitle("修改密码").
                            setView(passwordReviseView).
                            setNegativeButton("确认", new DialogInterface.OnClickListener()
                            {
                                @Override
                                public void onClick(DialogInterface dialog, int which)
                                {
                                    EditText passwordReviseEditView = (EditText)passwordReviseView.findViewById(R.id.passwordRevise);
                                    String newPassword = passwordReviseEditView.getText().toString();
                                    EditText passwordReviseConfirmEditView = (EditText)passwordReviseView.findViewById(R.id.passwordReviseConfirm);
                                    String newPasswordConfirm = passwordReviseConfirmEditView.getText().toString();
                                    if(newPassword.equals(newPasswordConfirm))
                                    {
                                        updatePassword(student_ID,newPassword);
                                    }
                                }
                            }).
                            setPositiveButton("取消", new DialogInterface.OnClickListener()
                            {
                                @Override
                                public void onClick(DialogInterface dialog, int which)
                                {
                                }
                            }).
                            create();
                    alertDialog.show();
                }
                else if(item.getItemId() == R.id.password_show)
                {

                    Cursor cursor = getUser(student_ID);
                    String name = cursor.getString(cursor.getColumnIndex("Password"));
                    Dialog alertDialog = new AlertDialog.Builder(MainActivity.this).
                            setTitle("账号：" + student_ID).
                            setMessage("密码：" + name).
                            create();
                    alertDialog.show();
                }
                else if(item.getItemId() == R.id.user_del)
                {
                    userDelete(student_ID);
                    initUserFragment();
                }
                return false;
            }
        });
        popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener()
        {
            @Override
            public void onDismiss(PopupMenu menu)
            {
                return;
            }
        });
        popupMenu.show();
    }

    public void classifyEditButton_Click(View view)
    {
        showClassifyPopupMenu(view);
    }
    private void showClassifyPopupMenu(final View view)
    {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.classify_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener()
        {
            @Override
            public boolean onMenuItemClick(MenuItem item)
            {
                LinearLayout linearLayout = (LinearLayout) view.getParent();
                TextView textView = (TextView) linearLayout.getChildAt(0);
                String[] textViewString = textView.getText().toString().split("\\t");
                String[] textViewPrefixString = textViewString[0].split("：");
                final String classify_ID = textViewPrefixString[1];
                if(item.getItemId() == R.id.classify_revise)
                {
                    LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
                    final View classifyReviseView = layoutInflater.inflate(R.layout.classify_revise, null);
                    Dialog alertDialog = new AlertDialog.Builder(MainActivity.this).
                            setTitle("修改类别").
                            setView(classifyReviseView).
                            setNegativeButton("确认", new DialogInterface.OnClickListener()
                            {
                                @Override
                                public void onClick(DialogInterface dialog, int which)
                                {
                                    EditText classifyReviseEditView = (EditText)classifyReviseView.findViewById(R.id.classifyRevise);
                                    String newClassify = classifyReviseEditView.getText().toString();
                                    updateClassify(classify_ID,newClassify);
                                    initClassifyFragment();
                                }
                            }).
                            setPositiveButton("取消", new DialogInterface.OnClickListener()
                            {
                                @Override
                                public void onClick(DialogInterface dialog, int which)
                                {
                                }
                            }).
                            create();
                    alertDialog.show();
                }
                else if(item.getItemId() == R.id.classify_del)
                {
                    classifyDelete(classify_ID);
                    initClassifyFragment();
                }
                return false;
            }
        });
        popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener()
        {
            @Override
            public void onDismiss(PopupMenu menu)
            {
                return;
            }
        });
        popupMenu.show();
    }

    private String getClassifyName(String classify)
    {
        DataBase dataBase = new DataBase(this,"Ebooks",null,1);
        SQLiteDatabase dbo = dataBase.getWritableDatabase();
        String sql = "select * from BooksClassify Where Classify_ID = '" + classify + "'";
        Cursor cursor = dbo.rawQuery(sql,null);
        cursor.moveToNext();
        dataBase.close();
        return cursor.getString(cursor.getColumnIndex("Name"));
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

    private Cursor getUser(String student_ID)
    {
        DataBase dataBase = new DataBase(this,"Ebooks",null,1);
        SQLiteDatabase dbo = dataBase.getWritableDatabase();
        String sql = "select * from User Where Student_ID = '" + student_ID + "'";
        Cursor cursor = dbo.rawQuery(sql,null);
        cursor.moveToNext();
        dataBase.close();
        return cursor;
    }

    private void bookDelete(String book_ID)
    {
        DataBase dataBase = new DataBase(this,"Ebooks",null,1);
        SQLiteDatabase dbo = dataBase.getWritableDatabase();
        String sql = "delete from Books Where Books_ID = '" + book_ID + "'";
        dbo.execSQL(sql);
        dataBase.close();
    }

    private void userDelete(String student_ID)
    {
        DataBase dataBase = new DataBase(this,"Ebooks",null,1);
        SQLiteDatabase dbo = dataBase.getWritableDatabase();
        String sql = "delete from User Where Student_ID = '" + student_ID + "'";
        dbo.execSQL(sql);
        dataBase.close();
    }

    private void classifyDelete(String classify_ID)
    {
        DataBase dataBase = new DataBase(this,"Ebooks",null,1);
        SQLiteDatabase dbo = dataBase.getWritableDatabase();
        String sql = "delete from BooksClassify Where Classify_ID = '" + classify_ID + "'";
        dbo.execSQL(sql);
        dataBase.close();
    }

    private void notesDelete(String notes_ID)
    {
        DataBase dataBase = new DataBase(this,"Ebooks",null,1);
        SQLiteDatabase dbo = dataBase.getWritableDatabase();
        String sql = "delete from Notes Where Notes_ID = '" + notes_ID + "'";
        dbo.execSQL(sql);
        dataBase.close();
    }

    private void updatePassword(String student_ID,String newPassword)
    {
        DataBase dataBase = new DataBase(this,"Ebooks",null,1);
        SQLiteDatabase dbo = dataBase.getWritableDatabase();
        String sql = "update User Set Password = '" + newPassword + "' Where Student_ID = '" + student_ID + "'";
        dbo.execSQL(sql);
        dataBase.close();
    }

    private void updateClassify(String classify_ID,String newClassify)
    {
        DataBase dataBase = new DataBase(this,"Ebooks",null,1);
        SQLiteDatabase dbo = dataBase.getWritableDatabase();
        String sql = "update BooksClassify Set Name = '" + newClassify + "' Where Classify_ID = '" + classify_ID + "'";
        dbo.execSQL(sql);
        dataBase.close();
    }

    private void addClassify(String classify)
    {
        DataBase dataBase = new DataBase(this,"Ebooks",null,1);
        SQLiteDatabase dbo = dataBase.getWritableDatabase();
        String sql = "select Classify_ID from BooksClassify Order By Classify_ID DESC limit 1";
        Cursor cursor = dbo.rawQuery(sql,null);
        cursor.moveToNext();
        int classify_ID = cursor.getInt(0);
        sql = "Insert Into BooksClassify Values('" + String.valueOf(classify_ID + 1) + "','" + classify + "')";
        dbo.execSQL(sql);
        dataBase.close();
    }

    private String notesCount()
    {
        DataBase dataBase = new DataBase(this,"Ebooks",null,1);
        SQLiteDatabase dbo = dataBase.getWritableDatabase();
        String sql = "select Count(*),Books_ID from Notes Where Student_ID = '" + student_ID + "' Group By Books_ID";
        Cursor cursor = dbo.rawQuery(sql,null);
        String message = "";
        while(cursor.moveToNext())
        {
           message += getBookName(cursor.getString(1)) + "：";
           message += cursor.getString(0) + "\n";
        }
        dataBase.close();
        return message;
    }

    private String getBookName(String book_ID)
    {
        DataBase dataBase = new DataBase(this,"Ebooks",null,1);
        SQLiteDatabase dbo = dataBase.getWritableDatabase();
        String sql = "select * from Books Where Books_ID = '" + book_ID + "'";
        Cursor cursor = dbo.rawQuery(sql,null);
        cursor.moveToNext();
        String bookName = cursor.getString(cursor.getColumnIndex("Name"));
        dataBase.close();
        return bookName;
    }
}
