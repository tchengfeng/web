package java.sigar.sample.service.jdk.impl;

import com.tech.sigar.service.jdk.IOSJDKService;

import java.net.UnknownHostException;
import java.util.List;

/**
 * Created by BinZ on 2016/8/24.
 */
public class OSJDKServiceImpl implements IOSJDKService {

    private static volatile IOSJDKService osJDKService = null;

    public static IOSJDKService getInstance() {
        if (null == osJDKService) {
            synchronized (OSJDKServiceImpl.class) {
                if (null == osJDKService) {
                    osJDKService = new OSJDKServiceImpl();
                }
            }
        }
        return osJDKService;
    }


    @Override
    public List<String> getAllIpAddress() throws UnknownHostException {
        return NetUtils.getInstance().getAllIpAddress();
    }
}
