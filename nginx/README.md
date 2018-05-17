# example for an OpenShift template setting up a high-available NGINX

## prerequisites

Run as cluster admin (or user with respective permissions).

### import nginx image into namespace 'openshift'
``$ oc import-image rhscl_nginx-112-rhel7 -n openshift --from=registry.access.redhat.com/rhscl/nginx-112-rhel7 --scheduled=true --confirm``

### import the template into namespace 'openshift'
if template does not yet exist
``$ oc create -n openshift -f nginx-application-template.yaml``

if template already exists
``$ oc replace -n openshift -f nginx-application-template.yaml``

## rollout application

Run as arbitrary developer user in respective project.

Create application using the template.  
Certain parameters defined in the template need to be filled:
``$ oc new-app nginx-application-template -n myproject -p NAMESPACE=myproject -p APPLICATION=my-sample-nginx -p APPLICATION_DOMAIN=my.fqdn.com -p GIT_URL=https://github.com/avoigtma/sampleWebPage.git``  

and e.g. on 'minishift' set the registry
``$ oc new-app nginx-application-template -n myproject -p NAMESPACE=myproject -p APPLICATION=my-sample-nginx -p APPLICATION_DOMAIN=192.168.64.9.nip.io -p GIT_URL=https://github.com/avoigtma/sampleWebPage.git -p REGISTRY=172.30.1.1:5000``  

### Rebuild
Remark:
As long as there are no Githooks implemented, changes to the source code repository will need a manual start of the OpenShift build. This can be initiated by the following command; once the build is finished, the deployment will be triggered automatically. ``application-name`` is the name of the application set above when running ``oc new-app``.

``$ oc start-build bc/application-name``  

### Delete all artefacts
To delete all artefacts created by the template:  

``$ oc delete bc my-sample-nginx; oc delete dc my-sample-nginx; oc delete route my-sample-nginx; oc delete svc my-sample-nginx; oc delete is my-sample-nginx; oc delete hpa my-sample-nginx; oc delete poddisruptionbudget my-sample-nginx``  

