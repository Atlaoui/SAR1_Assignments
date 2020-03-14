cmake_minimum_required(VERSION 3.15)
project(TP-02 C)

set(CMAKE_C_STANDARD 99)

add_executable(EXO-01  EXO-01/list.h EXO-05/comment.c EXO-05/comment.h EXO-01/commit.h EXO-01/version.h EXO-01/version.c EXO-01/commit.c EXO-01/history.h
        EXO-01/history.c EXO-01/testHistory.c)

add_executable(EXO-5 EXO-05/comment.h EXO-05/comment.c EXO-05/testComment.c)