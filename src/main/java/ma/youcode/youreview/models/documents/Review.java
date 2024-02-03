package ma.youcode.youreview.models.documents;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

@Document
public class Review {
    
    @Id
    private UUID id;
    private String title;
    private String message;
    private LocalDateTime date;
    private Integer reactions;
    private boolean isReported;

    @DBRef
    private User author;
}
