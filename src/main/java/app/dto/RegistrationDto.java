package app.dto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class RegistrationDto {
    private String login;

    private String firstName;

    private String lastName;

    private String password;
}
