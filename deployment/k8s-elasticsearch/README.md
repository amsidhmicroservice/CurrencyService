#Minikube 
minikube start --cpus 4 --memory 5120 --mount-string="C:/Users/amsid/templog:/bureau-service/templog" --mount
# k8s-elasticsearch

See our website blog for more details.

https://faun.pub/setup-elastic-search-cluster-kibana-fluentd-on-kubernetes-with-x-pack-security-part-1-271e57c2fe19/

https://faun.pub/setup-elastic-search-cluster-kibana-fluentd-on-kubernetes-with-x-pack-security-part-2-593a01b79fbb/

https://faun.pub/setup-elastic-search-cluster-kibana-fluentd-on-kubernetes-with-x-pack-security-part-3-5579343b5113/

Deployment sequence 
1) 0namespace
2) 1elsticsearch
   
   a) master
   b) data
   c) client
   
  kubectl get logs of master to see the last success log message as
  "Cluster health status changed from [YELLOW] to [GREEN]"
3) Create the default password for different default users
   C:\Users\amsid>kubectl exec -it pod/elasticsearch-client-58795f8fb8-pdgtj -n infra -- bin/elasticsearch-setup-passwords auto -b
   Defaulted container "elasticsearch-client" out of: elasticsearch-client, increase-vm-max-map (init)
   Changed password for user apm_system
   PASSWORD apm_system = BijjTJAUAu2ekjy43gt2

Changed password for user kibana_system
PASSWORD kibana_system = a26Ox0RMnfQE4DaLbU28

Changed password for user kibana
PASSWORD kibana = a26Ox0RMnfQE4DaLbU28

Changed password for user logstash_system
PASSWORD logstash_system = OTnaYTvux6j4FpvCMA2M

Changed password for user beats_system
PASSWORD beats_system = Nh5hPnW1mkTP0I07TPMn

Changed password for user remote_monitoring_user
PASSWORD remote_monitoring_user = HJAVFIvzzZPmuWukKccJ

Changed password for user elastic
PASSWORD elastic = SHTLLjdPQE9PBrw4A2sd

C:\Users\amsid>
4) kubectl create secret generic elasticsearch-pw-elastic -n infra --from-literal password=SHTLLjdPQE9PBrw4A2sd

5) Check whether we are able to access Elastic indices url with basic auth 
   a) kubectl port-forward service/elasticsearch-client -n infra 9200:9200
   b) curl -X GET -H "Authorization: Basic ZWxhc3RpYzowaFVjMTFUd0RqNWc5aDhLdE1NTA==" http://localhost:9200/_cat/indices

6) Now deploy FluentD/Kibana

