## External Sort

This is demo application for external merge sort. The application reads `N` numbers from input file, 
sorts and stores in temporary file. Once the input file is read completely, all temp files are merged
into one single file.  

#### Problem

> Given with a line separated text file of integers ranging anywhere from Integer.MIN to
Integer.MAX, the program should be able to produce line separated text
file which has the sorted content of the input file.


### Execution

* Clone the repository and run `gradle build` to install dependencies
* Import the project into IDE and run `Application`


#### Generate big data

* running `./generate.sh` should generate `src/main/resources/input-big.txt` file with 50000 numbers
* You can run the script multiple times to add more numbers in same file
* To sort this file you need to make small change in `Application.java:14`, to change the input file name


#### Performance Optimization 

- Implement K-Way merge using `PriorityQueue` to merge the tempFiles. All tempFiles will merged at once. 
- Parallelize the split and sorting of tempFiles
- Dynamically decide the size of tempFiles based of available memory


### Improvements

- Take input file and output files as arguments  
- Log the progress on console, at each stage
- Summary - Total time taken, total temp files created, count of numbers
