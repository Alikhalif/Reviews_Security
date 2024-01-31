package ma.youcode.youreview.models.documents;

import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

@Document
public class Role implements GrantedAuthority {
    
    @Id
    private UUID id;
    private String name;

    private List<User> users;

    @Override
    public String getAuthority() {
        return name;
    }
}
