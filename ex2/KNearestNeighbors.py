import operator


class KNearestNeighbors:

    def __init__(self, attributes, data):
        """
        init
        @param attributes: the attribute
        @param data: the data
        @param num_of_example: number of attribute
        """
        self.data = data
        self.attributes = attributes
        # self.num_of_example = num_of_example

    def predict(self, entry_from_test, k):
        """
              this method predict the classification of each entry.
              @param entry: line in our test data
              @param k: introduce the number of neighbors.
              @return: the classification.
              """
        votes = {}
        ne = self.get_neighbors(entry_from_test, k)
        for x in range(0, len(ne)):
            # took the calssify from the last column
            response = ne[x][-1]
            # update the votes
            if response in votes:
                votes[response] += 1
            else:
                votes[response] = 1
        sorted_votes = sorted(votes.items(), key=operator.itemgetter(1), reverse=True)
        return sorted_votes[0][0]

    def get_neighbors(self, entry_from_test, k):
        """
        @param entry_from_test: entry from test
        @param k: k
        @return: return the best k neighbors
        """
        distances_list = []
        for x in range(0, len(self.data)):
            distance = self.hamming_distance(entry_from_test, self.data[x])
            distances_list.append((self.data[x], distance))
            # sort by the first index(by distance).
            distances_list.sort(key=operator.itemgetter(1))
        neighbors = []
        # best k.
        for x in range(k):
            neighbors.append(distances_list[x][0])
        return neighbors

    def hamming_distance(self, instance_from_test, instance_from_train):
        """
        calc the hamming distance between 2 instance
        @param instance_from_test: entry from text
        @param instance_from_train: entry from data train
        @return: the distance.
        """
        distance = 0
        for feature1, feature2 in zip(instance_from_test, instance_from_train):
            if feature1 != feature2:
                distance += 1
        return distance
