package UserManagement.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class JwtAuthenticationResponse {

    private String token,refreshToken;
}
