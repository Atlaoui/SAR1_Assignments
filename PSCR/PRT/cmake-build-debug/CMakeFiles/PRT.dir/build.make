# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.15

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /home/adrien/.CLion2019.2/bin/cmake/linux/bin/cmake

# The command to remove a file.
RM = /home/adrien/.CLion2019.2/bin/cmake/linux/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /home/adrien/CLionProjects/PRT

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/adrien/CLionProjects/PRT/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/PRT.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/PRT.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/PRT.dir/flags.make

CMakeFiles/PRT.dir/main.cpp.o: CMakeFiles/PRT.dir/flags.make
CMakeFiles/PRT.dir/main.cpp.o: ../main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/adrien/CLionProjects/PRT/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/PRT.dir/main.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/PRT.dir/main.cpp.o -c /home/adrien/CLionProjects/PRT/main.cpp

CMakeFiles/PRT.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/PRT.dir/main.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/adrien/CLionProjects/PRT/main.cpp > CMakeFiles/PRT.dir/main.cpp.i

CMakeFiles/PRT.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/PRT.dir/main.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/adrien/CLionProjects/PRT/main.cpp -o CMakeFiles/PRT.dir/main.cpp.s

CMakeFiles/PRT.dir/Compte.cpp.o: CMakeFiles/PRT.dir/flags.make
CMakeFiles/PRT.dir/Compte.cpp.o: ../Compte.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/adrien/CLionProjects/PRT/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Building CXX object CMakeFiles/PRT.dir/Compte.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/PRT.dir/Compte.cpp.o -c /home/adrien/CLionProjects/PRT/Compte.cpp

CMakeFiles/PRT.dir/Compte.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/PRT.dir/Compte.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/adrien/CLionProjects/PRT/Compte.cpp > CMakeFiles/PRT.dir/Compte.cpp.i

CMakeFiles/PRT.dir/Compte.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/PRT.dir/Compte.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/adrien/CLionProjects/PRT/Compte.cpp -o CMakeFiles/PRT.dir/Compte.cpp.s

CMakeFiles/PRT.dir/transferts.cpp.o: CMakeFiles/PRT.dir/flags.make
CMakeFiles/PRT.dir/transferts.cpp.o: ../transferts.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/adrien/CLionProjects/PRT/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Building CXX object CMakeFiles/PRT.dir/transferts.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/PRT.dir/transferts.cpp.o -c /home/adrien/CLionProjects/PRT/transferts.cpp

CMakeFiles/PRT.dir/transferts.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/PRT.dir/transferts.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/adrien/CLionProjects/PRT/transferts.cpp > CMakeFiles/PRT.dir/transferts.cpp.i

CMakeFiles/PRT.dir/transferts.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/PRT.dir/transferts.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/adrien/CLionProjects/PRT/transferts.cpp -o CMakeFiles/PRT.dir/transferts.cpp.s

# Object files for target PRT
PRT_OBJECTS = \
"CMakeFiles/PRT.dir/main.cpp.o" \
"CMakeFiles/PRT.dir/Compte.cpp.o" \
"CMakeFiles/PRT.dir/transferts.cpp.o"

# External object files for target PRT
PRT_EXTERNAL_OBJECTS =

PRT: CMakeFiles/PRT.dir/main.cpp.o
PRT: CMakeFiles/PRT.dir/Compte.cpp.o
PRT: CMakeFiles/PRT.dir/transferts.cpp.o
PRT: CMakeFiles/PRT.dir/build.make
PRT: CMakeFiles/PRT.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/adrien/CLionProjects/PRT/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_4) "Linking CXX executable PRT"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/PRT.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/PRT.dir/build: PRT

.PHONY : CMakeFiles/PRT.dir/build

CMakeFiles/PRT.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/PRT.dir/cmake_clean.cmake
.PHONY : CMakeFiles/PRT.dir/clean

CMakeFiles/PRT.dir/depend:
	cd /home/adrien/CLionProjects/PRT/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/adrien/CLionProjects/PRT /home/adrien/CLionProjects/PRT /home/adrien/CLionProjects/PRT/cmake-build-debug /home/adrien/CLionProjects/PRT/cmake-build-debug /home/adrien/CLionProjects/PRT/cmake-build-debug/CMakeFiles/PRT.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/PRT.dir/depend

