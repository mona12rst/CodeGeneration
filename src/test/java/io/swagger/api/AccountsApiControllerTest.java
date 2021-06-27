package io.swagger.api;

import io.swagger.model.*;
import io.swagger.model.enums.AccountStatusEnum;
import io.swagger.model.enums.AccountTypeEnum;
import io.swagger.model.enums.UserRoleEnum;
import io.swagger.service.interfaces.AccountService;
import io.swagger.service.interfaces.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AccountsApiControllerTest
{
    @Autowired
    private MockMvc mvc;

    @MockBean
    private AccountService accountService;

    @MockBean
    private TransactionService transactionService;

    private Account account;

    @BeforeEach
    public void init() throws Exception
    {
        User user = new User().userRole(List.of(UserRoleEnum.ROLE_EMPLOYEE))
                .username("Mona")
                .dailyLimit(100)
                .dateOfBirth(LocalDate.of(1994, 4, 1)
                                     .toString())
                .emailAddress("mona@gmail.com")
                .firstName("Mona")
                .lastName("Mona")
                .transactionLimit(50);


        IBAN iban = new IBAN();
        iban.setCountryCode("NL");
        iban.setCheckNumber(47);
        iban.setBankIdentifier("INGB");
        iban.setAccountNumber(123456078);


        Balance balance = new Balance().amount(675);


        account = new Account().accountStatus(AccountStatusEnum.ACTIVE)
                .accountType(AccountTypeEnum.CURRENT)
                .IBAN(iban.toString())
                .absoluteLimit(200)
                .balance(balance)
                .dateOfOpening(LocalDateTime.now()
                                       .toString())
                .user(user);


    }

    @Test
    void creatAccountShouldReturnStatusCode201() throws Exception
    {
        this.mvc.perform(post("/accounts").contentType(MediaType.APPLICATION_JSON)
                                 .content("{\n" + "    \n" + "    \"absoluteLimit\": 500,\n" + "    \"dailyLimit\": 175,\n" + "    \"balance\": {\n" + "      \n" + "      \"amount\": 952\n" + "    },\n" + "    \"dateOfOpening\": \"2021-06-27\",\n" + "    \"accountType\": \"current\",\n" + "    \"accountStatus\": \"active\",\n" + "    \"user\": {\n" + "     \n" + "      \"UserID\": 10,\n" + "  \"Username\": \"Zarmina\",\n" + "  \"firstName\": \"Zarmina\",\n" + "  \"lastName\": \"Abbas\",\n" + "  \"emailAddress\": \"email@email.com\",\n" + "  \"dateOfBirth\": \"1994-01-04\",\n" + "  \"mobileNumber\": \"2222222\",\n" + "  \"dailyLimit\": 500.0,\n" + "  \"transactionLimit\": 2000.0,\n" + "  \"userRole\": \"user\"\n" + "    }\n" + "  }"))
                .andExpect(status().isCreated());
    }

    @Test
    void getAllAccountsShouldReturnJsonArray() throws Exception
    {

        given(accountService.getAllAccounts()).willReturn(List.of(account));
        accountService.getAllAccounts()
                .forEach(System.out::println);
        this.mvc.perform(get("/accounts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));

    }

    @Test
    void getAllAccountsShouldReturn200() throws Exception
    {

        this.mvc.perform(get("/accounts"))
                .andExpect(status().isOk());
    }

    @Test
    void deleteAccountShouldReturnStatusCodeNoContent() throws Exception
    {

        given(accountService.getAllAccounts()).willReturn(List.of(account));
        this.mvc.perform(delete("/accounts/NL47INGB123456078"))
                .andExpect(status().isNoContent());
    }


    @Test
    void depositMoneyShouldReturnStatusCodeCreated() throws Exception
    {
        this.mvc.perform(post("/accounts/NL47INGB123456078/deposit").contentType(MediaType.APPLICATION_JSON)
                                 .content(" {\n" + "\t \"FromIBAN\": \"000000000000000\",\n" + "    \"ToIBAN\": \"NL47INGB123456078\",\n" + "    \"Amount\": 9999.5,\n" + "    \"TransactionType\": \"deposit\",\n" + "    \"userPerforming\": {\n" + "      \"UserID\": 2,\n" + "      \"Username\": \"Fabio\",\n" + "      \"firstName\": \"Mona\",\n" + "      \"lastName\": \"Rostami\",\n" + "      \"emailAddress\": \"email@address.com\",\n" + "      \"dateOfBirth\": \"1994-04-01\",\n" + "      \"mobileNumber\": \"111111\",\n" + "      \"dailyLimit\": 500.00,\n" + "      \"transactionLimit\": 2000.00,\n" + "      \"userRole\": \"user\"\n" + "    }\n" + "  }"))
                .andExpect(status().isCreated());

    }

    @Test
    void editAccountByIbanShouldReturnCreated() throws Exception
    {
        this.mvc.perform(put("/accounts/NL47INGB123456078").contentType(MediaType.APPLICATION_JSON)
                                 .content("{\n" + "  \"absoluteLimit\": 523,\n" + "  \"dailyLimit\": 123,\n" + "  \"balance\": {\n" + "    \"balanceId\": 7,\n" + "    \"amount\": 8965\n" + "  },\n" + "  \"dateOfOpening\": \"06-06-2021\",\n" + "  \"accountType\": \"savings\",\n" + "  \"accountStatus\": \"active\",\n" + "  \"user\": {\n" + "    \"UserID\": 6,\n" + "    \"Username\": \"Mona\",\n" + "    \"firstName\": \"Mona\",\n" + "    \"lastName\": \"Rostami\",\n" + "    \"emailAddress\": \"email@address\",\n" + "    \"dateOfBirth\": \"01-04-1994\",\n" + "    \"mobileNumber\": \"0621212121\",\n" + "    \"dailyLimit\": 175,\n" + "    \"transactionLimit\": 1852,\n" + "    \"userRole\": \"user\"\n" + "  }\n" + "}"))
                .andExpect(status().isCreated());
    }

    @Test
    void getAccountBalanceShouldReturnJsonArrayAndOkStatus() throws Exception
    {

        this.mvc.perform(get("/accounts/NL47INGB123456078/balance"))
                .andExpect(status().isOk());

    }

    @Test
    void getAccountByIbanShouldReturnOk() throws Exception
    {
        this.mvc.perform(get("/accounts/NL47INGB123456078"))
                .andExpect(status().isOk());
    }

    @Test
    void getAccountTransactionsShouldReturnOk() throws Exception
    {
        this.mvc.perform(get("/accounts/NL47INGB123456078/transactions"))
                .andExpect(status().isOk());
    }



    @Test
    void withdrawMoneyShouldReturnCreated() throws Exception
    {
        this.mvc.perform(post("/accounts/NL47INGB123456078/deposit").contentType(MediaType.APPLICATION_JSON)
                                 .content(" {\n" + "\t \"FromIBAN\": \"NL47INGB123456078\",\n" + "    \"ToIBAN\": \"00000000000000\",\n" + "    \"Amount\": 600.5,\n" + "    \"TransactionType\": \"withdraw\",\n" + "   \n" + "    \"userPerforming\": {\n" + "      \"UserID\": 2,\n" + "      \"Username\": \"Fabio\",\n" + "      \"firstName\": \"Mona\",\n" + "      \"lastName\": \"Rostami\",\n" + "      \"emailAddress\": \"email@address.com\",\n" + "      \"dateOfBirth\": \"1994-01-04\",\n" + "      \"mobileNumber\": \"111111\",\n" + "      \"dailyLimit\": 500.00,\n" + "      \"transactionLimit\": 2000.00,\n" + "      \"userRole\": \"user\"\n" + "    }\n" + "  }"))
                .andExpect(status().isCreated());
    }
}