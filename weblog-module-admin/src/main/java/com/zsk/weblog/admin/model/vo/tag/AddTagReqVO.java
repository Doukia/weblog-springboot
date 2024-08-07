package com.zsk.weblog.admin.model.vo.tag;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotEmpty;
import java.util.List;


/**
 * @author 朱少康
 * @date 2024/7/20
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("添加标签 VO")
public class AddTagReqVO {

    @NotEmpty(message = "标签集合不能为空")
    private List<String> tags;
}
