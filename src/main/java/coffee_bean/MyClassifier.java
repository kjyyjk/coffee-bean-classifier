package coffee_bean;

import weka.classifiers.AbstractClassifier;
import weka.classifiers.Evaluation;
import weka.core.Instance;
import weka.core.Instances;

public class MyClassifier {
    private final AbstractClassifier classifier;

    public MyClassifier(final AbstractClassifier classifier, final Instances data) throws Exception {
        this.classifier = classifier;
        classifier.buildClassifier(data);
    }

    public double classify(final Instance instance) throws Exception {
        return classifier.classifyInstance(instance);
    }

    public Evaluation crossValidate(final Instances data) throws Exception {
        Evaluation evaluation = new Evaluation(data);
        evaluation.crossValidateModel(classifier, data, 10, new java.util.Random(1));
        return evaluation;
    }
}