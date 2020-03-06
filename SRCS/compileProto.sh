#!/bin/bash
fileproto=$HOME/SAR1_Assignments/SRCS/TME/SRCS-TP/src/TME5
prosrc=/usr/local/protobuf-master/src
grppath=/usr/local/grpc-java-master/compiler/build/exe/java_plugin/protoc-gen-grpc-java

protoc --proto_path=$fileproto --proto_path=$prosrc --plugin=$grppath --grpc-java_out=$HOME/SAR1_Assignments/SRCS/TME/SRCS-TP/src --java_out=$HOME/SAR1_Assignments/SRCS/TME/SRCS-TP/src $fileproto/messages.proto
