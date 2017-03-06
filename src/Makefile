CC = gcc
JC = javac

n = 1000
i = integers.txt
o = sorted.txt
p1 = 0.01
p2 = 0.02
t = 100

all:
	$(JC) *.java
	javah InsertionSort
	gcc -I$JAVA_HOME/include -I$JAVA_HOME/include/linux -shared -fpic -o libinsertionsort.so lib_insertionsort.c
        export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:.

generator:
	java DataGenerator $(i) $(n)

sorter:
	java Driver $(i) $(o) $(p1) $(p2) $(t)

clean:
	rm -f *~ *.class *.so *.txt
