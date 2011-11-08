package co.imado;

import java.util.List;

import org.mobylet.core.Mobylet;
import org.mobylet.core.MobyletFactory;
import org.mobylet.core.gps.Gps;

public final class ImadocoUtil {
    
    // 位置情報の取得
    public static Gps getGps() {
        // MobyletインスタンスからGPSを取得する。
        Mobylet mobylet = MobyletFactory.getInstance();
        Gps gps = mobylet.getGps();
        return gps;
    }
    
    
    /**
     * 地図画像のsrc属性を生成する
     * @param userList
     * @return
     */
    public static String makeMapImageSrc(List<User> userList, Integer width, Integer height) {
        StringBuilder sb = new StringBuilder("http://maps.google.com/maps/api/staticmap?type=jpg-baseline&mobile=true&size=");
        sb.append(width).append('x').append(height).append("&sensor=false&markers=");
        int size = userList.size();
        for (int i = 0; i < size; i++) {
            User user = userList.get(i);
            sb.append(user.getLat());
            sb.append(',');
            sb.append(user.getLon());
            if (i < size - 1) {
                sb.append('|');
            }
        }
        return sb.toString();
    }
    
    
    public static Double toDouble(String value) {
        if (value != null) {
            return Double.valueOf(value);
        }
        return 0d;
    }
}
