package ma.youcode.youreview.models.documents;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

@Document
public class User {
    
    @Id
    private String id;
    private String userName;
    private String password;

    private Set<Role> roles;
}
