package com.galid.order.refund.infra;

import com.galid.order.refund.application.RefundModule;
import org.springframework.stereotype.Service;

@Service
public class ImPortRefundModule implements RefundModule {
    public void refund() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        throw new IllegalArgumentException("ERROR");
    }
}
