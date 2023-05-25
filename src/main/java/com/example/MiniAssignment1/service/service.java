package com.example.MiniAssignment1.service;

import com.example.MiniAssignment1.models.movie;
import com.example.MiniAssignment1.repository.MovieRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.csv.CSVParser;
import java.io.*;
import java.nio.file.Paths;

import static java.nio.file.Files.newBufferedReader;

@Service
    public class service {

        private final MovieRepository movieRepository;
        private static final String CSV_File="C:/Users/srkomirisetti/Downloads/movies.csv";


        @Autowired
        public service(MovieRepository movieRepository) {

            this.movieRepository = movieRepository;
        }

        public void readCSV() throws IOException {
            try (Reader reader = newBufferedReader(Paths.get(CSV_File));
                 CSVParser csvparser= new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader()))
            {
                for (CSVRecord csvRecord:csvparser ){
                    movie Movie = new movie();
                    Movie.setTitle(csvRecord.get("title"));
                    Movie.setImdbTitleId(csvRecord.get("imdb_title_id"));
                    Movie.setOriginalTitle(csvRecord.get("original_title"));
                    Movie.setYear(Integer.parseInt(csvRecord.get("year")));
                    Movie.setDatePublished(csvRecord.get("date_published"));
                    Movie.setGenre(csvRecord.get("genre"));
                    Movie.setDuration(Integer.parseInt(csvRecord.get("duration")));
                    Movie.setCountry(csvRecord.get("country"));
                    Movie.setLanguage(csvRecord.get("language"));
                    Movie.setDirector(csvRecord.get("director"));
                    Movie.setWriter(csvRecord.get("writer"));
                    Movie.setProductionCompany(csvRecord.get("production_company"));
                    Movie.setActors(csvRecord.get("actors"));
                    Movie.setDescription(Double.parseDouble(String.valueOf(Double.parseDouble(csvRecord.get("description")))));
                    Movie.setVotes(Integer.parseInt(csvRecord.get("votes")));
                    Movie.setBudget(csvRecord.get("budget"));
                    Movie.setUsaGrossIncome(csvRecord.get("usa_gross_income"));
                    Movie.setWorldwideGrossIncome(csvRecord.get("worldwide_gross_income"));
                    Movie.setMetascore(csvRecord.get("metascore"));
                    Movie.setReviewsFromUsers(Integer.parseInt(csvRecord.get("reviews_from_users")));
                    Movie.setReviewsFromCritics(Integer.parseInt(csvRecord.get("reviews_from_critics")));


                    movieRepository.save(Movie);


                }
            }catch (IOException e) {
                e.printStackTrace();
            }// Handle the exception
        }


    }

