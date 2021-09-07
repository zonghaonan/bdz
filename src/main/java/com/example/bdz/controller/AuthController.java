package com.example.bdz.controller;

import cn.hutool.core.map.MapUtil;
import com.example.bdz.common.lang.Const;
import com.example.bdz.common.lang.Result;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author zhn
 * @Date 2021/9/3 20:13
 * @Version 1.0
 */
@RestController
public class AuthController extends BaseController {
    @Autowired
    Producer producer;
    //生成验证码
    @GetMapping("/captcha")
    public Result captcha() throws IOException {
        String key= UUID.randomUUID().toString();
        System.out.println("key:"+key);
        String code=producer.createText();
        BufferedImage image = producer.createImage(code);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image,"jpg",outputStream);
        BASE64Encoder encoder = new BASE64Encoder();
        String str="data:image/jpeg;base64,";
        String base64Img=str+encoder.encode(outputStream.toByteArray());
        //System.out.println(encoder.encode(outputStream.toByteArray()));
        redisUtil.hset(Const.CAPTCHA_KEY,key,code,120);
        return Result.success(
                MapUtil.builder()
                        .put("key",key)
                        .put("base64Img",base64Img)
                        .build()
        );
    }
}
