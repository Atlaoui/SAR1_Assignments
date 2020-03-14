cmake_minimum_required(VERSION 3.15)
project(tme5-BlablaY-master)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++17 -pthread")

add_executable(tme5-BlablaY-master /home/adrien/CLionProjects/tme5-BlablaY-master/src/rsleep.cpp /home/adrien/CLionProjects/tme5-BlablaY-master/src/rsleep.h /home/adrien/CLionProjects/tme5-BlablaY-master/src/fork_exo.cpp TD6/fork1.cpp src/ExecCode/code_exec.cpp src/Handler/Handler.cpp TD6/signaux.cpp)