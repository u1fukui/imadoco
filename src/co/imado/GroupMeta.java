package co.imado;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-11-06 14:48:29")
/** */
public final class GroupMeta extends org.slim3.datastore.ModelMeta<co.imado.Group> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<co.imado.Group> groupId = new org.slim3.datastore.StringAttributeMeta<co.imado.Group>(this, "groupId", "groupId");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<co.imado.Group, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<co.imado.Group, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<co.imado.Group, java.util.Date> startDate = new org.slim3.datastore.CoreAttributeMeta<co.imado.Group, java.util.Date>(this, "startDate", "startDate", java.util.Date.class);

    private static final GroupMeta slim3_singleton = new GroupMeta();

    /**
     * @return the singleton
     */
    public static GroupMeta get() {
       return slim3_singleton;
    }

    /** */
    public GroupMeta() {
        super("Group", co.imado.Group.class);
    }

    @Override
    public co.imado.Group entityToModel(com.google.appengine.api.datastore.Entity entity) {
        co.imado.Group model = new co.imado.Group();
        model.setGroupId((java.lang.String) entity.getProperty("groupId"));
        model.setKey(entity.getKey());
        model.setStartDate((java.util.Date) entity.getProperty("startDate"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        co.imado.Group m = (co.imado.Group) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("groupId", m.getGroupId());
        entity.setProperty("startDate", m.getStartDate());
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        co.imado.Group m = (co.imado.Group) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        co.imado.Group m = (co.imado.Group) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        throw new IllegalStateException("The version property of the model(co.imado.Group) is not defined.");
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
    }

    @Override
    protected void prePut(Object model) {
    }

    @Override
    protected void postGet(Object model) {
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

    @Override
    protected boolean isCipherProperty(String propertyName) {
        return false;
    }

    @Override
    protected void modelToJson(org.slim3.datastore.json.JsonWriter writer, java.lang.Object model, int maxDepth, int currentDepth) {
        co.imado.Group m = (co.imado.Group) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getGroupId() != null){
            writer.setNextPropertyName("groupId");
            encoder0.encode(writer, m.getGroupId());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getStartDate() != null){
            writer.setNextPropertyName("startDate");
            encoder0.encode(writer, m.getStartDate());
        }
        writer.endObject();
    }

    @Override
    protected co.imado.Group jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        co.imado.Group m = new co.imado.Group();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("groupId");
        m.setGroupId(decoder0.decode(reader, m.getGroupId()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("startDate");
        m.setStartDate(decoder0.decode(reader, m.getStartDate()));
        return m;
    }
}