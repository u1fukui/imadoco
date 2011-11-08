package co.imado;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-11-06 09:49:53")
/** */
public final class UserMeta extends org.slim3.datastore.ModelMeta<co.imado.User> {

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<co.imado.User, org.slim3.datastore.ModelRef<co.imado.Group>, co.imado.Group> groupRef = new org.slim3.datastore.ModelRefAttributeMeta<co.imado.User, org.slim3.datastore.ModelRef<co.imado.Group>, co.imado.Group>(this, "groupRef", "groupRef", org.slim3.datastore.ModelRef.class, co.imado.Group.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<co.imado.User, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<co.imado.User, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<co.imado.User, java.lang.Double> lat = new org.slim3.datastore.CoreAttributeMeta<co.imado.User, java.lang.Double>(this, "lat", "lat", double.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<co.imado.User, java.lang.Double> lon = new org.slim3.datastore.CoreAttributeMeta<co.imado.User, java.lang.Double>(this, "lon", "lon", double.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<co.imado.User> userId = new org.slim3.datastore.StringAttributeMeta<co.imado.User>(this, "userId", "userId");

    private static final UserMeta slim3_singleton = new UserMeta();

    /**
     * @return the singleton
     */
    public static UserMeta get() {
       return slim3_singleton;
    }

    /** */
    public UserMeta() {
        super("User", co.imado.User.class);
    }

    @Override
    public co.imado.User entityToModel(com.google.appengine.api.datastore.Entity entity) {
        co.imado.User model = new co.imado.User();
        if (model.getGroupRef() == null) {
            throw new NullPointerException("The property(groupRef) is null.");
        }
        model.getGroupRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("groupRef"));
        model.setKey(entity.getKey());
        model.setLat(doubleToPrimitiveDouble((java.lang.Double) entity.getProperty("lat")));
        model.setLon(doubleToPrimitiveDouble((java.lang.Double) entity.getProperty("lon")));
        model.setUserId((java.lang.String) entity.getProperty("userId"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        co.imado.User m = (co.imado.User) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        if (m.getGroupRef() == null) {
            throw new NullPointerException("The property(groupRef) must not be null.");
        }
        entity.setProperty("groupRef", m.getGroupRef().getKey());
        entity.setProperty("lat", m.getLat());
        entity.setProperty("lon", m.getLon());
        entity.setProperty("userId", m.getUserId());
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        co.imado.User m = (co.imado.User) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        co.imado.User m = (co.imado.User) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        throw new IllegalStateException("The version property of the model(co.imado.User) is not defined.");
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        co.imado.User m = (co.imado.User) model;
        if (m.getGroupRef() == null) {
            throw new NullPointerException("The property(groupRef) must not be null.");
        }
        m.getGroupRef().assignKeyIfNecessary(ds);
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
        co.imado.User m = (co.imado.User) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getGroupRef() != null && m.getGroupRef().getKey() != null){
            writer.setNextPropertyName("groupRef");
            encoder0.encode(writer, m.getGroupRef(), maxDepth, currentDepth);
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        writer.setNextPropertyName("lat");
        encoder0.encode(writer, m.getLat());
        writer.setNextPropertyName("lon");
        encoder0.encode(writer, m.getLon());
        if(m.getUserId() != null){
            writer.setNextPropertyName("userId");
            encoder0.encode(writer, m.getUserId());
        }
        writer.endObject();
    }

    @Override
    protected co.imado.User jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        co.imado.User m = new co.imado.User();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("groupRef");
        decoder0.decode(reader, m.getGroupRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("lat");
        m.setLat(decoder0.decode(reader, m.getLat()));
        reader = rootReader.newObjectReader("lon");
        m.setLon(decoder0.decode(reader, m.getLon()));
        reader = rootReader.newObjectReader("userId");
        m.setUserId(decoder0.decode(reader, m.getUserId()));
        return m;
    }
}