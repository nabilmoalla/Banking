import java.math.BigDecimal;
import com.banking.domain.model.Account;
import com.banking.domain.model.Money;
import com.banking.domain.model.transaction.Transactions;
import com.banking.domain.port.secondary.AccountRepository;
import com.banking.domain.port.usecase.WithdrawalAccountUseCase;
import com.banking.exceptions.InsuffisantBalanceException;
import org.junit.Assert;
import org.junit.Test;

public class WithdrawalUseCaseTest {

    @Test
    public void should_decrease_balance_when_withdraw_money() throws InsuffisantBalanceException {
        Long accountId = 1L;
        Transactions transactions = new Transactions();
        Account account = new Account(accountId, Money.of(BigDecimal.valueOf(50)), transactions);
        AccountRepository accountRepositoryStub = id -> account;
        WithdrawalAccountUseCase withdrawAccountUseCase = new WithdrawalAccountUseCase(accountRepositoryStub);
        withdrawAccountUseCase.handle(accountId, Money.of(BigDecimal.valueOf(6)));
        Assert.assertEquals(account.getBalance(), Money.of(BigDecimal.valueOf(44)));
        Assert.assertEquals(account.getTransactions().getAll().size(), 1);
    }

    @Test(expected = InsuffisantBalanceException.class)
    public void should_throw_exception_when_withdraw_amount_greater_than_balance() throws InsuffisantBalanceException {
        Long accountId = 1L;
        Transactions transactions = new Transactions();
        Account account = new Account(accountId, Money.of(BigDecimal.TEN), transactions);
        AccountRepository accountRepositoryStub = id -> account;
        WithdrawalAccountUseCase withdrawAccountUseCase = new WithdrawalAccountUseCase(accountRepositoryStub);
        withdrawAccountUseCase.handle(accountId, Money.of(BigDecimal.valueOf(15)));
    }




}
