package com.zsk.weblog.common.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zsk.weblog.common.domain.dos.BlogSettingsDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 朱少康
 * @date 2024/7/23
 **/
@Mapper
public interface BlogSettingsMapper extends BaseMapper<BlogSettingsDO> {
}
