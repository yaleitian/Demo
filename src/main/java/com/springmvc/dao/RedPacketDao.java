package com.springmvc.dao;

import com.springmvc.entity.RedPacket;

/**
 * @author tianyalei
 */
public interface RedPacketDao {
    /**
     * 获取红包信息
     * @param id
     * @return
     */
    public RedPacket getRedPacket(Long id);

    /**
     * 扣减抢红包数
     * @param id
     * @return
     */
    public int decreaseRedPacket(Long id);

}
