package io.swagger.api;

import io.swagger.model.*;
import io.swagger.model.enums.AccountStatusEnum;
import io.swagger.model.enums.AccountTypeEnum;
import io.swagger.model.enums.TransactionTypeEnum;
import io.swagger.model.enums.UserRoleEnum;
import io.swagger.service.interfaces.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.threeten.bp.LocalDateTime;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TransactionsApiControllerTest
{
    @Autowired
    private MockMvc mvc;

    @MockBean
    private TransactionService transactionService;

    private Transaction transaction;

    @BeforeEach
    void init() throws Exception
    {
        User user1 = new User().username("Fabio")
                .userRole(List.of(UserRoleEnum.ROLE_EMPLOYEE))
                .dailyLimit(700)
                .dateOfBirth(LocalDate.of(1994, 4, 1).toString())
                .emailAddress("email@address.")
                .firstName("Mona")
                .lastName("Rostami")
                .emailAddress("mona@m.com")

                .mobileNumber("111111")
//                .primaryAddress(address)
                .transactionLimit(550);

        User user2 = new User().username("Zarmina")
                .userRole(List.of(UserRoleEnum.ROLE_EMPLOYEE))
                .dailyLimit(500)
                .dateOfBirth(LocalDate.of(1994, 4, 1).toString())
                .emailAddress("email@address.")
                .firstName("Zarmina")
                .lastName("Abbas")
                .emailAddress("zimi@z.com")
                .mobileNumber("111111")
//                .primaryAddress(address)
                .transactionLimit(380);

        IBAN iban = new IBAN();
        iban.setCountryCode("NL");
        iban.setCheckNumber(47);
        iban.setBankIdentifier("INGB");
        iban.setAccountNumber(123456078);



        Balance balance = new Balance().amount(675);



        Account account1 = new Account().accountStatus(AccountStatusEnum.ACTIVE)
                .accountType(AccountTypeEnum.CURRENT)
                .IBAN(iban.toString())

                .absoluteLimit(200)
                .balance(balance)

                .dateOfOpening(LocalDateTime.now().toString())
                .user(user1);




        // account 2
        IBAN iban2 = new IBAN();
        iban2.setCountryCode("NL");
        iban2.setCheckNumber(23);
        iban2.setBankIdentifier("AMRO");
        iban2.setAccountNumber(252365048);

        IBANHelper.validate(iban2.toString());


        Balance balance2 = new Balance().amount(955);



        Account account2 = new Account().accountStatus(AccountStatusEnum.ACTIVE)
                .accountType(AccountTypeEnum.CURRENT)
                .IBAN(iban2.toString())

                .absoluteLimit(180)
                .balance(balance2)
                .dateOfOpening(LocalDateTime.now().toString())
                .user(user2);



        transaction = new Transaction().transactionType(TransactionTypeEnum.TRANSFER)
                .amount(200.50f)
                .fromIBAN(account1.getIBAN())
                .toIBAN(account2.getIBAN())
                .userPerforming(user1);
    }

    @Test
    void getTransactionByIbanShouldProduceJsonArray() throws Exception
    {
        given(transactionService.getAllTransactionsForIban("NL47INGB123456078")).willReturn(List.of(transaction));

        this.mvc.perform(get("/transactions/NL47INGB123456078"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }
    @Test
    void getTransactionsByIbanShouldReturn200() throws Exception
    {
        given(transactionService.getAllTransactionsForIban("NL47INGB123456078")).willReturn(List.of(transaction));

        this.mvc.perform(get("/transactions/NL47INGB123456078"))
                .andExpect(status().isOk());

    }

    @Test
    void getTransactionByUserIdShouldReturn200() throws Exception
    {
        given(transactionService.getAllTransactionsForIban("NL47INGB123456078")).willReturn(List.of(transaction));

        this.mvc.perform(get("/transactions/users/1"))
                .andExpect(status().isOk());
    }

    @Test
    void transferMoneyShouldReturn201() throws Exception
    {
        this.mvc.perform(post("/transactions").contentType(MediaType.APPLICATION_JSON).content(" {\n" + "\t \"FromIBAN\": \"NL47INGB123456078\",\n" + "    \"ToIBAN\": \"NL23AMRO252365048\",\n" + "    \"Amount\": 13,\n" + "    \"TransactionType\": \"transfer\",\n" + "   \n" + "    \"userPerforming\": {\n" + "      \"UserID\": 2,\n" + "      \"Username\": \"Fabio\",\n" + "      \"firstName\": \"Mona\",\n" + "      \"lastName\": \"Rostami\",\n" + "      \"emailAddress\": \"email@address.com\",\n" + "      \"dateOfBirth\": \"1994-01-04\",\n" + "      \"mobileNumber\": \"111111\",\n" + "      \"dailyLimit\": 500.00,\n" + "      \"transactionLimit\": 2000.00,\n" + "      \"userRole\": \"user\"\n" + "    }\n" + "  }"))
                .andExpect(status().isCreated());
    }
}