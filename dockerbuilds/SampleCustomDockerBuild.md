# OpenShift v3/v4 Example - RHEL 7 UBI Container Image

## import RHEL image
Run as cluster admin, as we want to import into openshift namespace  
``$ oc import-image ubi7/ubi --from=registry.access.redhat.com/ubi7/ubi -n openshift --confirm``

## build dockerfile
### create new build (and target image stream)
> Note: we create a new build config using 'oc new-build', delete the bc afterwards and (re-)create our own build config. This is just a simple 'workaround-style' approach to create the imagestream required as the target of the build :-)

``$ oc new-build --strategy docker --binary --name sample-custom-docker-ubi``
``$ oc delete bc sample-custom-docker-ubi``
``$ oc create -f buildcfg.sampleCustomDockerUbi.yaml``

### start the build
``$ oc start-build sample-custom-docker-ubi``

## deploy
``$ oc create -f deploycfg.sampleCustomDockerUbi.yaml``





# OpenShift v3 Example - Plain RHEL 7 Container Image

## prerequisites
### import RHEL image
Run as cluster admin, as we want to import into openshift namespace  
``$ oc import-image rhel7 --from=registry.access.redhat.com/rhel7 -n openshift --confirm``  

## build dockerfile
### create new build (and target image stream)

> Note: we create a new build config using 'oc new-build', delete the bc afterwards and (re-)create our own build config. This is just a simple 'workaround-style' approach to create the imagestream required as the target of the build :-)

``$ oc new-build --strategy docker --binary --name sample-custom-docker``  
``$ oc delete bc sample-custom-docker``  
``$ oc create -f buildcfg.sampleCustomDocker.yaml``  

### start the build
``$ oc start-build sample-custom-docker``

## deploy
``$ oc create -f deploycfg.sampleCustomDocker.yaml``

