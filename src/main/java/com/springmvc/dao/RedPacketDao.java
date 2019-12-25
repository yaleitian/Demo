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

    /***
     * 使用for update语句加锁.
     * @param id ——红包id
     * @return 红包信息
     */
    public RedPacket getRedPacketForUpdate(Long id);

    int decreaseRedPacketForVersion(Long redPacketId, Integer version);
}
