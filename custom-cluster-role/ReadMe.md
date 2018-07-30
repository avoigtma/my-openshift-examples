

- Load the cluster role (run as cluster-admin user)
```oc create -f monitoring-cluster-role.yaml```
- Assign a user or group to the role

	- User

		```oc adm policy add-cluster-role-to-user monitoring-role <user-id>```

	- Group

		```oc adm policy add-cluster-role-to-group monitoring-role <group-name>```

