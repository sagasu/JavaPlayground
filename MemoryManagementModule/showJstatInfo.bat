REM 6604 is a pid of a process
REM jps will print currently running java processes
REM S is survivor, E is eden, O is old, M is meta space, YGC young generation garbage collects, YGCT is time, FGCT full garbage collects
jps
jstat -gccapacity 8508
jstat -gcutil 8508
jstat -gccause 8508
jstat -gc 8508