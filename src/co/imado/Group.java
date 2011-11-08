package co.imado;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.InverseModelListRef;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;

/**
 * 招集グループ。
 *
 * ある人が開始した、一連の招集アクション。
 * 複数のユーザーの位置を複数のユーザーで共有する。
 */
@Model
public class Group {
    @Attribute(primaryKey = true)
    private Key key;

    private String groupId;  // 簡易パスワードがわり
    private Date startDate;  // 招集開始時刻

    // 一対多のおきまり？
    @Attribute(persistent=false)
    private InverseModelListRef<User, Group> userListRef = new InverseModelListRef<User, Group>(User.class, UserMeta.get().groupRef, this);

    // なぜかデフォルトコンストラクタが必要？！
    public Group() {
    }

    public Group(String groupId, Date startDate) {
        this.groupId = groupId;
        this.startDate = startDate;
    }

    /*
     * ユーザーを取得するための便利メソッド。
     */
    public static List<User> getUsers(String groupId) {
        Group group = getGroup(groupId);
        if (group == null) {
            return new ArrayList<User>();
        }
        return group.getUserListRef().getModelList();
    }
    
    public static Group getGroup(String groupId) {
        GroupMeta e = GroupMeta.get();
        List<Group> list = Datastore.query(e)
            .filter(e.groupId.equal(groupId))
            .asList();
        
        if (list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    /*
     * getter/setter
     */
    public Key getKey() {
        return key;
    }
    public void setKey(Key key) {
        this.key = key;
    }
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
    public String getGroupId() {
        return groupId;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public InverseModelListRef<User, Group> getUserListRef() {
        return userListRef;
    }
}
