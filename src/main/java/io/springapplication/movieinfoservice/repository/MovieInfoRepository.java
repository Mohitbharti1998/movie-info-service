package io.springapplication.movieinfoservice.repository;


import io.springapplication.movieinfoservice.models.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieInfoRepository extends MongoRepository<Movie,String> {
}
