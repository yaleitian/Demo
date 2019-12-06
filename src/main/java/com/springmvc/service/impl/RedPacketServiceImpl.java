package com.springmvc.service.impl;

import com.springmvc.dao.RedPacketDao;
import com.springmvc.entity.RedPacket;
import com.springmvc.service.RedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author tianyalei
 */
@Service
public class RedPacketServiceImpl implements RedPacketService {

    @Autowired
    private RedPacketDao redPacketDao;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public RedPacket getRedPacket(Long id) {
        return redPacketDao.getRedPacket( id );
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public int decreaseRedPacket(Long id) {
        return redPacketDao.decreaseRedPacket( id );
    }
}
