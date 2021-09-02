package com.example.cst438_homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static Intent intentFactory(Context context, int userId, String username) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("userId", userId);
        intent.putExtra("username", username);
        return intent;
    }

    private TextView textViewResult;
    private TextView showUserIdName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showUserIdName = findViewById(R.id.showUserId);
        String text = "";
        text += "Welcome " + getIntent().getStringExtra("username");
        text += " UserId: " + getIntent().getIntExtra("userId", -1);
        showUserIdName.append(text);
        textViewResult = findViewById(R.id.text_view_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Post>> call = jsonPlaceHolderApi.getPosts(getIntent().getIntExtra("userId", -1));

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Post> posts = response.body();

                for(Post post : posts) {
                    String content = "";
                    content += "User ID: " + post.getUserId() + "\n";
                    content += "ID: " + post.getId() + "\n";
                    content += "Title: " + post.getTitle() + "\n";
                    content += "Text: " + post.getText() + "\n\n";

                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
}