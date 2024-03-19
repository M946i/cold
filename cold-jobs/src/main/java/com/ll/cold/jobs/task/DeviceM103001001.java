package com.ll.cold.jobs.task;

import com.ll.cold.jobs.utils.DeviceClientFactory;
import org.springframework.stereotype.Component;

@Component("deviceM103001001")
public class DeviceM103001001 implements ITask {
    @Override
    public void run(String params) {
        if( params == null ){
            params = "M103001001";
        }

        DeviceClientFactory.getInstance().sendDeviceMessage(params);
    }
}
