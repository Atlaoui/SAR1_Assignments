cmake_minimum_required(VERSION 3.15)
project(PRT)

set(CMAKE_CXX_STANDARD 17 )
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++17 -pthread")

add_executable(PRT main.cpp Compte.cpp Compte.h transferts.cpp)