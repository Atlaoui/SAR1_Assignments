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
CMAKE_SOURCE_DIR = /home/adrien/SAR1_Assignments/SFTR/Reseau_de_petri/C/MutationCamelelonPB

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/adrien/SAR1_Assignments/SFTR/Reseau_de_petri/C/MutationCamelelonPB/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/Main.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/Main.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/Main.dir/flags.make

CMakeFiles/Main.dir/server.c.o: CMakeFiles/Main.dir/flags.make
CMakeFiles/Main.dir/server.c.o: ../server.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/adrien/SAR1_Assignments/SFTR/Reseau_de_petri/C/MutationCamelelonPB/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object CMakeFiles/Main.dir/server.c.o"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/Main.dir/server.c.o   -c /home/adrien/SAR1_Assignments/SFTR/Reseau_de_petri/C/MutationCamelelonPB/server.c

CMakeFiles/Main.dir/server.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/Main.dir/server.c.i"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /home/adrien/SAR1_Assignments/SFTR/Reseau_de_petri/C/MutationCamelelonPB/server.c > CMakeFiles/Main.dir/server.c.i

CMakeFiles/Main.dir/server.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/Main.dir/server.c.s"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /home/adrien/SAR1_Assignments/SFTR/Reseau_de_petri/C/MutationCamelelonPB/server.c -o CMakeFiles/Main.dir/server.c.s

CMakeFiles/Main.dir/simulation.c.o: CMakeFiles/Main.dir/flags.make
CMakeFiles/Main.dir/simulation.c.o: ../simulation.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/adrien/SAR1_Assignments/SFTR/Reseau_de_petri/C/MutationCamelelonPB/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Building C object CMakeFiles/Main.dir/simulation.c.o"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/Main.dir/simulation.c.o   -c /home/adrien/SAR1_Assignments/SFTR/Reseau_de_petri/C/MutationCamelelonPB/simulation.c

CMakeFiles/Main.dir/simulation.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/Main.dir/simulation.c.i"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /home/adrien/SAR1_Assignments/SFTR/Reseau_de_petri/C/MutationCamelelonPB/simulation.c > CMakeFiles/Main.dir/simulation.c.i

CMakeFiles/Main.dir/simulation.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/Main.dir/simulation.c.s"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /home/adrien/SAR1_Assignments/SFTR/Reseau_de_petri/C/MutationCamelelonPB/simulation.c -o CMakeFiles/Main.dir/simulation.c.s

# Object files for target Main
Main_OBJECTS = \
"CMakeFiles/Main.dir/server.c.o" \
"CMakeFiles/Main.dir/simulation.c.o"

# External object files for target Main
Main_EXTERNAL_OBJECTS =

Main: CMakeFiles/Main.dir/server.c.o
Main: CMakeFiles/Main.dir/simulation.c.o
Main: CMakeFiles/Main.dir/build.make
Main: CMakeFiles/Main.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/adrien/SAR1_Assignments/SFTR/Reseau_de_petri/C/MutationCamelelonPB/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Linking C executable Main"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/Main.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/Main.dir/build: Main

.PHONY : CMakeFiles/Main.dir/build

CMakeFiles/Main.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/Main.dir/cmake_clean.cmake
.PHONY : CMakeFiles/Main.dir/clean

CMakeFiles/Main.dir/depend:
	cd /home/adrien/SAR1_Assignments/SFTR/Reseau_de_petri/C/MutationCamelelonPB/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/adrien/SAR1_Assignments/SFTR/Reseau_de_petri/C/MutationCamelelonPB /home/adrien/SAR1_Assignments/SFTR/Reseau_de_petri/C/MutationCamelelonPB /home/adrien/SAR1_Assignments/SFTR/Reseau_de_petri/C/MutationCamelelonPB/cmake-build-debug /home/adrien/SAR1_Assignments/SFTR/Reseau_de_petri/C/MutationCamelelonPB/cmake-build-debug /home/adrien/SAR1_Assignments/SFTR/Reseau_de_petri/C/MutationCamelelonPB/cmake-build-debug/CMakeFiles/Main.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/Main.dir/depend
