package ycx.ebook;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class UserAddActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_add);
    }

    public void userAddButton_Click(View view)
    {
        TextView student_IDViewText = (TextView)findViewById(R.id.userAddText);
        String student_ID = student_IDViewText.getText().toString();
        TextView passwordViewText = (TextView)findViewById(R.id.passwordAddText);
        String password = passwordViewText.getText().toString();
        TextView passwordConfirmViewText = (TextView)findViewById(R.id.passwordConfirmText);
        String passwordConfirm = passwordConfirmViewText.getText().toString();
        if(passwordConfirm.equals(password))
        {
            userAdd(student_ID,password);
            finish();
        }
        else
        {
            Toast.makeText(this,"密码不一致",Toast.LENGTH_LONG);
        }
    }

    private void userAdd(String student_ID,String password)
    {
        DataBase dataBase = new DataBase(this,"Ebooks",null,1);
        SQLiteDatabase dbo = dataBase.getWritableDatabase();
        String sql = "Insert Into User Values('" + student_ID + "','" + password + "')";
        dbo.execSQL(sql);
        dataBase.close();
    }
}
