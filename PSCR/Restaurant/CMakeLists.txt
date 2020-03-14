cmake_minimum_required(VERSION 3.15)
project(Restaurant)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++17 -pthread")
add_executable(Restaurant main.cpp Client/Client.cpp Client/Client.h Client/GroupClient.cpp Client/GroupClient.h Restaurant.cpp Restaurant.h)