package com.example.MiniAssignment1.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DynamoDBTable(tableName="movies")
public class movie {
    @DynamoDBHashKey
   private String imdb_title_id;
   private String title;
   private String original_title;
   private int year;
   private int date_published;
   private double budget;
   private int userReviews;
   private String country;
   private String genre;
   private String language;
   private int duration;
   private String director;
   private String writer;
   private String production_company;
   private String actors;
   private String description;
   private float avg_votes;
   private int votes;
   private String usa_gross_income;
   private String worlwide_gross_income;
   private String metascore;
   private int reviews_from_users;
   private int reviews_from_critics;

    public void setTitle(String datum) {

    }

    public void setImdbTitleId(String datum) {
    }

    public void setOriginalTitle(String datum) {
    }

    public void setYear(int i) {
    }

    public void setDatePublished(String datum) {
    }

    public void setGenre(String datum) {
    }

    public void setDuration(int i) {
    }

    public void setCountry(String datum) {
    }

    public void setLanguage(String datum) {
    }

    public void setDirector(String datum) {
    }

    public void setWriter(String datum) {
    }

    public void setProductionCompany(String datum) {
    }

    public void setActors(String datum) {
    }

    public void setDescription(double v) {
    }

    public void setVotes(int i) {
    }

    public void setBudget(String datum) {
    }

    public void setUsaGrossIncome(String datum) {
    }

    public void setWorldwideGrossIncome(String datum) {
    }

    public void setMetascore(String datum) {
    }

    public void setReviewsFromUsers(int i) {
    }

    public void setReviewsFromCritics(int i) {
    }

// Getters and setters
}
