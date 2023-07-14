package bit.edu.user.service;

import bit.edu.user.dto.UserDetailsDto;
import bit.edu.user.dto.UserLoginDto;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
public interface UserService {

    UserDetailsDto loginUser(UserLoginDto userLoginDto);
}
