@echo off
kubectl delete deployment --all -n paysgift
kubectl delete service --all -n paysgift

echo All resources have been down.