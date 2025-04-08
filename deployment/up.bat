@echo off

REM Create the Paysgift namespace if it doesn't exist
kubectl create namespace paysgift || echo Namespace 'paysgift' already exists.

REM Create Persistent Volume Claims
kubectl apply -f service/mysql-pvc.yaml -n paysgift
kubectl apply -f service/redis-pvc.yaml -n paysgift
kubectl apply -f service/zookeeper-pvc.yaml -n paysgift
kubectl apply -f service/kafka-pvc.yaml -n paysgift

REM Create Services
kubectl apply -f service/mysql-service.yaml -n paysgift
kubectl apply -f service/redis-service.yaml -n paysgift
kubectl apply -f service/zookeeper-service.yaml -n paysgift
kubectl apply -f service/kafka-service.yaml -n paysgift

REM Create Deployments
kubectl apply -f service/mysql-deployment.yaml -n paysgift
kubectl apply -f service/redis-deployment.yaml -n paysgift
kubectl apply -f service/zookeeper-deployment.yaml -n paysgift
kubectl apply -f service/kafka-configmap.yaml -n paysgift
kubectl apply -f service/kafka-deployment.yaml -n paysgift

REM Create API Gateway Service and Deployment
kubectl apply -f app/paysgift-apigateway-service.yaml -n paysgift
kubectl apply -f app/paysgift-apigateway-deployment.yaml -n paysgift


REM Create Web App Service and Deployment
kubectl apply -f app/paysgift-web-service.yaml -n paysgift
kubectl apply -f app/paysgift-web-deployment.yaml -n paysgift

REM Create Web Admin Service and Deployment
kubectl apply -f app/paysgift-admin-service.yaml -n paysgift
kubectl apply -f app/paysgift-admin-deployment.yaml -n paysgift

kubectl apply -f monitoring/paysgift-grafana.yaml -n paysgift
kubectl apply -f monitoring/paysgift-prometheus.yaml -n paysgift

echo All resources have been applied.

