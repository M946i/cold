package com.ll.cold.jobs.task;

import com.ll.cold.jobs.utils.DeviceClientFactory;
import org.springframework.stereotype.Component;

@Component("deviceM201002002")
public class DeviceM201002002 implements ITask {
    @Override
    public void run(String params) {
        if( params == null ){
            params = "M201002002";
        }

        DeviceClientFactory.getInstance().sendDeviceMessage(params);
    }
}
