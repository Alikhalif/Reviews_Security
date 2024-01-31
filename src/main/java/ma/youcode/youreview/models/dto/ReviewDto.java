package ma.youcode.youreview.models.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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

    @NotEmpty
    private String message;
    private Integer reactions;

    @NotNull
    private User author;
}
