package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.LinkView;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class PinImageRealmProxy extends com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage
    implements RealmObjectProxy, PinImageRealmProxyInterface {

    static final class PinImageColumnInfo extends ColumnInfo {
        long idIndex;
        long rawImageIndex;
        long smallImageIndex;
        long regularImageIndex;
        long fullImageIndex;
        long thumbImageIndex;

        PinImageColumnInfo(SharedRealm realm, Table table) {
            super(6);
            this.idIndex = addColumnDetails(table, "id", RealmFieldType.STRING);
            this.rawImageIndex = addColumnDetails(table, "rawImage", RealmFieldType.STRING);
            this.smallImageIndex = addColumnDetails(table, "smallImage", RealmFieldType.STRING);
            this.regularImageIndex = addColumnDetails(table, "regularImage", RealmFieldType.STRING);
            this.fullImageIndex = addColumnDetails(table, "fullImage", RealmFieldType.STRING);
            this.thumbImageIndex = addColumnDetails(table, "thumbImage", RealmFieldType.STRING);
        }

        PinImageColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new PinImageColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final PinImageColumnInfo src = (PinImageColumnInfo) rawSrc;
            final PinImageColumnInfo dst = (PinImageColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.rawImageIndex = src.rawImageIndex;
            dst.smallImageIndex = src.smallImageIndex;
            dst.regularImageIndex = src.regularImageIndex;
            dst.fullImageIndex = src.fullImageIndex;
            dst.thumbImageIndex = src.thumbImageIndex;
        }
    }

    private PinImageColumnInfo columnInfo;
    private ProxyState<com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage> proxyState;
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("rawImage");
        fieldNames.add("smallImage");
        fieldNames.add("regularImage");
        fieldNames.add("fullImage");
        fieldNames.add("thumbImage");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    PinImageRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (PinImageColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$rawImage() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.rawImageIndex);
    }

    @Override
    public void realmSet$rawImage(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.rawImageIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.rawImageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.rawImageIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.rawImageIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$smallImage() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.smallImageIndex);
    }

    @Override
    public void realmSet$smallImage(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.smallImageIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.smallImageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.smallImageIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.smallImageIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$regularImage() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.regularImageIndex);
    }

    @Override
    public void realmSet$regularImage(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.regularImageIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.regularImageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.regularImageIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.regularImageIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$fullImage() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.fullImageIndex);
    }

    @Override
    public void realmSet$fullImage(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.fullImageIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.fullImageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.fullImageIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.fullImageIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$thumbImage() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.thumbImageIndex);
    }

    @Override
    public void realmSet$thumbImage(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.thumbImageIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.thumbImageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.thumbImageIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.thumbImageIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("PinImage");
        builder.addProperty("id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addProperty("rawImage", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addProperty("smallImage", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addProperty("regularImage", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addProperty("fullImage", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addProperty("thumbImage", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
         return expectedObjectSchemaInfo;
    }

    public static PinImageColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_PinImage")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'PinImage' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_PinImage");
        final long columnCount = table.getColumnCount();
        if (columnCount != 6) {
            if (columnCount < 6) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 6 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 6 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 6 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final PinImageColumnInfo columnInfo = new PinImageColumnInfo(sharedRealm, table);

        if (!table.hasPrimaryKey()) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'id' in existing Realm file. @PrimaryKey was added.");
        } else {
            if (table.getPrimaryKey() != columnInfo.idIndex) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key annotation definition was changed, from field " + table.getColumnName(table.getPrimaryKey()) + " to field id");
            }
        }

        if (!columnTypes.containsKey("id")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("id") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'id' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.idIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'id' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
        }
        if (!table.hasSearchIndex(table.getColumnIndex("id"))) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'id' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
        }
        if (!columnTypes.containsKey("rawImage")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'rawImage' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("rawImage") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'rawImage' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.rawImageIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'rawImage' is required. Either set @Required to field 'rawImage' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("smallImage")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'smallImage' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("smallImage") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'smallImage' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.smallImageIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'smallImage' is required. Either set @Required to field 'smallImage' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("regularImage")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'regularImage' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("regularImage") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'regularImage' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.regularImageIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'regularImage' is required. Either set @Required to field 'regularImage' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("fullImage")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'fullImage' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("fullImage") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'fullImage' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.fullImageIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'fullImage' is required. Either set @Required to field 'fullImage' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("thumbImage")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'thumbImage' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("thumbImage") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'thumbImage' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.thumbImageIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'thumbImage' is required. Either set @Required to field 'thumbImage' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_PinImage";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage obj = null;
        if (update) {
            Table table = realm.getTable(com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("id")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage.class), false, Collections.<String> emptyList());
                    obj = new io.realm.PinImageRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.PinImageRealmProxy) realm.createObjectInternal(com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.PinImageRealmProxy) realm.createObjectInternal(com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }
        if (json.has("rawImage")) {
            if (json.isNull("rawImage")) {
                ((PinImageRealmProxyInterface) obj).realmSet$rawImage(null);
            } else {
                ((PinImageRealmProxyInterface) obj).realmSet$rawImage((String) json.getString("rawImage"));
            }
        }
        if (json.has("smallImage")) {
            if (json.isNull("smallImage")) {
                ((PinImageRealmProxyInterface) obj).realmSet$smallImage(null);
            } else {
                ((PinImageRealmProxyInterface) obj).realmSet$smallImage((String) json.getString("smallImage"));
            }
        }
        if (json.has("regularImage")) {
            if (json.isNull("regularImage")) {
                ((PinImageRealmProxyInterface) obj).realmSet$regularImage(null);
            } else {
                ((PinImageRealmProxyInterface) obj).realmSet$regularImage((String) json.getString("regularImage"));
            }
        }
        if (json.has("fullImage")) {
            if (json.isNull("fullImage")) {
                ((PinImageRealmProxyInterface) obj).realmSet$fullImage(null);
            } else {
                ((PinImageRealmProxyInterface) obj).realmSet$fullImage((String) json.getString("fullImage"));
            }
        }
        if (json.has("thumbImage")) {
            if (json.isNull("thumbImage")) {
                ((PinImageRealmProxyInterface) obj).realmSet$thumbImage(null);
            } else {
                ((PinImageRealmProxyInterface) obj).realmSet$thumbImage((String) json.getString("thumbImage"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage obj = new com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PinImageRealmProxyInterface) obj).realmSet$id(null);
                } else {
                    ((PinImageRealmProxyInterface) obj).realmSet$id((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("rawImage")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PinImageRealmProxyInterface) obj).realmSet$rawImage(null);
                } else {
                    ((PinImageRealmProxyInterface) obj).realmSet$rawImage((String) reader.nextString());
                }
            } else if (name.equals("smallImage")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PinImageRealmProxyInterface) obj).realmSet$smallImage(null);
                } else {
                    ((PinImageRealmProxyInterface) obj).realmSet$smallImage((String) reader.nextString());
                }
            } else if (name.equals("regularImage")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PinImageRealmProxyInterface) obj).realmSet$regularImage(null);
                } else {
                    ((PinImageRealmProxyInterface) obj).realmSet$regularImage((String) reader.nextString());
                }
            } else if (name.equals("fullImage")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PinImageRealmProxyInterface) obj).realmSet$fullImage(null);
                } else {
                    ((PinImageRealmProxyInterface) obj).realmSet$fullImage((String) reader.nextString());
                }
            } else if (name.equals("thumbImage")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PinImageRealmProxyInterface) obj).realmSet$thumbImage(null);
                } else {
                    ((PinImageRealmProxyInterface) obj).realmSet$thumbImage((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage copyOrUpdate(Realm realm, com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage) cachedRealmObject;
        }

        com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage.class);
            long pkColumnIndex = table.getPrimaryKey();
            String value = ((PinImageRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (value == null) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, value);
            }
            if (rowIndex != Table.NO_MATCH) {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.PinImageRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            } else {
                canUpdate = false;
            }
        }

        if (canUpdate) {
            return update(realm, realmObject, object, cache);
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage copy(Realm realm, com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage realmObject = realm.createObjectInternal(com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage.class, ((PinImageRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        PinImageRealmProxyInterface realmObjectSource = (PinImageRealmProxyInterface) newObject;
        PinImageRealmProxyInterface realmObjectCopy = (PinImageRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$rawImage(realmObjectSource.realmGet$rawImage());
        realmObjectCopy.realmSet$smallImage(realmObjectSource.realmGet$smallImage());
        realmObjectCopy.realmSet$regularImage(realmObjectSource.realmGet$regularImage());
        realmObjectCopy.realmSet$fullImage(realmObjectSource.realmGet$fullImage());
        realmObjectCopy.realmSet$thumbImage(realmObjectSource.realmGet$thumbImage());
        return realmObject;
    }

    public static long insert(Realm realm, com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage.class);
        long tableNativePtr = table.getNativePtr();
        PinImageColumnInfo columnInfo = (PinImageColumnInfo) realm.schema.getColumnInfo(com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((PinImageRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, primaryKeyValue);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$rawImage = ((PinImageRealmProxyInterface) object).realmGet$rawImage();
        if (realmGet$rawImage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.rawImageIndex, rowIndex, realmGet$rawImage, false);
        }
        String realmGet$smallImage = ((PinImageRealmProxyInterface) object).realmGet$smallImage();
        if (realmGet$smallImage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.smallImageIndex, rowIndex, realmGet$smallImage, false);
        }
        String realmGet$regularImage = ((PinImageRealmProxyInterface) object).realmGet$regularImage();
        if (realmGet$regularImage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.regularImageIndex, rowIndex, realmGet$regularImage, false);
        }
        String realmGet$fullImage = ((PinImageRealmProxyInterface) object).realmGet$fullImage();
        if (realmGet$fullImage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fullImageIndex, rowIndex, realmGet$fullImage, false);
        }
        String realmGet$thumbImage = ((PinImageRealmProxyInterface) object).realmGet$thumbImage();
        if (realmGet$thumbImage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.thumbImageIndex, rowIndex, realmGet$thumbImage, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage.class);
        long tableNativePtr = table.getNativePtr();
        PinImageColumnInfo columnInfo = (PinImageColumnInfo) realm.schema.getColumnInfo(com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage object = null;
        while (objects.hasNext()) {
            object = (com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((PinImageRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
            } else {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, primaryKeyValue);
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$rawImage = ((PinImageRealmProxyInterface) object).realmGet$rawImage();
            if (realmGet$rawImage != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.rawImageIndex, rowIndex, realmGet$rawImage, false);
            }
            String realmGet$smallImage = ((PinImageRealmProxyInterface) object).realmGet$smallImage();
            if (realmGet$smallImage != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.smallImageIndex, rowIndex, realmGet$smallImage, false);
            }
            String realmGet$regularImage = ((PinImageRealmProxyInterface) object).realmGet$regularImage();
            if (realmGet$regularImage != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.regularImageIndex, rowIndex, realmGet$regularImage, false);
            }
            String realmGet$fullImage = ((PinImageRealmProxyInterface) object).realmGet$fullImage();
            if (realmGet$fullImage != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fullImageIndex, rowIndex, realmGet$fullImage, false);
            }
            String realmGet$thumbImage = ((PinImageRealmProxyInterface) object).realmGet$thumbImage();
            if (realmGet$thumbImage != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.thumbImageIndex, rowIndex, realmGet$thumbImage, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage.class);
        long tableNativePtr = table.getNativePtr();
        PinImageColumnInfo columnInfo = (PinImageColumnInfo) realm.schema.getColumnInfo(com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((PinImageRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$rawImage = ((PinImageRealmProxyInterface) object).realmGet$rawImage();
        if (realmGet$rawImage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.rawImageIndex, rowIndex, realmGet$rawImage, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.rawImageIndex, rowIndex, false);
        }
        String realmGet$smallImage = ((PinImageRealmProxyInterface) object).realmGet$smallImage();
        if (realmGet$smallImage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.smallImageIndex, rowIndex, realmGet$smallImage, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.smallImageIndex, rowIndex, false);
        }
        String realmGet$regularImage = ((PinImageRealmProxyInterface) object).realmGet$regularImage();
        if (realmGet$regularImage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.regularImageIndex, rowIndex, realmGet$regularImage, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.regularImageIndex, rowIndex, false);
        }
        String realmGet$fullImage = ((PinImageRealmProxyInterface) object).realmGet$fullImage();
        if (realmGet$fullImage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fullImageIndex, rowIndex, realmGet$fullImage, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fullImageIndex, rowIndex, false);
        }
        String realmGet$thumbImage = ((PinImageRealmProxyInterface) object).realmGet$thumbImage();
        if (realmGet$thumbImage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.thumbImageIndex, rowIndex, realmGet$thumbImage, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.thumbImageIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage.class);
        long tableNativePtr = table.getNativePtr();
        PinImageColumnInfo columnInfo = (PinImageColumnInfo) realm.schema.getColumnInfo(com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage object = null;
        while (objects.hasNext()) {
            object = (com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((PinImageRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
            } else {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$rawImage = ((PinImageRealmProxyInterface) object).realmGet$rawImage();
            if (realmGet$rawImage != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.rawImageIndex, rowIndex, realmGet$rawImage, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.rawImageIndex, rowIndex, false);
            }
            String realmGet$smallImage = ((PinImageRealmProxyInterface) object).realmGet$smallImage();
            if (realmGet$smallImage != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.smallImageIndex, rowIndex, realmGet$smallImage, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.smallImageIndex, rowIndex, false);
            }
            String realmGet$regularImage = ((PinImageRealmProxyInterface) object).realmGet$regularImage();
            if (realmGet$regularImage != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.regularImageIndex, rowIndex, realmGet$regularImage, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.regularImageIndex, rowIndex, false);
            }
            String realmGet$fullImage = ((PinImageRealmProxyInterface) object).realmGet$fullImage();
            if (realmGet$fullImage != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fullImageIndex, rowIndex, realmGet$fullImage, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.fullImageIndex, rowIndex, false);
            }
            String realmGet$thumbImage = ((PinImageRealmProxyInterface) object).realmGet$thumbImage();
            if (realmGet$thumbImage != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.thumbImageIndex, rowIndex, realmGet$thumbImage, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.thumbImageIndex, rowIndex, false);
            }
        }
    }

    public static com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage createDetachedCopy(com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage) cachedObject.object;
            }
            unmanagedObject = (com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        PinImageRealmProxyInterface unmanagedCopy = (PinImageRealmProxyInterface) unmanagedObject;
        PinImageRealmProxyInterface realmSource = (PinImageRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$rawImage(realmSource.realmGet$rawImage());
        unmanagedCopy.realmSet$smallImage(realmSource.realmGet$smallImage());
        unmanagedCopy.realmSet$regularImage(realmSource.realmGet$regularImage());
        unmanagedCopy.realmSet$fullImage(realmSource.realmGet$fullImage());
        unmanagedCopy.realmSet$thumbImage(realmSource.realmGet$thumbImage());
        return unmanagedObject;
    }

    static com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage update(Realm realm, com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage realmObject, com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage newObject, Map<RealmModel, RealmObjectProxy> cache) {
        PinImageRealmProxyInterface realmObjectTarget = (PinImageRealmProxyInterface) realmObject;
        PinImageRealmProxyInterface realmObjectSource = (PinImageRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$rawImage(realmObjectSource.realmGet$rawImage());
        realmObjectTarget.realmSet$smallImage(realmObjectSource.realmGet$smallImage());
        realmObjectTarget.realmSet$regularImage(realmObjectSource.realmGet$regularImage());
        realmObjectTarget.realmSet$fullImage(realmObjectSource.realmGet$fullImage());
        realmObjectTarget.realmSet$thumbImage(realmObjectSource.realmGet$thumbImage());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("PinImage = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{rawImage:");
        stringBuilder.append(realmGet$rawImage() != null ? realmGet$rawImage() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{smallImage:");
        stringBuilder.append(realmGet$smallImage() != null ? realmGet$smallImage() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{regularImage:");
        stringBuilder.append(realmGet$regularImage() != null ? realmGet$regularImage() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{fullImage:");
        stringBuilder.append(realmGet$fullImage() != null ? realmGet$fullImage() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{thumbImage:");
        stringBuilder.append(realmGet$thumbImage() != null ? realmGet$thumbImage() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PinImageRealmProxy aPinImage = (PinImageRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPinImage.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPinImage.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPinImage.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
