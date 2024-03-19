package com.ll.cold.jobs.task;

import com.ll.cold.jobs.utils.DeviceClientFactory;
import org.springframework.stereotype.Component;

@Component("deviceSenderTask")
public class DeviceSenderTask implements ITask {
    @Override
    public void run(String params) {

        DeviceClientFactory.getInstance().sendDeviceMessage(params);
    }

}
