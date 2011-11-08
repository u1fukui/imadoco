package co.imado.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.mobylet.core.Carrier;
import org.mobylet.core.Mobylet;
import org.mobylet.core.MobyletFactory;
import org.mobylet.core.device.DeviceDisplay;
import org.mobylet.core.gps.Gps;
import org.mobylet.core.http.MobyletRequest;
import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import co.imado.Group;
import co.imado.ImadocoUtil;
import co.imado.User;

public class MapController extends Controller {
    
    Logger logger = Logger.getLogger(this.getClass().getName());
 
    // 位置情報による検索
    @Override
    public Navigation run() throws Exception {
        Mobylet mobylet = MobyletFactory.getInstance();
        String userId = mobylet.getGuid();
        String groupId = param("gid");
        logger.info("1: groupId=" + groupId);
        if (groupId == null) {
            groupId = extractGroupId(getForwardServletPath());
            logger.info("2: groupId=" + groupId);
        }
        requestScope("groupId", groupId);
        
        Double lat = ImadocoUtil.toDouble(param("x-lat"));
        Double lon = ImadocoUtil.toDouble(param("x-lon"));

        // 位置情報を取得
        boolean hasLocationInfo = true;
        if (lat == 0d || lon == 0d) {
            Gps gps = ImadocoUtil.getGps();
            if (gps != null) {
                lat = gps.getLat();
                lon = gps.getLon();
                
                Carrier carrier = mobylet.getCarrier();
                if (carrier != null && carrier == Carrier.DOCOMO) {
                    String value = param("guid");
                    if (!"on".equals(value)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("map?guid=on&x-lat=").append(lat);
                        sb.append("&x-lon=").append(lon);
                        sb.append("&gid=").append(groupId);
                        return redirect(sb.toString());
                    }
                }
            } else {
                hasLocationInfo = false;
            }
        }
     // 登録
        if (hasLocationInfo) {
            logger.info("save");
            // User user = new User(userId, lat, lon);
            // Group group = Group.getGroup(groupId);
            // user.getGroupRef().setModel(group);
            // Datastore.put(user);
    
            // ユーザー取得 (同時アクセスとかトランザクションとか全然考えてないです。。。)
            Group group = Group.getGroup(groupId);
            User user = null;
    
            List<User> list = Group.getUsers(groupId);
            for (int i = 0; i < list.size(); i++) {
                User u = list.get(i);
                if (u.getUserId().equals(userId)) {
                    user = u;
                    user.setLat(lat);
                    user.setLon(lon);
                    Datastore.put(user);
            
                    logger.info("user update");
                    break;
                }
            }
    
            if (user == null) {
                user = new User(userId, lat, lon);
                user.getGroupRef().setModel(group);
                Datastore.put(user);
                logger.info("user create");
            }
        }
        
        // グループメンバーの情報取得
        List<User> userList = Group.getUsers(groupId);
        
        // 地図画像のsrc属性を生成
        DeviceDisplay display = mobylet.getDisplay();
        Integer w;
        Integer h;
        if (display == null) {
            w = 400;
            h = 400;
        } else {
            w = display.getWidth();
            h = display.getHeight();
        }
        String imageSrc = ImadocoUtil.makeMapImageSrc(userList, w, h);
        requestScope("image_src", imageSrc);
        
        if (hasLocationInfo) {
            return forward("map_after.jsp");
        } else {
            return forward("map.jsp");
        }
    }
    
    private static String extractGroupId(String path) {
        int idx = path.lastIndexOf('/');
        return path.substring(idx + 1);
    }
    
    private String getColor(int uid) {
        switch(uid) {
        case 1:
            return "red";
        case 2:
            return "blue";
        case 3:
            return "green";
        case 4:
            return "orange";
        case 5:
            return "yellow";
        }
        return "black";
    }
}
