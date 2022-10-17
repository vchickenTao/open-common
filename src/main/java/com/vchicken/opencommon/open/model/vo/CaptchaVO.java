package com.vchicken.opencommon.open.model.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author vchicken
 * @date 2020-04-29 1:31 下午
 */
@Getter
@Setter
public class CaptchaVO {

    private String base64Img;

    private String uuid;

    public CaptchaVO(String uuid, String base64) {
        this.uuid = uuid;
        this.base64Img = base64;
    }
}
