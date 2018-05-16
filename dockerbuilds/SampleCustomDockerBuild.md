
# prerequisites
## import RHEL image
Run as cluster admin, as we want to import into openshift namespace  
``$ oc import-image rhel7 --from=registry.access.redhat.com/rhel7 -n openshift --confirm``  

# build dockerfile
## create new build (and target image stream)
### we delete the bc afterwards and (re-)create our own build config
``$ oc new-build --strategy docker --binary --name sample-custom-docker``  
``$ oc delete bc sample-custom-docker``  
``$ oc create -f buildcfg.sampleCustomDocker.yaml``  

# start the build
``$ oc start-build sample-custom-docker``

# deploy
``$ oc create -f deploycfg.sampleCustomDocker.yaml``

