#!/bin/bash
cd ./src

# $1 represents first parameter passed through

if [ "$1" == "-rem" ]
then
  if [[ -e Control.class || -e Generator.class || -e Interact.class || -e Manipulate.class || -e Sort.class ]];
  then
    rm *.class
  fi

elif [ "$1" == "-com" ]
then
  javac *.java

elif [ "$1" == "-run" ]
then
  if [[ -e Control.class && -e Generator.class && -e Interact.class && -e Manipulate.class && -e Sort.class ]];
  then
    cd ../
    java src.Control
  else
    echo "Not all .class files are present. Aborting run."
  fi

else
#Default behavior is to delete class files, then replace them (if class files exist or on successfull run)
  # Removes all class files
  if [[ -e Control.class || -e Generator.class || -e Interact.class || -e Manipulate.class || -e Sort.class ]];
  then
    rm *.class
  fi

  # Compile all files ending in .java
  javac *.java

  # Only on a succesful compile (class files were generated), run the .class files
  if [[ -e Control.class && -e Generator.class && -e Interact.class && -e Manipulate.class && -e Sort.class ]];
  then
    cd ../
    java src.Control
  else
    echo "Not all .class files are present. Aborting run."
  fi
fi
