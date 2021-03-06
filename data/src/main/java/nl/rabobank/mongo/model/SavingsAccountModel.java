package nl.rabobank.mongo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Savings Account Model.
 */
@Builder
@Data
@Document(collection = "savings_account")
@AllArgsConstructor
@NoArgsConstructor
public class SavingsAccountModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String accountNumber;

    @Indexed(unique = true)
    @NotNull
    @Size(min = 2, max = 50)
    private String accountHolderName;


    @NotNull
    private Double balance;

    @NotNull
    private String userId;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SavingsAccountModel)) {
            return false;
        }
        return accountNumber != null && accountNumber.equals(((SavingsAccountModel) o).accountNumber);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
