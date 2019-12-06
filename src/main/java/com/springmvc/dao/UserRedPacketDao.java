package com.springmvc.dao;

import com.springmvc.entity.UserRedPacket;

/**
 * @author tianyalei
 */
public interface UserRedPacketDao {
    /**
     * 插入抢红包信息
     * @param userRedPacket
     * @return
     */
    public int grapRedPacket(UserRedPacket userRedPacket);
}
