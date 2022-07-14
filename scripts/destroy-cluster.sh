#!/bin/bash

set -x

. ./set-env.sh

. ./delete-all.sh

kubectl config set-context $CLUSTER_NAME
kubectl config use-context $CLUSTER_NAME

kubectl delete clusterrolebinding service-pod-reader-init-container
kubectl delete clusterrolebinding service-pod-reader-dashboard
kubectl delete clusterrolebinding service-pod-reader-importer
kubectl delete clusterrolebinding service-pod-reader-rabbitmq
kubectl delete clusterrolebinding service-pod-reader-mysql

kubectl delete serviceaccount $SA_NAME -n $K8S_NAMESPACE

kubectl delete clusterrole microservices-kubernetes-namespace-reader

kubectl delete namespace $K8S_NAMESPACE

exit;