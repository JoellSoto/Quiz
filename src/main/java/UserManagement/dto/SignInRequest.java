package UserManagement.dto;


import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignInRequest {

    private String email,password;
}
