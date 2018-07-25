# Simple Java application eating up all memory

## Run locally
```
maven package
java -Xmx1024M -XX:+PrintFlagsFinal -jar target/memory-eater.jar
```
(or use any other java memory settings)

## Run on OpenShift
```
# create namespace
oc new-project demo
# import image into current namespace
oc import-image redhat-openjdk18-openshift --from=registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift --confirm
# rollout the application
oc new-app redhat-openjdk18-openshift~https://github.com/avoigtma/my-openshift-examples.git --context-dir=java-mem
```


## References
- derived from: <https://alvinalexander.com/blog/post/java/java-program-consume-all-memory-ram-on-computer>

