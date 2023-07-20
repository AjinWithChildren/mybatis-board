package bit.edu.uploadfile.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
@Getter
@AllArgsConstructor
public class UploadFileDto {
    private int uploadFileNo;
    private int boardNo;
    private String originFileName;
    private String uuidFileName;
    private String fileExtension;

}
