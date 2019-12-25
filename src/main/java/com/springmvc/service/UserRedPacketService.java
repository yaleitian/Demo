package com.springmvc.service;

/**
 * @author tianyalei
 */
public interface UserRedPacketService {

    /**
     * 保存抢红包信息
     *
     * @param redPacketId
     * @param UserId
     * @return
     */
    public int grapRedPacket(Long redPacketId, Long UserId);

    /**
     * 通过乐观锁实现
     * @param redPacketId --红包编号
     * @param userId -- 用户编号
     * @return
     * 0-没有库存，失败
     * 1--成功，且不是最后一个红包
     * 2--成功，且是最后一个红包
     */
    public int grapRedPacketForVersion(Long redPacketId, Long userId);
}
