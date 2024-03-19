package com.ll.cold.jobs.utils;

import com.ll.cold.common.netty.entity.MessageEntity;
import com.ll.cold.common.utils.YmlUtil;
import com.ll.cold.jobs.service.ClientDeviceHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DeviceClientFactory {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private static Channel channel;

    private static final DeviceClientFactory client = new DeviceClientFactory();

    public static DeviceClientFactory getInstance() {
        return client;
    }

    /**
     * 向Netty服务端发送信息
     *
     * @param meterCode
     */
    public void sendDeviceMessage(String meterCode) {
        try {
            String msg = getRandomMsg(meterCode);

            logger.info(msg);

            this.connect(msg);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * 模拟硬件:
     * 1.连接平台(不同类型硬件对应不同的端口);
     * 2.向平台发送报文(ClientDeviceHandler);
     *
     * @throws Exception
     */
    private void connect(final String msg) throws Exception {
        // 设置netty服务器的ip、端口
        String host = YmlUtil.getValue("netty.host").toString();
        int port = Integer.parseInt(YmlUtil.getValue("netty.port").toString());

        //设置netty客户端主线程
        Bootstrap bootstrap = new Bootstrap();

        //设置连接缓冲池
        EventLoopGroup group = new NioEventLoopGroup();

        //配置客户端主线程的参数
        bootstrap.group(group);
        //通道的类型
        bootstrap.channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true); //发送类型，非延迟
        //执行程序
        bootstrap.handler(
                new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline p = ch.pipeline();
                        p.addLast("decoder", new StringDecoder());
                        p.addLast("encoder", new StringEncoder());
                        p.addLast(new ClientDeviceHandler(msg));
                    }
                }
        );

        try {
            //发起异步连接操作(异步连接服务器)
            ChannelFuture channelFuture = bootstrap.connect(host, port).sync();
            channel = channelFuture.channel();
            //异步等待关闭连接channel
            channel.closeFuture().sync();
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        } finally {
            group.shutdownGracefully(); //释放线程池资源
        }
    }

    /**
     * 随机报文
     */
    private String getRandomMsg(String meterCode) {
        MessageEntity me = new MessageEntity();
        me.setMetercode(meterCode);

        //设置随机温度
        int maxTem = 100;
        int minTem = -100;
        me.setTem(getRandom(minTem, maxTem));

        //设置随机湿度
        int maxHum = 100;
        int minHum = 0;
        me.setHum(getRandom(minHum, maxHum));

        //设置随机状态
        int state = Integer.valueOf(getRandom(0, 100)) % 3;
        me.setState(state);

        //设置当前时间
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date(System.currentTimeMillis());
        me.setCurtime(formatter.format(date));

        return me.deviceMessage();
    }

    /**
     * 获得两数之间的随机数字
     *
     * @param min
     * @param max
     * @return
     */
    private int getRandom(int min, int max) {
        Random random = new Random();
        int i = random.nextInt(max) % (max - min + 1) + min;
        return i;
    }


    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        DeviceClientFactory.getInstance().sendDeviceMessage("M101001002");
    }

}
