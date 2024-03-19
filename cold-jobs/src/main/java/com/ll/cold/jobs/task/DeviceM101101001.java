package com.ll.cold.jobs.task;

import com.ll.cold.jobs.utils.DeviceClientFactory;
import org.springframework.stereotype.Component;

@Component("deviceM101101001")
public class DeviceM101101001 implements ITask {
    @Override
    public void run(String params) {
        if( params == null ){
            params = "M101101001";
        }

        DeviceClientFactory.getInstance().sendDeviceMessage(params);
    }
}
