###On Minikube local cluster
minikube start -p multinodecluster --nodes 2 --cpus 4 --memory 5120
minikube dashboard
This is Github path https://github.com/elastic/helm-charts/blob/main/elasticsearch/examples/minikube/values.yaml
This is Github raw path https://raw.githubusercontent.com/elastic/helm-charts/master/elasticsearch/examples/minikube/values.yaml
Use this raw path for below command

helm install elasticsearch elastic/elasticsearch -f https://raw.githubusercontent.com/elastic/helm-charts/master/elasticsearch/examples/minikube/values.yaml

https://github.com/elastic/helm-charts/blob/main/kibana/values.yaml
https://raw.githubusercontent.com/elastic/helm-charts/master/kibana/values.yaml
helm install kibana elastic/kibana -f https://raw.githubusercontent.com/elastic/helm-charts/master/kibana/values.yaml



###On GKE Cluster

helm install elasticsearch elastic/elasticsearch -f https://raw.githubusercontent.com/elastic/helm-charts/master/elasticsearch/examples/kubernetes-kind/values.yaml

https://github.com/elastic/helm-charts/blob/main/kibana/values.yaml
https://raw.githubusercontent.com/elastic/helm-charts/master/kibana/values.yaml

helm install kibana elastic/kibana -f https://raw.githubusercontent.com/elastic/helm-charts/master/kibana/values.yaml






https://github.com/elastic/helm-charts/blob/main/elasticsearch/examples/minikube/values.yaml
https://raw.githubusercontent.com/elastic/helm-charts/master/elasticsearch/examples/minikube/values.yaml


https://github.com/elastic/helm-charts/blob/main/elasticsearch/examples/kubernetes-kind/values.yaml
https://raw.githubusercontent.com/elastic/helm-charts/master/elasticsearch/examples/kubernetes-kind/values.yaml


