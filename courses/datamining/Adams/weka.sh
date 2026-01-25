#!/bin/bash

if [ "$#" -ne "2" ] ; then
  echo "Usage: $0 output_directory class_variable"
  echo "This script assumes an empty directory name (first argument), e.g., \"tmp\", as well as a data file with a name based on the provided directory argument, e.g., \"tmp.arff\"."
  exit
fi

OUTPUT=$1
CLASS=$2
INPUTFILE="${OUTPUT}.arff"
shift

JAVA_COMMAND="java -Xms4096m -Xmx32768m -cp $CLASSPATH:${WEKA_HOME}/weka.jar"
RANDSEED=$RANDOM
FOLDS=10
CVAL=10

#get index of attribute in the file
POSITION=$((`grep -e "^@attribute.*${CLASS}" ${INPUTFILE} -n | cut -d : -f 1` - `grep -e "^@attribute" ${INPUTFILE} -n -m 1 | cut -d : -f 1` + 1))

# Files
TRAIN_TMP_FILE="$OUTPUT/train_unsamp.arff"
TRAIN_FILE="$OUTPUT/train.arff" #will always be the training set in each step of 10-fold
TEST_FILE="$OUTPUT/test.arff" #will always be the test set in each step of 10-fold

# Commands
genFolds="$JAVA_COMMAND weka.filters.supervised.instance.StratifiedRemoveFolds"
trainGenFoldsOpts="-i $INPUTFILE -o $TRAIN_TMP_FILE -c $POSITION -S $RANDSEED -N $CVAL -V"
testGenFoldsOpts="-i $INPUTFILE -o $TEST_FILE -c $POSITION -S $RANDSEED -N $CVAL"

resample="$JAVA_COMMAND weka.filters.unsupervised.instance.Resample"
resampleOpts="-S $RANDSEED -Z 100.0 -c $POSITION -i $TRAIN_TMP_FILE -o $TRAIN_FILE"

j48="$JAVA_COMMAND weka.classifiers.trees.J48"
j48Opts="-t $TRAIN_FILE -T $TEST_FILE -c $POSITION -C 0.25 -M 5 -i"


#BEGIN
if [ ! -e $OUTPUT ]; then
	mkdir $OUTPUT
fi

FOLDS=(1 2 3 4 5 6 7 8 9 10)


for FOLD_VAL in ${FOLDS[*]};
do
	echo "* Step $FOLD_VAL *"

	# Generate data
	echo -n "Generating training data..."
	$genFolds $trainGenFoldsOpts -F $FOLD_VAL #get the training set part of the 10-fold (so, the 9 folds for the $FOLD_VAL-th step)
	$resample $resampleOpts
	echo "DONE!"

	echo -n "Generating test data..."
	$genFolds $testGenFoldsOpts -F $FOLD_VAL #get the test set part of the 10-fold (so, the 1 fold for the $FOLD_VAL-th step)
	echo "DONE!"

	echo -n "Generating results..."
	$j48 $j48Opts > $OUTPUT/results_${FOLD_VAL}.out
	gzip -f $OUTPUT/results_${FOLD_VAL}.out
	echo "DONE!"
done

# Cleanup
rm -f $TRAIN_FILE $TRAIN_TMP_FILE $TEST_FILE

