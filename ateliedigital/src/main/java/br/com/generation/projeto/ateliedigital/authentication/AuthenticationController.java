package br.com.generation.projeto.ateliedigital.authentication;

import java.net.URI;
import java.util.Collections;
import javax.validation.Valid;
import br.com.generation.projeto.ateliedigital.exception.BackendException;
import br.com.generation.projeto.ateliedigital.role.Role;
import br.com.generation.projeto.ateliedigital.role.RoleName;
import br.com.generation.projeto.ateliedigital.role.RoleRepository;
import br.com.generation.projeto.ateliedigital.security.LoginRequest;
import br.com.generation.projeto.ateliedigital.security.SignUpRequest;
import br.com.generation.projeto.ateliedigital.security.jwt.JwtAuthenticationResponse;
import br.com.generation.projeto.ateliedigital.security.jwt.JwtTokenProvider;
import br.com.generation.projeto.ateliedigital.user.User;
import br.com.generation.projeto.ateliedigital.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private JwtTokenProvider tokenProvider;

  @PostMapping("/sign-in")
  public ResponseEntity<JwtAuthenticationResponse> authenticateUser(
      @Valid @RequestBody LoginRequest loginRequest) {
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            loginRequest.getUsernameOrEmail(),
            loginRequest.getPassword()
        )
    );

    SecurityContextHolder.getContext().setAuthentication(authentication);

    String jwt = tokenProvider.generateToken(authentication);
    return ResponseEntity.ok(new JwtAuthenticationResponse(jwt, "Bearer"));
  }

  @PostMapping("/sign-up")
  public ResponseEntity<AuthenticationResponse> registerUser(
      @Valid @RequestBody SignUpRequest signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getUsername()) || userRepository
        .existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity.badRequest()
          .body(new AuthenticationResponse(false, "Username or E-mail Address already in use."));
    }

    Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
        .orElseThrow(() -> new BackendException("User Role not set."));

    // Creating user's account
    User user = new User();
    user.setName(signUpRequest.getName());
    user.setUsername(signUpRequest.getUsername());
    user.setEmail(signUpRequest.getEmail());
    user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
    user.setRoles(Collections.singleton(userRole));

    URI location = ServletUriComponentsBuilder
        .fromCurrentContextPath().path("/users/{username}")
        .buildAndExpand(userRepository.save(user).getUsername()).toUri();

    return ResponseEntity.created(location)
        .body(new AuthenticationResponse(true, "User registered successfully."));
  }

}
