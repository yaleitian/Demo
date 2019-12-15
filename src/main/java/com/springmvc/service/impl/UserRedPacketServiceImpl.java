package com.springmvc.service.impl;

import com.springmvc.dao.RedPacketDao;
import com.springmvc.dao.UserRedPacketDao;
import com.springmvc.entity.RedPacket;
import com.springmvc.entity.UserRedPacket;
import com.springmvc.service.UserRedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author tianyalei
 */
@Service
public class UserRedPacketServiceImpl implements UserRedPacketService {
    @Autowired
    private UserRedPacketDao userRedPacketDao;

    @Autowired
    private RedPacketDao redPacketDao;

    /**
     * 失败
     */
    private static final int FAILED = 0;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public int grapRedPacket(Long redPacketId, Long UserId) {

        // 获取红包信息
        //RedPacket redPacket = redPacketDao.getRedPacket( redPacketId );
        RedPacket redPacket = redPacketDao.getRedPacketForUpdate( redPacketId );
        // 当前小红包库存大于0
        if (redPacket.getStock() > 0) {
            redPacketDao.decreaseRedPacket( redPacketId );
            // 扣减抢红包信息
            UserRedPacket userRedPacket = new UserRedPacket();
            userRedPacket.setRedPacketId( redPacketId );
            userRedPacket.setUserId( UserId );
            userRedPacket.setAmount( redPacket.getAmount() );
            userRedPacket.setNote( "抢红包 " + redPacketId );
            // 插入抢红包信息
            int result = userRedPacketDao.grapRedPacket( userRedPacket );
            return result;
        }
        // 失败返回
        return FAILED;
    }
}
