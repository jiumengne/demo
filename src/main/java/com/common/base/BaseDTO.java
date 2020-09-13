package com.common.base;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseDTO {
    // 创建人
    private String creator;

    // 修改人
    private String modifier;

    // 创建时间
    private LocalDateTime createDate;

    // 修改时间
    private LocalDateTime modificationDate;
}
