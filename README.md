### Love Match Sample
This is a sample Alfresco webscript project thats been created for the purpose of a benchmark demo.
The sample return a json message that displays total number of users in the system, 2 random user details and their compatibility.
This sample is then loaded test by the benchmark love match driver to highlight different problems that have been purposely introduced into the code.
### Running The Sample 
'''
./run.sh
'''
'''
./run.bad
'''
### Addtional Configuration
Unlike most Alfresco SDK sample project, this has a minor tweak to the run.sh which includes parameters for YourKit.
This allows us to run the sample application with the ability to hook in YourKit to profile the app.
'''
-agentpath:/Applications/YourKit.app/Contents/Resources/mac/libyjpagent.jnilib=disablestacktelemetry,disableexceptiontelemetry,builtinprobes=none,delay=10000,sessionname=Benchmark"
'''
