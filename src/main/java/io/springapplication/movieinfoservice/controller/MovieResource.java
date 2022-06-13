package io.springapplication.movieinfoservice.controller;

import io.springapplication.movieinfoservice.models.Movie;
import io.springapplication.movieinfoservice.models.Response;
import io.springapplication.movieinfoservice.repository.MovieInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/movieInfo")
public class MovieResource {

    @Autowired
    public MovieInfoRepository movieInfoRepository;

    @Autowired
    public Response response;

    @RequestMapping("/count")
    public Object getMovieInfo(){
        return Collections.singletonMap("count",movieInfoRepository.count());
    }

    @RequestMapping("/insert")
    public Object insertMovieInfo(@RequestBody Movie insert) {
        Movie movie;
        try {
            movie = movieInfoRepository.insert(insert);
            response.setStatus("success");
            response.setError(null);
            response.setData(movie);
            return response;
        } catch (org.springframework.dao.DuplicateKeyException error) {
            response.setStatus("failure");
            response.setError("Already data present with this Id");
            response.setData(insert);
            return response;
        }

    }


}
