package com.zsk.weblog.web.model.vo.tag;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 朱少康
 * @date 2024/7/25
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindTagListRspVO {

    private Long id;

    private String name;
}
