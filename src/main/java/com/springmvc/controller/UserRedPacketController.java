package com.springmvc.controller;

import com.springmvc.service.UserRedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tianyalei
 */
@Controller
@RequestMapping("/userRedPacket")
public class UserRedPacketController {

    @Autowired
    private UserRedPacketService userRedPacketService;

    @RequestMapping("/grapRedPacket")
    @ResponseBody
    public Map<String, Object> grapRedPacket(Long redPacketId, Long userId) {
        // 抢红包
        int result = userRedPacketService.grapRedPacket( redPacketId, userId );
        Map<String, Object> retMap = new HashMap<String, Object>();
        boolean flag = result > 0;
        retMap.put( "success", flag );
        retMap.put( "message", flag ? "抢红包成功" : "抢红包失败" );
        return retMap;
    }
    //乐观锁请求，使用时修改javascript的请求路径
    @RequestMapping(value = "/grapRedPacketForVersion")
    @ResponseBody
    public Map<String, Object> grapRedPacketForVersion(Long redPacketId, Long userId) {
        // 抢红包
        int result = userRedPacketService.grapRedPacketForVersion(redPacketId, userId);
        Map<String, Object> retMap = new HashMap<String, Object>();
        boolean flag = result > 0;
        retMap.put("success", flag);
        retMap.put("message", flag ? "抢红包成功" : "抢红包失败");
        return retMap;
    }

}
