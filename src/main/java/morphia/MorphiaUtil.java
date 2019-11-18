package morphia;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public class MorphiaUtil {

    private static final Morphia morphia = new Morphia().mapPackage("model");
    private static final Datastore datastore = morphia.createDatastore(new MongoClient(), "dsp_trabalho3");

    public static Datastore getDatastore() {
        datastore.ensureIndexes();
        return datastore;
    }

}
