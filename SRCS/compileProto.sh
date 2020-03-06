#!/bin/bash
fileproto=/home/adrien/SAR1_Assignments/SRCS/TME/SRCS-TP/src/TME5/messages.proto
protoc --proto_path=$fileproto --plugin=/home/adrien/Software/grpc-java/jars
--grpc-java_out=/home/adrien/SAR1_Assignments/SRCS
--java_out=/home/adrien/SAR1_Assignments/SRCS/TME/SRCS-TP/src/TME5
messages.proto
