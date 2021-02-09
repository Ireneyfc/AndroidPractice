package com.example.litepaltest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button createDatabase = (Button) findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LitePal.getDatabase();
            }
        });
        Button addData = (Button) findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book1 = new Book();
                book1.setName("The Da Vinci Code");
                book1.setAuthor("Dan Brown");
                book1.setPress("Unknown");
                book1.setPages(454);
                book1.setPrice(16.96);
                book1.save();
                Book book2 = new Book();
                book2.setName("The Lost Symbol");
                book2.setAuthor("Dan Brown");
                book2.setPress("Unknown");
                book2.setPages(510);
                book2.setPrice(19.95);
                book2.save();

            }
        });

        Button updateData = (Button) findViewById(R.id.update_data);
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setPrice(14.95);
                book.setPress("Anchor");
                book.updateAll("name = ? and author = ?",
                        "The Lost Symbol", "Dan Brown");
            }
        });

        Button deleteData = (Button) findViewById(R.id.delete_data);
        deleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LitePal.deleteAll(Book.class, "price<?", "15");

            }
        });


        Button queryData = (Button) findViewById(R.id.query_data);
        queryData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Book> books = LitePal.findAll(Book.class);
                for (Book book : books) {
                    Log.d("MainActivity", "book name is" + book.getName());
                    Log.d("MainActivity", "book author is" + book.getAuthor());
                    Log.d("MainActivity", "book pages is" + book.getPages());
                    Log.d("MainActivity", "book price is" + book.getPrice());
                    Log.d("MainActivity", "book press is" + book.getPress());


                }

            }
        });
    }
}