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
import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import co.imado.Group;
import co.imado.GroupMeta;
import co.imado.ImadocoUtil;
import co.imado.User;

public class MailController extends Controller {


    Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public Navigation run() throws Exception {
        // 位置情報保存
        Double lat = ImadocoUtil.toDouble(param("x-lat"));
        Double lon = ImadocoUtil.toDouble(param("x-lon"));

        // GPS結果から
        Mobylet mobylet = MobyletFactory.getInstance();
        if (lat == 0d || lon == 0d) {
            logger.info("lat == 0d || lon == 0d , lat=" + lat + ", lon=" + lon);
            Gps gps = ImadocoUtil.getGps();
            if (gps == null) {
                requestScope("message", "位置情報の取得に失敗しました。");
                return forward("error.jsp");
            }
            lat = gps.getLat();
            lon = gps.getLon();
            logger.info("2: lat=" + lat + ", lon=" + lon);
        }

        logger.info("lat=" + lat + ", lon=" + lon);

        Carrier carrier = mobylet.getCarrier();
        if (carrier != null && carrier == Carrier.DOCOMO) {
            String value = param("guid");
            if (!"on".equals(value)) {
                return redirect("mail?guid=on&x-lat=" + lat + "&x-lon=" + lon);
            }
        }

        // ユーザID取得
        String userId = mobylet.getGuid();
        if (userId == null) {
            //userId = getSession();
            if (userId == null) {
                //requestScope("message", "Cookieを有効に、もしくは端末固有IDを通知しないと、このサービスを利用することは出来ません。");
                //return forward("error.jsp");
            }
        }
        logger.info("userId=" + userId);


        // ユーザ情報保存
        String groupId = makeGroupId();
        // グループIDが被ってないかの判定が微妙
        Group group = new Group(groupId, new Date());
        User user = new User(userId, lat, lon);
        user.getGroupRef().setModel(group);
        Datastore.put(group, user);

        // 画像URL生成
        List<User> userList = new ArrayList<User>();
        userList.add(user);
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

        logger.info(imageSrc);

        // メールURL生成
        String linkUrl = makeLinkUrl(groupId);
        requestScope("link_url", linkUrl);

        logger.info(linkUrl);

        return forward("mail.jsp");
    }

    private String makeGroupId() {
        String guid;

        while(true) {
            // ランダム○桁の文字列
            guid = createRandomString(12);

            // 被ってなかったらOK
            // checkDB(guid);
            GroupMeta e = GroupMeta.get();
            List<Group> list = Datastore.query(e)
                .filter(e.groupId.equal(guid))
                .asList();

            if (list.size() == 0) {
                break;
            }
        }

        // 保存
        // saveDB(guid);

        return guid;
    }

    /**
     * ランダムな文字列を作成する。
     * @param size 文字列のサイズ
     * @return 文字列
     *
     * Special Thanks: http://d.hatena.ne.jp/unageanu/20091127
     */
    static String createRandomString( int size ) {
        StringBuilder sb = new StringBuilder();
        for ( int i=0;i<size;i++ ) {
            sb.append( seed[(int)(seed.length*Math.random())] );
        }
        return sb.toString();
    }
    private static final char[] seed = new char[62];
    static {
        int i = 0;
        for ( char c = 'a'; c <= 'z'; c++ ) seed[i++] = c;
        for ( char c = '0'; c <= '9'; c++ ) seed[i++] = c;
        for ( char c = 'A'; c <= 'Z'; c++ ) seed[i++] = c;
    }

    public static final String HOSTNAME = "http://www.imado.co";
    //public static final String HOSTNAME = "http://kyuuki-imadoco.appspot.com";

    private String makeLinkUrl(String gid) {
        return HOSTNAME + "/map/" + gid + "?guid=on";
    }
}
