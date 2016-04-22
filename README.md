Love Match Sample
=================
This is a sample Alfresco webscript project thats been created for the purpose of a benchmark demo.
The sample returns a json message that displays:
- Total number of users in the system.
- 2 random user details.
- The compatibility match of the selected users.

This sample is then load tested by Alfresco Benchmark to monitor performance and highlight issues.
Please note that this sample contains code that would lead to performance problems.
### Running The Sample 
```
mvn clean install -Pamp-to-war
```
Or simple run the script:
```
./run.sh
```
### Addtional Configuration
Unlike most Alfresco SDK sample project, this has a minor tweak to the run.sh which includes parameters for YourKit.
This allows us to run the sample application with the ability to hook in YourKit to profile the app.
```
-agentpath:/Applications/YourKit.app/Contents/Resources/mac/libyjpagent.jnilib=disablestacktelemetry,disableexceptiontelemetry,builtinprobes=none,delay=10000,sessionname=Benchmark"
```
