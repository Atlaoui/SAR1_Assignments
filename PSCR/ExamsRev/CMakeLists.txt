cmake_minimum_required(VERSION 3.15)
project(ExamsRev)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++17 -pthread -lrt")

add_executable(ExamJuin2019 ExamJuin2019/Exo1/SharedData.h ExamJuin2019/Exo1/main.cpp ExamJuin2019/Exo1/rwlock.h ExamJuin2019/Exo1/rwlock_sem.cpp)
add_executable(Baboon_crossing Baboon_crossing/Corde.h Baboon_crossing/main.cpp Baboon_crossing/Baboon.h)
add_executable(ltime ExamJuin2019/Exo2/ltime.cpp )
add_executable(mainSleep Test/mainSleep.cpp )
add_executable(Sign Sign/main.cpp)
add_executable(Exo3  ExamJuin2019/Exo3/shared.cpp )
add_executable(ExamJanv2019 ExamJanv2019/main.cpp ExamJanv2019/IValue.h ExamJanv2019/TicketBarrier.h )