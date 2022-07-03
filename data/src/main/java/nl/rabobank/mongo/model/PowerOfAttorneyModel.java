package nl.rabobank.mongo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.rabobank.enums.Authorization;
import nl.rabobank.service.account.Account;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Model for Power of Attorney.
 */
@Builder
@Data
@Document(collection = "power_of_attorney")
@AllArgsConstructor
@NoArgsConstructor
public class PowerOfAttorneyModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Indexed(unique = true)
    @NotNull
    private String grantorName;

    @Indexed(unique = true)
    @NotNull
    private String granteeName;

    private Account account;

    @NotNull
    private Authorization authorization;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PowerOfAttorneyModel)) {
            return false;
        }
        return id != null && id.equals(((PowerOfAttorneyModel) o).id);
    }
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
