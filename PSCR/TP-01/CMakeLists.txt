cmake_minimum_required(VERSION 3.15)
project(TP-01 C)

set(CMAKE_C_STANDARD 99)

add_executable(EXO-01 EXO-01/testVersion.c EXO-01/version.c EXO-01/version.h EXO-03/commit.c EXO-03/commit.h EXO-03/history.c EXO-03/history.h)

add_executable(EXO-02 EXO-02/testOffset.c EXO-01/version.c EXO-01/version.h EXO-03/commit.c EXO-03/commit.h EXO-03/history.c EXO-03/history.h)

add_executable(EXO-03 EXO-01/version.c EXO-01/version.h EXO-03/commit.c EXO-03/commit.h EXO-03/history.c EXO-03/testHistory.c)