import com.banking.domain.model.Account;
import com.banking.domain.model.Money;
import com.banking.domain.model.transaction.Transactions;
import com.banking.domain.port.secondary.AccountRepository;
import com.banking.domain.port.usecase.DepositAccountUseCase;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class DepositUseCaseTest {


    @Test
    public void should_increase_balance_when_deposit_money() {
        Long accountId = 1L;
        Transactions transactions = new Transactions();
        Account account = new Account(accountId, Money.of(BigDecimal.ZERO), transactions);
        AccountRepository accountRepositoryStub = id -> account;
        DepositAccountUseCase depositAccountUsecase = new DepositAccountUseCase(accountRepositoryStub);
        depositAccountUsecase.handle(accountId, Money.of(BigDecimal.valueOf(50)));
        Assert.assertEquals(account.getBalance(), Money.of(BigDecimal.valueOf(50)));
        Assert.assertEquals(account.getTransactions().getAll().size(), 1);
    }




}
