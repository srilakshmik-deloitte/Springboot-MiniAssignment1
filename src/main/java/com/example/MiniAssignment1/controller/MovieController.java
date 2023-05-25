package com.example.MiniAssignment1.controller;


import com.example.MiniAssignment1.models.movie;
import com.example.MiniAssignment1.service.service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;

@RestController
@RequestMapping("/movies")
public class MovieController {
        private MovieController csvDataReaderService;

        public void movieController(MovieController csvDataReaderService) {

            this.csvDataReaderService = csvDataReaderService;
        }
    public MovieController(MovieController csvDataReaderService) {

            this.csvDataReaderService = csvDataReaderService;
    }



    @PostMapping("/movies/import")
    public ResponseEntity<String> importMovies() throws IOException {
            csvDataReaderService.readCSV();
            return ResponseEntity.ok("Data imported successfully."); }

    private void readCSV() {
    }

    @GetMapping("/{id}")
    public ResponseEntity<movie> getMovie(@PathVariable("id") Long id) {

        movie Movie = null;

        if (Movie != null) {
            return ResponseEntity.ok(Movie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable("id") Long id) {


        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

