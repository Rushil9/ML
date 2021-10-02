import json
import sys
import os
import csv
import pandas as pd
from sklearn.metrics.pairwise import cosine_similarity
from sklearn.feature_extraction.text import CountVectorizer

n = int(input('Number of Files'))
arr=[];
sim=[];
for i in range(0,n):
    a=input('Enter file name: ')
    arr.append(a)
for i in range(0, n):
    filen = arr[i]
    file = open(filen, 'r')
    text = file.read()
    for j in range(0,n):
        file1n = arr[j]
        file1 = open(file1n,'r')
        text1 = file1.read()
        documents = [text, text1]
        count_vectorizer = CountVectorizer()
        sparse_matrix = count_vectorizer.fit_transform(documents)
        doc_term_matrix = sparse_matrix.todense()
        df = pd.DataFrame(doc_term_matrix, columns=count_vectorizer.get_feature_names(), index=['text', 'text1'])
        answer = cosine_similarity(df, df)
        answer = pd.DataFrame(answer)
        answer = answer.iloc[[1],[0]].values[0]
        answer = round(float(answer),4)*100
        print("% similarity btw",filen, "and",file1n ,"is",answer)
        if answer>15:
            f=[]
            f.append(filen)
            f.append(file1n)
            sim.append(f)

print('FIles with % similarity > 15 are : ')
print('sim matrix')
print(sim)




#similarity using cosine between different files



#file = 'input.txt'
#file = open(file , 'r')
#text = file.read()
#file2 =open ("input.txt","r")
#text1= file2.read()
#n = input('Enter the number of files to compare : ')

#documents = [text, text1]
#count_vectorizer = CountVectorizer()
#sparse_matrix = count_vectorizer.fit_transform(documents)
#doc_term_matrix = sparse_matrix.todense()
#df = pd.DataFrame(doc_term_matrix, columns=count_vectorizer.get_feature_names(), index=['text', 'text1'])
#answer = cosine_similarity(df, df)
#answer = pd.DataFrame(answer)
#answer = answer.iloc[[1],[0]].values[0]
#answer = round(float(answer),4)*100
#print(answer)
