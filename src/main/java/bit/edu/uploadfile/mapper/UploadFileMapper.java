package bit.edu.uploadfile.mapper;

import bit.edu.uploadfile.dto.UploadFileDto;
import bit.edu.uploadfile.dto.UploadFileRegisterDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
@Mapper
public interface UploadFileMapper {

    /* FIXME : 미구현 */
    void createUploadFile(UploadFileRegisterDto uploadFileRegisterDto);

    List<UploadFileDto> findUploadFileByBoardNo(int boardNo);

}
