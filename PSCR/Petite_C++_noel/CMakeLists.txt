cmake_minimum_required(VERSION 3.15)
project(Petite_C___noel)

set(CMAKE_CXX_STANDARD 14)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++14 -pthread")

add_executable(Petite_C___noel main.cpp job.h Renne.cpp Renne.h PereNoel.cpp PereNoel.h Struct/barrier.cpp Struct/barrier.h)