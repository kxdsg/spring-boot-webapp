package com.web.api.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xingding on 18/2/9.
 */
@Controller
public class QrcodeController {

    @RequestMapping(value = "/qrcodeindex", method = RequestMethod.GET)
    public String qrcode() {
        return "qrcode";
    }

    @GetMapping("/qrcode")
    public void placeQrCode(HttpServletResponse resp) throws Exception{
        resp.setHeader("Cache-Control", "no-store");
        resp.setHeader("Pragma", "no-cache");
        resp.setDateHeader("Expires", 0);
        resp.setContentType("image/png");

        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hints.put(EncodeHintType.MARGIN, 0);

        BitMatrix bitMatrix = new MultiFormatWriter()
                .encode("https://www.toutiao.com", BarcodeFormat.QR_CODE, 150, 150, hints);

        MatrixToImageWriter.writeToStream(bitMatrix, "png", resp.getOutputStream());

    }
}
