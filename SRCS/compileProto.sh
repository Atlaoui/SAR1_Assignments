#!/bin/bash

protoc
--proto_path=/home/adrien/SAR1_Assignments/SRCS/TME/SRCS-TP/src/TME5/messages.proto
--proto_path=/home/adrien/SAR1_Assignments/SRCS/TME/SRCS-TP/src/TME5/messages.proto
--plugin=/home/adrien/Software/grpc-java/jars
--grpc-java_out=/home/adrien/SAR1_Assignments/SRCS/
--java_out=/home/adrien/SAR1_Assignments/SRCS/TME/SRCS-TP/src/TME5
messages.proto
