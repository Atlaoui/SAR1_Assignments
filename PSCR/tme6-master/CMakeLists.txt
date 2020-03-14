cmake_minimum_required(VERSION 3.15)
project(TME6-master)

set(CMAKE_CXX_STANDARD 17 )
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++17 -pthread")

add_executable(TME6-master src/fork_exo.cpp src/rsleep.cpp src/rsleep.h src/VadorvsLuke.cpp src/teste_wait.cpp)