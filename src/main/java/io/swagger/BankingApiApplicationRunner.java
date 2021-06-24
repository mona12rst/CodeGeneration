package io.swagger;


import io.swagger.model.*;
import io.swagger.repository.*;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;

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
//    @Autowired
//    private AddressRepository addressRepository;

    @Autowired
    private AccountRepository accountRepository;

    public void run(ApplicationArguments args) throws Exception
    {
//        Address address = new Address().city("Haarlem")
//                .country("NL")
//                .houseNumber(23)
//                .postCode("2011RE")
//                .street("Smedestraat");
//
//        addressRepository.save(address);

        User user1 = new User().username("Fabio")
                .userRole(UserRoleEnum.USER)
                .dailyLimit(BigDecimal.valueOf(500))
                .dateOfBirth("some date")
                .emailAddress("email@address")
                .firstName("Mona")
                .lastName("Rostami")
                .mobileNumber("111111")
//                .primaryAddress(address)
                .transactionLimit(BigDecimal.valueOf(2000));
//        System.out.println(user1);

        User user2 = new User().username("Zarmina")
                .userRole(UserRoleEnum.USER)
                .dailyLimit(BigDecimal.valueOf(500))
                .dateOfBirth("some other date")
                .emailAddress("email@address")
                .firstName("Zarmina")
                .lastName("Abbas")
                .mobileNumber("111111")
//                .primaryAddress(address)
                .transactionLimit(BigDecimal.valueOf(2000));
        userRepository.save(user2);


        userRepository.save(user1);


        IBAN iban = new IBAN();
        iban.setCountryCode("NL");
        iban.setCheckNumber(47);
        iban.setBankIdentifier("INGB");
        iban.setAccountNumber(123456078);


//        ibanRepository.save(iban);

        Balance balane = new Balance().amount(BigDecimal.valueOf(675));

        balanceRepository.save(balane);

        Account account1 = new Account().accountStatus(AccountStatusEnum.ACTIVE)
                .accountType(Account.AccountTypeEnum.CURRENT)
                .IBAN(iban.toString())

                .absoluteLimit(BigDecimal.valueOf(200))
                .balance(balane)
                .dailyLimit(BigDecimal.valueOf(200))
                .dateOfOpening("some date")
                .user(user1);
//        account1.setAccountId(1);
        accountRepository.save(account1);
        System.out.println(account1);


    }

}
