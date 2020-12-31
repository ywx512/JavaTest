package hex.cmd;

import hex.ByteUtil;

import java.util.HashMap;

/**
 * @author yuweixiong
 * @date 2020/12/30 15:04
 * @description
 */
public class DeviceCmdFactory {
    private static final HashMap<String, Class<? extends DeviceCmd>> CMD_TYPE_MAP = new HashMap<>();

    static {
        CMD_TYPE_MAP.put(Mode.TYPE, Mode.class);
        CMD_TYPE_MAP.put(Speed.TYPE, Speed.class);
        CMD_TYPE_MAP.put(Temperature.TYPE, Temperature.class);
        CMD_TYPE_MAP.put(Time.TYPE, Time.class);
        CMD_TYPE_MAP.put(DeviceStartStatus.TYPE, DeviceStartStatus.class);
    }

    public static DeviceCmd makeDeviceCmd(String cmdType) {
        Class<? extends DeviceCmd> clazz = CMD_TYPE_MAP.get(cmdType);
        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static DeviceCmd makeDeviceCmd(byte[] cmd) {
        String cmdType = ByteUtil.bytesToHexStr(cmd);
        return makeDeviceCmd(cmdType);
    }
}
