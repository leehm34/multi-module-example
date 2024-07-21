package com.multimodule.core.model.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PostStatusType {

    NORMAL("Y"),
    BANNED("B"),
    ;

    private final String code;

}
