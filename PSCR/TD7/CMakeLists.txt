cmake_minimum_required(VERSION 3.15)
project(TD7)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++17 -pthread")

add_executable(TD7 main.cpp Stack.h prodcons.cpp Semaphore.cpp)