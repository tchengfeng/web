package java.sigar.sample.service.jdk.impl;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by BinZ on 2016/8/24.
 */
class NetUtils {
    
    private static volatile NetUtils netUtils = null;

    private NetUtils() {
    }

    public static NetUtils getInstance() {
        if (null == netUtils) {
            synchronized (NetUtils.class) {
                if (null == netUtils) {
                    netUtils = new NetUtils();
                }
            }
        }
        return netUtils;
    }

    /**
     * 获取所有的ip地址
     *
     * @return 如果为空表示获取失败
     * @throws UnknownHostException 操作异常
     */
    public List<String> getAllIpAddress() throws UnknownHostException {
        String hostName = getLocalHostName();
        List<String> resultLt = new ArrayList<String>();
        if (null != hostName && 0 < hostName.length()) {
            InetAddress[] addresses = InetAddress.getAllByName(hostName);
            if (null != addresses && 0 < addresses.length) {
                for (int i = 0; i < addresses.length; i++) {
                    resultLt.add(addresses[i].getHostAddress());
                }
            }
        }
        return resultLt;
    }

    private String getLocalHostName() throws UnknownHostException {
        String hostName;
        InetAddress addr = InetAddress.getLocalHost();
        hostName = addr.getHostAddress();
        return hostName;
    }
}
