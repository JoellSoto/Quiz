package com.Tech.quiz.UserManagement.Controller;


import com.Tech.quiz.UserManagement.dto.*;
import com.Tech.quiz.UserManagement.entity.User;
import com.Tech.quiz.UserManagement.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/sign-up")
    public ResponseEntity<User> signUp(@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authenticationService.signUp(signUpRequest));
    }

    @PostMapping("/sign-in")
    public ResponseEntity<JwtAuthenticationResponse> signIn(@RequestBody SignInRequest signInRequest){
        return ResponseEntity.ok(authenticationService.signIn(signInRequest));
    }
    @PostMapping("/token-state")
    public ResponseEntity<TokenState> isTokenInvalid(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return  ResponseEntity.ok(authenticationService.isTokenExpired(refreshTokenRequest.getToken()));
    }


    @PostMapping("/refresh-token")
    public ResponseEntity<JwtAuthenticationResponse> refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));
    }
}
