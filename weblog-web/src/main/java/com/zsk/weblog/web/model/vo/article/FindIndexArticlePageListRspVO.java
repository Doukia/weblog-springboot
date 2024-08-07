package com.zsk.weblog.web.model.vo.article;

import com.zsk.weblog.web.model.vo.category.FindCategoryListRspVO;
import com.zsk.weblog.web.model.vo.tag.FindTagListRspVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * @author 朱少康
 * @date 2024/7/25
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindIndexArticlePageListRspVO {

    private Long id;

    private String cover;

    private String title;

    private LocalDate createDate;

    private String summary;

    /**
     * 文章分类
     */
    private FindCategoryListRspVO category;

    /**
     * 文章标签
     */
    private List<FindTagListRspVO> tags;
}
