package joaopepe10.com.github.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "tbl_users")
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity{
    private String name;
}
