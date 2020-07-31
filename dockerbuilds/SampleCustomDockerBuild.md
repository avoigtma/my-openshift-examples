# OpenShift v3/v4 Example - RHEL 7 UBI Container Image

## import RHEL image
Run as cluster admin, as we want to import into openshift namespace  

```shell
$ oc import-image ubi7/ubi --from=registry.access.redhat.com/ubi7/ubi -n openshift --confirm
```

## build dockerfile

### create new build (and target image stream)

> Note: we create a new build config using 'oc new-build', delete the bc afterwards and (re-)create our own build config. This is just a simple 'workaround-style' approach to create the imagestream required as the target of the build :-)

```shell
$ oc new-build --strategy docker --binary --name sample-custom-docker-ubi
$ oc delete bc sample-custom-docker-ubi
$ oc create -f openshift/buildcfg.sampleCustomDockerUbi.yaml
```

### start the build

Creating the BuildConfig will automatically issue a build. To start the build (again), run

```shell
$ oc start-build sample-custom-docker-ubi
```


## deploy

```shell
$ oc create -f openshift/deploycfg.sampleCustomDockerUbi.yaml
```





# OpenShift v3 Example - Plain RHEL 7 Container Image

## Prerequisites

### import RHEL image

Run as cluster admin, as we want to import into openshift namespace  

```shell
$ oc import-image rhel7 --from=registry.access.redhat.com/rhel7 -n openshift --confirm
```

## build dockerfile
### create new build (and target image stream)

> Note: we create a new build config using 'oc new-build', delete the bc afterwards and (re-)create our own build config. This is just a simple 'workaround-style' approach to create the imagestream required as the target of the build :-)

```shell
$ oc new-build --strategy docker --binary --name sample-custom-docker
$ oc delete bc sample-custom-docker
$ oc create -f openshift/buildcfg.sampleCustomDocker.yaml
```

### start the build

Creating the BuildConfig will automatically issue a build. To start the build (again), run

```shell
$ oc start-build sample-custom-docker
```

## deploy

```shell
$ oc create -f openshift/deploycfg.sampleCustomDocker.yaml
```


