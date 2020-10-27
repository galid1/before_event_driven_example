package com.galid.order.command.refund.application;

import com.galid.order.command.refund.command.domain.OrderRefundEntity;
import com.galid.order.command.refund.command.domain.OrderRefundRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RefundService {
    private final OrderRefundRepository orderRefundRepository;
    private final RefundModule refundModule;

    public void startRefund(Long orderId) {
        OrderRefundEntity refundEntity = new OrderRefundEntity(orderId);
        orderRefundRepository.save(refundEntity);

        refundModule.refund();

        // 환불 완료 상태로 변경
        refundEntity.refundComplete();
    }
}
