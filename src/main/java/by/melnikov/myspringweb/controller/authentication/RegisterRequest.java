package by.melnikov.myspringweb.controller.authentication;

import by.melnikov.myspringweb.model.Role;
import by.melnikov.myspringweb.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    private String login;
    private String password;
    private String email;
    private User.Status status;
    private Role role;
    private String name;
    private String lastName;
    private LocalDate birthdate;
    private String phone;
    private BigDecimal balance;
    private Integer ordersCount;
}
