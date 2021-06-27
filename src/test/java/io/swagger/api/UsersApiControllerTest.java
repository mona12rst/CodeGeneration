package io.swagger.api;


import io.swagger.model.User;
import io.swagger.model.enums.UserRoleEnum;
import io.swagger.service.interfaces.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class UsersApiControllerTest
{
    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    private User user;

    @BeforeEach
    public void init() throws Exception
    {
        user = new User().userRole(List.of(UserRoleEnum.ROLE_EMPLOYEE))
                .username("Mona")
                .dailyLimit(100)
                .dateOfBirth(LocalDate.of(1994, 4, 1)
                                     .toString())
                .emailAddress("mona@gmail.com")
                .firstName("Mona")
                .lastName("Mona")
                .transactionLimit(50);


    }

    @Test
    public void getAllUsersShouldReturnJsonArray() throws Exception
    {
        given(userService.getAllUsers()).willReturn(List.of(user));
        this.mvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));

    }

    @Test
    public void createAUserShouldReturnStatusCodeCreated() throws Exception
    {
        // because user has a many checks, if this is not an actual user provided, it will fail... so be careful...
        this.mvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON)
                                 .content("{\n" + "  \"UserID\": 1,\n" + "  \"Username\": \"Zarmina\",\n" + "  \"firstName\": \"Zarmina\",\n" + "  \"lastName\": \"Abbas\",\n" + "  \"emailAddress\": \"email@email.com\",\n" + "  \"dateOfBirth\": \"1994-01-04\",\n" + "  \"mobileNumber\": \"2222222\",\n" + "  \"dailyLimit\": 500.0,\n" + "  \"transactionLimit\": 2000.0,\n" + "  \"userRole\": \"user\"\n" + "}"))
                .andExpect(status().isCreated());
    }

    @Test
    public void deleteAUserShouldReturnNoContent() throws Exception
    {
        given(userService.getAllUsers()).willReturn(List.of(user));
        this.mvc.perform(delete("/users/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void editAUserShouldReturnStatusCodeCreated() throws Exception
    {
        this.mvc.perform(put("/users/1").contentType(MediaType.APPLICATION_JSON)
                                 .content(" {\n" + "\t \"FromIBAN\": \"000000000000000\",\n" + "    \"ToIBAN\": \"NL47INGB123456078\",\n" + "    \"Amount\": 9999.5,\n" + "    \"TransactionType\": \"deposit\",\n" + "   \n" + "    \"userPerforming\": {\n" + "      \"UserID\": 2,\n" + "      \"Username\": \"Fabio\",\n" + "      \"firstName\": \"Mona\",\n" + "      \"lastName\": \"Rostami\",\n" + "      \"emailAddress\": \"email@address\",\n" + "      \"dateOfBirth\": \"some date\",\n" + "      \"mobileNumber\": \"111111\",\n" + "      \"dailyLimit\": 500.00,\n" + "      \"transactionLimit\": 2000.00,\n" + "      \"userRole\": \"user\"\n" + "    }\n" + "  }"))
                .andExpect(status().isCreated());
    }


}