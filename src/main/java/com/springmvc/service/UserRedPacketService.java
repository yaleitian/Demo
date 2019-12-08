package com.springmvc.service;

/**
 * @author tianyalei
 */
public interface UserRedPacketService {

    /**
     * 保存抢红包信息
     * @param redPacketId
     * @param UserId
     * @return
     */
    public int grapRedPacket(Long redPacketId, Long UserId);
}
