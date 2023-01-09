import com.banking.domain.model.Account;
import com.banking.domain.model.Money;
import com.banking.domain.model.transaction.Transactions;
import com.banking.domain.port.usecase.DepositAccountUseCase;
import com.banking.exceptions.AccountNotFoundException;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class DepositUseCaseTest {


    @Test
    public void should_increase_balance_when_deposit_money() throws AccountNotFoundException {
        Long accountId = 1L;
        Transactions transactions = new Transactions();
        Account account = new Account(accountId, Money.of(BigDecimal.ZERO), transactions);
        InMemoryAccountRepository inMemoryAccountRepository = new InMemoryAccountRepository(account);
        DepositAccountUseCase depositAccountUsecase = new DepositAccountUseCase(inMemoryAccountRepository);
        depositAccountUsecase.handle(accountId, Money.of(BigDecimal.valueOf(50)));
        Assert.assertEquals(inMemoryAccountRepository.getAccount().getBalance(), Money.of(BigDecimal.valueOf(50)));
        Assert.assertEquals(inMemoryAccountRepository.getAccount().getTransactions().getAll().size(), 1);
    }




}
