# k8s-elasticsearch

See our website blog for more details.

https://faun.pub/setup-elastic-search-cluster-kibana-fluentd-on-kubernetes-with-x-pack-security-part-1-271e57c2fe19/

https://faun.pub/setup-elastic-search-cluster-kibana-fluentd-on-kubernetes-with-x-pack-security-part-2-593a01b79fbb/

https://faun.pub/setup-elastic-search-cluster-kibana-fluentd-on-kubernetes-with-x-pack-security-part-3-5579343b5113/



$ kubectl exec -it $(kubectl get pods -n infra | grep elasticsearch-client | sed -n 1p | awk '{print $1}') -n infra -- bin/elasticsearch-setup-passwords auto -b

kubectl create secret generic elasticsearch-pw-elastic -n infra --from-literal password=XOzLZRfCEZRuudHavHh7


