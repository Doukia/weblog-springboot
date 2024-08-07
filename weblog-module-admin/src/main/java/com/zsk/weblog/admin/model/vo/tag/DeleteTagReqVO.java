package com.zsk.weblog.admin.model.vo.tag;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author 朱少康
 * @date 2024/7/20
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("删除标签 VO")
public class DeleteTagReqVO {

    @NotNull(message = "标签 ID 不能为空")
    private Long id;
}
