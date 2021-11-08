package dto;

import lombok.*;

@Setter
@Getter
@ToString
@Builder

public class Credentials {
    String email;
    String password;

}
