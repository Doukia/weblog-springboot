package com.zsk.weblog.web.convert;

import com.zsk.weblog.common.domain.dos.BlogSettingsDO;
import com.zsk.weblog.web.model.vo.blogsettings.FindBlogSettingsDetailRspVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author 朱少康
 * @date 2024/7/25
 **/
@Mapper
public interface BlogSettingsConvert {

    /**
     * 初始化 convert 实例
     */
    BlogSettingsConvert INSTANCE = Mappers.getMapper(BlogSettingsConvert.class);

    /**
     * 将 DO 转化为 VO
     *
     * @param bean
     * @return
     */
    FindBlogSettingsDetailRspVO convertDO2VO(BlogSettingsDO bean);
}
