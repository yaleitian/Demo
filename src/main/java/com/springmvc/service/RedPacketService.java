package com.springmvc.service;

import com.springmvc.entity.RedPacket;

/**
 * @author tianyalei
 */
public interface RedPacketService {
    /**
     * 获取红包
     * @param id
     * @return
     */
    public RedPacket getRedPacket(Long id);

    /**
     * 扣减红包
     * @param id
     * @return
     */
    public int decreaseRedPacket(Long id);
}
