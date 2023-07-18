package bit.edu.user.mapper;

import bit.edu.user.dto.UserDetailsDto;
import bit.edu.user.dto.UserLoginDto;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
@Mapper
public interface UserMapper {

    List<UserDetailsDto> findUserByUserId(UserLoginDto userLoginDto);
}
