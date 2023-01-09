import com.banking.domain.model.Account;
import com.banking.domain.model.Money;
import com.banking.domain.model.transaction.Transactions;
import com.banking.domain.model.transaction.Deposit;
import com.banking.domain.model.transaction.Transaction;
import com.banking.domain.model.transaction.Withdrawal;
import com.banking.domain.port.secondary.AccountRepository;
import com.banking.domain.port.usecase.PrintStatementUseCase;
import com.banking.exceptions.AccountNotFoundException;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PrintStatementUseCaseTest {

    private static final String EXPECTED_PRINTED_STATEMENTS = "Operation\t|\tDate\t|\tAmount\t|\tBalance\n" +
            "WITHDRAWAL\t|\t2022-12-20T00:00\t|\t5.00$\t|\t15.00$\n" +
            "DEPOSIT\t|\t2022-12-16T00:00\t|\t10.00$\t|\t20.00$";
    private static final LocalDateTime DEPOSIT_DATE = LocalDateTime.of(2022, 12, 16, 0, 0, 0);
    private static final LocalDateTime WITHDRAWAL_DATE = LocalDateTime.of(2022, 12, 20, 0, 0, 0);


    @Test
    public void should_print_statement() throws AccountNotFoundException {
        Long accountId = 1L;
        Transactions transactions = new Transactions();
        Transaction deposit = new Deposit(Money.of(BigDecimal.valueOf(10)), DEPOSIT_DATE, Money.of(BigDecimal.valueOf(20)));
        transactions.add(deposit);

        Transaction withDrawal = new Withdrawal(Money.of(BigDecimal.valueOf(5)), WITHDRAWAL_DATE, Money.of(BigDecimal.valueOf(15)));
        transactions.add(withDrawal);

        Account account = new Account(accountId, Money.of(BigDecimal.TEN), transactions);
        InMemoryAccountRepository inMemoryAccountRepository = new InMemoryAccountRepository(account);
        PrintStatementUseCase printStatementUseCase = new PrintStatementUseCase(inMemoryAccountRepository);
        String printedStatements = printStatementUseCase.print(accountId);
        Assert.assertEquals(EXPECTED_PRINTED_STATEMENTS, printedStatements);
    }




}
