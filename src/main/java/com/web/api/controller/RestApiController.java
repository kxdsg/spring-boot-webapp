package com.web.api.controller;

import com.web.api.common.Constants;
import com.web.api.common.RtnData;
import com.web.api.common.ServiceRumtimeException;
import com.web.api.service.RestApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Created by xingding on 2016/11/17.
 */
@RestController
public class RestApiController {

    @Autowired
    private RestApiService restApiService;

    @RequestMapping(value = "/mobile/location", method = RequestMethod.GET)
    public RtnData mobileLocation(@RequestParam(required = false) String phone) throws Exception {
        if(StringUtils.isEmpty(phone)){
            throw new ServiceRumtimeException(Constants.MANDATORY_CODE_ERROR, Constants.MANDATORY_MESSAGE_ERROR);
        }
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("phone",phone);
        Object result = restApiService.mobileLocation(params);
        return new RtnData(result);
    }
}
