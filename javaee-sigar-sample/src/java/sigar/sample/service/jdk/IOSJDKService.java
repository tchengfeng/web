package java.sigar.sample.service.jdk;

import java.net.UnknownHostException;
import java.util.List;

/**
 * Created by BinZ on 2016/8/24.
 */
public interface IOSJDKService {

    /**
     * 获取所有的ip地址
     *
     * @return 如果为空表示获取失败
     * @throws UnknownHostException 操作异常
     */
    List<String> getAllIpAddress() throws UnknownHostException;
}
