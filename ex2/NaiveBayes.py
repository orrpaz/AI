from collections import defaultdict


class NaiveBayes:
    def __init__(self, attributes, data):
        """
        init
        @param attributes: attribute
        @param data: data we learn
        """
        self.data = data
        self.attributes = attributes
        self.list_of_classification = self.separated_example_by_classification()
        self.tag = [line[-1] for line in self.data]
        self.possible = defaultdict(int)
        self.get_unique_size_of_attribute()

    def separated_example_by_classification(self):
        """
        this method return dictionary that the key is the classification and value is all entry that suit of this
        classification.
        @return: dictinary
        """
        separated = {}
        for i in range(len(self.data)):
            vector = self.data[i]
            # check the value of line in last column - the classify
            if vector[-1] not in separated:
                separated[vector[-1]] = []
            separated[vector[-1]].append(vector[:-1])
        return separated

    def get_unique_size_of_attribute(self):
        """
        this method calc the k in smoothing formula - all possible values the feature can get
        and put it in possible dict.
        @return:
        """
        for index in range(len(self.attributes)-1):
            domain = set([example[index] for example in self.data[:-1]])
            self.possible[index] = len(domain)

    def calc_prob(self,entry, classification):
        """
        this method calc the prob of each entry with certain classification.
        @param entry: line in test data
        @param classification: dict that key is certain classification and value is all entrys the suit to it
        @return: the prob with smoothing
        """
        prob_list = []
        res = 1
        classification_group_size = len(classification)
        # computes conditioned probability.
        for feature_index in range(len(entry)):
            # for smoothing.
            counter = 1
            attr_size = self.possible[feature_index]
            for train_example in classification:
                if train_example[feature_index] == entry[feature_index]:
                    counter += 1
            prob_list.append(float(counter) / (classification_group_size + attr_size))
        prior = float(len(classification)) / len(self.data)

        for x in prob_list:
            res = res * x
        return res * prior

    def predict(self, entry):
        """
        gets an entry and returns a predicted tag for the example.
        :param entry: line in test data
        :return: prediction
        """
        max_prob = 0
        max_tag = list(self.list_of_classification.keys())[0]
        probs = []
        # calculates the probability for each class, keep tracking the maximum prob
        for tag in self.list_of_classification:
            prob = self.calc_prob(entry, self.list_of_classification[tag])
            probs.append(prob)
            if prob > max_prob:
                max_prob = prob
                max_tag = tag

        if len(probs) == 2:
            if probs[0] == probs[1]:
                for tag in self.list_of_classification.keys():
                    if tag in ["yes", "true"]:
                        return tag
                    return tag[0]
        # return the tag with the highest probability
        return max_tag
