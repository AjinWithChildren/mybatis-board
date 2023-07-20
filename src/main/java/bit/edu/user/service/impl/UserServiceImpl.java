package bit.edu.user.service.impl;

import bit.edu.user.dto.UserDetailsDto;
import bit.edu.user.dto.UserLoginDto;
import bit.edu.user.exception.UserNotFountException;
import bit.edu.user.mapper.UserMapper;
import bit.edu.user.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
//    @Override
//    public UserDetailsDto loginUser(UserLoginDto userLoginDto) {
//        return userMapper.findUserByUserId(userLoginDto)
//            .orElseThrow(UserNotFountException::new);
//    }


    @Override
    public UserDetailsDto loginUser(UserLoginDto userLoginDto) {
        List<UserDetailsDto> userDetailsDtoList = userMapper.findUserByUserId(userLoginDto);

        if (userDetailsDtoList.isEmpty()) {
            throw new UserNotFountException();
        }


        return userDetailsDtoList.get(1);
    }

}
