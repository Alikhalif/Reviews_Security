package ma.youcode.youreview.models.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.youcode.youreview.models.documents.User;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ReviewDto {
    
    private UUID id;

    @NotEmpty
    private String title;
    private String message;
    private LocalDateTime date;
    private Integer reactions = 1;

    private User author;
}
