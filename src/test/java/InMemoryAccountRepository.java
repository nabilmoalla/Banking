import com.banking.domain.model.Account;
import com.banking.domain.port.secondary.AccountRepository;

import java.util.Optional;

public class InMemoryAccountRepository implements AccountRepository {

    private Account account;

    public InMemoryAccountRepository(Account account) {
        this.account = account;
    }

    @Override
    public Optional<Account> getById(Long id) {
        return Optional.of(account);
    }

    @Override
    public void save(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }
}
