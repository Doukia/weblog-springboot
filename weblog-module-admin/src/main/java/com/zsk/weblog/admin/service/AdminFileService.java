package com.zsk.weblog.admin.service;

import com.zsk.weblog.common.utils.Response;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 朱少康
 * @date 2024/7/23
 **/
public interface AdminFileService {

    /**
     * 上传文件
     * @param file
     * @return
     */
    Response uploadFile(MultipartFile file);
}
