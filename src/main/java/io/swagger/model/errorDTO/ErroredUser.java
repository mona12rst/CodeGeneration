package io.swagger.model.errorDTO;

import io.swagger.model.DTO.UserDTO;
import io.swagger.model.User;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ErroredUser extends User
{
    private String cause;

}
