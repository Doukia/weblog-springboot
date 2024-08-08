package com.zsk.weblog.search.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 朱少康
 * @date 2024/8/8
 **/
@ConfigurationProperties(prefix = "lucene")
@Component
@Data
public class LuceneProperties {

    /**
     * 索引存放的文件夹
     */
    private String indexDir;
}
