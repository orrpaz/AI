import math



class DecisionTree:
    def __init__(self):
        self.values = {}
        # self.build()

    def build(self, data, attributes, default=None):
        """
        this method bulid the tree by recusion
        @param data: the data
        @param attributes: the attribute
        @param default
        @return: return tree
        """
        target = attributes[len(attributes) - 1]
        val_classification = [classification[attributes.index(target)] for classification in data]

        # if default is None:
        # if default is None:
        #     default = self.mode(attributes, data, target)

        if not data:
            # stop condition
            return default

        elif val_classification.count(val_classification[0]) == len(val_classification):
            # stop condition
            return val_classification[0]

        elif (len(attributes) - 1) <= 0:
            return self.mode(attributes, data, target)
        else:
            # Choose the next best attribute to best classify our data
            best = self.choose_attribute(data, attributes, target)

            tree = {best: {}}

            if self.values == {}:
                self.get_values(data, attributes)

            for val in self.values[best]:
                # Create a subtree for the current value under the "best" field
                examples = self.get_examples(data, attributes, best, val)
                new_attr = attributes[:]
                new_attr.remove(best)
                major = self.mode(attributes, data, target)
                # recursive call
                subtree = self.build(examples, new_attr, major)
                # Add the new subtree
                tree[best][val] = subtree

        return tree

    def get_examples(self,data, attributes, best, val):
        """
        this method get example that suit to best attribute
        @param data: data
        @param attributes: attributes
        @param best: best attribute
        @param val: value
        @return: example
        """
        examples = [[]]
        index = attributes.index(best)
        for entry in data:
            # find entries with the give value
            if entry[index] == val:
                new_entry = []
                # add value if it is not in best column
                for i in range(0, len(entry)):
                    if i != index:
                        new_entry.append(entry[i])
                examples.append(new_entry)
        examples.remove([])
        return examples

    def mode(self, attributes, data, target):
        """
        calc the majority
        @param attributes: attributes
        @param data: data
        @param target: target
        @return: return thr majority
        """
        # find target attribute

        max_val = 0
        majority = ""
        index = attributes.index(target)

        frequent = self.calc_freq(data, index)

        for key in frequent.keys():
            if (frequent[key] > max_val) or (frequent[key] == max_val and key in ["yes", "1", "true"]):
                max_val = frequent[key]
                majority = key

        return majority

    def get_values(self, data, attributes):
        """
        this method get the possible value of each attribute.
        @param data:
        @param attributes:
        @return: dict of value
        """
        for attr in attributes:
            self.values[attr] = []

        for attr in attributes:
            index = attributes.index(attr)
            for entry in data:
                if entry[index] not in self.values[attr]:
                    self.values[attr].append(entry[index])

        return self.values

    def choose_attribute(self, data, attributes, target):
        """
        this method choose best attribute according to algorithm
        @param data:
        @param attributes:
        @param target:
        @return:  best attribute
        """
        best = attributes[0]
        max_gain = 0
        features_gains_dict = {feature: self.information_gain(data,attributes,feature,target) for feature in attributes}
        for attr in attributes:
            if target != attr:
                if features_gains_dict[attr] > max_gain:
                    max_gain = features_gains_dict[attr]
                    best = attr
        return best


    def entropy(self, data, attributes, target_attribute):
        """
        this method calc the entropy
        @param data: data
        @param attributes: attributes
        @param target_attribute: target_attribute
        @return: the entropy
        """
        dataEntropy = 0.0
        index = attributes.index(target_attribute)
        frequent = self.calc_freq(data, index)
            # Calculate the entropy
        for freq in frequent.values():
            dataEntropy += (-freq / len(data)) * math.log(freq / len(data), 2)

        return dataEntropy

    def information_gain(self, data, attributes, attr, targetAttr):
        """
        this method calc the Information Gain
        @param data: data
        @param attributes: attributes
        @param attr: list of the attribute
        @param targetAttr: targetAttr
        @return:
        """
        subset_entropy = 0.0
        i = attributes.index(attr)

        frequent = self.calc_freq(data, i)

        for val in frequent.keys():
            probability = frequent[val] / sum(frequent.values())
            data_subset = [entry for entry in data if entry[i] == val]
            subset_entropy += probability * self.entropy(data_subset, attributes, targetAttr)

        # gain formula
        return self.entropy(data, attributes, targetAttr) - subset_entropy


    def calc_freq(self,data,i):
        """
        this method calc rhe frequent of feature
        @param data: data
        @param i: index
        @return: list of frequent
        """
        frequent = {}
        for entry in data:
            if entry[i] in frequent:
                frequent[entry[i]] += 1.0
            else:
                frequent[entry[i]] = 1.0
        return frequent


    def write_tree_to_file(self,f, tree_result, attr, i=0, parent=""):
        """
        this method write to file.
        @param f:
        @param tree_result:
        @param attr:
        @param i:
        @param parent:
        @return:
        """

        # isinstance(tree_result, dict) and not isinstance(tree_result, list):
        if tree_result in ['yes', 'no','true','false']:
            f.write(":" + tree_result + "\n")
        else:
            for key in sorted(tree_result):
                if (key in attr) and (key in tree_result) and parent:
                    f.write("\n")
                if parent in attr:
                    f.write("\t" * (i - 1) + ["|" if i != 1 else ""][0] + str(parent))
                if key not in attr:
                    f.write("=" + str(key))
                if not isinstance(tree_result, list):
                    self.write_tree_to_file(f, tree_result[key], attr, i + 1, key)

    def predict(self,tree_result, entry, attributes):
        """
                      this method predict the classification of each entry.
                      @param entry: line in our test data
                      @param k: introduce the number of neighbors.
                      @return: the classification.
                      """
        index = 0
        value = ""
        tree = tree_result.copy()
        while tree not in ['yes', 'no', 'true', 'false']:  # this is ugly
            # check if we are in an attribute
            for attribute in attributes:
                if attribute in tree:
                    tree = tree[attribute]
                    index = attributes.index(attribute)
                    value = entry[index]
                    break
            if value in tree.keys():
                # result = tree[value]
                tree = tree[value]
        return tree

