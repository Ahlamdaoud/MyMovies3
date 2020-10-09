package com.example.mymovies.Controller;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymovies.Model.Movie;
import com.example.mymovies.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder>implements Filterable {
 List<Movie> moviesList;
List<Movie> movielistfull;






    public MoviesAdapter(List<Movie> moviesList) {

        this.moviesList = moviesList;
        this.movielistfull=new ArrayList<>(moviesList);
        //movielistfull=new ArrayList<>(moviesList);

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_rows,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
      Movie movie=moviesList.get(position);
      holder.title.setText(movie.getTitle());
      holder.year.setText(movie.getYear());
        holder.genre.setText(movie.getGenre());
        holder.image.setImageResource(movie.getImage());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder {
        private TextView title,genre,year;
        private ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            title= itemView.findViewById(R.id.mytitle);
            year= itemView.findViewById(R.id.year);
            genre= itemView.findViewById(R.id.genre);
            image= itemView.findViewById(R.id.imageView);
        }
    }

    @Override
    public Filter getFilter() {

        return moviesFilter;
    }

    private Filter moviesFilter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            List<Movie> filteredList =new ArrayList<>();
            if(constraint==null|| constraint.length()==0){
                filteredList.addAll(movielistfull);
            }else
            {
                String filterPattern=constraint.toString().toLowerCase().trim();


                for (Movie item:movielistfull ){
                    if(item.getTitle().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }

            }

            FilterResults results=new FilterResults();
            results.values=filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            moviesList.clear();
            moviesList.addAll((Collection<? extends Movie>) results.values);
            notifyDataSetChanged();
        }
    };
}
