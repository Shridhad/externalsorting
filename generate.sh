#! /bin/bash
MAX=50000;

for j in $(seq 1 1000); do
    for i in $(seq $MAX);
        do
        random32=$(( ( ($RANDOM & 3)<<30 | $RANDOM<<15 | $RANDOM ) - 0x80000000 ))
        echo $random32 >> "./src/main/resources/input-big.txt";
    done
done