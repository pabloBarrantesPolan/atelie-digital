package br.com.generation.projeto.ateliedigital.user;

import br.com.generation.projeto.ateliedigital.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String usernameOrEmail) {
    // Let people login with either username or email
    User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
        .orElseThrow(() ->
            new UsernameNotFoundException(
                "User not found with username or email: " + usernameOrEmail)
        );

    return UserPrincipal.create(user);
  }

  @Transactional
  public UserDetails loadUserById(Long id) throws ResourceNotFoundException {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("User not found."));

    return UserPrincipal.create(user);
  }

}
