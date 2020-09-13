package com.common.base;

import lombok.Data;

@Data
public class RequestDTO {
    // 第几页，默认值1
    private Integer page = 1;

    // 一页几个数据.默认值10
    private Integer limit = 10;
}
