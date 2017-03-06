//DictionaryTest.c
//Erica Tom
//edtom
//pa5
//May 28 2016
//Tests Dictionary.c

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include"Dictionary.h"

#define MAX_LEN 180

int main(int argc, char* argv[]){
 Dictionary A = newDictionary();

  size(A);
  char* X[] = {"uno","dos","tres","cuatro","cince","seis","siete"};
  char* Y[] = {"one","two","three","four","five","six","seven"};

  for(int i=0; i<7; i++){
    insert(A, X[i], Y[i]);
  }

  size(A);
  makeEmpty(A);
  isEmpty(A);

  printDictionary(stdout, A);
}
