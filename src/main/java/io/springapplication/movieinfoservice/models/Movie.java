package io.springapplication.movieinfoservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Document(collection = "movieInfo")
public class Movie {


    @Id
    private long id;

    private List<String> type;

    private String description;

    private List<String> director;

    private List<String> writer;

    private List<String> stars;


}
