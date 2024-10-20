package app.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class signUpDto {
    private String login;
    private String password;
}
