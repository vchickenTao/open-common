package com.vchicken.opencommon;

import com.vchicken.opencommon.captcha.ArithmeticCaptcha;
import com.vchicken.opencommon.captcha.CaptchaBuilder;
import com.vchicken.opencommon.captcha.base.BaseCaptcha;
import com.vchicken.opencommon.open.model.vo.CaptchaVO;
import com.vchicken.opencommon.open.service.OpenService;
import com.vchicken.opencommon.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
class OpenCommonApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private OpenService openService;

    @Test
    public void getOpenService() {
        ArithmeticCaptcha ac = CaptchaBuilder.<ArithmeticCaptcha>newArithmeticBuilder()
                .len(3).build();
        log.info(JsonUtils.toJSONString(ac.toBase64()));
    }

}
