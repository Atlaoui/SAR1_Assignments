cmake_minimum_required(VERSION 3.15)
project(PR)

set(CMAKE_CXX_STANDARD 17)

add_executable(PR main.cpp WordCountPair.cpp WordCountPair.h WordCountV.cpp WordCountV.h HashMap.cpp HashMap.h iterGen.h)