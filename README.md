# newpipe-sync-server
Sync subscriptions, playlists, watch history and other newpipe data across devices.

## Build & Deploy
* Create a mysql database and populate schema using the [np.sql](np.sql) script.
* Configure all properties in the [application.properties](src/main/resources/application.properties) file.
* Build jar using `mvn clean package`
* Run jar using `java -jar target/newpipe-sync-server-0.1.0.jar`
