package com.example.MiniAssignment1.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.example.MiniAssignment1.models.movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public <Movie> Movie save(Movie movie) {
        dynamoDBMapper.save(movie);
        return movie;
    }


    public movie getMovieByID(String imdb_title_id){
        return dynamoDBMapper.load(movie.class, imdb_title_id);
    }

    public String delete(String imdb_title_id) {
        movie Movie = dynamoDBMapper.load(movie.class, imdb_title_id);
        dynamoDBMapper.delete(Movie);
        return "Movie Deleted";
    }

    public String update(String imdb_title_id, movie Movie) {
        dynamoDBMapper.save(Movie,
                new DynamoDBSaveExpression()
                        .withExpectedEntry("imdb_title_id",
                                new ExpectedAttributeValue(
                                        new AttributeValue().withS(imdb_title_id)
                                )));
        return imdb_title_id;
    }
}
