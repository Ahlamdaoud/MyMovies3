package com.example.mymovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import com.example.mymovies.Controller.MoviesAdapter;
import com.example.mymovies.Model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

 private List<Movie> movieList=new ArrayList<>();
 private RecyclerView recyclerView;
 private MoviesAdapter moviesAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        recyclerView=findViewById(R.id.recyclerview);
        moviesAdapter=new MoviesAdapter(movieList);
       // RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getApplicationContext());
        recyclerView.setAdapter(moviesAdapter);
        //recyclerView.setItemAnimator(new DefaultItemAnimator());
        //recyclerView.setAdapter(moviesAdapter);
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        fillMovieList();


    }

    private void fillMovieList() {


        Movie movie1 =new Movie("Akira","Anime","2016",R.drawable.a1);
        movieList.add(movie1);

        Movie movie2 =new Movie("Antebellum","Drama","2020",R.drawable.a2);
        movieList.add(movie2);

        Movie movie3 =new Movie("The Broken Hearts Gallery","romantic | comedy ","2020",R.drawable.a3);
        movieList.add(movie3);

        Movie movie4=new Movie("Back to the Future","science"," 1985",R.drawable.a4);
        movieList.add(movie4);

        Movie movie5 =new Movie("The Silence of the Lambs","Action","1991",R.drawable.a5);
        movieList.add(movie5);

        Movie movie6 =new Movie("Mulan","Action","2020",R.drawable.a6);
        movieList.add(movie6);

        Movie movie7 =new Movie("The War with Grandpa","Comedy","2019",R.drawable.a7);
        movieList.add(movie7);

        Movie movie8 =new Movie("I'm Thinking of Ending Things","Horror","2020",R.drawable.a8);
        movieList.add(movie8);

        Movie movie9 =new Movie("Iron Man","Action","2008",R.drawable.a9);
        movieList.add(movie9);

        Movie movie10 =new Movie("Dragon Ball Super","Action|Cartoon","2015",R.drawable.a10);
        movieList.add(movie10);

        Movie movie11 =new Movie("The New Mutants","Action|Horror","2020",R.drawable.a11);
        movieList.add(movie11);

        Movie movie12 =new Movie("Bill & Ted Face the Music","Comedy","2019",R.drawable.a12);
        movieList.add(movie12);

        moviesAdapter.notifyDataSetChanged();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu,menu);
        MenuItem item=menu.findItem(R.id.action_search);
        SearchView searchView=(SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                moviesAdapter.getFilter().filter(newText);
                return false;
            }
        });



        return super.onCreateOptionsMenu(menu);
    }



}