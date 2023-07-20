package bit.edu.uploadfile.dto;

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
public class UploadFileRegisterDto {
    private int boardNo;
    private String originFileName;
    private String uuidFileName;
    private String fileExtension;

}
