FROM golang:1.18.3-bullseye
# Configure to reduce warnings and limitations as instruction from official VSCode Remote-Containers.
# See https://code.visualstudio.com/docs/remote/containers-advanced#_reducing-dockerfile-build-warnings.
RUN apt-get update 
ENV DEBIAN_FRONTEND=noninteractive
RUN apt-get -y install git iproute2 procps lsb-release