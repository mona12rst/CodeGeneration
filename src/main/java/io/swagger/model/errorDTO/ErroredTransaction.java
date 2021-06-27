package io.swagger.model.errorDTO;

import io.swagger.model.Transaction;
import io.swagger.model.User;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ErroredTransaction extends Transaction
{
    private String cause;
    private User user;
    private LocalDateTime time;
}
