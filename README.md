# Service--Kotlin

Intent Service :
Service class uses the application's main thread, while IntentService creates a worker thread and uses that thread to run the service. IntentService creates a queue that passes one intent at a time to onHandleIntent()

manifests

    <service
            android:name=".IntntService"
            tools:ignore="Instantiatable" />
