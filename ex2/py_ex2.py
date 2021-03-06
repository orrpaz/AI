import math

from DecisionTree import DecisionTree
from KNearestNeighbors import KNearestNeighbors
from NaiveBayes import NaiveBayes


def main():
    attributes_train, data_train = read_from_file("train.txt")

    # DTL
    dtl = DecisionTree()
    tree = dtl.build(data_train, attributes_train)
    with open("output_tree.txt", "w") as file:
        tree_string = dtl.write_tree_to_file(tree, attributes_train, 0)
        file.write(tree_string[:len(tree_string)-1])
    # KNN
    knn = KNearestNeighbors(attributes_train, data_train)
    # NAIVE BAYES
    naive_bayes = NaiveBayes(attributes_train, data_train)
    attribute_text, data_test = read_from_file("test.txt")
    knn_result = []
    naive_bayes_result = []
    dtl_result = []
    real_classify = []

    for line in data_test:
        real_classify.append(line[-1])
        entry = line[:-1]
        knn_result.append(knn.predict(entry, 5))
        naive_bayes_result.append(naive_bayes.predict(entry))
        dtl_result.append(dtl.predict(tree, entry, attribute_text))
    acc_knn = 0
    acc_nb = 0
    acc_dtl = 0
    # get accuracy
    for (dtl, knn, nb, real) in zip(dtl_result, knn_result, naive_bayes_result, real_classify):
        if dtl == real:
            acc_dtl += 1
        if knn == real:
            acc_knn += 1
        if nb == real:
            acc_nb += 1
    acc_knn /= len(real_classify)
    acc_nb /= len(real_classify)
    acc_dtl /= len(real_classify)
    acc_knn = float(math.ceil(acc_knn * 100)) / float(100)
    acc_nb = float(math.ceil(acc_nb * 100)) / float(100)
    acc_dtl = float(math.ceil(acc_dtl * 100)) / float(100)

    with open('output.txt', 'w') as output:
        output.write("Num\tDT\tKNN\tnaiveBase\n")
        for i,(a, b, c) in (enumerate(zip(dtl_result, knn_result, naive_bayes_result))):
            output.write(str(i+1) + "\t" + a + "\t" + b + "\t" + c + "\n")
        output.write("\t" + str(acc_dtl) + "\t" + str(acc_knn) + "\t" + str(acc_nb) + "\n")


def read_from_file(file_name):
    with open(file_name, 'r') as file:
            content = [line.strip('\n').split('\t') for line in file]
            return content[0], content[1:]



if __name__ == "__main__":
    main()