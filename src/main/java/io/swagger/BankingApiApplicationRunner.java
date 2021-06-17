package io.swagger;


import io.swagger.model.Address;
import io.swagger.model.User;
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
    private UserRepository userRepository;

    public void run(ApplicationArguments args) throws Exception
    {
        User user1 = new User().username("Mona")
                .userRole(User.UserRoleEnum.USER)
                .dailyLimit(BigDecimal.valueOf(500))
                .dateOfBirth("some date")
                .emailAddress("email@address")
                .firstName("Mona")
                .lastName("Rostami")
                .mobileNumber("111111")
                .primaryAddress(new Address().city("Haarlem").country("NL").houseNumber(23).postCode("2011RE").street("Smedestraat"))
                .transactionLimit(BigDecimal.valueOf(2000));
        System.out.println(user1);








    }

}
