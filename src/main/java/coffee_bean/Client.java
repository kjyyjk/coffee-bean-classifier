package coffee_bean;

import static coffee_bean.view.Output.printClassifyResult;
import static coffee_bean.view.Output.printWelcomeMessage;

import coffee_bean.view.Input;
import weka.classifiers.trees.RandomForest;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class Client {
    private static final String PATH = "data/coffee.arff";

    public static void main(String[] args) throws Exception {
        DataSource dataSource = new DataSource(PATH);
        Instances data = getData(dataSource);
        MyClassifier classifier = new MyClassifier(new RandomForest(), data);

        Thread.sleep(2000);

        printWelcomeMessage();
        Instance instance = getNewInstance(data, Input.getAttributeInputValues(data));
        printClassifyResult(classify(data, instance, classifier));
    }

    private static Instances getData(final DataSource source) throws Exception {
        Instances data = source.getDataSet();
        data.setClassIndex(data.numAttributes() - 1);
        return data;
    }

    private static Instance getNewInstance(final Instances data, final double[] values) {
        Instance instance = new DenseInstance(1.0, values);
        instance.setDataset(data);
        return instance;
    }

    private static String classify(final Instances data, final Instance instance, final MyClassifier classifier) throws Exception {
        double classIndex = classifier.classify(instance);
        return classIndexToClassValue(data, classIndex);
    }

    private static String classIndexToClassValue(final Instances data, final double classIndex) {
        return data.classAttribute().value((int) classIndex);
    }
}