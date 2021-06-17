package io.swagger;


import io.swagger.model.*;
import io.swagger.repository.AddressRepository;
import io.swagger.repository.BalanceRepository;
import io.swagger.repository.IBANRepository;
import io.swagger.repository.UserRepository;
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
    IBANRepository ibanRepository;
    @Autowired
    BalanceRepository balanceRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;

    public void run(ApplicationArguments args) throws Exception
    {
        Address address = new Address().city("Haarlem")
                .country("NL")
                .houseNumber(23)
                .postCode("2011RE")
                .street("Smedestraat");

        addressRepository.save(address);

        User user1 = new User().username("Mona")
                .userRole(User.UserRoleEnum.USER)
                .dailyLimit(BigDecimal.valueOf(500))
                .dateOfBirth("some date")
                .emailAddress("email@address")
                .firstName("Mona")
                .lastName("Rostami")
                .mobileNumber("111111")
                .primaryAddress(address)
                .transactionLimit(BigDecimal.valueOf(2000));
//        System.out.println(user1);


        userRepository.save(user1);


        IBAN iban = new IBAN();
        iban.setBankIdentifier("INGB");
        iban.setAccountNumber(123456078);
        iban.setCheckNumber(47);
        iban.setCountryCode("NL");

        ibanRepository.save(iban);

        Balance balane = new Balance().amount(BigDecimal.valueOf(675));

        balanceRepository.save(balane);

        Account account = new Account().accountStatus(Account.AccountStatusEnum.ACTIVE)
                .accountType(Account.AccountTypeEnum.CURRENT)
                .IBAN(iban)
                .absoluteLimit(BigDecimal.valueOf(200))
                .balance(balane)
                .dailyLimit(BigDecimal.valueOf(200))
                .dateOfOpening("some date");




    }

}
