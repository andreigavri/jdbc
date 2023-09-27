package Task1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MovieEntity {
    private int id;
    private String title;
    private String genre;
    private int yearOfRelease;

}
