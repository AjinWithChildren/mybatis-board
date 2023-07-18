package bit.edu.user.dto;

import bit.edu.auth.Auth;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
@Getter
@AllArgsConstructor
@ToString
public class UserDetailsDto {
    private int userNo;
    private String userId;

    private Auth auth;
}
