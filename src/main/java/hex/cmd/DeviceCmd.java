package hex.cmd;

import hex.DeviceStatus;

/**
 * @author yuweixiong
 * @date 2020/12/30 15:03
 * @description
 */
public interface DeviceCmd {
    void handle(byte[] cmdValue, DeviceStatus deviceStatus);
}
