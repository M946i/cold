package com.ll.cold.jobs.task;

import com.ll.cold.jobs.utils.DeviceClientFactory;
import org.springframework.stereotype.Component;

@Component("deviceM301001002")
public class DeviceM301001002 implements ITask {
    @Override
    public void run(String params) {
        if( params == null || params.isEmpty()){
            params = "M301001002";
        }

        DeviceClientFactory.getInstance().sendDeviceMessage(params);
    }
}
