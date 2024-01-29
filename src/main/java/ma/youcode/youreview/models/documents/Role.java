package ma.youcode.youreview.models.documents;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

@Document
public class Role {
    
    private String id;
    private String name;

    private List<User> users;
}
