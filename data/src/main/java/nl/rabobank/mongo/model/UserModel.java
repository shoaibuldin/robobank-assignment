package nl.rabobank.mongo.model;

import lombok.*;
import nl.rabobank.enums.RoleType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * User Model.
 */
@Builder
@Data
@Document(collection = "user")
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    @Id
    private String id;

    @Indexed(unique = true)
    @NotNull
    @Size(min = 6, max = 50)
    private String username;

    @NotNull
    @Size(min = 8, max = 50)
    private String password;

    @NotNull
    private RoleType roleType;

    private Boolean enabled;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserModel)) {
            return false;
        }
        return id != null && id.equals(((UserModel) o).id);
    }
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
