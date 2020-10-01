from sklearn import svm
from sklearn.cross_validation import train_test_split
from sklearn.metrics import confusion_matrix
from sklearn.metrics import accuracy_score
from sklearn import datasets

# Load dataset
dataset = datasets.load_iris()

#print(dataset)

features = dataset.data
targetVariables = dataset.target

featureTrain, featureTest, targetTrain, targetTest = train_test_split(features, targetVariables, test_size=0.3)

#model = svm.SVC(gamma=0.001, C=100)
model = svm.SVC()
fittedModel = model.fit(featureTrain, targetTrain)
predictions = fittedModel.predict(featureTest)

print(confusion_matrix(targetTest, predictions))
print(accuracy_score(targetTest, predictions))
