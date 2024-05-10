package joaopepe10.com.github.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.ZonedDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "tbl_users")
@AllArgsConstructor
public class User extends BaseEntity{
    private String name;
    @Builder
    public User(Long id, ZonedDateTime createdAt, String name) {
        super(id, createdAt);
        this.name = name;
    }

    public User() {
        super();
    }
}
