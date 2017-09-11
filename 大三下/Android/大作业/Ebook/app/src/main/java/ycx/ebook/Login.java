package ycx.ebook;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.database.Cursor;

public class Login extends AppCompatActivity
{
    private DataBase dataBase = new DataBase(this,"Ebooks",null,1);
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        dataBase.getReadableDatabase();
        setContentView(R.layout.activity_login);
    }

    public void loginButton_click(View view)
    {
        SQLiteDatabase dbo = dataBase.getWritableDatabase();
        TextView userText = (TextView)findViewById(R.id.loginUserTextView);
        String student_ID = userText.getText().toString();
        TextView passwordText = (TextView)findViewById(R.id.loginPasswordTextView);
        String password = passwordText.getText().toString();
        String sql = "Select Password from User Where Student_ID = '" + student_ID + "'";
        Cursor cursor = dbo.rawQuery(sql,null);
        while (cursor.moveToNext())
        {
            String realPassword = cursor.getString(cursor.getColumnIndex("Password"));
            if(password.equals(realPassword))
            {
                SharedPreferences sharedPreferences = this.getSharedPreferences("User",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("student_ID",student_ID);
                editor.commit();
                Bundle bundle = new Bundle();
                bundle.putString("student_ID",student_ID);
                Intent intent = new Intent(this,MainActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        }
        cursor.close();
        dataBase.close();
    }
}
