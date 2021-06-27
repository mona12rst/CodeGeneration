package io.swagger;


import io.swagger.config.PropertiesConfig;
import io.swagger.model.*;
import io.swagger.model.enums.AccountStatusEnum;
import io.swagger.model.enums.AccountTypeEnum;
import io.swagger.model.enums.TransactionTypeEnum;
import io.swagger.model.enums.UserRoleEnum;
import io.swagger.repository.*;
import io.swagger.service.LoginServiceImpl;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.threeten.bp.LocalDateTime;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Component
@Log
@Transactional
public class BankingApiApplicationRunner implements ApplicationRunner
{

    @Autowired
    private IBANRepository ibanRepository;
    @Autowired
    private BalanceRepository balanceRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PropertiesConfig propertiesConfig;

    @Autowired
    LoginServiceImpl loginService;



    public void run(ApplicationArguments args) throws Exception
    {


        User user = new User();
        user.setUsername("test user");
        user.setPassword("test password");
        user.setUserRoles(List.of(UserRoleEnum.ROLE_CUSTOMER));
        String token = loginService.add(user.getUsername(), user.getPassword(), user.getUserRoles());
        log.info("token: " + token);

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
//        System.out.println(user1);

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
        userRepository.save(user2);


        userRepository.save(user1);

        // account 1

        IBAN iban = new IBAN();
        iban.setCountryCode("NL");
        iban.setCheckNumber(47);
        iban.setBankIdentifier("INGB");
        iban.setAccountNumber(123456078);

        IBANHelper.validate(iban.toString());
        ibanRepository.save(iban);

        Balance balance = new Balance().amount(675);

        balanceRepository.save(balance);

        Account account1 = new Account().accountStatus(AccountStatusEnum.ACTIVE)
                .accountType(AccountTypeEnum.CURRENT)
                .IBAN(iban.toString())

                .absoluteLimit(200)
                .balance(balance)
//                .dailyLimit(200)
                .dateOfOpening(LocalDateTime.now().toString())
                .user(user1);
//        account1.setAccountId(1);
        accountRepository.save(account1);
        System.out.println(account1);


        // account 2
        IBAN iban2 = new IBAN();
        iban2.setCountryCode("NL");
        iban2.setCheckNumber(23);
        iban2.setBankIdentifier("AMRO");
        iban2.setAccountNumber(252365048);

        IBANHelper.validate(iban2.toString());
        ibanRepository.save(iban2);

        Balance balance2 = new Balance().amount(955);

        balanceRepository.save(balance2);

        Account account2 = new Account().accountStatus(AccountStatusEnum.ACTIVE)
                .accountType(AccountTypeEnum.CURRENT)
                .IBAN(iban2.toString())

                .absoluteLimit(180)
                .balance(balance2)
//                .dailyLimit(200)
                .dateOfOpening(LocalDateTime.now().toString())
                .user(user2);
//        account1.setAccountId(1);
        accountRepository.save(account2);
        System.out.println(account2);


        // create a dummy transaction as data seed
        Transaction transactionDTO = new Transaction().transactionType(TransactionTypeEnum.TRANSFER)
                .amount(200.50f)
                .fromIBAN(account1.getIBAN())
                .toIBAN(account2.getIBAN())
                .userPerforming(user1);


       transactionRepository.save(transactionDTO);





    }

    public void editor()
    {

    }

}
