package personalspring.infrastructure.delegators;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import personalspring.infrastructure.api.SigninApiDelegate;
import personalspring.infrastructure.dto.SignIn;

@Service
public class SigninApiDelegateImpl implements SigninApiDelegate {

  @Override
  public ResponseEntity<Void> postSignin(SignIn signIn) {
    return SigninApiDelegate.super.postSignin(signIn);
  }
}
