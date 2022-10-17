package com.vchicken.opencommon.open.service.impl;

import com.vchicken.opencommon.captcha.ArithmeticCaptcha;
import com.vchicken.opencommon.captcha.CaptchaBuilder;
import com.vchicken.opencommon.common.cache.CacheKey;
import com.vchicken.opencommon.exception.BizAssert;
import com.vchicken.opencommon.open.model.vo.CaptchaVO;
import com.vchicken.opencommon.open.service.OpenService;
import com.vchicken.opencommon.util.BracePlaceholder;
import com.vchicken.opencommon.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author vchicken
 * @date 2020-04-29 1:33 下午
 */
@Service
public class OpenServiceImpl implements OpenService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public CaptchaVO generateCaptcha() {
        ArithmeticCaptcha ac = CaptchaBuilder.<ArithmeticCaptcha>newArithmeticBuilder()
                .len(3).build();
        String text = ac.text();
        String uuid = UUIDUtils.generateUUID();
        String key = BracePlaceholder.resolve(CacheKey.CAPTCHA_KEY, uuid);
        redisTemplate.opsForValue().set(key, text, CacheKey.CAPTCHA_EXPIRE_TIME, TimeUnit.MINUTES);
        return new CaptchaVO(uuid, ac.toBase64());
    }

    @Override
    public boolean checkCaptcha(String uuid, String captcha) {
        String key = BracePlaceholder.resolve(CacheKey.CAPTCHA_KEY, uuid);
        String text = (String) redisTemplate.opsForValue().get(key);
        BizAssert.notNull(text, "验证码过期");
        if (!captcha.equalsIgnoreCase(text)) {
            return false;
        }
        redisTemplate.delete(key);
        return true;
    }
}
