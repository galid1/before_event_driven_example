package com.galid.order.order.application;

import com.galid.order.order.domain.OrderEntity;
import com.galid.order.order.domain.OrderRepository;
import com.galid.order.refund.application.RefundService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;
    private final RefundService refundService;

    public Long placeOrder(Long orderer) {
        OrderEntity newOrder = new OrderEntity(orderer);
        return orderRepository.save(newOrder).getOrderId();
    }

    public void cancelOrder(Long orderId) {
        // 주문 취소
        orderRepository.findById(orderId)
                .get()
                .cancel();

        // 환불을 위한 로직
        refundService.startRefund(orderId);
    }
}
