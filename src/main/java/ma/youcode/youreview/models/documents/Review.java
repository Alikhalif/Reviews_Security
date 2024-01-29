package ma.youcode.youreview.models.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

@Document
public class Review {
    
    @Id
    private String id;
    private String content;

    @DBRef
    private User author;
}
